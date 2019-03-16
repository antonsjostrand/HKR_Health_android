package com.example.hkr_health;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    //TAG used for logging/debuggning
    private static final String TAG = "LoginActivity";

    //UI
    private EditText userName, password;
    private Button createUserButton, facebookLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.usernameET);
        password = findViewById(R.id.passwordET);
        createUserButton = findViewById(R.id.createUserButton);
        facebookLoginButton = findViewById(R.id.facebookLoginButton);

    }

    public void loginButtonPressed(View v){
        try{

        }catch (Exception e){
            Log.d(TAG, "createUserButtonPressed: Error: " + e);
        }
    }

    public void createUserButtonPressed(View v){
        try{

        }catch (Exception e){
            Log.d(TAG, "createUserButtonPressed: Error: " + e);
        }
    }

    public void facebookLoginButtonPressed(View v){
        try{

        }catch (Exception e){
            Log.d(TAG, "createUserButtonPressed: Error: " + e);
        }
    }


}
