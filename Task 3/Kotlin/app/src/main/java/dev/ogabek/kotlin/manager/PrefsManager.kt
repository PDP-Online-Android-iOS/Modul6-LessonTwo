package dev.ogabek.kotlin.manager

import android.content.Context
import android.content.SharedPreferences

class PrefsManager(context: Context) {

    var sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun setData(key: String, value: Long) {
        val prefsEditor = sharedPreferences.edit()
        prefsEditor.putLong(key, value)
        prefsEditor.apply()
    }

    fun setData(key: String, value: String?) {
        val prefsEditor = sharedPreferences.edit()
        prefsEditor.putString(key, value)
        prefsEditor.apply()
    }

    fun setData(key: String, value: Boolean) {
        val prefsEditor = sharedPreferences.edit()
        prefsEditor.putBoolean(key, value)
        prefsEditor.apply()
    }

    fun setData(key: String, value: Int) {
        val prefsEditor = sharedPreferences.edit()
        prefsEditor.putInt(key, value)
        prefsEditor.apply()
    }

    fun setData(key: String, value: Double) {
        val prefsEditor = sharedPreferences.edit()
        prefsEditor.putFloat(key, value.toFloat())
        prefsEditor.apply()
    }

    fun getLongData(key: String): Long {
        return sharedPreferences.getLong(key, 0)
    }

    fun getBooleanData(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun getIntData(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

    fun getDoubleData(key: String): Double {
        return sharedPreferences.getFloat(key, 0f).toDouble()
    }

    fun getStringData(key: String): String? {
        return sharedPreferences.getString(key, "")
    }

}