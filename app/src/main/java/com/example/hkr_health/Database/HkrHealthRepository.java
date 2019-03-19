package com.example.hkr_health.Database;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.example.hkr_health.Async.DeleteExerciseTableAsyncTask;
import com.example.hkr_health.Async.DeleteMeasurementTableAsyncTask;
import com.example.hkr_health.Async.DeleteWorkoutTableAsyncTask;
import com.example.hkr_health.Async.InsertExerciseAsyncTask;
import com.example.hkr_health.Async.InsertMeasurementAsyncTask;
import com.example.hkr_health.Async.InsertWorkoutAsyncTask;
import com.example.hkr_health.Models.Exercise;
import com.example.hkr_health.Models.Measurement;
import com.example.hkr_health.Models.Workout;

import java.util.List;

public class HkrHealthRepository {

    private HkrHealthDatabase mHkrHealthDatabase;

    public HkrHealthRepository(Context context) {
        mHkrHealthDatabase = HkrHealthDatabase.getInstance(context);
    }

    public void insertWorkout(Workout workout){
        new InsertWorkoutAsyncTask(mHkrHealthDatabase.getWorkoutDAO()).execute(workout);
    }

    public LiveData<List<Workout>> retrieveAllWorkouts(){
        return mHkrHealthDatabase.getWorkoutDAO().getWorkouts();
    }

    public LiveData<Integer> retrieveMaxWorkoutID(){
        return mHkrHealthDatabase.getWorkoutDAO().retrieveMaxWorkoutID();
    }

    public LiveData<Integer> retrieveNumberOfWorkouts(){
        return mHkrHealthDatabase.getWorkoutDAO().retrieveNumberOfWorkouts();
    }

    public void insertMeasurement(Measurement measurement){
        new InsertMeasurementAsyncTask(mHkrHealthDatabase.getMeasurementDAO()).execute(measurement);
    }

    public LiveData<List<Measurement>> retrieveAllMeasurements(){
        return mHkrHealthDatabase.getMeasurementDAO().getMeasurements();
    }

    public LiveData<Integer> retrieveMaxMeasurementID(){
        return mHkrHealthDatabase.getMeasurementDAO().retrieveMaxMeasurementID();
    }

    public LiveData<Integer> retrieveNumberOfMeasurements(){
        return mHkrHealthDatabase.getMeasurementDAO().retrieveNumberOfMeasurements();
    }

    public void insertExercise(Exercise exercise){
        new InsertExerciseAsyncTask(mHkrHealthDatabase.getExerciseDAO()).execute(exercise);
    }

    public LiveData<List<Exercise>> retrieveSpecificExercise(int id){
        return mHkrHealthDatabase.getExerciseDAO().getSpecificExerciseList(id);
    }

    public LiveData<String> retrieveHeaviestExerciseLiftName(){
        return mHkrHealthDatabase.getExerciseDAO().getExercisesWithHeaviestLiftName();
    }

    public LiveData<String> retrieveHeaviestExerciseLiftWeight(){
        return mHkrHealthDatabase.getExerciseDAO().getExercisesWithHeaviestLiftWeight();
    }

    //ONLY USED WHEN TESTING AND DELETING UNWANTED DATA!!!
    //SHOULDNT BE USED IN THE CODE UNLESS YOU PUT IT THERE YOURSELF TO DELETE DATA.
    public void deleteDataFromExercisesTable(){
        new DeleteExerciseTableAsyncTask(mHkrHealthDatabase.getExerciseDAO()).execute();
    }

    public void deleteDataFromWorkoutTable(){
        new DeleteWorkoutTableAsyncTask(mHkrHealthDatabase.getWorkoutDAO()).execute();
    }

    public void deleteDataFromMeasurementTable(){
        new DeleteMeasurementTableAsyncTask(mHkrHealthDatabase.getMeasurementDAO()).execute();
    }



}
