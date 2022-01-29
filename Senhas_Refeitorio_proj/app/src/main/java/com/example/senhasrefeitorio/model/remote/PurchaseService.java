package com.example.senhasrefeitorio.model.remote;

import com.example.senhasrefeitorio.model.Meal;
import com.example.senhasrefeitorio.model.Purchase;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface PurchaseService {
    @GET("Purchases/")
    Call<List<Purchase>> getPurchases();

    @POST("Purchases/")
    Call<Boolean>setPurchase(@Body Purchase purchase);
}
