package com.starboy.profile.home.presenter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.starboy.profile.R;
import com.starboy.profile.home.model.FacebookResponse;
import com.starboy.profile.service.FacebookService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by i_osc on 8/3/2017.
 */

public class HomePresenter {

    private FacebookService.FacebookApi facebookApi;
    private Context context;
    private HomePresenterListener listener;

    public HomePresenter(Context context, HomePresenterListener listener) {
        this.context = context;
        this.listener = listener;

        facebookApi = FacebookService.getFacebookApi();
    }

    public void getFacebookImage() {
        Call<FacebookResponse> call = facebookApi.getProfilePic(context.getString(R.string.id_facebook), "large", false, 9999, 9999);
        call.enqueue(new Callback<FacebookResponse>() {
            @Override
            public void onResponse(Call<FacebookResponse> call, Response<FacebookResponse> response) {
                FacebookResponse body = response.body();
                if (body != null) {
                    listener.onFacebookDataReady(body);
                }
            }

            @Override
            public void onFailure(Call<FacebookResponse> call, Throwable t) {

            }
        });
    }

    public void loadImageFromURL(final String imageUrl, final ImageView imageView) {
        Glide.with(context)
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .dontAnimate()
//                .error(R.drawable.bg)
                .into(imageView);
    }

    public interface HomePresenterListener {
        void onFacebookDataReady(FacebookResponse facebookResponse);
    }
}
