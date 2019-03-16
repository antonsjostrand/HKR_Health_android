package com.example.hkr_health.Models;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hkr_health.R;

import java.util.ArrayList;
import java.util.Date;

public class WorkoutListAdapter extends ArrayAdapter<Workout> {

    private static final String TAG = "WorkoutListAdapter";

    private Context myConxtext;
    private int myResource;

    public WorkoutListAdapter(Context context, int resource, ArrayList<Workout> workoutList){
        super(context, resource, workoutList);
        myConxtext = context;
        myResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String title = getItem(position).getTitle();
        Date date = getItem(position).getDate();

        LayoutInflater inflater = LayoutInflater.from(myConxtext);
        convertView = inflater.inflate(myResource, parent, false);

        TextView titleTW = convertView.findViewById(R.id.workoutNameTV);
        TextView dateTW = convertView.findViewById(R.id.dateOfWorkoutTV);

        titleTW.setText(title);
        dateTW.setText(date.toString());

        return convertView;
    }
}
