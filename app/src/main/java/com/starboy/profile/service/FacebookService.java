package com.starboy.profile.service;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.starboy.profile.BuildConfig;
import com.starboy.profile.home.model.FacebookResponse;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by i_osc on 8/2/2017.
 */

public class FacebookService {

    public static final String FACEBOOK_URL = "http://graph.facebook.com/";

    @NonNull
    public static MultipartBody.Part getImageMultipart(Uri uri, String key) {
        File file = new File(uri.getPath());
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        return MultipartBody.Part.createFormData(key, file.getName(), requestFile);
    }

    public static FacebookApi getFacebookApi() {
        return getApi(new Gson(), FACEBOOK_URL, FacebookApi.class);
    }

    public static <T> T getApi(Gson gson, String url, Class<T> service) {

        OkHttpClient.Builder httpClient;

        httpClient = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            httpClient.addInterceptor(logging);
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(service);


    }

    public interface FacebookApi {
        @GET("{facebookID}/picture")
        Call<FacebookResponse> getProfilePic(@Path("facebookID") String username, @Query("type") String type, @Query("redirect") boolean redirect, @Query("width") int width, @Query("height") int height);
    }
}
