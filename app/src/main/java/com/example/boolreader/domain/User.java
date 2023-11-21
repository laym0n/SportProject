package com.example.boolreader.domain;


import java.util.Objects;

public class User {
    private String login;
    private String pass;

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login) && pass.equals(user.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
