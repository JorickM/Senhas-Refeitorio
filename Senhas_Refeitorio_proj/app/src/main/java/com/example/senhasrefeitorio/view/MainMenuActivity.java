package com.example.senhasrefeitorio.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.User;

public class MainMenuActivity extends AppCompatActivity {


    private static final String KEY_ID = "id";

    public static void startActivity(Context context, User user) {
        Intent intent = new Intent(context, MainMenuActivity.class);
        intent.putExtra(KEY_ID, id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ImageView imageView;
        imageView = findViewById(R.id.imgUser);

        //User user = LoginActivity.getUser();
        //Glide.with(this).load(user.getUrl()).into(imageView);
    }

    public void goToEmenta(View view) {
        //Intent intent = new Intent(this, MealActivity.class);
        //startActivity(intent);
    }

    public void goToSenhas(View view) {
        //Intent intent = new Intent(this, SenhaActivity.class);
        //startActivity(intent);
    }

}