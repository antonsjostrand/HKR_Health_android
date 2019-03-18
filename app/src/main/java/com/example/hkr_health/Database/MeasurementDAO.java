package com.example.hkr_health.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.hkr_health.Models.Measurement;

import java.util.List;

@Dao
public interface MeasurementDAO {

    @Insert
    void insertMeasurement(Measurement... measurement);

    @Query("SELECT * FROM measurements")
    LiveData<List<Measurement>> getMeasurements();

    @Query("SELECT * FROM measurements WHERE id = :measurementID")
    List<Measurement> getSpecificMeasurement(int measurementID);

    @Query("SELECT MAX(id) FROM measurements")
    LiveData<Integer> retrieveMaxMeasurementID();

    @Query("DELETE FROM measurements")
    void deleteMeasurementsTableContent();
}
