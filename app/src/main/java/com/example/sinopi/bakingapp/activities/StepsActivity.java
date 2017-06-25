package com.example.sinopi.bakingapp.activities;

import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;


import com.example.sinopi.bakingapp.R;
import com.example.sinopi.bakingapp.fragments.StepsActivityFragment;
import com.example.sinopi.bakingapp.fragments.StepsDetailsActivityFragment;

import static com.example.sinopi.bakingapp.activities.MainActivity.isTablet;

public class StepsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            if (isTablet) {
                StepsActivityFragment stepsFragment = new StepsActivityFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.stepsframe, stepsFragment)
                        .commit();

                StepsDetailsActivityFragment stepsDetailsFragment = new StepsDetailsActivityFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.stepsdetailsframe, stepsDetailsFragment)
                        .commit();
            } else {
                StepsActivityFragment stepsFragment = new StepsActivityFragment();
                fragmentManager.beginTransaction()
                        .add(R.id.stepsframe, stepsFragment)
                        .commit();
            }
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    }


