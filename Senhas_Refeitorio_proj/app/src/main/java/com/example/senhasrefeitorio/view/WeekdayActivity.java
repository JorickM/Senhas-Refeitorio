package com.example.senhasrefeitorio.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.Weekday;
import com.example.senhasrefeitorio.model.WeekdayAdapter;
import com.example.senhasrefeitorio.viewmodel.WeekdayActivityViewModel;

import java.util.List;

public class WeekdayActivity extends AppCompatActivity {

    private WeekdayAdapter adapter;
    private WeekdayActivityViewModel viewModel;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, WeekdayActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekday);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        this.adapter = new WeekdayAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(this.adapter);

        this.viewModel = new ViewModelProvider(this).get(WeekdayActivityViewModel.class);

        this.viewModel.getWeekday().observe(this, new Observer<List<Weekday>>() {
            @Override
            public void onChanged(List<Weekday> weekdays) {
                WeekdayActivity.this.adapter.updateList(weekdays);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        this.viewModel.updateList();
    }

}