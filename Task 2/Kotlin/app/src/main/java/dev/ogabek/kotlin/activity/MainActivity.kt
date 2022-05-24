package dev.ogabek.kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.User
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

            val user = User(fullName.text.toString(), email.text.toString(), password.text.toString(), confirmPassword.text.toString())

            PrefsManager(this@MainActivity).setData("user", Gson().toJson(user))
            Toast.makeText(this@MainActivity, "Saved", Toast.LENGTH_SHORT).show()
            fullName.setText("")
            email.setText("")
            password.setText("")
            confirmPassword.setText("")
        }
        load.setOnClickListener {
            val user = Gson().fromJson(PrefsManager(this@MainActivity).getStringData("user"), User::class.java)

            if (user != null) {
                val account = """
                Full Name : ${user.fullName}
                Email : ${user.email}
                Password : ${user.password}
                Confirm Password : ${user.confirmPassword}
                """.trimIndent()

                data.text = account
            }
        }
    }
}