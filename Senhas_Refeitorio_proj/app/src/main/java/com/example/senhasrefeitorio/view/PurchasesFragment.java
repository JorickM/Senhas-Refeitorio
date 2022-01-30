package com.example.senhasrefeitorio.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.Meal;
import com.example.senhasrefeitorio.model.Purchase;
import com.example.senhasrefeitorio.model.PurchaseWithMeal;
import com.example.senhasrefeitorio.model.User;
import com.example.senhasrefeitorio.model.sharedpreferences.SessionManager;
import com.example.senhasrefeitorio.viewmodel.MealDetailsFragmentViewModel;
import com.example.senhasrefeitorio.viewmodel.MealFragmentViewModel;
import com.example.senhasrefeitorio.viewmodel.PurchaseFragmentViewModel;

import java.util.List;

public class PurchasesFragment extends Fragment {

    private PurchaseFragmentViewModel mViewModel;
    private PurchaseAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_purcheses, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PurchaseFragmentViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        this.adapter = new PurchaseAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(this.adapter);

        User user = SessionManager.getActiveSession(getActivity());

        this.mViewModel.getAllPurchasesWithMealInformation(user.getCodUser()).observe(getActivity(), new Observer<List<PurchaseWithMeal>>() {
            @Override
            public void onChanged(List<PurchaseWithMeal> purchaseList) {
                PurchasesFragment.this.adapter.updateList(purchaseList);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        this.mViewModel.updateList();
    }
}