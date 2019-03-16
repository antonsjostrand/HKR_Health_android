package com.example.hkr_health.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hkr_health.R;

public class WorkoutCreationFragment extends Fragment {

    //TAG used for logging and debugging
    private static final String TAG = "WorkoutCreationFragment";

    //UI
    private Button createWorkoutButton;

    //Variables that handles the fragments
    private FragmentManager fm;
    private FragmentTransaction ft;

    public WorkoutCreationFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.workout_creation_fragment_layout, container, false);

        createWorkoutButton = view.findViewById(R.id.createWorkoutButton);

        createWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createWorkoutButtonPressed();
            }
        });


        return view;
    }

    //Method that is used to handle the clicks on the createworkoutbutton
    public void createWorkoutButtonPressed(){

    }

}
