package com.example.senhasrefeitorio.model;

import androidx.room.Embedded;
import androidx.room.Relation;

public class PurchaseWithMeal {

    @Embedded
    private Purchase purchase;

    @Relation(parentColumn = "codMeal", entityColumn = "codMeal", entity = Meal.class)
    private MealWithWeekday mealWithWeekday;

    public PurchaseWithMeal(Purchase purchase, MealWithWeekday mealWithWeekday) {
        this.purchase = purchase;
        this.mealWithWeekday = mealWithWeekday;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public MealWithWeekday getMealWithWeekday() {
        return mealWithWeekday;
    }

    public void setMealWithWeekday(MealWithWeekday mealWithWeekday) {
        this.mealWithWeekday = mealWithWeekday;
    }
}
