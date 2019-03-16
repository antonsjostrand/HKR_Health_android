package com.example.hkr_health.Models;

import android.util.Log;

public class Workout {

    private static final String TAG = "Workout";

    private String title;
    private Exercise[] exerciseList;
    private String date;

    public Workout(String title, String date, Exercise... exerciseList){
        try {
            this.title = title;
            this.date = date;
            this.exerciseList = exerciseList.clone();
        }catch (Exception e){
            Log.d(TAG, "Workout: Constructor error");
            Log.d(TAG, "Workout: " + e);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Exercise[] getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(Exercise[] exerciseList) {
        this.exerciseList = exerciseList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
