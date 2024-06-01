package com.test.kaarigar.categories;

public class categorymodel {
    private int imageResId;
    private String rating;
    private String description;
    private String price;
    private Class<?> targetActivity;

    public categorymodel(int imageResId, String rating, String description, String price, Class<?> targetActivity) {
        this.imageResId = imageResId;
        this.rating = rating;
        this.description = description;
        this.price = price;
        this.targetActivity = targetActivity;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public Class<?> getTargetActivity() {
        return targetActivity;
    }
}
