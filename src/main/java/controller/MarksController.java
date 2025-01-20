/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.DatabaseConnection;
import model.marks;

/**
 *
 * @author DELL
 */
public class MarksController {
    public void addMarks(int studentId, String month, String subject, int marks) {
        try {
            marks marksEntity = new marks(studentId, month, subject, marks);
            marksEntity.saveMarks();
            JOptionPane.showMessageDialog(null, "Marks added successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding marks: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateMarks(int studentId, String month, String subject, int marks) {
    try {
        marks marksEntity = new marks(studentId, month, subject, marks);
        boolean isUpdated = marksEntity.updateMarks();

        if (isUpdated) {
            JOptionPane.showMessageDialog(null, "Marks updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "No matching record found to update.", "Update Error", JOptionPane.WARNING_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error updating marks: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
public Vector<Vector<Object>> getAllMarks() {
        try {
            marks marksModel = new marks();
            return marksModel.getAllMarks();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading marks: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return new Vector<>(); // Return an empty vector in case of error
        }
    }

    // Method to retrieve marks for a student ID
    public ArrayList<marks> getMarksByStudentId(int studentId) {
        return marks.getMarksByStudentId(studentId);
    }
}
