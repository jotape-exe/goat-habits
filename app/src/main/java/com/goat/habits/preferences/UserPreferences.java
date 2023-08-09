package com.goat.habits.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {

    SharedPreferences preferences;

    public UserPreferences(Context context){
        preferences = context.getSharedPreferences("UserPreferences",Context.MODE_PRIVATE);
    }

    public void setNamePreference(String keyPref, String stringToSave){
        preferences.edit().putString(keyPref, stringToSave).apply();
    }

    public String getNamePreferences(String name){
        return preferences.getString(name, "Seu Nome");
    }

    public void setHabitCountPreference(String keyPref, Long habitCount){
        Long currentCount = getHabitCountPreferences(keyPref);
        habitCount += currentCount;
        preferences.edit().putLong(keyPref, habitCount).apply();
    }

    public Long getHabitCountPreferences(String key){
        return preferences.getLong(key,0);
    }

}
