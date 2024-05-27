package com.test.kaarigar;

public class CardItem {
    private int imageResource;
    private String serviceName;
    private String rating;
    private String price;

    public CardItem(int imageResource, String serviceName, String rating, String price) {
        this.imageResource = imageResource;
        this.serviceName = serviceName;
        this.rating = rating;
        this.price = price;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getRating() {
        return rating;
    }

    public String getPrice() {
        return price;
    }
}
