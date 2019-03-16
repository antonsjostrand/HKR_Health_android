package com.example.hkr_health.Models;

import android.util.Log;

public class Exercise {

    private static final String TAG = "Exercise";

    private String name;
    private String weight;
    private int set;

    public Exercise(String name, String weight, int set) {
        try {
            this.name = name;
            this.weight = weight;
            this.set = set;
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
}
