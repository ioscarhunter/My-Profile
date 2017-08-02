package com.starboy.profile.model;

import android.support.v4.app.Fragment;

/**
 * Created by Starboy on 4/12/2017.
 */

public class TabItem {
    private Fragment fragment;
    private String title;

    public TabItem(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
