package com.example.projeto_pas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MealTypeAdapter adapter;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView =findViewById(R.id.recyclerView);
        this.adapter =new MealTypeAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(this.adapter);

        this.viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        this.viewModel.getMealTypeLiveData().observe(this, new Observer<List<MealType>>() {
            @Override
            public void onChanged(List<MealType> mealTypeList) {
                MainActivity.this.adapter.updateList(mealTypeList);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.viewModel.updateList();
    }
}