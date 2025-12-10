package com.expensivetracker;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ExpenseDAO dao = new ExpenseDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== EXPENSE TRACKER ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Category: ");
                    String category = sc.nextLine();
                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Date (yyyy-mm-dd): ");
                    String date = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();

                    Expense e = new Expense(category, amount, date, desc);
                    dao.addExpense(e);
                    break;

                case 2:
                    List<Expense> list = dao.getAllExpenses();
                    System.out.println("\nID | CATEGORY | AMOUNT | DATE | DESCRIPTION");
                    for (Expense exp : list) {
                        System.out.println(exp.getId() + " | " +
                                exp.getCategory() + " | " +
                                exp.getAmount() + " | " +
                                exp.getDate() + " | " +
                                exp.getDescription());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteExpense(id);
                    break;

                case 4:
                    System.out.println("Goodbye...");
                    System.exit(0);
            }
        }
    }
}

