package dev.ogabek.java.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dev.ogabek.java.R;
import dev.ogabek.java.manager.PrefsManager;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setData();
        initViews();

    }

    private void setData() {
        new PrefsManager(this).setData("long", 9346597323L);
        new PrefsManager(this).setData("boolean", true);
        new PrefsManager(this).setData("int", 132);
        new PrefsManager(this).setData("double", 2.6);
    }

    private void initViews() {
        Button btn_long = findViewById(R.id.btn_long);
        Button btn_boolean = findViewById(R.id.btn_boolean);
        Button btn_int = findViewById(R.id.btn_int);
        Button btn_double = findViewById(R.id.btn_double);

        tv = findViewById(R.id.tv);

        btn_long.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(String.valueOf(new PrefsManager(MainActivity.this).getLongData("long")));
            }
        });

        btn_boolean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(String.valueOf(new PrefsManager(MainActivity.this).getBooleanData("boolean")));
            }
        });

        btn_int.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(String.valueOf(new PrefsManager(MainActivity.this).getIntData("int")));
            }
        });

        btn_double.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(String.valueOf(new PrefsManager(MainActivity.this).getDoubleData("double")));
            }
        });

    }
}