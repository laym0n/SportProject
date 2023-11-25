package com.example.boolreader.domain;

import java.util.List;
import java.util.UUID;

public class Company {
    private UUID id = UUID.randomUUID();
    private String name;
    private String address;

    private List<Advise> advises;
    private User creator;

    public Company(String name, String address, User creator) {
        this.name = name;
        this.address = address;
        this.creator = creator;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Advise> getAdvises() {
        return advises;
    }

    public void setAdvises(List<Advise> advises) {
        this.advises = advises;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return name;
    }
}
