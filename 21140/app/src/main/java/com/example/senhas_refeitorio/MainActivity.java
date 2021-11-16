package com.example.senhas_refeitorio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private WeekdaysAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        this.adapter = new WeekdaysAdapter(this);
        recyclerView.setAdapter(this.adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



    @Override
    protected void onStart() {
        super.onStart();

        Service weekdays = Datasource.getServiceData();
        Call<List<Weekdays>> call = weekdays.getWeekdays();


        call.enqueue(new Callback<List<Weekdays>>() {
            @Override
            public void onResponse(Call<List<Weekdays>> call, Response<List<Weekdays>> response) {
                List<Weekdays> weekdaysList = response.body();

                adapter.updateList(weekdaysList);

            }

            @Override
            public void onFailure(Call<List<Weekdays>> call, Throwable t) {

            }
        });



    }


}