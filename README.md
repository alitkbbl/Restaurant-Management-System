# Restaurant Management System

A robust, console-based **Restaurant Management System** built with **Java**. This project demonstrates strong **Object-Oriented Programming (OOP)** principles, design patterns, and efficient data management using the Java Collections Framework.

---

## 🚀 Overview

This application allows restaurant staff to manage table reservations, handle customer orders, and generate bills. It is designed to be scalable and maintainable, showcasing a clean architecture that separates models, services, and interfaces.

## 🔑 Key Features

- **Table Management**: View table status, occupy tables, and vacate them upon checkout.
- **Menu System**: Supports different categories of items (Food & Beverages) with specific attributes.
- **Order Processing**: Add items to active tables and calculate real-time totals.
- **Billing**: Generate detailed bills and handle order closure.
- **Error Handling**: Custom exceptions (`TableException`) to manage logic errors like double-booking.

---

## 🛠️ Tech Stack & Concepts

- **Language**: Java (JDK 17+)
- **Architecture**: Modular (MVC-inspired)
- **Data Structures**: `ArrayList`, `HashMap`

### 🧠 OOP Principles Applied
This project is heavily focused on demonstrating OOP concepts:

1.  **Encapsulation**: All model fields are `private` and accessed via public Getters/Setters.
2.  **Inheritance**: `Food` and `Beverage` classes inherit from the base `MenuItem` class.
3.  **Polymorphism**: The `getDetails()` method behaves differently for Food (shows cuisine/spice) and Beverages (shows volume/alcohol).
4.  **Abstraction**:
    - `MenuItem` is an **Abstract Class** (cannot be instantiated directly).
    - `Billable` is an **Interface** ensuring all items have a price and name.

### 🏗️ Design Patterns
- **Singleton Pattern**: The `RestaurantManager` class is a Singleton to ensure a centralized state for the menu and tables throughout the application lifecycle.

---

## 📂 Project Structure
```text
src/
└── com/
└── restaurant/
├── interfaces/
│   └── Billable.java        # Interface for priceable items
├── models/
│   ├── MenuItem.java        # Abstract base class
│   ├── Food.java            # Concrete class for food
│   ├── Beverage.java        # Concrete class for drinks
│   ├── Table.java           # Represents a restaurant table
│   └── Order.java           # Holds order details
├── exceptions/
│   └── TableException.java  # Custom exception handling
├── service/
│   └── RestaurantManager.java # Logic controller (Singleton)
└── Main.java                # Entry point (CLI)
```
---

## 💻 How to Run

### Prerequisites
- Java Development Kit (JDK) 17 or higher.
- An IDE (IntelliJ IDEA, Eclipse) or Terminal.

### Steps
1.  **Clone the repository**:

```bash
    git clone https://github.com/your-username/restaurant-system.git
```
2.   **Open in IDE: Open the project folder in IntelliJ IDEA.**
3.   **Run: Navigate to src/com/restaurant/Main.java and run the main method.**

---

## 📖 Usage Example

Upon running the application, you will see the following interactive menu:
```text
=== RESTAURANT SYSTEM ===

1. View Tables
2. View Menu
3. Occupy Table
4. Add Item to Order
5. Checkout / Print Bill
6. Exit

Select an option: 
```
**Scenario:**

1. Select `3` to occupy Table #1.
2. Select `4` to add a "Burger" (Item ID: 101) to Table #1.
3. Select `5` to checkout Table #1 and see the calculated bill.

