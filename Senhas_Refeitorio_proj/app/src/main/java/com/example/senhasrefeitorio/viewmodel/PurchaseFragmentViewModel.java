package com.example.senhasrefeitorio.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.senhasrefeitorio.model.Purchase;
import com.example.senhasrefeitorio.model.Repository;

public class PurchaseFragmentViewModel  extends AndroidViewModel {


    private Repository repository;

    public PurchaseFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public void addPurchase(Purchase purchase) {
        this.repository.addPurchase(purchase);
    }
}

