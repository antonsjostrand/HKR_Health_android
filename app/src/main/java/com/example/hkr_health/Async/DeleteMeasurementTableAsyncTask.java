package com.example.hkr_health.Async;

import android.os.AsyncTask;

import com.example.hkr_health.Database.MeasurementDAO;
import com.example.hkr_health.Models.Measurement;

public class DeleteMeasurementTableAsyncTask extends AsyncTask<Measurement, Void, Void> {

    private MeasurementDAO mMeasurementDAO;

    public DeleteMeasurementTableAsyncTask(MeasurementDAO mMeasurementDAO) {
        this.mMeasurementDAO = mMeasurementDAO;
    }

    @Override
    protected Void doInBackground(Measurement... measurements) {
        mMeasurementDAO.deleteMeasurementsTableContent();
        return null;
    }
}
