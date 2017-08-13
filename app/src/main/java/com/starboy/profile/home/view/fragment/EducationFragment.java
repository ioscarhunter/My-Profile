package com.starboy.profile.home.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.starboy.profile.R;
import com.starboy.profile.home.model.ExperienceItem;
import com.starboy.profile.home.view.adapter.ExperienceAdapter;
import com.starboy.profile.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;


public class EducationFragment extends Fragment {

    private RecyclerView recyclerView;

    public EducationFragment() {
        // Required empty public constructor
    }


    public static EducationFragment newInstance() {
        return new EducationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_education, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ExperienceAdapter adapter = new ExperienceAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        try {
            String exp = Utils.loadJSONFromAsset(getActivity(), "education.json");

            ArrayList<ExperienceItem> items = new Gson().fromJson(exp, new TypeToken<ArrayList<ExperienceItem>>() {
            }.getType());
            adapter.setItems(items);
        } catch (IOException e) {
            e.printStackTrace();
        }


//        adapter.setItems()


    }
}
