package com.example.sinopi.bakingapp.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import com.example.sinopi.bakingapp.R;
import com.example.sinopi.bakingapp.concoct.Steps;
import com.example.sinopi.bakingapp.adapters.IngredientsAdapter;
import com.example.sinopi.bakingapp.adapters.StepsAdapter;
import com.example.sinopi.bakingapp.bakingactivities.BakingSteps;
import static com.example.sinopi.bakingapp.fragments.MainActivityFragment.bakes;
import static com.example.sinopi.bakingapp.bakingactivities.MainActivity.isTablet;

/**
 * A placeholder fragment containing a simple view.
 */
public class StepsActivityFragment extends Fragment implements StepsAdapter.ListItemClickListener{

    private RecyclerView stepsRecyclerView;
    private RecyclerView ingredientRecyclerView;
    private StepsAdapter stepsAdapter;
    private IngredientsAdapter ingredientsAdapter;
    private int index = 0;
    public static ArrayList<Steps> steps = new ArrayList<>();


    public StepsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_steps, container, false);

        stepsRecyclerView = (RecyclerView) view.findViewById(R.id.stepslist);
        ingredientRecyclerView = (RecyclerView) view.findViewById(R.id.ingredientslist);
        stepsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ingredientRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        index = getActivity().getIntent().getExtras().getInt("item");
        steps = bakes.get(index).getSteps();
        stepsAdapter = new StepsAdapter(this, steps);
        ingredientsAdapter = new IngredientsAdapter(bakes.get(index).getIngredients());
        stepsRecyclerView.setAdapter(stepsAdapter);
        ingredientRecyclerView.setAdapter(ingredientsAdapter);

        return view;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        if (!isTablet) {
            Intent intent = new Intent(getActivity(), BakingSteps.class);
            intent.putExtra("item", clickedItemIndex);
            startActivity(intent);
        } else {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            StepsDetailsActivityFragment stepsDetailsFragment = new StepsDetailsActivityFragment();
            stepsDetailsFragment.index = clickedItemIndex;
            fragmentManager.beginTransaction()
                    .replace(R.id.stepsdetailsframe, stepsDetailsFragment)
                    .commit();
        }
    }

}
