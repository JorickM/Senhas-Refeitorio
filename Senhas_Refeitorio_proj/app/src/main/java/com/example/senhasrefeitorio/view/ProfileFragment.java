package com.example.senhasrefeitorio.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.User;
import com.example.senhasrefeitorio.model.sharedpreferences.SessionManager;
import com.example.senhasrefeitorio.viewmodel.LoginFragmentViewModel;
import com.example.senhasrefeitorio.viewmodel.ProfileFragmentViewModel;

public class ProfileFragment extends Fragment {
    private ProfileFragmentViewModel viewModel;
    private LoginFragmentViewModel mLoginViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.viewModel = new ViewModelProvider(this).get(ProfileFragmentViewModel.class);
        this.mLoginViewModel = new ViewModelProvider(this).get(LoginFragmentViewModel.class);

        ImageView imageView;
        imageView = view.findViewById(R.id.imgUserProfile);

        User userFromLogin = SessionManager.getActiveSession(getActivity());

        Glide.with(this).load(userFromLogin.getUrl()).into(imageView);

        Button logout = view.findViewById(R.id.btnLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginViewModel.logOut();
                NavController navController = NavHostFragment.findNavController(ProfileFragment.this);
                navController.navigate(R.id.action_profileFragment_to_loginFragment);
            }
        });

        Button button = view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = NavHostFragment.findNavController(ProfileFragment.this);
                navController.navigate(R.id.action_profileFragment_to_consumedPurchaseFragment);
            }
        });
    }
}