package com.restaurant.models;

public class Food extends MenuItem {
    private boolean isSpicy;
    private String cuisineType;

    public Food(int id, String name, double price, boolean isSpicy, String cuisineType) {
        super(id, name, price);
        this.isSpicy = isSpicy;
        this.cuisineType = cuisineType;
    }

    public boolean isSpicy() {
        return isSpicy;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    @Override
    public String getDetails() {
        return "Type: Food | Cuisine: " + cuisineType + " | Spicy: " + (isSpicy ? "Yes" : "No");
    }

    @Override
    public String toString() {
        return super.toString() + " (" + cuisineType + ")";
    }
}
