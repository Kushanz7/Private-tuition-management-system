/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class schedule {
    private String subject;
    private String day;
    private String startingTime;
    private String endingTime;
    private String grade;

    public schedule(String subject, String day, String startingTime, String endingTime, String grade) {
        this.subject = subject;
        this.day = day;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.grade = grade;
    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDay() {
        return day;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }

    public void saveSchedule() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO schedules (subject, day, startingtime, endingtime,grade) VALUES (?, ?, ?, ?,?)");
            ps.setString(1, subject);
            ps.setString(2, day);
            ps.setString(3, startingTime);
            ps.setString(4, endingTime);
            ps.setString(5, grade);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }
    
    public boolean deleteSchedule() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            String sql = "DELETE FROM schedules WHERE subject = ? AND day = ? AND grade = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, subject);
            ps.setString(2, day);
            ps.setString(3, grade);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
