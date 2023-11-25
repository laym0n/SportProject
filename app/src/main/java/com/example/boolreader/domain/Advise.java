package com.example.boolreader.domain;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Advise {
    private UUID id = UUID.randomUUID();
    private String title;
    private String text;
    private Company company;

    public Advise(String title, String text, Company company) {
        this.title = title;
        this.text = text;
        this.company = company;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return title;
    }
}
