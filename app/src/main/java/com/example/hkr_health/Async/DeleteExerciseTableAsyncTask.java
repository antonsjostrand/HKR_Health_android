package com.example.hkr_health.Async;

import android.os.AsyncTask;

import com.example.hkr_health.Database.ExerciseDAO;
import com.example.hkr_health.Models.Exercise;

public class DeleteExerciseTableAsyncTask extends AsyncTask<Exercise, Void, Void> {

    private ExerciseDAO mExerciseDao;

    public DeleteExerciseTableAsyncTask(ExerciseDAO mExerciseDao) {
        this.mExerciseDao = mExerciseDao;
    }

    @Override
    protected Void doInBackground(Exercise... exercises) {
        mExerciseDao.deleteExerciseTableContent();
        return null;
    }
}
