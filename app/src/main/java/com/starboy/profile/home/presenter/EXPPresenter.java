package com.starboy.profile.home.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.starboy.profile.home.model.ExperienceItem;
import com.starboy.profile.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by i_osc on 8/14/2017.
 */

public class EXPPresenter {

    private EXPPresenterListener listener;
    private Context context;

    public EXPPresenter(Context context, EXPPresenterListener listener) {
        this.listener = listener;
        this.context = context;
    }

    public void getData(String filename) {
        try {
            String exp = Utils.loadJSONFromAsset(context, filename);

            ArrayList<ExperienceItem> items = new Gson().fromJson(exp, new TypeToken<ArrayList<ExperienceItem>>() {
            }.getType());
            listener.setData(items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface EXPPresenterListener {
        void setData(ArrayList<ExperienceItem> items);
    }

}
