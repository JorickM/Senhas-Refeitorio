package com.example.senhasrefeitorio.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.senhasrefeitorio.model.MealType;
import com.example.senhasrefeitorio.model.Purchase;
import com.example.senhasrefeitorio.model.User;


@Database(entities = {User.class, MealType.class, Purchase.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao getUserao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "planetsDB").
                    build();
        }
        return INSTANCE;
    }
}
