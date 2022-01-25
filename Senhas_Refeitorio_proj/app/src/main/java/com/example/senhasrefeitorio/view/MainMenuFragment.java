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
import com.example.senhasrefeitorio.viewmodel.LoginActivityViewModel;

public class MainMenuFragment extends Fragment {

    private static User userFromLogin;
    private LoginActivityViewModel mLoginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);

        userFromLogin = SessionManager.getActiveSession(getActivity());

        mLoginViewModel = new ViewModelProvider(this).get(LoginActivityViewModel.class);

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

    }



    public void goToEmenta(View view) {

    }

    public void goToSenhas(View view) {
        //Intent intent = new Intent(this, SenhaActivity.class);
        //startActivity(intent);
    }

    public void goToProfile(View view) {
        //ProfileActivity.startActivity(MainMenuActivity.this, userFromLogin);
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