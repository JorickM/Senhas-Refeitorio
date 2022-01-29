package com.example.senhasrefeitorio.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Meal {
    @PrimaryKey
    private long codMeal;
    private String mainDish;
    private String soup;
    private String desert;
    private long codWeekday;
    private String url;

    public Meal(long codMeal, String mainDish, String soup, String desert, long codWeekday, String url) {
        this.codMeal = codMeal;
        this.mainDish = mainDish;
        this.soup = soup;
        this.desert = desert;
        this.codWeekday = codWeekday;
        this.url = url;
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

    public String getDesert() {
        return desert;
    }

    public void setDesert(String desert) {
        this.desert = desert;
    }

    public long getCodWeekday() {
        return codWeekday;
    }

    public void setCodWeekday(long codWeekday) {
        this.codWeekday = codWeekday;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
