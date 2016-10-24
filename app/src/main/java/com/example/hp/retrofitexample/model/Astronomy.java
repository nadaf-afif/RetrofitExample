package com.example.hp.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hp on 10/23/16.
 */
public class Astronomy {

    @SerializedName("sunrise")
    @Expose
    private String sunrise;
    @SerializedName("sunset")
    @Expose
    private String sunset;

    /**
     *
     * @return
     * The sunrise
     */
    public String getSunrise() {
        return sunrise;
    }

    /**
     *
     * @param sunrise
     * The sunrise
     */
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    /**
     *
     * @return
     * The sunset
     */
    public String getSunset() {
        return sunset;
    }

    /**
     *
     * @param sunset
     * The sunset
     */
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

}
