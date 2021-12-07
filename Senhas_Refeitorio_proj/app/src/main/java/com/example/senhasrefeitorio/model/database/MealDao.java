package com.example.senhasrefeitorio.model.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.senhasrefeitorio.model.Meal;

import java.util.List;

@Dao
public interface MealDao {

    @Query("SELECT * FROM Meal")
    List<Meal> getAll();

    @Insert
    void add(Meal meal);

    @Insert
    void add(List<Meal> mealList);

    @Delete
    void delete(Meal meal);

    @Update
    void update(Meal meal);
}