/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class DatabaseConnection {
    private static Connection connection;

    public static void databaseConnect() {
         if (connection == null) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ptmsdb?useSSL=false", "root", "root2004");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }}
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                databaseConnect();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error checking database connection: " + e.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);
            databaseConnect(); // Reconnect if necessary
        }
        return connection;
    }

}
