package com.example.senhasrefeitorio.model.remote;

import com.example.senhasrefeitorio.model.Meal;
import com.example.senhasrefeitorio.model.Purchase;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PurchaseService {
    @GET("purchases/byUser/{codUser}")
    Call<List<Purchase>> getPurchases(@Path("codUser") long codUser);

    @POST("purchases/")
    Call<Boolean>setPurchase(@Body Purchase purchase);
}
