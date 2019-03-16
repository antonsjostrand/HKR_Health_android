package com.example.hkr_health;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    //TAG used for logging/debuggning
    private static final String TAG = "LoginActivity";

    //UI
    private EditText userName, password;
    private Button createUserButton, loginButton;
    private LoginButton facebookLoginButton;

    //Handles the facebook login.
    private CallbackManager callbackManager;
    private static final String EMAIL = "email";
    private boolean isLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            //Creates the buttons and edittexts using the IDs.
            userName = findViewById(R.id.usernameET);
            password = findViewById(R.id.passwordET);
            createUserButton = findViewById(R.id.createUserButton);
            loginButton = findViewById(R.id.loginButton);

            //Creates everything involved with handling the facebook login.
            facebookLoginButton = findViewById(R.id.facebookLoginButton);
            callbackManager = CallbackManager.Factory.create();
            facebookLoginButton.setReadPermissions(Arrays.asList(EMAIL));

            isLoggedIn = checkFacebookLoginStatus();

            if (isLoggedIn){
                Log.d(TAG, "onCreate: USER ALREADY LOGGED IN.");
                Intent intent = new Intent(LoginActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }

                //Callback registration
                facebookLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    //If login succeded we will be taken to the main menu.
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        AccessToken accessToken = loginResult.getAccessToken();
                        GraphRequest graphRequest = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {

                            }
                        });


                        Log.d(TAG, "onCompleted: FACEBOOK LOGIN SUCCESS.");
                        Intent intent = new Intent(LoginActivity.this, MainMenuActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });

        } catch (Exception e) {
            Log.d(TAG, "onCreate: ERROR CAUGHT BY TRY-CATCH");
            Log.d(TAG, "onCreate: ERROR: " + e);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
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

    //Method that is used to check if a user is already logged in to facebook.
    public boolean checkFacebookLoginStatus(){
        AccessToken checkToken = AccessToken.getCurrentAccessToken();

        if (checkToken == null){
            return false;
        } else {
            return true;
        }


    }

}
