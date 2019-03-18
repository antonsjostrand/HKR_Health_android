package com.example.hkr_health.Fragments;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hkr_health.Adapters.MeasurementRecyclerAdapter;
import com.example.hkr_health.Adapters.WorkoutRecyclerAdapter;
import com.example.hkr_health.Database.HkrHealthRepository;
import com.example.hkr_health.Models.Measurement;
import com.example.hkr_health.R;
import com.example.hkr_health.SelectedMeasurementActivity;
import com.example.hkr_health.Util.VerticalSpacingItemDecorator;

import java.util.ArrayList;
import java.util.List;

public class MeasurementHistoryFragment extends Fragment implements MeasurementRecyclerAdapter.OnMeasurementListener {

    //TAG used for logging and debugging
    private static final String TAG = "MeasurementHistoryFragm";

    //UI
    private RecyclerView mRecyclerView;

    //Variables
    private ArrayList<Measurement> mMeasurements = new ArrayList<>();
    private MeasurementRecyclerAdapter mMeasurementRecyclerAdapter;
    private Measurement mSelecetedMeasurement;

    //Database
    HkrHealthRepository mHkrHealthRepository;

    public MeasurementHistoryFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.measurement_history_fragment_layout, container, false);
        try{
            mRecyclerView = view.findViewById(R.id.measurementHistoryRecyclerView);
            mHkrHealthRepository = new HkrHealthRepository(getActivity());

            initRecyclerView();
            retrieveAllMeasurements();

        }catch (Exception e){
            Log.d(TAG, "onCreateView: Error: " + e);
        }

        return view;
    }

    public void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);
        mMeasurementRecyclerAdapter = new MeasurementRecyclerAdapter(mMeasurements, this);
        mRecyclerView.setAdapter(mMeasurementRecyclerAdapter);
    }

    @Override
    public void OnMeasurementClick(int position) {
        try{
            Log.d(TAG, "OnMeasurementClick: MEASUREMENT CLICKED: " + position);

            mSelecetedMeasurement = mMeasurements.get(position);

            Intent intent = new Intent(getActivity(), SelectedMeasurementActivity.class);
            intent.putExtra("clicked_measurement", mSelecetedMeasurement);
            startActivity(intent);

        }catch (Exception e){
            Log.d(TAG, "OnMeasurementClick: Error: " + e);
        }
    }

    public void retrieveAllMeasurements(){
        mHkrHealthRepository.retrieveAllMeasurements().observe(getActivity(), new Observer<List<Measurement>>() {
            @Override
            public void onChanged(@Nullable List<Measurement> measurements) {
                if (mMeasurements.size() > 0){
                    mMeasurements.clear();
                }
                if (measurements != null){
                    mMeasurements.addAll(measurements);
                }
                mMeasurementRecyclerAdapter.notifyDataSetChanged();
            }
        });
    }
}
