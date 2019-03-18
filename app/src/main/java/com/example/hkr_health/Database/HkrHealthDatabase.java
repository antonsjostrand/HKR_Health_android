package com.example.hkr_health.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.hkr_health.Models.Exercise;
import com.example.hkr_health.Models.Measurement;
import com.example.hkr_health.Models.Workout;

@Database(entities = {Workout.class, Measurement.class, Exercise.class}, version = 1)
public abstract class HkrHealthDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "hkr_health.db";

    private static HkrHealthDatabase instance;

    static HkrHealthDatabase getInstance(final Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), HkrHealthDatabase.class, DATABASE_NAME).build();
        }
        return instance;
    }

    public abstract WorkoutDAO getWorkoutDAO();

    public abstract ExerciseDAO getExerciseDAO();

    public abstract MeasurementDAO getMeasurementDAO();
}
