package org.ac.cst8277.Befekadu.Nahom.twitternbk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Person {

    public Person(@JsonProperty int id,@JsonProperty String userName,@JsonProperty String password,@JsonProperty String email,@JsonProperty int subscriberCount,@JsonProperty String createDate) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.subscriberCount = subscriberCount;
        this.createDate = createDate;
    }

    private final int id;
    @NotBlank
    private final String userName;
    @NotBlank
    private final String  password;
    private final String  email;
    private final int  subscriberCount;
    private final String  createDate;

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getSubscriberCount() {
        return subscriberCount;
    }

    public String getCreateDate() {
        return createDate;
    }
}
