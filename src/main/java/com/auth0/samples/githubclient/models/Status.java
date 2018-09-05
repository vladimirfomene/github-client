package com.auth0.samples.githubclient.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Status {

    @SerializedName("status")
    @Expose
    private String status;

    public Status(String stat){
        this.status = stat;
    }

}
