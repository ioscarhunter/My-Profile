package com.starboy.profile.home.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.starboy.profile.R;
import com.starboy.profile.home.model.SkillResponse;
import com.starboy.profile.home.presenter.SkillPresenter;

import java.util.ArrayList;

/**
 */
public class SkillFragment extends Fragment implements SkillPresenter.SkillPresenterListener {

    private SkillPresenter presenter;

    public SkillFragment() {
        // Required empty public constructor
    }

    public static SkillFragment newInstance() {
        return new SkillFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter = new SkillPresenter(this, context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getData();
    }

    @Override
    public void setData(ArrayList<SkillResponse> items) {

    }
}
