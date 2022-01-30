package com.example.senhasrefeitorio.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.senhasrefeitorio.model.Repository;
import com.example.senhasrefeitorio.model.Weekday;

import java.util.List;

public class WeekDayFragmentViewModel extends AndroidViewModel {
    private Repository repository;

    public WeekDayFragmentViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }

    public LiveData<List<Weekday>> getAllWeekdays(){
        return this.repository.getAllWeekdays();
    }

    public void updateList() {
        this.repository.updateWeekDayList();
    }
}