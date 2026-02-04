package com.restaurant;

import com.restaurant.exceptions.TableException;
import com.restaurant.models.Beverage;
import com.restaurant.models.Food;
import com.restaurant.models.MenuItem;
import com.restaurant.models.Table;
import com.restaurant.service.RestaurantManager;

import java.util.Scanner;

public class Main {
    private static final RestaurantManager manager = RestaurantManager.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedData();
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displayTables();
                    break;
                case "2":
                    displayMenu();
                    break;
                case "3":
                    handleReservation();
                    break;
                case "4":
                    handleOrder();
                    break;
                case "5":
                    handleCheckout();
                    break;
                case "0":
                    running = false;
                    System.out.println("System shutting down...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== RESTAURANT SYSTEM ===");
        System.out.println("1. View Tables");
        System.out.println("2. View Menu");
        System.out.println("3. Occupy Table");
        System.out.println("4. Add Item to Order");
        System.out.println("5. Checkout / Print Bill");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
    }

    private static void displayTables() {
        System.out.println("\n--- Tables Status ---");
        for (Table t : manager.getTables().values()) {
            System.out.println(t);
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- Menu ---");
        for (MenuItem item : manager.getMenu()) {
            System.out.println(item + " -> " + item.getDetails());
        }
    }

    private static void handleReservation() {
        System.out.print("Enter Table Number to Occupy: ");
        try {
            int tableNum = Integer.parseInt(scanner.nextLine());
            manager.reserveTable(tableNum);
            System.out.println("Table " + tableNum + " is now occupied.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format.");
        } catch (TableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void handleOrder() {
        try {
            System.out.print("Enter Table Number: ");
            int tableNum = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Menu Item ID: ");
            int itemId = Integer.parseInt(scanner.nextLine());

            manager.addItemToOrder(tableNum, itemId);
            System.out.println("Item added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format.");
        } catch (TableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void handleCheckout() {
        System.out.print("Enter Table Number to Checkout: ");
        try {
            int tableNum = Integer.parseInt(scanner.nextLine());
            String bill = manager.generateBill(tableNum);
            System.out.println(bill);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format.");
        } catch (TableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void seedData() {
        manager.addTable(new Table(1, 4));
        manager.addTable(new Table(2, 2));
        manager.addTable(new Table(3, 6));

        manager.addMenuItem(new Food(101, "Burger", 8.99, false, "American"));
        manager.addMenuItem(new Food(102, "Spicy Pasta", 12.50, true, "Italian"));
        manager.addMenuItem(new Beverage(201, "Coke", 2.00, false, 330));
        manager.addMenuItem(new Beverage(202, "Red Wine", 15.00, true, 250));
    }
}
