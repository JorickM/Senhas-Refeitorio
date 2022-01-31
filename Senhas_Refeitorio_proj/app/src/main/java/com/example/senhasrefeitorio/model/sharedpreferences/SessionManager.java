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
    private static final String KEY_USER_NAME = "userName";
    private static final String KEY_USER_LAST_NAME = "userLastName";
    private static final String KEY_USER_URL = "userURL";

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
            SharedPreferences sharedPreferences = getSharedPreferences(context);
            long code = sharedPreferences.getLong(KEY_USER_CODE, 0);
            String name = sharedPreferences.getString(KEY_USER_NAME, "");
            String lastName = sharedPreferences.getString(KEY_USER_LAST_NAME, "");
            String email = sharedPreferences.getString(KEY_USER_EMAIL, "");
            String url = sharedPreferences.getString(KEY_USER_URL, "");
            User user = new User(code, name, lastName, email, "", url);
            return user;
        }
        return null;
    }

    public static void saveSession(Context context, User user) {
        getSharedPreferences(context).edit()
                .putLong(KEY_USER_CODE, user.getCodUser())
                .putString(KEY_USER_NAME, user.getName())
                .putString(KEY_USER_LAST_NAME, user.getLastName())
                .putString(KEY_USER_EMAIL, user.getEmail())
                .putString(KEY_USER_URL, user.getUrl())
                .apply();
    }
//KEY_USER_CODE , user.getCodUser()

}
