package com.starboy.profile.home.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.starboy.profile.home.model.PersonResponse;
import com.starboy.profile.utils.Utils;

import java.io.IOException;

/**
 * Created by i_osc on 8/14/2017.
 */

public class PersonalPresenter {

    private PersonalPresenterListener listener;
    private Context context;

    public PersonalPresenter(PersonalPresenterListener listener, Context context) {
        this.listener = listener;
        this.context = context;
    }

    public void getData() {
        try {
            String exp = Utils.loadJSONFromAsset(context, "personal.json");

            PersonResponse items = new Gson().fromJson(exp, PersonResponse.class);
            listener.setData(items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface PersonalPresenterListener {

        void setData(PersonResponse items);
    }
}
