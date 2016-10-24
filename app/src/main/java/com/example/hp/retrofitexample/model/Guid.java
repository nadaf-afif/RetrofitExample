package com.example.hp.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hp on 10/23/16.
 */
public class Guid {

    @SerializedName("isPermaLink")
    @Expose
    private String isPermaLink;

    /**
     *
     * @return
     * The isPermaLink
     */
    public String getIsPermaLink() {
        return isPermaLink;
    }

    /**
     *
     * @param isPermaLink
     * The isPermaLink
     */
    public void setIsPermaLink(String isPermaLink) {
        this.isPermaLink = isPermaLink;
    }
}
