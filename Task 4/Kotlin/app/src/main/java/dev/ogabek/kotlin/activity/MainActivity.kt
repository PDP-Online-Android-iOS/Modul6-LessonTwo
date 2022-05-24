package dev.ogabek.kotlin.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.manager.LocaleManager

class MainActivity : AppCompatActivity() {
    private lateinit var uzbek: Button
    private lateinit var english: Button
    private lateinit var russian: Button
    private lateinit var language: TextView
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        context = this
        uzbek = findViewById(R.id.uzbek)
        english = findViewById(R.id.english)
        russian = findViewById(R.id.russian)
        language = findViewById(R.id.language)
        uzbek.setOnClickListener {
            LocaleManager(context).updateLanguage(context, LocaleManager.LANGUAGE_UZBEK)
            recreateActivity()
        }
        english.setOnClickListener {
            LocaleManager(context).updateLanguage(context, LocaleManager.LANGUAGE_ENGLISH)
            recreateActivity()
        }
        russian.setOnClickListener {
            LocaleManager(context).updateLanguage(context, LocaleManager.LANGUAGE_RUSSIAN)
            recreateActivity()
        }
        language.text = getString(R.string.language)
    }

    private fun recreateActivity() {
        startActivity(Intent(context, MainActivity::class.java))
    }
}