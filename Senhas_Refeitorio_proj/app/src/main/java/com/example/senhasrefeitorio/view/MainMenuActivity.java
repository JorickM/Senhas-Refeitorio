package com.example.senhasrefeitorio.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.User;
import com.example.senhasrefeitorio.viewmodel.LoginActivityViewModel;

public class MainMenuActivity extends AppCompatActivity {

    private static User userFromLogin;

    public static void startActivity(Context context, User user) {
        Intent intent = new Intent(context, MainMenuActivity.class);
        userFromLogin = user;
        context.startActivity(intent);
    }

    private LoginActivityViewModel mLoginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mLoginViewModel = new ViewModelProvider(this).get(LoginActivityViewModel.class);

        ImageView imageView;
        imageView = findViewById(R.id.imgUser);

        Glide.with(this).load(userFromLogin.getUrl()).into(imageView);
    }

    public void goToEmenta(View view) {
        Intent intent = new Intent(this, WeekdayActivity.class);
        startActivity(intent);
    }

    public void goToSenhas(View view) {
        //Intent intent = new Intent(this, SenhaActivity.class);
        //startActivity(intent);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menuLogout:
                mLoginViewModel.logOut();
                LoginActivity.startActivity(this);
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void goToProfile(View view) {

    }

}