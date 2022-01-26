package com.example.senhasrefeitorio.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.senhasrefeitorio.model.Meal;
import com.example.senhasrefeitorio.model.Repository;
import com.example.senhasrefeitorio.model.Weekday;

import java.util.List;

public class MealFragmentViewModel extends AndroidViewModel {

    private Repository repository;

    public MealFragmentViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }

    public LiveData<List<Meal>> getAllMeals(long codWeekday) {
        return this.repository.getAllMeals(codWeekday);
    }

    public void updateList() {
        this.repository.updateMealList();
    }
}