package com.example.senhasrefeitorio.model.remote;

import com.example.senhasrefeitorio.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {


    @GET("Users/{userId}")
    Call<User> getUser(@Path("userId") long id);
}
