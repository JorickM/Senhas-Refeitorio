package com.example.senhasrefeitorio.model.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.senhasrefeitorio.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User WHERE email LIKE :email AND password LIKE :password")
    LiveData<User> getUser(String email, String password);

    @Update
    void update(List<User> userList);

    @Update
    void update(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(User user);
}
