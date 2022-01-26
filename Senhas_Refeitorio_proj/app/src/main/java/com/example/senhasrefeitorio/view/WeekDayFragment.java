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

import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.Weekday;
import com.example.senhasrefeitorio.viewmodel.WeekDayFragmentViewModel;

import java.util.List;

public class WeekDayFragment extends Fragment implements WeekdayAdapter.WeekDayNavigator {

    private WeekDayFragmentViewModel mViewModel;
    private WeekdayAdapter adapter;

    public static WeekDayFragment newInstance() {
        return new WeekDayFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.week_day_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WeekDayFragmentViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView2);
        this.adapter = new WeekdayAdapter(getActivity(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(this.adapter);

        this.mViewModel.getAllWeekdays().observe(getActivity(), new Observer<List<Weekday>>() {
            @Override
            public void onChanged(List<Weekday> weekdays) {
                WeekDayFragment.this.adapter.updateList(weekdays);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        this.mViewModel.updateList();
    }

    @Override
    public void goToMeals(long codWeekDay) {
        NavDirections action =
                WeekDayFragmentDirections.actionweekDaytomealFragment(codWeekDay);
        NavHostFragment.findNavController(this).navigate(action);
    }
}