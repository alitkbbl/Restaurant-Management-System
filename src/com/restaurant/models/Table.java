package com.restaurant.models;

public class Table {
    private int tableNumber;
    private int capacity;
    private boolean isOccupied;
    private Order currentOrder;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isOccupied = false;
        this.currentOrder = null;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupy() {
        this.isOccupied = true;
    }

    public void vacate() {
        this.isOccupied = false;
        this.currentOrder = null;
    }

    public void setOrder(Order order) {
        this.currentOrder = order;
    }

    public Order getOrder() {
        return currentOrder;
    }

    @Override
    public String toString() {
        return "Table " + tableNumber + " [Capacity: " + capacity + "] - " + (isOccupied ? "Occupied" : "Available");
    }
}
