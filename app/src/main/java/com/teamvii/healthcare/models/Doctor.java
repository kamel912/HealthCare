package com.teamvii.healthcare.models;

/**
 * Created by MK on 12/24/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Doctor {

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("language_english")
    @Expose
    public String languageEnglish;

    @SerializedName("language_arabic")
    @Expose
    public String languageArabic;

    @SerializedName("speciality")
    @Expose
    public String speciality;

    @SerializedName("gender")
    @Expose
    public String gender;

    @SerializedName("areas")
    @Expose
    public String areas;

    @SerializedName("state")
    @Expose
    public String state;

    @SerializedName("insurance")
    @Expose
    public String insurance;

    public String toString() {
        String string =
                "Name : " + name +
                        "language : " + languageEnglish +
                        "arabic :" + languageArabic +
                        " spesiality : " + speciality +
                        " gender :" + gender +
                        " areas " + areas +
                        " state " + state +
                        " insurance " + insurance;


        return string;
    }


}