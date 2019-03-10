package com.example.hkr_health;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "HKR_health.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Overrides onCreate to be able to create the database.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseContract.WorkoutEntry.SQL_CREATE_WORKOUT_TABLE);
        db.execSQL(DatabaseContract.MesurementEntry.SQL_CREATE_MEASUREMENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
