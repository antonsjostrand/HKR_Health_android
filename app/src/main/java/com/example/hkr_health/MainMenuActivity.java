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

import com.example.hkr_health.Fragments.WorkoutFragment;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_menu);

            drawerLayout = findViewById(R.id.main_menu_drawerlayout);
            setNavigationMenuListener();

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
            ft = fm.beginTransaction();

        }catch (Exception e){
            Log.d(TAG, "setNavigationMenuListener: ERROR");
            Log.d(TAG, "setNavigationMenuListener: " + e);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        try {
            //Switch that puts the correct fragment into the framelayout when
            //the corresponding navigation item is clicked.
            switch (item.getItemId()) {
                case R.id.nav_workout:
                    Log.d(TAG, "onNavigationItemSelected: workout pressed");

                    WorkoutFragment workFrag = new WorkoutFragment();
                    ft.replace(R.id.fragment_container, workFrag);
                    ft.commit();

                    break;
                case R.id.nav_measurement:

                    break;
                case R.id.nav_logout:
                    Log.d(TAG, "onNavigationItemSelected: logout pressed");

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
