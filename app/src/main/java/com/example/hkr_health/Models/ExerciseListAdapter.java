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

public class ExerciseListAdapter extends ArrayAdapter<Exercise> {

    private static final String TAG = "ExerciseListAdapter";

    private Context myContext;
    private int myResource;

    public ExerciseListAdapter(Context context, int resource, ArrayList<Exercise> objects){
        super(context, resource, objects);
        myContext = context;
        myResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        String weight = getItem(position).getWeight();
        int set = getItem(position).getSet();

        LayoutInflater inflater = LayoutInflater.from(myContext);
        convertView = inflater.inflate(myResource, parent, false);

        TextView nameTV = (TextView) convertView.findViewById(R.id.exerciseTV);
        TextView setTV = (TextView) convertView.findViewById(R.id.setTV);
        TextView weightTV = (TextView) convertView.findViewById(R.id.weightTV);

        nameTV.setText(name);
        setTV.setText("Set: " + String.valueOf(set));
        weightTV.setText(weight + " kg");

        return convertView;
    }
}
