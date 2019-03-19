package com.example.hkr_health.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.hkr_health.R;

public class SendMailFragment extends Fragment {

    //Used for logging and debugging
    private static final String TAG = "SendMailFragment";

    //UI
    private EditText mBodyOfMailET, mSubjectOfMailET;
    private Button mSendMailButton;

    public SendMailFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mail_fragment_layout, container, false);

        mBodyOfMailET = view.findViewById(R.id.sendMailBodyTextView);
        mSubjectOfMailET = view.findViewById(R.id.sendMailSubjectTW);
        mSendMailButton = view.findViewById(R.id.sendMailButton);

        mSendMailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMailButtonPressed();
            }
        });
        return view;
    }


    public void sendMailButtonPressed(){
        String[] recpient = {"hkr.app.testing@gmail.com"};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, recpient);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, mSubjectOfMailET.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT, mBodyOfMailET.getText().toString());

        try{
            startActivity(Intent.createChooser(emailIntent, "Pick email client:"));

            mSubjectOfMailET.getText().clear();
            mBodyOfMailET.getText().clear();


        }catch (android.content.ActivityNotFoundException e) {
            Log.d(TAG, "sendMailButtonPressed: Error: " + e);
        }
    }
}
