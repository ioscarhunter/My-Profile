package com.starboy.profile.home.model;

import com.google.gson.annotations.SerializedName;

public class SkillItem {

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }
}