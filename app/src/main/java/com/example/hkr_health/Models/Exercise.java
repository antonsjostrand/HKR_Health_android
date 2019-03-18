package com.example.hkr_health.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.util.Log;

@Entity(tableName = "exercises")
public class Exercise {

    private static final String TAG = "Exercise";

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "weight")
    private String weight;

    @ColumnInfo(name = "set")
    private int set;

    @ColumnInfo(name = "exercisesListID")
    private int exerciseListID;

    @ColumnInfo(name = "reps")
    private int reps;

    public Exercise(String name, String weight, int set, int reps, int exerciseListID) {
        try {
            this.name = name;
            this.weight = weight;
            this.set = set;
            this.reps = reps;
            this.exerciseListID = exerciseListID;
        }catch (Exception e){
            Log.d(TAG, "Exercise: Constructor error: " + e);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public int getExerciseListID() {
        return exerciseListID;
    }

    public void setExerciseListID(int exerciseListID) {
        this.exerciseListID = exerciseListID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}
