package com.auth0.samples.githubclient.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Permissions {

    @SerializedName("admin")
    @Expose
    private Boolean admin;
    @SerializedName("push")
    @Expose
    private Boolean push;
    @SerializedName("pull")
    @Expose
    private Boolean pull;

}