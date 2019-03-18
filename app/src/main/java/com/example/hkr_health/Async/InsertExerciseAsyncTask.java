package com.example.hkr_health.Async;

import android.os.AsyncTask;

import com.example.hkr_health.Database.ExerciseDAO;
import com.example.hkr_health.Models.Exercise;

public class InsertExerciseAsyncTask extends AsyncTask<Exercise, Void, Void> {

    private ExerciseDAO mExerciseDao;

    public InsertExerciseAsyncTask(ExerciseDAO exerciseDAO) {
        mExerciseDao = exerciseDAO;
    }

    @Override
    protected Void doInBackground(Exercise... exercises) {
        mExerciseDao.insertExercise(exercises);
        return null;
    }
}