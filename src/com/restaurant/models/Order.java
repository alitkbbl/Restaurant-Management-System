package com.restaurant.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private List<MenuItem> items;
    private boolean isClosed;

    public Order(int orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.isClosed = false;
    }

    public void addItem(MenuItem item) {
        if (!isClosed) {
            items.add(item);
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void closeOrder() {
        this.isClosed = true;
    }

    public boolean isClosed() {
        return isClosed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId).append("\n");
        for (MenuItem item : items) {
            sb.append(" - ").append(item.getName()).append(": $").append(item.getPrice()).append("\n");
        }
        sb.append("Total: $").append(calculateTotal());
        return sb.toString();
    }
}
