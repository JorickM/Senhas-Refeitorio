package com.example.senhasrefeitorio.view;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.senhasrefeitorio.model.Meal;
import com.example.senhasrefeitorio.viewmodel.MealFragmentViewModel;
import com.example.senhasrefeitorio.R;

import java.util.List;

public class MealFragment extends Fragment implements MealAdapter.MealNavigator {

    private MealFragmentViewModel mViewModel;
    private MealAdapter adapter;
    private long codWeekDay;

    public static MealFragment newInstance() {
        return new MealFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.meal_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MealFragmentViewModel.class);

        MealFragmentArgs args = MealFragmentArgs.fromBundle(getArguments());
        this.codWeekDay = args.getCodWeekDay();

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView2);
        this.adapter = new MealAdapter(getActivity(),this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(this.adapter);

        this.mViewModel.getAllMeals(codWeekDay).observe(getActivity(), new Observer<List<Meal>>() {
            @Override
            public void onChanged(List<Meal> mealList) {
                MealFragment.this.adapter.updateList(mealList);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        this.mViewModel.updateList();
    }

    @Override
    public void goToPurchase(long codMeal) {
        NavDirections action =
                MealFragmentDirections.actionMealtoPurchaseFragment(codMeal);
        NavHostFragment.findNavController(this).navigate(action);
    }
}