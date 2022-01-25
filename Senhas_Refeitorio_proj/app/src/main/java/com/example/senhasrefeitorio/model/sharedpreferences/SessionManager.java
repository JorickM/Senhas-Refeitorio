package com.example.senhasrefeitorio.model.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.senhasrefeitorio.model.User;

public class SessionManager {
    private SessionManager() {}

    private static SharedPreferences sharedPreferences;
    private static final String FILENAME = "sessionSharedPrefs";
    private static final String KEY_USER_CODE = "userID";
    private static final String KEY_USER_EMAIL = "email";


    private static SharedPreferences getSharedPreferences(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getApplicationContext().getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    public static void clearSession(Context context) {
        getSharedPreferences(context).edit().clear().apply();
    }

    public static User getActiveSession(Context context) {
        if (getSharedPreferences(context).contains(KEY_USER_EMAIL)) {
            User user = new User(getSharedPreferences(context).getString(KEY_USER_EMAIL, ""), "");
            return user;
        }
        return null;
    }

    public static void saveSession(Context context, User user) {
        getSharedPreferences(context).edit().putString(KEY_USER_EMAIL, user.getEmail()).apply();
    }


}
