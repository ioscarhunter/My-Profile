package com.starboy.profile.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

/**
 * Created by i_osc on 8/7/2017.
 */

public class Utils {

    public static String loadJSONFromAsset(Context context, String filename) throws IOException {
        String json = null;
        InputStream is = context.getAssets().open(filename);
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        json = new String(buffer, "UTF-8");

        return json;
    }

    public static int getId(String resourceName, Class<?> c) throws NoSuchFieldException, IllegalAccessException {

        Field idField = c.getDeclaredField(resourceName);
        return idField.getInt(idField);
    }
}
