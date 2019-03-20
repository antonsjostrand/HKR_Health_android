package com.example.hkr_health.Fragments;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hkr_health.Database.HkrHealthRepository;
import com.example.hkr_health.R;

public class StatisticsFragment extends Fragment {

    //Logging/debugging
    private static final String TAG = "StatisticsFragment";

    //UI
    private TextView mNumberOfWorkoutsTV, mNumberOfMeasurementsTV, mExerciseNameTV;

    //Variables
    private int mNumberOfWorkouts, mNumberOfMeasurements;
    private String mChoosenExercise;

    //Database
    HkrHealthRepository mHkrHealthRepository;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.statistics_fragment_layout, container, false);

        mNumberOfWorkoutsTV = view.findViewById(R.id.workoutsLoggedTV);
        mNumberOfMeasurementsTV = view.findViewById(R.id.statisticsMeasurementsLoggedTV);
        mExerciseNameTV = view.findViewById(R.id.statisticsExerciseNameTV);

        mHkrHealthRepository = new HkrHealthRepository(getActivity());

        initExerciseName();
        initExerciseWeight();
        initNumberOfMeasurements();
        initNumberOfWorkouts();

        return view;
    }

    public void initNumberOfMeasurements(){
        try{
            mHkrHealthRepository.retrieveNumberOfMeasurements().observe(getActivity(), new Observer<Integer>() {
                @Override
                public void onChanged(@Nullable Integer integer) {
                    mNumberOfMeasurements = integer;
                    mNumberOfMeasurementsTV.setText(String.valueOf(mNumberOfMeasurements));
                }
            });
        }catch (Exception e){
            Log.d(TAG, "initNumberOfMeasurements: Error: " + e);
        }
    }

    public void initNumberOfWorkouts(){
        try{
            mHkrHealthRepository.retrieveNumberOfWorkouts().observe(getActivity(), new Observer<Integer>() {
                @Override
                public void onChanged(@Nullable Integer integer) {
                    mNumberOfWorkouts = integer;
                    mNumberOfWorkoutsTV.setText(String.valueOf(mNumberOfWorkouts));
                }
            });
        }catch (Exception e){
            Log.d(TAG, "initNumberOfWorkouts: Error: " + e);
        }
    }

    public void initExerciseName(){
        try{
            mHkrHealthRepository.retrieveHeaviestExerciseLiftName().observe(getActivity(), new Observer<String>() {
                @Override
                public void onChanged(@Nullable String s) {
                    if (s != null) {
                        mExerciseNameTV.setText(s);
                    }else{
                        mExerciseNameTV.setText("-");
                    }
                }
            });

        }catch (Exception e){
            Log.d(TAG, "initExerciseName: Error: " + e);
        }
    }

    public void initExerciseWeight(){
        try{
            mHkrHealthRepository.retrieveHeaviestExerciseLiftWeight().observe(getActivity(), new Observer<String>() {
                @Override
                public void onChanged(@Nullable String s) {
                    if (s != null) {
                        mChoosenExercise = String.valueOf(mExerciseNameTV.getText());
                        mChoosenExercise = mChoosenExercise + " " + s + "kg";

                        mExerciseNameTV.setText(mChoosenExercise);
                    }
                }
            });


        }catch (Exception e){
            Log.d(TAG, "initExerciseWeight: Error: " + e);
        }
    }
}
