package com.example.senhasrefeitorio.model.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.senhasrefeitorio.model.Weekdays;

import java.util.List;

@Dao
public interface WeekdayDao {

    @Query("SELECT * FROM Weekdays")
    List<Weekdays> getAll();

    @Insert
    void add(Weekdays weekdays);

    @Insert
    void add(List<Weekdays> weekdaysList);

    @Delete
    void delete(Weekdays weekdays);

    @Update
    void update(Weekdays weekdays);
}