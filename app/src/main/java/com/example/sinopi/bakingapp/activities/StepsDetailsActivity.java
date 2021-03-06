package com.example.sinopi.bakingapp.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.sinopi.bakingapp.R;
import com.example.sinopi.bakingapp.fragments.StepsDetailsActivityFragment;


public class StepsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_details);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            StepsDetailsActivityFragment stepsDetailsFragment = new StepsDetailsActivityFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.stepsdetailsframe, stepsDetailsFragment)
                    .commit();

        }


    }

}
