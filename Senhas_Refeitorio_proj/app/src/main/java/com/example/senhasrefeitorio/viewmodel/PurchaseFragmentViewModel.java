package com.example.senhasrefeitorio.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.senhasrefeitorio.model.Purchase;
import com.example.senhasrefeitorio.model.Repository;

import java.util.List;

public class PurchaseFragmentViewModel extends AndroidViewModel {

    private Repository repository;

    public PurchaseFragmentViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }

    public void updateList() {
        this.repository.updatePurchaseList();
    }

    public LiveData<List<Purchase>> getAllPurchase(long codUser) {
        return this.repository.getPurchaseByUser(codUser);
    }
}
