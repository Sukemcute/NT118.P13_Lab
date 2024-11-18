package com.example.taskii;

public class Contact {
    private int id;
    private String phoneNumber;
    private String name;


    public Contact(String phoneNumber, String name) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }


}
