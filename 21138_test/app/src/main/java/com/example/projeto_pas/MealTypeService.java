package com.example.projeto_pas;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MealTypeService {

    @GET("MealType/")
    Call<List<MealType>> getListMealType();

    @GET("MealType/{id}")
    Call<MealType> getMealType(@Path("id") long id);
}
