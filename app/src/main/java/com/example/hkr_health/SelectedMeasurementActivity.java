package com.example.hkr_health;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.hkr_health.Models.Measurement;

public class SelectedMeasurementActivity extends AppCompatActivity {

    private static final String TAG = "SelectedMeasurementActi";

    //UI
    private TextView titleTV, dateTV, armsTV, legsTV, chestTV, waistTV, shouldersTV, calvesTV;

    //variables
    private Measurement mMeasurement;
    private String mModifiedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_measurement);

        try{
            mMeasurement = getIntent().getParcelableExtra("clicked_measurement");


            titleTV = findViewById(R.id.measurementTitleTV);
            dateTV = findViewById(R.id.measurementDateTV);
            armsTV = findViewById(R.id.measurementArmsTV);
            legsTV = findViewById(R.id.measurementLegsTV);
            chestTV = findViewById(R.id.measurementChestTV);
            waistTV = findViewById(R.id.measurementWaistTV);
            shouldersTV = findViewById(R.id.measurementShouldersTV);
            calvesTV = findViewById(R.id.measurementCalvesTV);

            initValues();

        }catch (Exception e){
            Log.d(TAG, "onCreate: Error: " + e);
        }
    }

    public void initValues(){
        mModifiedDate = String.valueOf(mMeasurement.getDate());
        mModifiedDate = mModifiedDate.substring(0,16);

        titleTV.setText(mMeasurement.getMeasurementTitle());
        dateTV.setText(mModifiedDate);
        armsTV.setText(String.valueOf(mMeasurement.getArms() + " cm"));
        legsTV.setText(String.valueOf(mMeasurement.getLegs() + " cm"));
        chestTV.setText(String.valueOf(mMeasurement.getChest() + " cm"));
        waistTV.setText(String.valueOf(mMeasurement.getWaist() + " cm"));
        shouldersTV.setText(String.valueOf(mMeasurement.getShoudlers() + " cm"));
        calvesTV.setText(String.valueOf(mMeasurement.getCalves() + " cm"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
