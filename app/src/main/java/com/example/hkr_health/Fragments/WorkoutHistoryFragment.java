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

import com.example.hkr_health.Adapters.WorkoutRecyclerAdapter;
import com.example.hkr_health.Database.HkrHealthRepository;
import com.example.hkr_health.Models.Workout;
import com.example.hkr_health.R;
import com.example.hkr_health.SelectedWorkoutActivity;
import com.example.hkr_health.Util.VerticalSpacingItemDecorator;

import java.util.ArrayList;
import java.util.List;


public class WorkoutHistoryFragment extends Fragment implements WorkoutRecyclerAdapter.OnWorkoutListener{

    //TAG used for logging and debugging
    private static final String TAG = "WorkoutHistoryFragment";

    //UI
    private RecyclerView mRecyclerView;

    //Variables
    private ArrayList<Workout> mWorkouts = new ArrayList<>();
    private WorkoutRecyclerAdapter mWorkoutRecyclerAdapter;
    private Workout mSelectedWorkout;
    private HkrHealthRepository mHkrHealthRepository;

    public WorkoutHistoryFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.workout_history_fragment_layout, container, false);
        try {
            mRecyclerView = view.findViewById(R.id.recyclerView);

            mHkrHealthRepository = new HkrHealthRepository(getActivity());

            initRecyclerView();
            retrieveAllWorkouts();

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
        mWorkoutRecyclerAdapter = new WorkoutRecyclerAdapter(mWorkouts, this);
        mRecyclerView.setAdapter(mWorkoutRecyclerAdapter);
    }

    //When you click an workout view holder in the recyclerview you will be taken to another activity that shows information
    //regarding the selected workout.
    @Override
    public void onWorkoutClick(int position) {
        try {
            Log.d(TAG, "onWorkoutClick: WORKOUT CLICKED: POSITION: " + position);

            mSelectedWorkout = mWorkouts.get(position);

            Intent intent = new Intent(getActivity(), SelectedWorkoutActivity.class);
            intent.putExtra("clicked_workout", mSelectedWorkout);
            startActivity(intent);

        }catch (Exception e){
            Log.d(TAG, "onWorkoutClick: Error: " + e);
        }
    }

    private void retrieveAllWorkouts(){
        mHkrHealthRepository.retrieveAllWorkouts().observe(getActivity(), new Observer<List<Workout>>() {
            @Override
            public void onChanged(@Nullable List<Workout> workouts) {
                if (mWorkouts.size() > 0){
                    mWorkouts.clear();
                }
                if (workouts != null){
                    mWorkouts.addAll(workouts);
                }
                mWorkoutRecyclerAdapter.notifyDataSetChanged();
            }
        });
    }
}
