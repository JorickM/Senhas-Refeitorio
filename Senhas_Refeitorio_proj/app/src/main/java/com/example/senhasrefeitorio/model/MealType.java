package com.example.senhasrefeitorio.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MealType {
    @PrimaryKey
    private long codMealType;
    private String name;

    public MealType(long codMealType, String name) {
        this.codMealType = codMealType;
        this.name = name;
    }

    public long getCodMealType() {
        return codMealType;
    }

    public void setCodMealType(long codMealType) {
        this.codMealType = codMealType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
