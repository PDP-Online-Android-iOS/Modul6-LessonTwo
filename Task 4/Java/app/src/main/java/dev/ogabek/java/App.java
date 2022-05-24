package dev.ogabek.java;

import android.app.Application;

import dev.ogabek.java.manager.LocaleManager;
import dev.ogabek.java.manager.PrefsManager;

public class App extends Application {

    LocaleManager localeManager;

    @Override
    public void onCreate() {
        super.onCreate();

        localeManager = new LocaleManager(this);
        localeManager.updateLanguage(this, new PrefsManager(this).getData("language"));

    }
}
