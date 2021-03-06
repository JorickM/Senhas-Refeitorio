package com.example.senhasrefeitorio.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.senhasrefeitorio.model.User;
import com.example.senhasrefeitorio.model.Repository;

public class LoginFragmentViewModel extends AndroidViewModel {

    private Repository repository;

    public LoginFragmentViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }

    public LiveData<User> getUser() {
        return this.repository.getLoggedInUser();
    }

    public void tryToLogInUser(String email, String password) {
        this.repository.tryToLoginUser(email, password);
    }

    public void logOut(){
        this.repository.logout();
    }
}
