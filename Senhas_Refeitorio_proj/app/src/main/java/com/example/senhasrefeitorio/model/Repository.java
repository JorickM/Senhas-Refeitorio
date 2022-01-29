package com.example.senhasrefeitorio.model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.senhasrefeitorio.model.database.AppDatabase;
import com.example.senhasrefeitorio.model.database.MealDao;
import com.example.senhasrefeitorio.model.database.PurchaseDao;
import com.example.senhasrefeitorio.model.database.WeekdayDao;
import com.example.senhasrefeitorio.model.remote.Datasource;
import com.example.senhasrefeitorio.model.remote.MealService;
import com.example.senhasrefeitorio.model.remote.PurchaseService;
import com.example.senhasrefeitorio.model.remote.WeekdayService;
import com.example.senhasrefeitorio.model.sharedpreferences.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private Context context;
    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();
    private WeekdayDao weekdayDao;
    private MealDao mealDao;
    private PurchaseDao purchaseDao;

    public Repository(Context context) {
        this.context = context;
        this.weekdayDao = AppDatabase.getInstance(context).getWeekDaysDao();
        this.mealDao = AppDatabase.getInstance(context).getMealsDao();
        this.purchaseDao = AppDatabase.getInstance(context).getPurchaseDao();
    }

    public void tryToLoginUser(String email, String password) {
        Datasource.getUserService().getUser(email, password).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    if (response.body().size() > 0) {
                        User user1 = response.body().get(0);
                        SessionManager.saveSession(Repository.this.context, user1);
                        userMutableLiveData.postValue(user1);
                    } else {
                        userMutableLiveData.postValue(null);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                t.printStackTrace();
                userMutableLiveData.postValue(null);
            }
        });
    }

    public LiveData<User> getLoggedInUser() {
        this.getUserInternal();
        return userMutableLiveData;
    }

    private void getUserInternal() {
        User user = SessionManager.getActiveSession(this.context);
        userMutableLiveData.postValue(user);
    }

    public void logout() {
        SessionManager.clearSession(this.context);
    }

    public LiveData<List<Weekday>> getAllWeekdays() {
        return this.weekdayDao.getAllWeekdays();
    }

    public void updateList() {
        WeekdayService service = Datasource.getWeekdayService();

        Call<List<Weekday>> call = service.getWeekDays();

        call.enqueue(new Callback<List<Weekday>>() {
            @Override
            public void onResponse(Call<List<Weekday>> call, Response<List<Weekday>> response) {
                // Main Thread
                if (response.isSuccessful()) {
                    List<Weekday> weekdayList = response.body();
                    if (weekdayList.size() > 0) {
                        // Need a new Thread because we are on UI Thread
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                // Update list on Room Table
                                weekdayDao.add(weekdayList);
                            }
                        }).start();
                    }
                } else {
                    // Resposta mal sucedida
                    // Snakbar
                }
            }

            @Override
            public void onFailure(Call<List<Weekday>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public LiveData<List<Meal>> getAllMeals(long codWeekday) {
        return this.mealDao.getAllMealsByCodWeekday(codWeekday);
    }

    public void updateMealList() {
        MealService service = Datasource.getMealService();

        service.getMealsByCodWeekday().enqueue(new Callback<List<Meal>>() {
            @Override
            public void onResponse(Call<List<Meal>> call, Response<List<Meal>> response) {
                if (response.isSuccessful()) {
                    List<Meal> meals = response.body();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (Meal meal : meals) {
                                mealDao.add(meal);
                            }
                        }
                    }).start();
                } else {
                    // Log error to logcat
                }
            }
            @Override
            public void onFailure(Call<List<Meal>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    public void updatePurchaseList() {
        PurchaseService service = Datasource.getPurchaseService();

        service.getPurchasesByCodUser().enqueue(new Callback<List<Purchase>>() {
            @Override
            public void onResponse(Call<List<Purchase>> call, Response<List<Purchase>> response) {
                if (response.isSuccessful()) {
                    List<Purchase> purchases = response.body();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (Purchase purchase : purchases) {
                                purchaseDao.add(purchase);
                            }
                        }
                    }).start();
                } else {
                    // Log error to logcat
                }
            }
            @Override
            public void onFailure(Call<List<Purchase>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public LiveData<Meal> getOneMeal(long codMeal) {
        return this.mealDao.getOneMealByCodMeal(codMeal);
    }

    public void addPurchase(Purchase purchase){
        PurchaseService service = Datasource.getPurchaseService();
        service.setPurchase(purchase).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful()) {
                    Boolean result = response.body();
                } else {
                    // Resposta mal sucedida
                    // Snakbar
                }
            }
            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
