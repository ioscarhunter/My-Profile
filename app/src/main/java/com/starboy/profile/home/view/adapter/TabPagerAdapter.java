package com.starboy.profile.home.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.starboy.profile.home.model.TabFragmentItem;

import java.util.ArrayList;

/**
 * Created by i_osc on 5/8/2017.
 */


public class TabPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<TabFragmentItem> tabItemIcons;
    private int mCurrentPosition = -1;
    private Context context;

    public TabPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabItemIcons = new ArrayList<>();
    }

    public void setTabItemIcons(ArrayList<TabFragmentItem> tabItemIcons) {
        this.tabItemIcons = tabItemIcons;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return tabItemIcons.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return tabItemIcons.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabItemIcons.get(position).getTitle();
    }

}

