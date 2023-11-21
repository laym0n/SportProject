package com.example.boolreader.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String login;
    private String pass;

    private List<Company> subscribes;
    private List<Company> owningCompanies;

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<Company> getSubscribes() {
        return Objects.isNull(subscribes) ? subscribes = new ArrayList<>() : subscribes;
    }

    public void setSubscribes(List<Company> subscribes) {
        this.subscribes = subscribes;
    }

    public List<Company> getOwningCompanies() {
        return Objects.isNull(owningCompanies) ? owningCompanies = new ArrayList<>() : owningCompanies;
    }

    public void setOwningCompanies(List<Company> owningCompanies) {
        this.owningCompanies = owningCompanies;
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
