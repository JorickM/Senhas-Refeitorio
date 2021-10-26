package com.example.senhas_refeitorio;

import android.content.Context;


import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {Meals.class, Weekdays.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MealsDao getMealsDao();
    public abstract WeekdaysDao getWeekdaysDao();


    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    "mealsDB")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            //insert into Meals
                            db.execSQL("INSERT INTO Meals (codMeal, mainDish, soup, dessert, codWeekday ,typeMeal) VALUES (1, 'Ensopado de Borrego','Creme de Cenoura', 'Laranja', 1)");
                            db.execSQL("INSERT INTO Meals (codMeal, mainDish, soup, dessert, codWeekday ,typeMeal) VALUES (2, 'Bacalhau com Natas','Creme de Cenoura', 'Pudim', 2)");
                            db.execSQL("INSERT INTO Meals (codMeal, mainDish, soup, dessert, codWeekday ,typeMeal) VALUES (3, 'Chili de Legumes','Creme de Cenoura', 'Maça', 3)");



                            //insert into Weekdays
                         //   db.execSQL("INSERT INTO Weekdays (codWeekday, weekdayName  , local, typeUser) VALUES (1, 'admin', 'admin', 'teste', '1')");

                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}
