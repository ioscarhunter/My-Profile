package com.starboy.profile.home.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import com.starboy.profile.R;
import com.starboy.profile.home.model.FacebookResponse;
import com.starboy.profile.home.model.TabFragmentItem;
import com.starboy.profile.home.presenter.HomePresenter;
import com.starboy.profile.home.view.adapter.TabPagerAdapter;
import com.starboy.profile.home.view.fragment.DetailFragment;
import com.starboy.profile.home.view.fragment.EducationFragment;
import com.starboy.profile.home.view.fragment.ExperienceFragment;
import com.starboy.profile.service.FacebookService;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity implements HomePresenter.HomePresenterListener {

    private final String TAG = "HomeActivity";
    private ViewPager viewPager;
    private CollapsingToolbarLayout collapsingToolbar;
    private ImageView profileBackdrop;
    private Toolbar toolbar;
    private CircleImageView profileImage;
    private TabLayout tabLayout;
    private ArrayList<TabFragmentItem> tabFragmentItems;
    private TabPagerAdapter tabPagerAdapter;
    private AppBarLayout appbarLayout;
    private int maxScrollSize;
    private boolean isAvatarShown;
    private FacebookService facebookService;
    private HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bindViews();
        initTab();
        homePresenter = new HomePresenter(getApplicationContext(), HomeActivity.this);

    }

    private void bindViews() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        profileBackdrop = (ImageView) findViewById(R.id.profileBackdrop);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        profileImage = (CircleImageView) findViewById(R.id.profileImage);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        appbarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);

        appbarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (maxScrollSize == 0)
                    maxScrollSize = appBarLayout.getTotalScrollRange();

                float percentage = (Math.abs(verticalOffset)) * 2 / (float) maxScrollSize;
                Log.d(TAG, "onOffsetChanged: " + percentage);
                if (percentage <= 1) {
                    profileImage.setScaleX(1 - percentage);
                    profileImage.setScaleY(1 - percentage);
                } else {
                    profileImage.setScaleX(0);
                    profileImage.setScaleY(0);
                }

//
//                if (percentage >= PERCENTAGE_TO_ANIMATE_AVATAR && isAvatarShown) {
//                    isAvatarShown = false;
//                    profileImage.animate()
//                            .scaleY(0).scaleX(0)
//                            .setDuration(200)
//                            .start();
//                }
//
//                if (percentage <= PERCENTAGE_TO_ANIMATE_AVATAR && !isAvatarShown) {
//                    isAvatarShown = true;
//
//                    profileImage.animate()
//                            .scaleY(1).scaleX(1)
//                            .start();
//                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        homePresenter.getFacebookImage();
    }

    private void initTab() {
        tabFragmentItems = new ArrayList<>();
        tabFragmentItems.add(new TabFragmentItem(DetailFragment.newInstance(), getString(R.string.fragment_detail)));
        tabFragmentItems.add(new TabFragmentItem(EducationFragment.newInstance(), getString(R.string.fragment_education)));
        tabFragmentItems.add(new TabFragmentItem(ExperienceFragment.newInstance(), getString(R.string.fragment_exprience)));

        tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), getApplication());
        tabPagerAdapter.setTabItemIcons(tabFragmentItems);
        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public void onFacebookDataReady(FacebookResponse facebookResponse) {
        String url = facebookResponse.getFacebookData().getUrl();
        if (url != null) {
            homePresenter.loadImageFromURL(url, profileImage);
        }
    }
}
