package com.example.hkr_health.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

@Entity(tableName = "measurements")
public class Measurement implements Parcelable {

    private static final String TAG = "Measurement";

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String measurementTitle;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "arms")
    private double arms;

    @ColumnInfo(name = "legs")
    private double legs;

    @ColumnInfo(name = "chest")
    private double chest;

    @ColumnInfo(name = "waist")
    private double waist;

    @ColumnInfo(name = "shoulders")
    private double shoudlers;

    @ColumnInfo(name = "calves")
    private double calves;

    public Measurement(String measurementTitle, String date, double arms, double legs, double chest, double waist, double shoudlers, double calves) {
        try {
            this.measurementTitle = measurementTitle;
            this.date = date;
            this.arms = arms;
            this.legs = legs;
            this.chest = chest;
            this.waist = waist;
            this.shoudlers = shoudlers;
            this.calves = calves;
        }catch (Exception e){
            Log.d(TAG, "Measurement: Error: " + e);
        }
    }

    protected Measurement(Parcel in) {
        id = in.readInt();
        measurementTitle = in.readString();
        date = in.readString();
        arms = in.readDouble();
        legs = in.readDouble();
        chest = in.readDouble();
        waist = in.readDouble();
        shoudlers = in.readDouble();
        calves = in.readDouble();
    }

    public static final Creator<Measurement> CREATOR = new Creator<Measurement>() {
        @Override
        public Measurement createFromParcel(Parcel in) {
            return new Measurement(in);
        }

        @Override
        public Measurement[] newArray(int size) {
            return new Measurement[size];
        }
    };

    public String getMeasurementTitle() {
        return measurementTitle;
    }

    public void setMeasurementTitle(String measurementTitle) {
        this.measurementTitle = measurementTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getArms() {
        return arms;
    }

    public void setArms(double arms) {
        this.arms = arms;
    }

    public double getLegs() {
        return legs;
    }

    public void setLegs(double legs) {
        this.legs = legs;
    }

    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public double getShoudlers() {
        return shoudlers;
    }

    public void setShoudlers(double shoudlers) {
        this.shoudlers = shoudlers;
    }

    public double getCalves() {
        return calves;
    }

    public void setCalves(double calves) {
        this.calves = calves;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(measurementTitle);
        dest.writeString(date);
        dest.writeDouble(arms);
        dest.writeDouble(legs);
        dest.writeDouble(chest);
        dest.writeDouble(waist);
        dest.writeDouble(shoudlers);
        dest.writeDouble(calves);
    }
}
