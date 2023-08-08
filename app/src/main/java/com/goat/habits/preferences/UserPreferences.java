package com.goat.habits.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {

    SharedPreferences preferences;

    public UserPreferences(Context context){
        preferences = context.getSharedPreferences("UserPreferences",Context.MODE_PRIVATE);
    }

    public void setPreference(String keyPref, String stringToSave){
        preferences.edit().putString(keyPref, stringToSave).apply();
    }

    public String getPreferences(String name){
        return preferences.getString(name, "Seu Nome");
    }
}
