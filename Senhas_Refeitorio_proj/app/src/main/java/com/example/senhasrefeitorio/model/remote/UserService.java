package com.example.senhasrefeitorio.model.remote;

import com.example.senhasrefeitorio.model.LoginModel;
import com.example.senhasrefeitorio.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {

    @GET("logins/")
    Call<List<User>> getUser(@Query("email") String email, @Query("password") String password);

    @POST("logins/")
    Call<User> loginUser(@Body LoginModel login);
}
