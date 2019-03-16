package com.example.hkr_health.Fragments;

import android.os.Bundle;
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

import com.example.hkr_health.Models.Exercise;
import com.example.hkr_health.Models.ExerciseListAdapter;
import com.example.hkr_health.Models.Workout;
import com.example.hkr_health.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class WorkoutCreationFragment extends Fragment {

    //TAG used for logging and debugging
    private static final String TAG = "WorkoutCreationFragment";

    //UI
    private EditText titleET, exerciseET, weightET;
    private Button createWorkoutButton, addExerciseButton, clearButton;
    private ListView exerciseLV;

    //Variables that handles the fragments
    private FragmentManager fm;
    private FragmentTransaction ft;

    //Variables that is needed to create a workout
    private int setNr = 0;
    private ArrayList<Exercise> exerciseList = new ArrayList<>();
    private String workoutName;
    private Exercise exercise;
    private Workout workout;

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
        exerciseLV = view.findViewById(R.id.workoutLV);

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
            Date currentTime = Calendar.getInstance().getTime();
            workoutName = String.valueOf(titleET.getText());

            //Makes sure the title only contains letters before creating an workout
            //If it is not only letters an error message is displayed
            if (workoutName.matches("[a-z]+")) {
                workout = new Workout(workoutName, currentTime, exerciseList);

                //Clear all fields.
                titleET.getText().clear();
                exerciseET.getText().clear();
                weightET.getText().clear();
                exerciseLV.setAdapter(null);
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
            setNr++;

            String exerciseName = String.valueOf(exerciseET.getText());
            String exerciseWeight = String.valueOf(weightET.getText());

            //Makes sure the name only contains letters and the weight is a number.
            //Else displays error message and clears the two fields.
            if (exerciseName.matches("[a-z]+") && exerciseWeight.matches("[0-9]+")) {
                exercise = new Exercise(exerciseName, exerciseWeight, setNr);
                exerciseList.add(exercise);

                ExerciseListAdapter adapter = new ExerciseListAdapter(getActivity(), R.layout.workout_listview_layout, exerciseList);
                exerciseLV.setAdapter(adapter);
            }else{
                Toast.makeText(getActivity(), "Make sure the values entered are correct", Toast.LENGTH_LONG).show();
                exerciseET.getText().clear();
                weightET.getText().clear();
            }

        }catch (Exception e){
            Log.d(TAG, "addExerciseButtonPressed: ERROR: " + e);
        }
    }

    //Method used to clear the fields to be able to enter a new exercise.
    public void clearButtonPressed(){
        exerciseET.getText().clear();
        weightET.getText().clear();
        setNr = 0;
    }

}
