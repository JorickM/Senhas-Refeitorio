package com.example.senhasrefeitorio.model.remote;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Datasource {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/ricardooooooo/senhasDB/")
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
}
