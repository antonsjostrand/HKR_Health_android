package com.example.hkr_health.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.hkr_health.Models.Workout;

import java.util.List;

@Dao
public interface WorkoutDAO {

    @Insert
    void insertWorkout(Workout... workouts);

    @Query("SELECT * FROM workouts")
    LiveData<List<Workout>> getWorkouts();

    @Query("SELECT MAX(id) FROM workouts")
    LiveData<Integer> retrieveMaxWorkoutID();

    @Query("DELETE FROM workouts")
    void deleteWorkoutTableContent();
}
