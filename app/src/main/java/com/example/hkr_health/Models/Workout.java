package com.example.hkr_health.Models;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.Log;

@Entity(tableName = "workouts")
public class Workout implements Parcelable {

    //Used for debugging and logging.
    private static final String TAG = "Workout";

    //Primarykey
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "title")
    private String title;

    @NonNull
    @ColumnInfo(name = "date")
    private String date;

    @NonNull
    @ColumnInfo(name = "exerciseListID")
    private int exerciseListID;

    public Workout(String title, String date, int exerciseListID){
        try {
            this.title = title;
            this.date = date;
            this.exerciseListID = exerciseListID;
        }catch (Exception e){
            Log.d(TAG, "Workout: Constructor error");
            Log.d(TAG, "Workout: " + e);
        }
    }


    protected Workout(Parcel in) {
        id = in.readInt();
        title = in.readString();
        date = in.readString();
        exerciseListID = in.readInt();
    }

    public static final Creator<Workout> CREATOR = new Creator<Workout>() {
        @Override
        public Workout createFromParcel(Parcel in) {
            return new Workout(in);
        }

        @Override
        public Workout[] newArray(int size) {
            return new Workout[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getExerciseListID() {
        return exerciseListID;
    }

    public void setExerciseListID(int exerciseListID) {
        this.exerciseListID = exerciseListID;
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
        dest.writeString(title);
        dest.writeString(date);
        dest.writeInt(exerciseListID);
    }
}
