package com.test.kaarigar;

public class Booking {

    private String name;
    private String price;
    private String phoneNumber;
    private int imageResId;

    public Booking(String name, String price, String phoneNumber, int imageResId) {
        this.name = name;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getImageResId() {
        return imageResId;
    }
}
