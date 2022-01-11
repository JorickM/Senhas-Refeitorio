package com.example.senhasrefeitorio.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Purchase {
    @PrimaryKey
    private long codPurchase;
    private long mealId;
    private long userId;

    public Purchase(long codPurchase, long mealId, long userId) {
        this.codPurchase = codPurchase;
        this.mealId = mealId;
        this.userId = userId;
    }

    public long getCodPurchase() {
        return codPurchase;
    }

    public void setCodPurchase(long codPurchase) {
        this.codPurchase = codPurchase;
    }

    public long getMealId() {
        return mealId;
    }

    public void setMealId(long mealId) {
        this.mealId = mealId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
