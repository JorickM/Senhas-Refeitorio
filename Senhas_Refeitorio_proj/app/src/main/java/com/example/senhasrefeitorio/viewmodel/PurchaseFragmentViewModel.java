package com.example.senhasrefeitorio.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.senhasrefeitorio.model.Purchase;
import com.example.senhasrefeitorio.model.PurchaseWithMeal;
import com.example.senhasrefeitorio.model.Repository;

import java.util.List;

public class PurchaseFragmentViewModel extends AndroidViewModel {

    private Repository repository;

    public PurchaseFragmentViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }

    public void updatePurchaseList(Long codUser) {
        this.repository.updatePurchaseList(codUser);
    }

    public LiveData<List<PurchaseWithMeal>> getUsedPurchases(long codUser) {
        return this.repository.getUsedPurchases(codUser);
    }

    public LiveData<List<PurchaseWithMeal>> getPurchaseWithUnusedMeal(long codUser) {
        return this.repository.getPurchaseWithUnusedMeal(codUser);
    }
}
