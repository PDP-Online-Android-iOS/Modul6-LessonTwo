package dev.ogabek.java.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import dev.ogabek.java.R;
import dev.ogabek.java.manager.PrefsManager;
import dev.ogabek.java.model.User;

public class MainActivity extends AppCompatActivity {

    private EditText fullName, email, password, confirmPassword;
    private TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {

        fullName = findViewById(R.id.et_fullName);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        confirmPassword = findViewById(R.id.et_confirmPassword);

        Button save = findViewById(R.id.btn_save);
        Button load = findViewById(R.id.btn_load);

        data = findViewById(R.id.tv_data);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User(fullName.getText().toString(), email.getText().toString(), password.getText().toString(), confirmPassword.getText().toString());

                new PrefsManager(MainActivity.this).setData("user", new Gson().toJson(user));

                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                fullName.setText("");
                email.setText("");
                password.setText("");
                confirmPassword.setText("");
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new Gson().fromJson(new PrefsManager(MainActivity.this).getStringData("user"), User.class);

                if (user != null) {
                    String account =
                            "Full Name : " + user.getFullName() +
                            "\nEmail : " + user.getEmail() +
                            "\nPassword : " + user.getPassword() +
                            "\nConfirm Password : " + user.getConfirmPassword();

                    data.setText(account);
                }
            }
        });

    }
}