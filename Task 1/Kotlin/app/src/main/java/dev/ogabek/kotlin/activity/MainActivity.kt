package dev.ogabek.kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.manager.PrefsManager
import java.lang.String

class MainActivity : AppCompatActivity() {

    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setData()
        initViews()

    }

    private fun initViews() {
        val btn_long = findViewById<Button>(R.id.btn_long)
        val btn_boolean = findViewById<Button>(R.id.btn_boolean)
        val btn_int = findViewById<Button>(R.id.btn_int)
        val btn_double = findViewById<Button>(R.id.btn_double)
        tv = findViewById<TextView>(R.id.tv)
        btn_long.setOnClickListener {
            tv.text = String.valueOf(PrefsManager(this@MainActivity).getLongData("long"))
        }
        btn_boolean.setOnClickListener {
            tv.text = String.valueOf(PrefsManager(this@MainActivity).getBooleanData("boolean"))
        }
        btn_int.setOnClickListener {
            tv.text = String.valueOf(PrefsManager(this@MainActivity).getIntData("int"))
        }
        btn_double.setOnClickListener {
            tv.text = String.valueOf(PrefsManager(this@MainActivity).getDoubleData("double"))
        }
    }

    private fun setData() {
        PrefsManager(this).setData("long", 9346597323L)
        PrefsManager(this).setData("boolean", true)
        PrefsManager(this).setData("int", 132)
        PrefsManager(this).setData("double", 2.6)
    }

}