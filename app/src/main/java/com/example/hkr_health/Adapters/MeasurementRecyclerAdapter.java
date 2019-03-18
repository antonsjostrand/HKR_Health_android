package com.example.hkr_health.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hkr_health.Models.Measurement;
import com.example.hkr_health.R;

import java.util.ArrayList;

public class MeasurementRecyclerAdapter extends RecyclerView.Adapter<MeasurementRecyclerAdapter.ViewHolder> {

    private ArrayList<Measurement> mMeasurements;
    private OnMeasurementListener mMeasurementListener;

    public MeasurementRecyclerAdapter(ArrayList<Measurement> measurements, OnMeasurementListener onMeasurementListener){
        this.mMeasurements = measurements;
        this.mMeasurementListener = onMeasurementListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.measurement_history_recyclerview_layout, viewGroup, false);
        return new ViewHolder(view, mMeasurementListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MeasurementRecyclerAdapter.ViewHolder viewHolder, int i) {
        viewHolder.measurementDateTV.setText(mMeasurements.get(i).getDate());
        viewHolder.measurementTitleTV.setText(mMeasurements.get(i).getMeasurementTitle());
    }

    @Override
    public int getItemCount() {
        return mMeasurements.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView measurementTitleTV, measurementDateTV;
        OnMeasurementListener onMeasurementListener;

        public ViewHolder(@NonNull View itemView, OnMeasurementListener onMeasurementListener) {
            super(itemView);
            measurementTitleTV = itemView.findViewById(R.id.titleOfMeasurementTV);
            measurementDateTV = itemView.findViewById(R.id.dateOfMeasurementTV);
            this.onMeasurementListener = onMeasurementListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onMeasurementListener.OnMeasurementClick(getAdapterPosition());
        }
    }

    public interface OnMeasurementListener{
        void OnMeasurementClick(int position);
    }
}
