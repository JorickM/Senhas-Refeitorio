package com.example.senhasrefeitorio.model.remote;

import com.example.senhasrefeitorio.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {
    @GET("users/")
    Call<List<User>> getUser(@Query("email") String email, @Query("password") String password);


}
