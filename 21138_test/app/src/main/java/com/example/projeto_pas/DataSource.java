package com.example.projeto_pas;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataSource {
    private static final String WEB_URL = "https://my-json-server.typicode.com/ricardooooooo/senhasDB/";

    public static MealTypeService getMealTypeService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WEB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MealTypeService service = retrofit.create(MealTypeService.class);
        return service;
    }
}
