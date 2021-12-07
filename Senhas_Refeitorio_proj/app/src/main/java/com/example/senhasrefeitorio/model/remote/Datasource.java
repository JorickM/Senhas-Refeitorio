package com.example.senhasrefeitorio.model.remote;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Datasource {

    public static Service getServiceData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/ricardooooooo/senhasDB/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);
        return service;
    }
}
