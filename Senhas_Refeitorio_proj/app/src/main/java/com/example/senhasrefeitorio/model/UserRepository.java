package com.example.senhasrefeitorio.model;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.senhasrefeitorio.model.database.AppDatabase;
import com.example.senhasrefeitorio.model.database.UserDao;

public class UserRepository {

    private UserDao userDao;

    public UserRepository(Context context) {
        this.userDao = AppDatabase.getInstance(context).getUserDao();
    }

    public LiveData<User> getUser(String email, String password) {
        return this.userDao.getUser(email,password);
    }




}
