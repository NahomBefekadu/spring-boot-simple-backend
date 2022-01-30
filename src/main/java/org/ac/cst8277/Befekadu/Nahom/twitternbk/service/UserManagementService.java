package org.ac.cst8277.Befekadu.Nahom.twitternbk.service;



import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserManagementService {
    public static List<UUID> Tokens;

    public UserManagementService() {
        Tokens = new ArrayList<>();
    }

    public List<UUID> getTokens() {
        return Tokens;
    }

    public UUID createToken() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        Tokens.add(uuid);
        return uuid;
    }
    public boolean TokenExists(UUID token){
        return Tokens.contains(token);
    }

}
