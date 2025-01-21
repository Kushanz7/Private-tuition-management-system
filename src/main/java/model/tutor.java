/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class tutor {
    private int id;
    private String name;
    private String email;
    private String password;

    public tutor(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public tutor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void saveTutor() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO tutor (name, email, password) VALUES (?, ?, ?)"); 
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString()); 
        } 
    }
    
    public static tutor getTutorDetails() {
        tutor tutor = null;

        // SQL query to retrieve tutor details
        String query = "SELECT name, email, password FROM tutor LIMIT 1";  // No WHERE clause since only one tutor

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Retrieve data from ResultSet
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String password = rs.getString("password");

                    // Create a Tutor object with the retrieved data
                    tutor = new tutor(name, email, password);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tutor;
    }
    public void saveSubject(String subjectName) {
    try {
        // Get database connection
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        // SQL query to insert a new subject into the subjects table
        PreparedStatement ps = connection.prepareStatement("INSERT INTO subjects (name) VALUES (?)");

        // Set the subject name as the parameter
        ps.setString(1, subjectName);

        // Execute the update to save the subject
        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Subject saved successfully!");
        
    } catch (SQLException e) {
        // Handle SQL errors here
        JOptionPane.showMessageDialog(null, "Error: " + e.toString());
    }
}


}
