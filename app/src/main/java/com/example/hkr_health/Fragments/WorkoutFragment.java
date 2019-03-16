package com.example.hkr_health.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hkr_health.R;

public class WorkoutFragment extends Fragment {

    public WorkoutFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.workout_fragment_layout, container, false);
        return view;
    }
}
