/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.DatabaseConnection;
import view.Dashboard;

/**
 *
 * @author DELL
 */
public class LoginController {
    public void loginUser(String email, String password) {
        try {
            DatabaseConnection.databaseConnect(); // Ensure the connection is established
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutors WHERE email = ? AND password = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Login successful, redirect to main page
                new Dashboard().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid email or password!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }

}
