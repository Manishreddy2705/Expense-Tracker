package com.expensivetracker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {

    Connection conn;

    public ExpenseDAO() {
        conn = DBConnection.getConnection();
        System.out.println("DAO Connection test: " + conn);
    }

    public void addExpense(Expense e) {
        String sql = "INSERT INTO expenses(category, amount, expense_date, description) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, e.getCategory());
            ps.setDouble(2, e.getAmount());
            ps.setString(3, e.getDate());
            ps.setString(4, e.getDescription());
            ps.executeUpdate();
            System.out.println("Expense added successfully!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    public List<Expense> getAllExpenses() {
        List<Expense> list = new ArrayList<>();
        String sql = "SELECT * FROM expenses";
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Expense e = new Expense();
                e.setId(rs.getInt("id"));
                e.setCategory(rs.getString("category"));
                e.setAmount(rs.getDouble("amount"));
                e.setDate(rs.getString("expense_date"));
                e.setDescription(rs.getString("description"));
                list.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void deleteExpense(int id) {
        String sql = "DELETE FROM expenses WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Expense deleted successfully!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
