package com.example.hkr_health.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hkr_health.Models.Exercise;
import com.example.hkr_health.R;

import java.util.ArrayList;

public class ExerciseRecyclerAdapter extends RecyclerView.Adapter<ExerciseRecyclerAdapter.ViewHolder> {

    private ArrayList<Exercise> mExerciseList;

    public ExerciseRecyclerAdapter(ArrayList<Exercise> exercises){
        mExerciseList = exercises;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.workout_selected_workout_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.mExercise.setText(mExerciseList.get(i).getName());
        viewHolder.mWeight.setText(mExerciseList.get(i).getWeight()+ " kg");
        viewHolder.mSet.setText(String.valueOf("Set " + mExerciseList.get(i).getSet()));
        viewHolder.mReps.setText(mExerciseList.get(i).getReps() + " reps");
    }

    @Override
    public int getItemCount() {
        return mExerciseList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mExercise, mSet, mWeight, mReps;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mExercise = itemView.findViewById(R.id.selectedExerciseTV);
            mSet = itemView.findViewById(R.id.selectedSetTV);
            mWeight = itemView.findViewById(R.id.selectedWeightTV);
            mReps = itemView.findViewById(R.id.selectedRepsTV);
        }
    }
}
