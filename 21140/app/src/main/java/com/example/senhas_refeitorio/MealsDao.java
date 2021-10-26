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
public interface MealsDao {

    @Query("SELECT * FROM Meals")
    List<Meals> getAll();


    @Insert
    void add(Meals meals);

    @Insert
    void add(List<Meals> mealsList);

    @Delete
    void delete(Meals meals);

    @Update
    void update(Meals meals);
}