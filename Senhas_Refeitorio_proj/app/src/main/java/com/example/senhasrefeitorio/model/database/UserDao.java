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


   // @Query("SELECT userId FROM users WHERE email = :email")
   // LiveData<User> getUser(long idUser);

    @Update
    void update(List<User> userList);

    @Update
    void update(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(List<User> userList);
}
