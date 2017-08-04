package com.starboy.profile.home.model;

import com.google.gson.annotations.SerializedName;

public class FacebookData {

    @SerializedName("is_silhouette")
    private boolean isSilhouette;

    @SerializedName("width")
    private int width;

    @SerializedName("url")
    private String url;

    @SerializedName("height")
    private int height;

    public boolean isIsSilhouette() {
        return isSilhouette;
    }

    public int getWidth() {
        return width;
    }

    public String getUrl() {
        return url;
    }

    public int getHeight() {
        return height;
    }
}