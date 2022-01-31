package com.example.senhasrefeitorio.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = Meal.class,
        parentColumns = "codMeal",
        childColumns = "codMeal",
        onDelete = ForeignKey.CASCADE)
})
public class Purchase {
    @PrimaryKey
    private long codPurchase;
    private long codMeal;
    @Ignore
    private Meal meal;
    private long codUser;
    private Integer flgUsed;

    public Purchase(long codPurchase, long codMeal, long codUser, Integer flgUsed) {
        this.codPurchase = codPurchase;
        this.codMeal = codMeal;
        this.codUser = codUser;
        this.flgUsed = flgUsed;
    }

    public long getCodPurchase() {
        return codPurchase;
    }

    public void setCodPurchase(long codPurchase) {
        this.codPurchase = codPurchase;
    }

    public long getCodMeal() {
        return codMeal;
    }

    public void setCodMeal(long codMeal) {
        this.codMeal = codMeal;
    }

    public long getCodUser() {
        return codUser;
    }

    public void setCodUser(long codUser) {
        this.codUser = codUser;
    }

    public Integer getFlgUsed() {
        return flgUsed;
    }

    public void setFlgUsed(Integer flgUsed) {
        this.flgUsed = flgUsed;
    }
}
