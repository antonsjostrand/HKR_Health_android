package com.example.hkr_health.Fragments;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hkr_health.Database.HkrHealthRepository;
import com.example.hkr_health.Models.Exercise;
import com.example.hkr_health.Adapters.ExerciseListAdapter;
import com.example.hkr_health.Models.Workout;
import com.example.hkr_health.R;

import java.util.ArrayList;
import java.util.Calendar;

public class WorkoutCreationFragment extends Fragment {

    //TAG used for logging and debugging
    private static final String TAG = "WorkoutCreationFragment";

    //UI
    private EditText titleET, exerciseET, weightET, repsET;
    private Button createWorkoutButton, addExerciseButton, clearButton;
    private ListView exerciseLV;

    //Variables that is needed to create a workout
    private int setNr = 0;
    private int workoutID;
    private ArrayList<Exercise> exerciseList = new ArrayList<>();
    private String workoutName;
    private Exercise exercise;
    private Workout workout;
    private String date;

    //Database
    private HkrHealthRepository mHkrHealthRepository;

    public WorkoutCreationFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.workout_creation_fragment_layout, container, false);

        createWorkoutButton = view.findViewById(R.id.createWorkoutButton);
        addExerciseButton = view.findViewById(R.id.addExerciseButton);
        clearButton = view.findViewById(R.id.clearButton);

        exerciseET = view.findViewById(R.id.exerciseName);
        weightET = view.findViewById(R.id.exerciseWeight);
        titleET = view.findViewById(R.id.workoutTitle);
        repsET = view.findViewById(R.id.exerciseReps);
        exerciseLV = view.findViewById(R.id.workoutLV);

        mHkrHealthRepository = new HkrHealthRepository(getActivity());

        retrieveMaxWorkoutID();

        createWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createWorkoutButtonPressed();
            }
        });

        addExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExerciseButtonPressed();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearButtonPressed();
            }
        });

        return view;
    }

    //Method that is used to handle the clicks on the createworkoutbutton
    public void createWorkoutButtonPressed(){
        try{
            //Gets the current time and name of the workout
            //Date currentTime = Calendar.getInstance().getTime();
            date = String.valueOf(Calendar.getInstance().getTime());
            workoutName = String.valueOf(titleET.getText());

            //Makes sure the title only contains letters before creating an workout
            //If it is not only letters an error message is displayed
            if (workoutName.matches("[a-zA-Z_ ]+") && !workoutName.equals("Enter only letters")) {
                workout = new Workout(workoutName, date, workoutID);

                //Insert the workout and the corresponding exercises to the database.
                for (int i = 0; i < exerciseList.size(); i++){
                    insertExercise(exerciseList.get(i));
                }
                insertWorkout(workout);
                workoutID++;

                //Clear all fields.
                titleET.getText().clear();
                exerciseET.getText().clear();
                weightET.getText().clear();
                repsET.getText().clear();
                exerciseLV.setAdapter(null);
                exerciseList.clear();
                setNr = 0;
            }else{
                Toast.makeText(getActivity(), "Make sure the values entered are correct", Toast.LENGTH_LONG).show();
                titleET.setText("Enter only letters");
            }
        }catch (Exception e){
            Log.d(TAG, "createWorkoutButtonPressed: Error: " + e);
        }

    }

    //Method that is used to add exercises to an array and to a listview.
    public void addExerciseButtonPressed(){
        try {
            Log.d(TAG, "addExerciseButtonPressed: workoutID: " + workoutID);
            setNr++;

            String exerciseName = String.valueOf(exerciseET.getText());
            String exerciseWeight = String.valueOf(weightET.getText());
            int exerciseReps = Integer.parseInt(String.valueOf(repsET.getText()));

            //Makes sure the name only contains letters and the weight is a number.
            //Else displays error message and clears the two fields.
            if (exerciseName.matches("[a-zA-Z_ ]+") && exerciseWeight.matches("[0-9]+") && String.valueOf(exerciseReps).matches("[0-9]+")) {
                exercise = new Exercise(exerciseName, exerciseWeight, setNr, exerciseReps, workoutID);
                exerciseList.add(exercise);

                ExerciseListAdapter adapter = new ExerciseListAdapter(getActivity(), R.layout.workout_listview_layout, exerciseList);
                exerciseLV.setAdapter(adapter);
            }else{
                Toast.makeText(getActivity(), "Make sure the values entered are correct", Toast.LENGTH_LONG).show();
                exerciseET.getText().clear();
                weightET.getText().clear();
                repsET.getText().clear();
                setNr--;
            }

        }catch (Exception e){
            Log.d(TAG, "addExerciseButtonPressed: ERROR: " + e);
        }
    }

    //Method used to clear the fields to be able to enter a new exercise.
    public void clearButtonPressed(){
        exerciseET.getText().clear();
        weightET.getText().clear();
        repsET.getText().clear();
        setNr = 0;
    }

    //Handles the insertion of the workout to the database.
    public void insertWorkout(Workout workout){
        try {
            mHkrHealthRepository.insertWorkout(workout);
        }catch (Exception e){
            Log.d(TAG, "insertWorkout: Error: " + e);
        }
    }

    public void insertExercise(Exercise exercise){
        try{
            mHkrHealthRepository.insertExercise(exercise);
        }catch (Exception e){
            Log.d(TAG, "insertExercise: Error: " + e);
        }
    }

    public void retrieveMaxWorkoutID(){
        mHkrHealthRepository.retrieveMaxWorkoutID().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                if (integer == null){
                    workoutID = 0;
                }else {
                    workoutID = integer;
                    Log.d(TAG, "onChanged: workoutID: " + workoutID);
                }

            }
        });
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume: workoutCreationFragment resume calledd!!!!");
        exerciseList.clear();
        super.onResume();
    }
}
