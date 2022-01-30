package com.example.senhasrefeitorio.model.remote;



import com.example.senhasrefeitorio.model.Purchase;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Datasource {

    private static Retrofit retrofit = new Retrofit.Builder()
            // .baseUrl("https://my-json-server.typicode.com/ricardooooooo/senhasDB/")
            .baseUrl("http://10.0.2.2:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static UserService getUserService() {
        return retrofit.create(UserService.class);
    }

    public static WeekdayService getWeekdayService() {
        return retrofit.create(WeekdayService.class);
    }

    public static MealService getMealService(){
        return retrofit.create(MealService.class);
    }

    public static PurchaseService getPurchaseService(){
        return retrofit.create(PurchaseService.class);
    }
}
