package com.starboy.profile.home.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.starboy.profile.home.model.SkillResponse;
import com.starboy.profile.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by i_osc on 8/14/2017.
 */

public class SkillPresenter {

    private SkillPresenterListener listener;
    private Context context;

    public SkillPresenter(SkillPresenterListener listener, Context context) {
        this.listener = listener;
        this.context = context;
    }

    public void getData() {
        try {
            String exp = Utils.loadJSONFromAsset(context, "skill.json");

            ArrayList<SkillResponse> items = new Gson().fromJson(exp, new TypeToken<ArrayList<SkillResponse>>() {
            }.getType());
            listener.setData(items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface SkillPresenterListener {

        void setData(ArrayList<SkillResponse> items);
    }
}
