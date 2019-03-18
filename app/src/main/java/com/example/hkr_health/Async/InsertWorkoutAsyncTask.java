package com.example.hkr_health.Async;

import android.os.AsyncTask;

import com.example.hkr_health.Database.WorkoutDAO;
import com.example.hkr_health.Models.Workout;

public class InsertWorkoutAsyncTask extends AsyncTask<Workout, Void, Void> {

    private WorkoutDAO mWorkoutDao;

    public InsertWorkoutAsyncTask(WorkoutDAO workoutDAO) {
        mWorkoutDao = workoutDAO;
    }

    @Override
    protected Void doInBackground(Workout... workouts) {
        mWorkoutDao.insertWorkout(workouts);
        return null;
    }
}
