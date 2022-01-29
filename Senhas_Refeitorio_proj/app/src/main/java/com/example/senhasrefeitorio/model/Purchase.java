package com.example.senhasrefeitorio.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Purchase {
    @PrimaryKey
    private long codPurchase;
    private long codMeal;
    private long codUser;

    public Purchase(long codPurchase, long codMeal, long codUser) {
        this.codPurchase = codPurchase;
        this.codMeal = codMeal;
        this.codUser = codUser;
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
}
