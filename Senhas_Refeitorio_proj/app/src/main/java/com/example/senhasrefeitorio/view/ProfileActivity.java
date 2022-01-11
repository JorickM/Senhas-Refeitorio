package com.example.senhasrefeitorio.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.User;
import com.example.senhasrefeitorio.viewmodel.LoginActivityViewModel;
import com.example.senhasrefeitorio.viewmodel.ProfileActivityViewModel;

public class ProfileActivity extends AppCompatActivity {

    private static User userFromLogin;
    private ProfileActivityViewModel viewModel;

    public static void startActivity(Context context, User user) {
        Intent intent = new Intent(context, ProfileActivity.class);
        userFromLogin = user;
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        this.viewModel = new ViewModelProvider(this).get(ProfileActivityViewModel.class);

        ImageView imageView;
        imageView = findViewById(R.id.imgUserProfile);

        Glide.with(this).load(userFromLogin.getUrl()).into(imageView);
    }


    public void logOut(View view) {
        viewModel.logOut();
        LoginActivity.startActivity(this);
    }


}