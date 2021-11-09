package com.example.projeto_pas;

public class MealType {
    private long mealTypeId;
    private String description;

    public long getMealTypeId() {
        return mealTypeId;
    }

    public void setMealTypeId(long mealTypeId) {
        this.mealTypeId = mealTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MealType(long mealTypeId, String description) {
        this.mealTypeId = mealTypeId;
        this.description = description;
    }
}
