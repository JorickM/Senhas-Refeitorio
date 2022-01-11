package com.example.senhasrefeitorio.model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.senhasrefeitorio.model.database.AppDatabase;
import com.example.senhasrefeitorio.model.database.WeekdayDao;
import com.example.senhasrefeitorio.model.remote.Datasource;
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

    public Repository(Context context) {
        this.context = context;
        this.weekdayDao = AppDatabase.getInstance(context).getWeekDaysDao();
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
}
