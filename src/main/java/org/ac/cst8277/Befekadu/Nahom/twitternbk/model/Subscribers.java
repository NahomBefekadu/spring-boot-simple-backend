package org.ac.cst8277.Befekadu.Nahom.twitternbk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Subscribers {


    public Subscribers(@JsonProperty int subscriptionID,@JsonProperty  String dateSubscribed,@JsonProperty  int userID,@JsonProperty  int followerID) {
        this.subscriptionID = subscriptionID;
        this.dateSubscribed = dateSubscribed;
        UserID = userID;
        FollowerID = followerID;
    }

    private final int subscriptionID;
    @NotBlank
    private final String dateSubscribed;
    @NotBlank
    private final int  UserID;
    private final int  FollowerID;

    public int getSubscriptionID() {
        return subscriptionID;
    }

    public String getDateSubscribed() {
        return dateSubscribed;
    }

    public int getUserID() {
        return UserID;
    }

    public int getFollowerID() {
        return FollowerID;
    }
}
