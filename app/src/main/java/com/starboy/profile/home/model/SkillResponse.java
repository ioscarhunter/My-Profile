package com.starboy.profile.home.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SkillResponse {

    @SerializedName("skill")
    private List<SkillItem> skill;

    @SerializedName("name")
    private String name;

    public List<SkillItem> getSkill() {
        return skill;
    }

    public String getName() {
        return name;
    }
}