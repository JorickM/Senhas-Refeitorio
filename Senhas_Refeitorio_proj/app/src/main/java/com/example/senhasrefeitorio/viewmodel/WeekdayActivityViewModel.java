package com.example.senhasrefeitorio.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

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

    private WeekdayDao weekdayDao;

    public WeekdayActivityViewModel(@NonNull Application application) {
        super(application);
        this.weekdayDao = AppDatabase.getInstance(application.getApplicationContext()).getWeekDaysDao();
    }

    public LiveData<List<Weekday>> getWeekday() {
        return this.weekdayDao.getAllWeekdays();
    }

    public void updateList() {
        WeekdayService service = Datasource.getWeekdayService();

        Call<List<Weekday>> call = service.getWeekDays();

        call.enqueue(new Callback<List<Weekday>>() {
            @Override
            public void onResponse(Call<List<Weekday>> call, Response<List<Weekday>> response) {
                // Main Thread
                if (response.isSuccessful()) {
                    List<Weekday> weekdayList = response.body();
                    if (weekdayList.size() > 0) {
                        // Need a new Thread because we are on UI Thread
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                // Update list on Room Table
                                weekdayDao.add(weekdayList);
                            }
                        }).start();
                    }
                } else {
                    // Resposta mal sucedida
                    // Snakbar
                }
            }

            @Override
            public void onFailure(Call<List<Weekday>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }














}
