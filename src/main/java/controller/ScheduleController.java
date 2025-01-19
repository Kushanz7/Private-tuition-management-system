/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            e.printStackTrace(); // Consider logging for better error tracking
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
}
