package com.example.senhasrefeitorio.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.User;
import com.example.senhasrefeitorio.model.sharedpreferences.SessionManager;
import com.example.senhasrefeitorio.viewmodel.LoginFragmentViewModel;

public class MainMenuFragment extends Fragment {
    private LoginFragmentViewModel mLoginViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        mLoginViewModel = new ViewModelProvider(this).get(LoginFragmentViewModel.class);

        User userFromLogin = SessionManager.getActiveSession(getActivity());

        ImageView imageView;
        imageView = view.findViewById(R.id.imgUser);

        Glide.with(this).load(userFromLogin.getUrl()).into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = NavHostFragment.findNavController(MainMenuFragment.this);
                navController.navigate(R.id.action_mainMenuFragment_to_profileFragment );
            }
        });

        Button btnGoToWeekDays = view.findViewById(R.id.btnWeekdays);
        Button btnGoToSenhas = view.findViewById(R.id.btnPurchases);

        btnGoToWeekDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = NavHostFragment.findNavController(MainMenuFragment.this);
                navController.navigate(R.id.action_mainMenuFragment_to_weekDay );
            }
        });

        btnGoToSenhas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavController navController = NavHostFragment.findNavController(MainMenuFragment.this);
//                navController.navigate(R.id.action_mainMenuFragment_to_weekDay );
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menuLogout:
                mLoginViewModel.logOut();
                NavController navController = NavHostFragment.findNavController(MainMenuFragment.this);
                navController.navigate(R.id.action_mainMenuFragment_to_loginFragment);
                return true;
        }
        return false;
    }

}