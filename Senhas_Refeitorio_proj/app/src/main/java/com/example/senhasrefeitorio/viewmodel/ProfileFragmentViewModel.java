package com.example.senhasrefeitorio.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.senhasrefeitorio.model.Repository;

public class ProfileFragmentViewModel extends AndroidViewModel {
    private Repository repository;

    public ProfileFragmentViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }




    public void logOut(){
        this.repository.logout();
    }
}
