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

    @Insert
    void add(List<Purchase> purchaseList);

    @Delete
    void delete(Purchase purchase);

    @Update
    void update(Purchase purchase);

    @Query("SELECT * FROM Purchase WHERE codUser = :codUser")
    LiveData<List<Purchase>> getOnePurchaseByCodMeal(long codUser);

    @Query("SELECT * FROM Purchase WHERE codUser = :codUser")
    LiveData<List<PurchaseWithMeal>> getPurchaseWithMeal(long codUser);
}
