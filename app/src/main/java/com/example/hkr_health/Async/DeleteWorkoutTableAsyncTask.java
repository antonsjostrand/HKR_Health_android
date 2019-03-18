package com.example.hkr_health.Async;

import android.os.AsyncTask;

import com.example.hkr_health.Database.WorkoutDAO;
import com.example.hkr_health.Models.Workout;

public class DeleteWorkoutTableAsyncTask extends AsyncTask<Workout, Void, Void> {

    private WorkoutDAO mWorkoutDao;

    public DeleteWorkoutTableAsyncTask(WorkoutDAO mWorkoutDao) {
        this.mWorkoutDao = mWorkoutDao;
    }

    @Override
    protected Void doInBackground(Workout... workouts) {
        mWorkoutDao.deleteWorkoutTableContent();
        return null;
    }
}
