package com.restaurant.service;

import com.restaurant.exceptions.TableException;
import com.restaurant.models.MenuItem;
import com.restaurant.models.Order;
import com.restaurant.models.Table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantManager {
    private static RestaurantManager instance;
    private List<MenuItem> menu;
    private Map<Integer, Table> tables;
    private int orderCounter;

    private RestaurantManager() {
        menu = new ArrayList<>();
        tables = new HashMap<>();
        orderCounter = 1;
    }

    public static RestaurantManager getInstance() {
        if (instance == null) {
            instance = new RestaurantManager();
        }
        return instance;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void addTable(Table table) {
        tables.put(table.getTableNumber(), table);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public Map<Integer, Table> getTables() {
        return tables;
    }

    public MenuItem findMenuItemById(int id) {
        for (MenuItem item : menu) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void reserveTable(int tableNumber) throws TableException {
        if (!tables.containsKey(tableNumber)) {
            throw new TableException("Table does not exist.");
        }
        Table table = tables.get(tableNumber);
        if (table.isOccupied()) {
            throw new TableException("Table is already occupied.");
        }
        table.occupy();
        table.setOrder(new Order(orderCounter++));
    }

    public void addItemToOrder(int tableNumber, int itemId) throws TableException {
        if (!tables.containsKey(tableNumber)) {
            throw new TableException("Table not found.");
        }
        Table table = tables.get(tableNumber);
        if (!table.isOccupied() || table.getOrder() == null) {
            throw new TableException("Table is not occupied or has no active order.");
        }

        MenuItem item = findMenuItemById(itemId);
        if (item == null) {
            throw new TableException("Menu item not found.");
        }

        table.getOrder().addItem(item);
    }

    public String generateBill(int tableNumber) throws TableException {
        if (!tables.containsKey(tableNumber)) {
            throw new TableException("Table not found.");
        }
        Table table = tables.get(tableNumber);
        if (!table.isOccupied() || table.getOrder() == null) {
            throw new TableException("No active order for this table.");
        }

        Order order = table.getOrder();
        String bill = "--- BILL FOR TABLE " + tableNumber + " ---\n" + order.toString();

        order.closeOrder();
        table.vacate();

        return bill;
    }
}
