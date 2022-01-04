package com.example.senhasrefeitorio.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.User;
import com.example.senhasrefeitorio.viewmodel.LoginActivityViewModel;

public class LoginActivity extends AppCompatActivity {

    private LoginActivityViewModel viewModel;
    private boolean tryingToLogIn = false;
    private int progressTime;
    private ProgressBar progressBar;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.viewModel = new ViewModelProvider(this).get(LoginActivityViewModel.class);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        this.viewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user == null) {
                    if (tryingToLogIn) {
                        Toast.makeText(LoginActivity.this, "Dados errados!", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                } else {
                    MainMenuActivity.startActivity(LoginActivity.this, user);
                    finish();
                }
            }
        });
    }

    public void login(View view) {
        EditText insertEmail, insertPassword;
        String email, password;

        Handler mHandler = new Handler();
        progressTime = 0;
        progressBar.setVisibility(View.VISIBLE);

        insertEmail = findViewById(R.id.editTextEmail);
        insertPassword = findViewById(R.id.editTextPassword);

        new  Thread(new Runnable() {
            @Override
            public void run() {
                while (progressTime < 100){
                    progressTime++;
                    android.os.SystemClock.sleep(50);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressTime);
                        }
                    });
                    if (progressTime == 99){
                        progressTime = 0;
                    }
                }
            }
        }).start();

        email = String.valueOf(insertEmail.getText());
        password = String.valueOf(insertPassword.getText());

        tryingToLogIn = true;
        this.viewModel.tryToLogInUser(email, password);
    }
}