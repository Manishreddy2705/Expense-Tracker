# Expense Tracker (Java, JDBC, MySQL)

A simple console-based Expense Tracker application built using Java, JDBC, and MySQL.  
This project allows users to manage daily expenses with features like adding, viewing, and deleting expense records.  
The data is stored in a MySQL database using secure CRUD operations.

---

## 🚀 Features

- Add new expenses (category, amount, date, description)
- View all recorded expenses
- Delete an expense by ID
- MySQL database for persistent storage
- JDBC PreparedStatement for secure queries
- Clean DAO (Data Access Object) architecture

---

## 🛠 Tech Stack

- **Java**
- **JDBC**
- **MySQL**
- **DAO Design Pattern**

---

## 📁 Project Structure



ExpenseTracker/
│── src/
│ ├── com.expensivetracker/
│ │ ├── DBConnection.java
│ │ ├── Expense.java
│ │ ├── ExpenseDAO.java
│ │ ├── Main.java
│── README.md
│── expense_db.sql


---

## Database Setup

Run the following SQL commands in MySQL:

```sql
CREATE DATABASE expense_db;

USE expense_db;

CREATE TABLE expenses(
    id INT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(50),
    amount DOUBLE,
    expense_date DATE,
    description VARCHAR(255)
);

🔌 Database Connection

Update your MySQL username and password inside DBConnection.java:

private static final String URL = "jdbc:mysql://localhost:3306/expense_db";
private static final String USER = "root"; 
private static final String PASSWORD = "your_password";

▶️ How to Run the Project

Install Java (JDK 8 or above)

Install MySQL Server

Add mysql-connector-j.jar to your project classpath

Create the database and table using the SQL above

Compile and run the project:

javac Main.java
java Main

📌 Usage
1. Add Expense

Enter category, amount, date, and a small description.

2. View All Expenses

Displays all the saved expense records.

3. Delete Expense

Enter the ID of the expense you want to delete.

4. Exit

Closes the application.

📘 Example Console Output
=== EXPENSE TRACKER ===
1. Add Expense
2. View All Expenses
3. Delete Expense
4. Exit
Choose: 1
Category: Food
Amount: 120
Date (yyyy-mm-dd): 2025-01-11
Description: Lunch
Expense added successfully!

📖 Learning Highlights

JDBC connection handling

PreparedStatement to prevent SQL Injection

DAO (Data Access Object) pattern for clean architecture

CRUD operations in MySQL using Java

🤝 Contributing

Pull requests are welcome.
For major changes, please open an issue first to discuss what you would like to change.
