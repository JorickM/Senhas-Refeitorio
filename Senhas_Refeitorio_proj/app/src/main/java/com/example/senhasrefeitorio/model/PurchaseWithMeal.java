package com.example.senhasrefeitorio.model;

import androidx.room.Embedded;
import androidx.room.Relation;

public class PurchaseWithMeal {

    @Embedded
    private Purchase purchase;

    @Relation(parentColumn = "codMeal", entityColumn = "codMeal", entity = Meal.class)
    private MealWithWeekday meal;

    public PurchaseWithMeal(Purchase purchase, MealWithWeekday meal) {
        this.purchase = purchase;
        this.meal = meal;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public MealWithWeekday getMeal() {
        return meal;
    }

    public void setMeal(MealWithWeekday meal) {
        this.meal = meal;
    }
}
