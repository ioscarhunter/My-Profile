package com.starboy.profile.home.model;

import com.google.gson.annotations.SerializedName;

public class FacebookResponse {

    @SerializedName("data")
    private FacebookData facebookData;

    public FacebookData getFacebookData() {
        return facebookData;
    }
}