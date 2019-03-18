package com.example.hkr_health.Async;

import android.os.AsyncTask;

import com.example.hkr_health.Database.MeasurementDAO;
import com.example.hkr_health.Models.Measurement;

public class InsertMeasurementAsyncTask extends AsyncTask<Measurement, Void, Void> {

    private MeasurementDAO mMeasurementDAO;

    public InsertMeasurementAsyncTask(MeasurementDAO measurementDAO){
        mMeasurementDAO = measurementDAO;
    }

    @Override
    protected Void doInBackground(Measurement... measurements) {
        mMeasurementDAO.insertMeasurement(measurements);
        return null;
    }
}
