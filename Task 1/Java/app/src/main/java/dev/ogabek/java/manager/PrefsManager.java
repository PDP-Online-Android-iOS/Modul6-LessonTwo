package dev.ogabek.java.manager;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsManager {

    SharedPreferences sharedPreferences;

    public PrefsManager(Context context) {
        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
    }

    public void setData(String key, long value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putLong(key, value);
        prefsEditor.apply();
    }

    public void setData(String key, boolean value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
    }

    public void setData(String key, int value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putInt(key, value);
        prefsEditor.apply();
    }

    public void setData(String key, double value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putFloat(key, (float) value);
        prefsEditor.apply();
    }

    public long getLongData(String key) {
        return sharedPreferences.getLong(key, 0);
    }

    public boolean getBooleanData(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public int getIntData(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public double getDoubleData(String key) {
        return sharedPreferences.getFloat(key, 0);
    }

}
