package com.example.senhasrefeitorio.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.senhasrefeitorio.model.User;

import pt.ipbeja.estig.twdm.pdm1.planetsretrofitexample.model.Planet;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PlanetDao getPlanetDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "planetsDB").
                    build();
        }
        return INSTANCE;
    }
}
