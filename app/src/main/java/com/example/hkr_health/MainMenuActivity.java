package com.example.hkr_health;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.hkr_health.Database.HkrHealthRepository;
import com.example.hkr_health.Fragments.MeasurementCreationFragment;
import com.example.hkr_health.Fragments.MeasurementHistoryFragment;
import com.example.hkr_health.Fragments.WorkoutCreationFragment;
import com.example.hkr_health.Fragments.WorkoutHistoryFragment;
import com.facebook.login.LoginManager;

public class MainMenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    
    //TAG used for logging/debugging this class.
    private static final String TAG = "MainMenuActivity";
    
    //UI
    private NavigationView navigationMenu;
    private DrawerLayout drawerLayout;

    //Fragment variables
    private FragmentManager fm;
    private FragmentTransaction ft;

    //Database
    HkrHealthRepository mHkrHealthRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_menu);

            mHkrHealthRepository = new HkrHealthRepository(this);

            drawerLayout = findViewById(R.id.main_menu_drawerlayout);
            setNavigationMenuListener();

            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        }catch (Exception e){
            Log.d(TAG, "onCreate: ERROR");
            Log.d(TAG, "onCreate: " + e);
        }
    }
    
    public void setNavigationMenuListener(){
        try {
            navigationMenu = findViewById(R.id.navigationMenu);
            navigationMenu.setNavigationItemSelectedListener(this);

            fm = MainMenuActivity.this.getSupportFragmentManager();

        }catch (Exception e){
            Log.d(TAG, "setNavigationMenuListener: ERROR");
            Log.d(TAG, "setNavigationMenuListener: " + e);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        try {
            ft = fm.beginTransaction();
            //Switch that puts the correct fragment into the framelayout when
            //the corresponding navigation item is clicked.
            switch (item.getItemId()) {
                case R.id.nav_workout_creation:
                    Log.d(TAG, "onNavigationItemSelected: WORKOUT CREATION PRESSED");

                    //Places the workout fragment and place it into the container.
                    WorkoutCreationFragment workCrFrag = new WorkoutCreationFragment();
                    ft.replace(R.id.fragment_container, workCrFrag);
                    ft.commit();

                    break;
                case R.id.nav_workout_history:
                    Log.d(TAG, "onNavigationItemSelected: WORKOUT HISTORY PRESSED");

                    //Places the workout history fragment into the fragment container.
                    WorkoutHistoryFragment workHisFrag = new WorkoutHistoryFragment();
                    ft.replace(R.id.fragment_container, workHisFrag);
                    ft.commit();

                    break;
                case R.id.nav_measurement_creation:
                    Log.d(TAG, "onNavigationItemSelected: MEASUREMENT CREATION PRESSED");

                    //Places the measurement creation fragment layout into the container.
                    MeasurementCreationFragment measurementCrFrag = new MeasurementCreationFragment();
                    ft.replace(R.id.fragment_container, measurementCrFrag);
                    ft.commit();

                    break;
                case R.id.nav_measurement_history:
                    Log.d(TAG, "onNavigationItemSelected: MEASUREMENT HISTORY PRESSED");

                    MeasurementHistoryFragment measurementHisFrag = new MeasurementHistoryFragment();
                    ft.replace(R.id.fragment_container, measurementHisFrag);
                    ft.commit();

                    break;
                case R.id.nav_logout:
                    Log.d(TAG, "onNavigationItemSelected: LOGOUT PRESSED");


                    LoginManager.getInstance().logOut();
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);

                    break;
            }
            
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
            
        }catch (Exception e){
            Log.d(TAG, "onNavigationItemSelected: ERROR");
            Log.d(TAG, "onNavigationItemSelected: " + e);
        }
        return true;
    }

}
