package com.example.senhasrefeitorio.model.remote;


import com.example.senhasrefeitorio.model.Meal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealService {
    @GET("meals/")
    Call<List<Meal>> getMealsByCodWeekday();
}
