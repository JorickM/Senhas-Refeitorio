package com.example.projeto_pas;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<MealType>> mealTypeLiveData = new MutableLiveData();

    public MutableLiveData<List<MealType>> getMealTypeLiveData() {
        return mealTypeLiveData;
    }

    public void updateList(){
        MealTypeService service = DataSource.getMealTypeService();
        Call<List<MealType>> call = service.getListMealType();

        call.enqueue(new Callback<List<MealType>>() {
            @Override
            public void onResponse(Call<List<MealType>> call, Response<List<MealType>> response) {
                if(response.isSuccessful()){
                    List<MealType> mealTypeList =response.body();
                    mealTypeLiveData.postValue(mealTypeList);
                }
            }

            @Override
            public void onFailure(Call<List<MealType>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

