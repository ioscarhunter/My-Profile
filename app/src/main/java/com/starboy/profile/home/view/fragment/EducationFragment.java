package com.starboy.profile.home.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.starboy.profile.R;
import com.starboy.profile.home.model.ExperienceItem;
import com.starboy.profile.home.presenter.EXPPresenter;
import com.starboy.profile.home.view.adapter.ExperienceAdapter;

import java.util.ArrayList;


public class EducationFragment extends Fragment implements EXPPresenter.EXPPresenterListener {

    private RecyclerView recyclerView;
    private EXPPresenter presenter;
    private ExperienceAdapter adapter;

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
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter = new EXPPresenter(context, this);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ExperienceAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        String filename = "education.json";
        presenter.getData(filename);

//        adapter.setItems()


    }

    public void setData(ArrayList<ExperienceItem> items) {
        adapter.setItems(items);
    }

}
