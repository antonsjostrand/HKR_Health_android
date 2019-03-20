package com.example.hkr_health.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.hkr_health.Models.Exercise;

import java.util.List;

@Dao
public interface ExerciseDAO {

    @Insert
    void insertExercise(Exercise... exercises);

    @Query("SELECT * FROM exercises")
    LiveData<List<Exercise>> getExercises();

    @Query("SELECT * FROM exercises WHERE exercisesListID = :exerciseListID")
    LiveData<List<Exercise>> getSpecificExerciseList(int exerciseListID);

    @Query("DELETE FROM exercises")
    void deleteExerciseTableContent();

    @Query("SELECT name FROM exercises WHERE weight = (SELECT MAX(CAST(weight AS INT)) FROM exercises)")
    LiveData<String> getExercisesWithHeaviestLiftName();

    @Query("SELECT weight FROM exercises WHERE weight = (SELECT MAX(CAST(weight AS INT)) FROM exercises)")
    LiveData<String> getExercisesWithHeaviestLiftWeight();
}
