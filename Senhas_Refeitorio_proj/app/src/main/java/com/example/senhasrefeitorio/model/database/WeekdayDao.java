package com.example.senhasrefeitorio.model.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.senhasrefeitorio.model.Weekday;

import java.util.List;

@Dao
public interface WeekdayDao {

    @Query("SELECT * FROM Weekday")
    List<Weekday> getAll();

    @Query("SELECT * FROM Weekday")
    LiveData<List<Weekday>> getAllWeekdays();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(List<Weekday> weekdayList);

    @Delete
    void delete(Weekday weekdays);

    @Update
    void update(Weekday weekdays);
}