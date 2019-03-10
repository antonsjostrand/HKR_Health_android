package com.example.hkr_health;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //Variables to handle and create the database.
    private DatabaseOpenHelper dbOpenHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the openhelper object to be able to create the database.
        dbOpenHelper = new DatabaseOpenHelper(this);

        db = dbOpenHelper.getReadableDatabase();
    }

    @Override
    protected void onDestroy() {
        dbOpenHelper.close();
        super.onDestroy();
    }


}
