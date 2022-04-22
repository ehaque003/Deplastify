package com.myowngame.deplastify;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Input extends AppCompatActivity {
    int amountOfTrashMade = 0;
    static AppDataDBHelper dbHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        dbHelper = new AppDataDBHelper(getBaseContext());
        EditText trashSubmission = findViewById(R.id.amountOfTrashMade);
        Button submit = findViewById(R.id.Submit);
        Button home = findViewById(R.id.home2);
        submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putBoolean("hasInputtedFirstData", true);
                myEdit.commit();
                String temp = trashSubmission.getEditableText().toString();
                amountOfTrashMade = Integer.parseInt(temp);
                amountOfTrashMade = (int)(amountOfTrashMade*0.82);
                HttpHandler httpHandler = new HttpHandler();
                httpHandler.handler(amountOfTrashMade);
                writeToDB();
                Intent intent = new Intent(Input.this, Log.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Input.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void writeToDB(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String timestring = time.format(formatter);
        ContentValues values = new ContentValues();
        values.put(AppDataRepo.WasteCountEntry.COLUMN_NAME_DATETIME, timestring);
        values.put(AppDataRepo.WasteCountEntry.COLUMN_NAME_WASTEAMOUNT, amountOfTrashMade);
        db.insert(AppDataRepo.WasteCountEntry.TABLE_NAME, null, values);
    }
}