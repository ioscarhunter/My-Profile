package com.starboy.profile.home.model;

import com.google.gson.annotations.SerializedName;

public class PersonResponse {

    @SerializedName("birthday")
    private String birthday;

    @SerializedName("address")
    private String address;

    @SerializedName("surname")
    private String surname;

    @SerializedName("name")
    private String name;

    @SerializedName("telephone")
    private String telephone;

    @SerializedName("email")
    private String email;

    @SerializedName("url")
    private String url;

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getUrl() {
        return url;
    }
}