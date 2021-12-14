package com.example.senhasrefeitorio.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.User;
import com.example.senhasrefeitorio.viewmodel.LoginActivityViewModel;

public class LoginActivity extends AppCompatActivity {

    private LoginActivityViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.viewModel = new ViewModelProvider(this).get(LoginActivityViewModel.class);
    }

    public void login(View view) {
        EditText insertEmail, insertPassword;
        String email, password;



        insertEmail = findViewById(R.id.editTextEmail);
        insertPassword = findViewById(R.id.editTextPassword);

        email = String.valueOf(insertEmail.getText());
        password = String.valueOf(insertPassword.getText());

        // inicio do login
        LiveData<User> userLiveData = this.viewModel.getUser(email, password);
        Observer<User> observer = new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user == null) {
                    // User não existe

                } else {
                    // User existe
                    
                }
                // fim do login
            }
        };
        userLiveData.observe(this, observer);
    }
}