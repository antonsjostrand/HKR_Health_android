package com.example.hkr_health.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hkr_health.R;

public class MeasurementHistoryFragment extends Fragment {

    //TAG used for logging and debugging
    private static final String TAG = "MeasurementHistoryFragm";

    public MeasurementHistoryFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.measurement_history_fragment_layout, container, false);


        return view;
    }
}
