package dev.ogabek.kotlin

import android.app.Application
import dev.ogabek.kotlin.manager.LocaleManager
import dev.ogabek.kotlin.manager.PrefsManager

class App : Application() {

    var localeManager: LocaleManager? = null

    override fun onCreate() {
        super.onCreate()
        localeManager = LocaleManager(this)
        localeManager!!.updateLanguage(this, PrefsManager(this).getData("language"))
    }
}