package com.myowngame.deplastify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PreInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_info);
        EditText sizeOfTrashBag = findViewById(R.id.sizeOfTrashBag);
        EditText usagePercentageOfPlastic = findViewById(R.id.usagePercentOfPlastic);
        Button done = findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = sizeOfTrashBag.getText().toString();
                String temp2 = usagePercentageOfPlastic.getText().toString();
                int sizeOfTrashBag = Integer.parseInt(temp);
                int usagePercentage = Integer.parseInt(temp2);
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putBoolean("usedAppFirstTime", false);
                myEdit.putInt("sizeOfTrashBag", sizeOfTrashBag);
                myEdit.putInt("usagePercentage", usagePercentage);
                myEdit.commit();
                Intent intent = new Intent(PreInfoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}