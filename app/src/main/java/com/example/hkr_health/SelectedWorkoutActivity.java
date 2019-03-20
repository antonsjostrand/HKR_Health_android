package com.example.hkr_health;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.hkr_health.Adapters.ExerciseRecyclerAdapter;
import com.example.hkr_health.Adapters.WorkoutRecyclerAdapter;
import com.example.hkr_health.Database.HkrHealthRepository;
import com.example.hkr_health.Models.Exercise;
import com.example.hkr_health.Models.Workout;
import com.example.hkr_health.Util.VerticalSpacingItemDecorator;

import java.util.ArrayList;
import java.util.List;

public class SelectedWorkoutActivity extends AppCompatActivity {

    //Used for logging and debugging.
    private static final String TAG = "SelectedWorkoutActivity";

    //UI
    private RecyclerView mRecyclerView;
    private TextView mTitle, mDate;

    //Variables used for different stuff.
    private Workout mWorkout;
    private ArrayList<Exercise> mExercises = new ArrayList<>();
    private ExerciseRecyclerAdapter mExerciseRecyclerAdapter;
    private String mModifiedDate;

    //Database
    HkrHealthRepository mHkrHealthRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_workout);

        try {

            mRecyclerView = findViewById(R.id.exercisesRecyclerView);
            mTitle = findViewById(R.id.selectedWorkoutTitleTV);
            mDate = findViewById(R.id.selectedWorkoutDateTV);

            mHkrHealthRepository = new HkrHealthRepository(this);

            mWorkout = getIntent().getParcelableExtra("clicked_workout");

            mModifiedDate = mWorkout.getDate();
            mModifiedDate = mModifiedDate.substring(0,16);

            mTitle.setText(mWorkout.getTitle());
            mDate.setText(mModifiedDate);


            initRecyclerView();

            retrieveAllExercisesForSelectedWorkout(mWorkout.getExerciseListID());

        }catch (Exception e){
            Log.d(TAG, "onCreate: Error: " + e);
        }
    }

    public void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);
        mExerciseRecyclerAdapter = new ExerciseRecyclerAdapter(mExercises);
        mRecyclerView.setAdapter(mExerciseRecyclerAdapter);
    }

    public void retrieveAllExercisesForSelectedWorkout(int id) {
        try {
            Log.d(TAG, "retrieveAllExercisesForSelectedWorkout: EXERCISELISTID: " + id);
            mHkrHealthRepository.retrieveSpecificExercise(id).observe(this, new Observer<List<Exercise>>() {
                @Override
                public void onChanged(@Nullable List<Exercise> exercises) {
                    if (mExercises.size() > 0) {
                        mExercises.clear();
                    }
                    if (exercises != null) {
                        mExercises.addAll(exercises);
                    }
                    mExerciseRecyclerAdapter.notifyDataSetChanged();
                }
            });
        }catch (Exception e){
            Log.d(TAG, "retrieveAllExercisesForSelectedWorkout: Error: " + e);
        }
    }
}
