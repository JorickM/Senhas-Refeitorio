package com.example.senhasrefeitorio.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.senhasrefeitorio.model.Meal;
import com.example.senhasrefeitorio.model.MealType;
import com.example.senhasrefeitorio.model.Purchase;
import com.example.senhasrefeitorio.model.User;
import com.example.senhasrefeitorio.model.Weekday;


@Database(entities = {User.class, MealType.class, Purchase.class, Meal.class, Weekday.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MealDao getMealsDao();
    public abstract MealTypeDao getMealTypeDao();
    public abstract PurchaseDao getPurchaseDao();
    public abstract UserDao getUserDao();
    public abstract WeekdayDao getWeekDaysDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "senhasDB").
                    build();
        }
        return INSTANCE;
    }
}
