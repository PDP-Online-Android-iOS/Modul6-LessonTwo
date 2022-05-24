package dev.ogabek.java.manager;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsManager {

    public SharedPreferences sharedPreferences;

    public PrefsManager(Context context) {
       sharedPreferences  = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
    }

    public void saveData(String key, String value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }

    public String getData(String key) {
        return sharedPreferences.getString(key, "en");
    }

}
