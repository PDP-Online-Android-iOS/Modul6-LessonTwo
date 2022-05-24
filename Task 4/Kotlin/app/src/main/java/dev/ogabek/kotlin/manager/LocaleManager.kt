package dev.ogabek.kotlin.manager

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import java.util.*

class LocaleManager(var context: Context) {
    fun updateLanguage(context: Context, language: String?) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
        PrefsManager(context).saveData("language", language)
    }

    private fun isAtLeastVersion(version: Int): Boolean {
        return Build.VERSION.SDK_INT >= version
    }

    companion object {
        const val LANGUAGE_ENGLISH = "en"
        const val LANGUAGE_RUSSIAN = "ru"
        const val LANGUAGE_UZBEK = "uz"
    }
}