package com.example.android.android_me.BodyPart;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.Helper.Create;
import com.example.android.android_me.R;

public class BodyPartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodypart);

        if(savedInstanceState == null) {

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.head_container, Create.createHead(getIntent(),0 ))
                    .add(R.id.body_container, Create.createBody(getIntent(),0 ))
                    .add(R.id.leg_container, Create.createLeg(getIntent(),0 ))
                    .commit();
        }
    }
}
