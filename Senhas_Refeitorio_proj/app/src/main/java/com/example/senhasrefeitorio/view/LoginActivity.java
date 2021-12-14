package com.example.senhasrefeitorio.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.User;
import com.example.senhasrefeitorio.viewmodel.LoginActivityViewModel;

public class LoginActivity extends AppCompatActivity {

    private LoginActivityViewModel viewModel;
    private boolean tryingToLogIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.viewModel = new ViewModelProvider(this).get(LoginActivityViewModel.class);

        this.viewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user == null) {
                    if (tryingToLogIn) {
                        Toast.makeText(LoginActivity.this, "Dados errados!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    MainMenuActivity.startActivity(LoginActivity.this);
                    finish();
                }
                // fim do login
            }
        });
    }

    public void login(View view) {
        EditText insertEmail, insertPassword;
        String email, password;

        insertEmail = findViewById(R.id.editTextEmail);
        insertPassword = findViewById(R.id.editTextPassword);

        email = String.valueOf(insertEmail.getText());
        password = String.valueOf(insertPassword.getText());

        tryingToLogIn = true;
        this.viewModel.tryToLogInUser(email, password);
    }
}