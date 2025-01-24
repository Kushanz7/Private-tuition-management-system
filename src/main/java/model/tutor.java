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
    public tutor getTutorDetails() {
    tutor tutor = null; // Initialize the tutor object
    try {
        // Get database connection
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        // Query to get tutor name and email
        String query = "SELECT name, email FROM tutor";
        PreparedStatement ps = connection.prepareStatement(query);

        // Execute query
        ResultSet rs = ps.executeQuery();

        // If tutor data is found, create a Tutor object
        if (rs.next()) {
            String name = rs.getString("name");
            String email = rs.getString("email");
            tutor = new tutor(); // Assuming a no-arg constructor exists
            tutor.setName(name); // Assuming setter methods exist
            tutor.setEmail(email);
        }

        // Close resources
        rs.close();
        ps.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error retrieving tutor details: " + e.getMessage());
    }
    return tutor;
}

}
