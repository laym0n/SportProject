package com.example.boolreader.services;

import com.example.boolreader.domain.User;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class AuthService {
    private static AuthService instance;
    public static AuthService getInstance() {
        return Objects.isNull(instance) ? instance = new AuthService() : instance;
    }
    private HashMap<String, User> users = new HashMap<>();
    private Optional<User> currentUser;
    private AuthService() {
        users.put("Victor", new User("Victor", "pass"));
    }

    public void auth(String login, String pass) {
        if (!users.containsKey(login) || !users.get(login).getPass().equals(pass)) {
            throw new InvalidParameterException("Логин или пароль неверный");
        }
        currentUser = Optional.of(users.get(login));
    }

    public void register(String login, String pass) {
        if ("".equals(login.trim()) || "".equals(pass.trim())) {
            throw new InvalidParameterException("Некорректный пароль или логин");
        }
        if (users.containsKey(login)) {
            throw new InvalidParameterException("Такой логин уже занят");
        }
        users.put(login, new User(login, pass));
    }

    public User getCurrentUser() {
        return currentUser.orElseThrow(() -> new RuntimeException("Пользователь не авторизован"));
    }
    public boolean isAuth() {
        return currentUser.isPresent();
    }
}
