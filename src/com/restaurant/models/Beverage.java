package com.restaurant.models;

public class Beverage extends MenuItem {
    private boolean isAlcoholic;
    private int volumeMl;

    public Beverage(int id, String name, double price, boolean isAlcoholic, int volumeMl) {
        super(id, name, price);
        this.isAlcoholic = isAlcoholic;
        this.volumeMl = volumeMl;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public int getVolumeMl() {
        return volumeMl;
    }

    @Override
    public String getDetails() {
        return "Type: Beverage | Volume: " + volumeMl + "ml | Alcoholic: " + (isAlcoholic ? "Yes" : "No");
    }
}
