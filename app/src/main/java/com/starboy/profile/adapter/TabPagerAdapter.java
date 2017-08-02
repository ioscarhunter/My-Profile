package com.starboy.profile.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.starboy.profile.model.TabItem;

import java.util.ArrayList;

/**
 * Created by i_osc on 5/8/2017.
 */


public class TabPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<TabItem> tabItems;
    private int mCurrentPosition = -1;
    private Context context;

    public TabPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabItems = new ArrayList<>();
    }

    public void setTabItems(ArrayList<TabItem> tabItems) {
        this.tabItems = tabItems;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return tabItems.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return tabItems.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabItems.get(position).getTitle();
    }

}

