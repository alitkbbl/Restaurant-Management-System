package com.restaurant.models;

import com.restaurant.interfaces.Billable;

public abstract class MenuItem implements Billable {
    private int id;
    private String name;
    private double price;

    public MenuItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public abstract String getDetails();

    @Override
    public String toString() {
        return String.format("[%d] %-15s $%.2f", id, name, price);
    }
}
