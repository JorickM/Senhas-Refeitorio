package com.example.senhas_refeitorio;

import androidx.room.PrimaryKey;

public class Weekdays {
    @PrimaryKey(autoGenerate = true)
    private long codWeekday;
    private String name;
    private String date;
    private int userlimit;
}
