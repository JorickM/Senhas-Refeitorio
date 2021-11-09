package com.example.senhas_refeitorio;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

    @Dao
    public interface WeekdaysDao {

        @Query("SELECT * FROM Weekdays")
        List<Meals> getAll();

        @Insert
        void add(Weekdays weekdays);

        @Insert
        void add(List<Weekdays> weekdaysList);

        @Delete
        void delete(Weekdays weekdays);

        @Update
        void update(Weekdays weekdays);
    }