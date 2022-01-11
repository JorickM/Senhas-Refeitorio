package com.example.senhasrefeitorio.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.senhasrefeitorio.model.Repository;
import com.example.senhasrefeitorio.model.Weekday;
import com.example.senhasrefeitorio.model.database.AppDatabase;
import com.example.senhasrefeitorio.model.database.WeekdayDao;
import com.example.senhasrefeitorio.model.remote.Datasource;
import com.example.senhasrefeitorio.model.remote.WeekdayService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeekdayActivityViewModel extends AndroidViewModel {

    private Repository repository;

    public WeekdayActivityViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }

    public LiveData<List<Weekday>> getAllWeekdays(){
        return this.repository.getAllWeekdays();
    }


    public void updateList() {
        this.repository.updateList();
    }














}
