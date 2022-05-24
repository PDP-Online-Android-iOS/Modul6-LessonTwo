package dev.ogabek.java.manager;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.LocaleList;

import androidx.annotation.RequiresApi;

import java.util.LinkedHashSet;
import java.util.Locale;

public class LocaleManager {

    Context context;

    public LocaleManager(Context context) {
        this.context = context;
    }

    public static final String LANGUAGE_ENGLISH = "en";
    public static final String LANGUAGE_RUSSIAN = "ru";
    public static final String LANGUAGE_UZBEK = "uz";

    public void updateLanguage(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());

        new PrefsManager(context).saveData("language", language);

    }


    private boolean isAtLeastVersion(int version) {
        return Build.VERSION.SDK_INT >= version;
    }


}
