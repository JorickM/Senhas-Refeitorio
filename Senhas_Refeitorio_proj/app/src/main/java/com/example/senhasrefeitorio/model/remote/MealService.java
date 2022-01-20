package com.example.senhasrefeitorio.model.remote;


import com.example.senhasrefeitorio.model.Meal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MealService {
    @GET("Meals/?codWeekday={codWeekday}")
    Call<List<Meal>> getMealsByCodWeekday(long codWeekday);

    @GET("Meals/")
    Call<List<Meal>> getAllMeals();
}
