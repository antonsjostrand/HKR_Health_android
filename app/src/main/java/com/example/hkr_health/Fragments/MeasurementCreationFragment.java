package com.example.hkr_health.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.example.hkr_health.Database.HkrHealthRepository;
import com.example.hkr_health.Models.Measurement;
import com.example.hkr_health.R;

import java.util.Calendar;

public class MeasurementCreationFragment extends Fragment {
    
    //TAG used for logging and debugging
    private static final String TAG = "MeasurementCreationFrag";
    
    //UI
    private Button createMeasurementButton;
    private EditText titleET, armsET, legsET, chestET, waistET, shouldersET, calvesET;

    //Variables
    private double arms, legs, chest, waist, shoulders, calves;
    private String date, title;

    //Database
    HkrHealthRepository mHkrHealthRepository;

    public MeasurementCreationFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.measurement_creation_fragment_layout, container, false);

        titleET = view.findViewById(R.id.measurementTitleET);
        armsET = view.findViewById(R.id.measurementArmsET);
        legsET = view.findViewById(R.id.measurementLegsET);
        chestET = view.findViewById(R.id.measurementChestET);
        waistET = view.findViewById(R.id.measurementWaistET);
        shouldersET = view.findViewById(R.id.measurementShouldersET);
        calvesET = view.findViewById(R.id.measurementCalvesET);

        mHkrHealthRepository = new HkrHealthRepository(getActivity());

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
        try {

            //Gets all the values from the textviews,
            title = String.valueOf(titleET.getText());
            date = String.valueOf(Calendar.getInstance().getTime());
            arms = Double.parseDouble(String.valueOf(armsET.getText()));
            legs = Double.parseDouble(String.valueOf(legsET.getText()));
            chest = Double.parseDouble(String.valueOf(chestET.getText()));
            waist = Double.parseDouble(String.valueOf(waistET.getText()));
            shoulders = Double.parseDouble(String.valueOf(shouldersET.getText()));
            calves = Double.parseDouble(String.valueOf(calvesET.getText()));

            //Makes sure the values are the correct form.
            if (title.matches("[a-zA-Z_ ]+")) {
                Measurement measurement = new Measurement(title, date, arms, legs, chest, waist, shoulders, calves);
                insertMeasurement(measurement);

                titleET.getText().clear();
                armsET.getText().clear();
                legsET.getText().clear();
                chestET.getText().clear();
                waistET.getText().clear();
                shouldersET.getText().clear();
                calvesET.getText().clear();


            } else {
                Toast.makeText(getActivity(), "Make sure the title only contains letters.", Toast.LENGTH_LONG).show();
                titleET.setText("Only letters.");
            }
        }catch (NumberFormatException e){
            Log.d(TAG, "createMeasurementButtonPressed: Error: " + e);
            Toast.makeText(getActivity(), "Make sure the values only contains numbers.", Toast.LENGTH_LONG).show();

            armsET.getText().clear();
            legsET.getText().clear();
            chestET.getText().clear();
            waistET.getText().clear();
            shouldersET.getText().clear();
            calvesET.getText().clear();

        }catch (Exception e){
            Log.d(TAG, "createMeasurementButtonPressed: Error: " + e);
        }
    }

    public void insertMeasurement(Measurement measurement){
        try{
            mHkrHealthRepository.insertMeasurement(measurement);
        }catch (Exception e){
            Log.d(TAG, "insertMeasurement: Error: " + e);
        }
    }
}
