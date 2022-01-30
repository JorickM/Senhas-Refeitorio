package com.example.senhasrefeitorio.model;

import androidx.room.Embedded;
import androidx.room.Relation;

public class MealWithWeekday {
    @Embedded
    private Meal meal;

    @Relation(parentColumn = "codWeekday", entityColumn = "codWeekday", entity = Weekday.class)
    private Weekday weekday;

    public MealWithWeekday(Meal meal, Weekday weekday) {
        this.meal = meal;
        this.weekday = weekday;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public void setWeekday(Weekday weekday) {
        this.weekday = weekday;
    }
}
