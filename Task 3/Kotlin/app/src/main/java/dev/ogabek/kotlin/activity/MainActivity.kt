package dev.ogabek.kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.manager.PrefsManager

class MainActivity : AppCompatActivity() {
    private lateinit var fullName: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var data: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        fullName = findViewById(R.id.et_fullName)
        email = findViewById(R.id.et_email)
        password = findViewById(R.id.et_password)
        confirmPassword = findViewById(R.id.et_confirmPassword)
        val save = findViewById<Button>(R.id.btn_save)
        val load = findViewById<Button>(R.id.btn_load)
        data = findViewById(R.id.tv_data)
        save.setOnClickListener {
            PrefsManager(this@MainActivity).setData("fullName", fullName.getText().toString())
            PrefsManager(this@MainActivity).setData("email", email.getText().toString())
            PrefsManager(this@MainActivity).setData("password", password.getText().toString())
            PrefsManager(this@MainActivity).setData(
                "confirmPassword",
                confirmPassword.getText().toString()
            )
            Toast.makeText(this@MainActivity, "Saved", Toast.LENGTH_SHORT).show()
            fullName.setText("")
            email.setText("")
            password.setText("")
            confirmPassword.setText("")
        }
        load.setOnClickListener {
            val fullName: String? = PrefsManager(this@MainActivity).getStringData("fullName")
            val email: String? = PrefsManager(this@MainActivity).getStringData("email")
            val password: String? = PrefsManager(this@MainActivity).getStringData("password")
            val confirmPassword: String? = PrefsManager(this@MainActivity).getStringData("confirmPassword")

            val account = """
                Full Name : $fullName
                Email : $email
                Password : $password
                Confirm Password : $confirmPassword
                """.trimIndent()

            data.text = account
        }
    }
}