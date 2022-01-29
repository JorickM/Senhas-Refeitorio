package com.example.senhasrefeitorio.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.senhasrefeitorio.model.Meal;
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

    public LiveData<Meal> getOneMeal(long codMeal) {
        return this.repository.getOneMeal(codMeal);
    }
}

