package com.example.boolreader.services;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Objects;

public class AuthService {
    private static AuthService instance;
    public static AuthService getInstance() {
        return Objects.isNull(instance) ? instance = new AuthService() : instance;
    }
    private HashMap<String, String> users = new HashMap<>();
    private AuthService() {
        users.put("Victor", "pass");
    }

    public void auth(String login, String pass) {
        if (!Objects.equals(users.getOrDefault(login, ""), pass)) {
            throw new InvalidParameterException("Логин или пароль неверный");
        }
    }

    public void register(String login, String pass) {
        if ("".equals(login.trim()) || "".equals(pass.trim())) {
            throw new InvalidParameterException("Некорректный пароль или логин");
        }
        if (users.containsKey(login)) {
            throw new InvalidParameterException("Такой логин уже занят");
        }
        users.put(login, pass);
    }

    public void getCurrentUser() {

    }
}
