package com.example.senhasrefeitorio.model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.senhasrefeitorio.model.remote.Datasource;
import com.example.senhasrefeitorio.model.remote.UserService;
import com.example.senhasrefeitorio.model.sharedpreferences.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private Context context;
    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    public UserRepository(Context context) {
        this.context = context;
    }

    public void tryToLoginUser(String email, String password) {
        Datasource.getUserService().getUser(email, password).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    if (response.body().size() > 0) {
                        User user1 = response.body().get(0);
                        SessionManager.saveSession(UserRepository.this.context, user1);
                        userMutableLiveData.postValue(user1);
                    } else {
                        userMutableLiveData.postValue(null);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                t.printStackTrace();
                userMutableLiveData.postValue(null);
            }
        });
    }

    public LiveData<User> getLoggedInUser() {
        this.getUserInternal();
        return userMutableLiveData;
    }

    private void getUserInternal() {
        User user = SessionManager.getActiveSession(this.context);
        userMutableLiveData.postValue(user);
    }

    public void logout() {
        SessionManager.clearSession(this.context);
    }

}
