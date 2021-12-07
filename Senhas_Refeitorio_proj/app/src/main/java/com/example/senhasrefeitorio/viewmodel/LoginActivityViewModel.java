package com.example.senhasrefeitorio.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.senhasrefeitorio.model.User;
import com.example.senhasrefeitorio.model.UserRepository;

import java.util.List;

public class LoginActivityViewModel extends AndroidViewModel {

    private UserRepository repository;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        this.repository = new UserRepository(application);
    }

    public LiveData<User> getUser(String email, String passowrd) {
        return this.repository.getUser(email, passowrd);
    }

}
