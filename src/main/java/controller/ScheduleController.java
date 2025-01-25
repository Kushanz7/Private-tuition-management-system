/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.DatabaseConnection;
import model.schedule;

/**
 *
 * @author DELL
 */
public class ScheduleController {
    public void saveSchedule(String subject, String day, String startingtime,String endingtime, String grade) {
        try {
            schedule schedule = new schedule(subject, day, startingtime,endingtime,grade);
            schedule.saveSchedule();
            JOptionPane.showMessageDialog(null, "Schedule Created Successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }
    
    public ArrayList<Object[]> getAllSchedules() {
        ArrayList<Object[]> schedules = new ArrayList<>();
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM schedules");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                schedules.add(new Object[]{
                    rs.getString("subject"),
                    rs.getString("day"),
                    rs.getString("startingtime"),
                    rs.getString("endingtime"),
                    rs.getString("grade")
                });
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return schedules;
    }
    
    public boolean deleteSchedule(String subject, String day, String startingTime, String endingTime, String grade) {
        try {
            schedule schedule = new schedule(subject, day, startingTime, endingTime, grade);
            boolean isDeleted = schedule.deleteSchedule();
            if (isDeleted) {
                JOptionPane.showMessageDialog(null, "Schedule deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Schedule not found!");
            }
            return isDeleted;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }
    
    public void updateSchedule(String subject, String grade, String newSubject, String day, String startingTime, String endingTime, String newGrade) {
    try {
        
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        
        String query = "UPDATE schedules SET subject = ?, day = ?, startingtime = ?, endingtime = ?, grade = ? WHERE subject = ? AND grade = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        
        ps.setString(1, newSubject);
        ps.setString(2, day);
        ps.setString(3, startingTime);
        ps.setString(4, endingTime);
        ps.setString(5, newGrade);
        ps.setString(6, subject);
        ps.setString(7, grade);

        
        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Schedule updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "No matching schedule found for the given subject and grade.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error updating schedule: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

}


