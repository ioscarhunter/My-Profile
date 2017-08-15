package com.starboy.profile.home.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.starboy.profile.R;
import com.starboy.profile.home.model.PersonResponse;
import com.starboy.profile.home.presenter.PersonalPresenter;

public class DetailFragment extends Fragment implements PersonalPresenter.PersonalPresenterListener {

    private PersonalPresenter presenter;
    private LinearLayout addressLayout;
    private TextView addressText;
    private LinearLayout phoneLayout;
    private TextView phoneText;
    private LinearLayout bdayLayout;
    private TextView bdayText;
    private LinearLayout mailLayout;
    private TextView mailText;
    private LinearLayout profileLayout;
    private TextView profileText;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter = new PersonalPresenter(this, context);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addressLayout = (LinearLayout) view.findViewById(R.id.addressLayout);
        addressText = (TextView) view.findViewById(R.id.addressText);
        phoneLayout = (LinearLayout) view.findViewById(R.id.phoneLayout);
        phoneText = (TextView) view.findViewById(R.id.phoneText);
        bdayLayout = (LinearLayout) view.findViewById(R.id.bdayLayout);
        bdayText = (TextView) view.findViewById(R.id.bdayText);
        mailLayout = (LinearLayout) view.findViewById(R.id.mailLayout);
        mailText = (TextView) view.findViewById(R.id.mailText);
        profileLayout = (LinearLayout) view.findViewById(R.id.profileLayout);
        profileText = (TextView) view.findViewById(R.id.profileText);

        presenter.getData();
    }

    @Override
    public void setData(PersonResponse items) {
        addressText.setText(items.getAddress());
        phoneText.setText(items.getTelephone());
        mailText.setText(items.getEmail());
        profileText.setText(items.getUrl());
        bdayText.setText(items.getBirthday());


    }
}
