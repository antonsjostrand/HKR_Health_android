package com.example.hkr_health.Models;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

public class Workout {

    private static final String TAG = "Workout";

    private String title;
    private ArrayList<Exercise> exerciseList;
    private Date date;

    public Workout(String title, Date date, ArrayList<Exercise> exerciseList){
        try {
            this.title = title;
            this.date = date;
            this.exerciseList = exerciseList;
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

    public ArrayList<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(ArrayList<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
