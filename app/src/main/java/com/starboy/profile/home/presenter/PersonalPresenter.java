package com.starboy.profile.home.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.starboy.profile.home.model.PersonResponse;
import com.starboy.profile.utils.Utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

            formatDate(items);
            listener.setData(items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void formatDate(PersonResponse items) {
        Calendar calendar = Calendar.getInstance();
        DateFormat fromFormat = new SimpleDateFormat("yyyy-MM-dd");

        DateFormat toFormat = new SimpleDateFormat("dd");

        try {
            calendar.setTime(fromFormat.parse(items.getBirthday()));
            items.setBirthday(toFormat.format(calendar.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();

        }
    }


    private int getAge(Calendar dob) {
        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }


    public interface PersonalPresenterListener {

        void setData(PersonResponse items);
    }
}
