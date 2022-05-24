package dev.ogabek.kotlin.manager

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class PrefsManager(val context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    fun setData(key: String, value: Long) {
        val prefsEditor = sharedPreferences.edit()
        prefsEditor.putLong(key, value)
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

}