package com.example.senhas_refeitorio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {
    @GET("WeekDays")
    Call<List<Weekdays>> getWeekdays();

    @GET("WeekDays/{idWeekday}")
    Call<Weekdays> getWeekday(@Path("idWeekday") long id);

}
