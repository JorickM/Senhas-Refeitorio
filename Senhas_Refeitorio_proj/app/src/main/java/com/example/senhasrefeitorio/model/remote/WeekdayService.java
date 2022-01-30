package com.example.senhasrefeitorio.model.remote;

import com.example.senhasrefeitorio.model.User;
import com.example.senhasrefeitorio.model.Weekday;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeekdayService {
    @GET("weekdays/")
    Call<List<Weekday>> getWeekDays();
}
