package com.myowngame.deplastify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        boolean hasUsedAppOnceBefore = sh.getBoolean("usedAppFirstTime", true);
        if(hasUsedAppOnceBefore){
            Intent intent = new Intent(MainActivity.this, PreInfoActivity.class);
            startActivity(intent);
        }
        else{
            setContentView(R.layout.activity_main);
            Button input = findViewById(R.id.input);
            Button log = findViewById(R.id.log);
            Button tutorial = findViewById(R.id.tutorial);
            input.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Input.class);
                    startActivity(intent);
                }
            });
            log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Log.class);
                    startActivity(intent);
                }
            });
            tutorial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Tutorial.class);
                    startActivity(intent);
                }
            });
        }
    }
}