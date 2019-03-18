package com.example.hkr_health.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hkr_health.Models.Workout;
import com.example.hkr_health.R;

import java.util.ArrayList;

public class WorkoutRecyclerAdapter extends RecyclerView.Adapter<WorkoutRecyclerAdapter.ViewHolder>{

    private ArrayList<Workout> mWorkouts;
    private OnWorkoutListener mOnWorkoutListener;

    public WorkoutRecyclerAdapter(ArrayList<Workout> Workouts, OnWorkoutListener onWorkoutListener) {
        this.mWorkouts = Workouts;
        this.mOnWorkoutListener = onWorkoutListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.workout_history_listview_layout, viewGroup, false);
        return new ViewHolder(view, mOnWorkoutListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.dateTV.setText(mWorkouts.get(i).getDate());
        viewHolder.workoutTitleTV.setText(mWorkouts.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return mWorkouts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView workoutTitleTV, dateTV;
        OnWorkoutListener onWorkoutListener;

        public ViewHolder(@NonNull View itemView, OnWorkoutListener onWorkoutListener) {
            super(itemView);
            workoutTitleTV = itemView.findViewById(R.id.workoutNameTV);
            dateTV = itemView.findViewById(R.id.dateOfWorkoutTV);
            this.onWorkoutListener = onWorkoutListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onWorkoutListener.onWorkoutClick(getAdapterPosition());
        }
    }

    public interface OnWorkoutListener {
        void onWorkoutClick(int position);
    }
}
