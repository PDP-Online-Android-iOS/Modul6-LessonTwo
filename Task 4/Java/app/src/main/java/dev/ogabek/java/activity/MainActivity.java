package dev.ogabek.java.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dev.ogabek.java.R;
import dev.ogabek.java.manager.LocaleManager;

public class MainActivity extends AppCompatActivity {

    private Button uzbek, english, russian;
    private TextView language;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {

        context = this;

        uzbek = findViewById(R.id.uzbek);
        english = findViewById(R.id.english);
        russian = findViewById(R.id.russian);
        language = findViewById(R.id.language);

        uzbek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LocaleManager(context).updateLanguage(context, LocaleManager.LANGUAGE_UZBEK);
                recreateActivity();
            }
        });

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LocaleManager(context).updateLanguage(context, LocaleManager.LANGUAGE_ENGLISH);
                recreateActivity();
            }
        });

        russian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LocaleManager(context).updateLanguage(context, LocaleManager.LANGUAGE_RUSSIAN);
                recreateActivity();
            }
        });

        language.setText(getString(R.string.language));

    }

    private void recreateActivity() {
        startActivity(new Intent(context, MainActivity.class));
    }

}