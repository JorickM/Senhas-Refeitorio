package com.example.senhasrefeitorio.model.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.senhasrefeitorio.model.MealType;

import java.util.List;

@Dao
public interface MealTypeDao {
    @Query("SELECT * FROM MealType")
    List<MealType> getAllMealType();

    @Insert
    void add(MealType mealType);

    @Insert
    void add(List<MealType> mealTypeList);

    @Delete
    void delete(MealType mealType);

    @Update
    void update(MealType mealType);
}
