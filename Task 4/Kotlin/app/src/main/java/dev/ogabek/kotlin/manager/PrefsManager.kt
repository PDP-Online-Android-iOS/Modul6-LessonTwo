package dev.ogabek.kotlin.manager

import android.content.Context
import android.content.SharedPreferences

class PrefsManager(context: Context) {
    var sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
    fun saveData(key: String?, value: String?) {
        val prefsEditor = sharedPreferences.edit()
        prefsEditor.putString(key, value)
        prefsEditor.apply()
    }

    fun getData(key: String?): String? {
        return sharedPreferences.getString(key, "en")
    }

}