package com.example.boolreader;

import java.util.HashMap;

public class AuthService {
    public HashMap<String, String> users = new HashMap<>();
    public AuthService() {
        users.put("Victor", "123");
    }

    public boolean auth(String name, String pass) {
        return users.getOrDefault(name, "").equals(pass);
    }
}
