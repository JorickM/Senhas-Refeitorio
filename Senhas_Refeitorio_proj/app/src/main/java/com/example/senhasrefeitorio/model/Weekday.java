package com.example.senhasrefeitorio.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Weekday {
    @PrimaryKey
    private long codWeekday;
    private String name;
    private String date;
    private int userlimit;

    public Weekday(long codWeekday, String name, String date, int userlimit) {
        this.codWeekday = codWeekday;
        this.name = name;
        this.date = date;
        this.userlimit = userlimit;
    }

    public long getCodWeekday() {
        return codWeekday;
    }

    public void setCodWeekday(long codWeekday) {
        this.codWeekday = codWeekday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUserlimit() {
        return userlimit;
    }

    public void setUserlimit(int userlimit) {
        this.userlimit = userlimit;
    }
}
