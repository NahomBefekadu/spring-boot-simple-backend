package org.ac.cst8277.Befekadu.Nahom.twitternbk.api;

import java.util.UUID;

public class Result {

    public Result(String mesg, UUID token) {
        this.mesg = mesg;
        this.token = token;
    }
    String mesg;
    UUID token;
    public String getMesg() {
        return mesg;
    }

    public UUID getToken() {
        return token;
    }


}
