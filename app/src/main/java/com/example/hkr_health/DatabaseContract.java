package com.example.hkr_health;

import android.provider.BaseColumns;

public final class DatabaseContract {

    //No need to create an object of the class.
    private DatabaseContract(){ }

    //Inner class used to handle the workout table
    public static final class WorkoutEntry implements BaseColumns {
        public static final String TABLE_NAME = "workout_table";
        public static final String COLUMN_WORKOUT_TITLE = "workout_title";

        public static final String SQL_CREATE_WORKOUT_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + "INTEGER PRIMARY KEY, " + COLUMN_WORKOUT_TITLE + "TEXT NOT NULL)";
    }

    //Inner class used to hande the measurement table
    public static final class MesurementEntry implements BaseColumns {
        public static final String TABLE_NAME = "measurement_table";
        public static final String COLUMN_MEASUREMENT_DATE = "measurement_date";

        public static final String SQL_CREATE_MEASUREMENT_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + "INTEGER PRIMARY KEY, " + COLUMN_MEASUREMENT_DATE + "TEXT NOT NULL)";
    }

}
