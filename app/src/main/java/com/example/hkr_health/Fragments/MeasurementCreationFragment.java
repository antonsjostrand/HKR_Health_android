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

public class MeasurementCreationFragment extends Fragment {
    
    //TAG used for logging and debugging
    private static final String TAG = "MeasurementCreationFrag";
    
    //UI
    private Button createMeasurementButton;
    
    //Variables that handles the fragments
    private FragmentManager fm;
    private FragmentTransaction ft;

    public MeasurementCreationFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.measurement_creation_fragment_layout, container, false);

        createMeasurementButton = view.findViewById(R.id.createMeasurementButton);

        createMeasurementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createMeasurementButtonPressed();
            }
        });

        return view;
    }

    //Method that is used to handle the clicks on the createmeasurementbutton
    public void createMeasurementButtonPressed(){

    }
}
