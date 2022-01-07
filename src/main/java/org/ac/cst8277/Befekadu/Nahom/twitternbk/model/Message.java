package org.ac.cst8277.Befekadu.Nahom.twitternbk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Message {

    public Message(@JsonProperty int messageID,@JsonProperty  String content,@JsonProperty  int likesCount,@JsonProperty  int retweetCount,@JsonProperty  String createDate,@JsonProperty  int creatorID) {
        MessageID = messageID;
        this.content = content;
        this.likesCount = likesCount;
        this.retweetCount = retweetCount;
        this.createDate = createDate;
        this.creatorID = creatorID;
    }

    private final int MessageID;
    @NotBlank
    private final String content;
    @NotBlank
    private final int  likesCount;

    private final int  retweetCount;

    private final String  createDate;
    @NotBlank
    private final int  creatorID;

    public int getMessageID() {
        return MessageID;
    }

    public String getContent() {
        return content;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public String getCreateDate() {
        return createDate;
    }

    public int getCreatorID() {
        return creatorID;
    }
}
