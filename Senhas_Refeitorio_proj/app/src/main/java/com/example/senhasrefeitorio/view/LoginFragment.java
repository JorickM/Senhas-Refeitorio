package com.example.senhasrefeitorio.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.User;
import com.example.senhasrefeitorio.viewmodel.LoginFragmentViewModel;


public class LoginFragment extends Fragment {

    private LoginFragmentViewModel viewModel;
    private boolean tryingToLogIn = false;
    private int progressTime;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.button);

        this.viewModel = new ViewModelProvider(this).get(LoginFragmentViewModel.class);

        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setVisibility(view.INVISIBLE);

        this.viewModel.getUser().observe(getActivity(), new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user == null) {
                    if (tryingToLogIn) {
                        Toast.makeText(getActivity(), "Dados errados!", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                } else {
                    NavController navController = NavHostFragment.findNavController(LoginFragment.this);
                    navController.navigate(R.id.action_loginFragment_to_mainMenuFragment);
                }
            }
        });

        EditText insertEmail, insertPassword;
        insertEmail = view.findViewById(R.id.editTextEmail);
        insertPassword = view.findViewById(R.id.editTextPassword);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Handler mHandler = new Handler();
                progressTime = 0;
                progressBar.setVisibility(view.VISIBLE);

                new Thread(new Runnable() {
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
                String email, password;
                email = insertEmail.getText().toString();
                password = insertPassword.getText().toString();

                tryingToLogIn = true;
                viewModel.tryToLogInUser(email, password);
            }
        });

    }

}