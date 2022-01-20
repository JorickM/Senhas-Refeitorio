package com.example.senhasrefeitorio.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Meal {
    @PrimaryKey
    private long codMeal;
    private String mainDish;
    private String soup;
    private String dessert;
    private long codWeekday;
    private long codMealType;


    public Meal(long codMeal, String mainDish, String soup, String dessert, long codWeekday, long codMealType) {
        this.codMeal = codMeal;
        this.mainDish = mainDish;
        this.soup = soup;
        this.dessert = dessert;
        this.codWeekday = codWeekday;
        this.codMealType = codMealType;
    }

    public long getCodMeal() {
        return codMeal;
    }

    public void setCodMeal(long codMeal) {
        this.codMeal = codMeal;
    }

    public String getMainDish() {
        return mainDish;
    }

    public void setMainDish(String mainDish) {
        this.mainDish = mainDish;
    }

    public String getSoup() {
        return soup;
    }

    public void setSoup(String soup) {
        this.soup = soup;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public long getCodWeekday() {
        return codWeekday;
    }

    public void setCodWeekday(long codWeekday) {
        this.codWeekday = codWeekday;
    }

    public long getCodMealType() {
        return codMealType;
    }

    public void setCodMealType(int typeMeal) {
        this.codMealType = codMealType;
    }
}
