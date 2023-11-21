package com.example.boolreader.domain;

import java.util.List;
import java.util.UUID;

public class Company {
    private UUID id;
    private String name;
    private String address;

    private List<Advise> advises;
    private User creator;
}
