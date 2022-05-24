package dev.ogabek.java.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dev.ogabek.java.R;
import dev.ogabek.java.manager.PrefsManager;

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
                new PrefsManager(MainActivity.this).setData("fullName", fullName.getText().toString());
                new PrefsManager(MainActivity.this).setData("email", email.getText().toString());
                new PrefsManager(MainActivity.this).setData("password", password.getText().toString());
                new PrefsManager(MainActivity.this).setData("confirmPassword", confirmPassword.getText().toString());

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
                String fullName = new PrefsManager(MainActivity.this).getStringData("fullName");
                String email = new PrefsManager(MainActivity.this).getStringData("email");
                String password = new PrefsManager(MainActivity.this).getStringData("password");
                String confirmPassword = new PrefsManager(MainActivity.this).getStringData("confirmPassword");

                String account =
                        "Full Name : " + fullName +
                        "\nEmail : " + email +
                        "\nPassword : " + password +
                        "\nConfirm Password : " + confirmPassword;

                data.setText(account);
            }
        });

    }
}