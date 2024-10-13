package com.example.task5;

public class Dish {
    String name;
    int thumbnail;
    Boolean promotion;

    public Dish(String name, int thumbnail, Boolean promotion) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.promotion = promotion;
    }

    public String getName() {
        return name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public Boolean getPromotion() {
        return promotion;
    }
}
