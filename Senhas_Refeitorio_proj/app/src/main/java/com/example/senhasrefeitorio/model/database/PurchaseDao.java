package com.example.senhasrefeitorio.model.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.senhasrefeitorio.model.Meal;
import com.example.senhasrefeitorio.model.Purchase;
import com.example.senhasrefeitorio.model.PurchaseWithMeal;

import java.util.List;

@Dao
public interface PurchaseDao {
    @Query("SELECT * FROM Purchase")
    List<Purchase> getAllPurchases();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(Purchase purchase);

    @Delete
    void delete(Purchase purchase);

    @Update
    void update(Purchase purchase);

    @Query("SELECT * FROM Purchase WHERE codUser = :codUser AND flgUsed = 1")
    LiveData<List<PurchaseWithMeal>> getUsedPurchaseWithMeal(long codUser);

    @Query("SELECT * FROM Purchase WHERE codUser = :codUser AND flgUsed = 0")
    LiveData<List<PurchaseWithMeal>> getPurchaseWithUnusedMeal(long codUser);
}
