package com.example.mycontactmanager.model;

public class Contact {
    private int id;
    private String name;
    private String phneNumber;

    public Contact(){}

    public Contact(int id, String name, String phneNumber){
        this.id = id;
        this.name = name;
        this.phneNumber = phneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhneNumber() {
        return phneNumber;
    }

    public void setPhneNumber(String phneNumber) {
        this.phneNumber = phneNumber;
    }
}
