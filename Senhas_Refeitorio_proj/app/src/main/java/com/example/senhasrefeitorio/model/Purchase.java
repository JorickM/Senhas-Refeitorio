package com.example.senhasrefeitorio.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
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
    private long codUser;
    private boolean flgUsed;

    public Purchase(long codPurchase, long codMeal, long codUser, boolean flgUsed) {
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

    public boolean isFlgUsed() {
        return flgUsed;
    }

    public void setFlgUsed(boolean flgUsed) {
        this.flgUsed = flgUsed;
    }
}
