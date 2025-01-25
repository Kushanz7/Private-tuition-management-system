/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class student {
    private int student_id;
    private String name;
    private String phoneNumber;
    private String email;
    private String subject;
    private String grade;

    public student(int student_id,String name, String phoneNumber, String email, String subject, String grade) {
        this.student_id = student_id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.subject = subject;
        this.grade = grade;
    }

    public student() {
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    
    
    public boolean saveStudent() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String sql = "INSERT INTO students (name, phone, email, subject, grade) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phoneNumber);
            ps.setString(3, email);
            ps.setString(4, subject);
            ps.setString(5, grade);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean updateStudent() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            String sql = "UPDATE students SET name = ?, phone = ?, email = ?, subject = ?, grade = ? WHERE student_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phoneNumber);
            ps.setString(3, email);
            ps.setString(4, subject);
            ps.setString(5, grade);
            ps.setInt(6, student_id);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public boolean deleteStudent() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            String sql = "DELETE FROM students WHERE student_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, student_id);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public static ArrayList<student> getAllStudents() {
        ArrayList<student> students = new ArrayList<>();
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            String sql = "SELECT * FROM students";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                students.add(new student(
                    rs.getInt("student_id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("subject"),
                    rs.getString("grade")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
    
    public Map<String, String> getStudentDetails(int studentId) throws SQLException {
        Map<String, String> studentDetails = new HashMap<>();
    String query = "SELECT name, subject, grade FROM students WHERE student_id = ?";

    try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query)) {
        ps.setInt(1, studentId);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                studentDetails.put("name", rs.getString("name"));
                studentDetails.put("subject", rs.getString("subject"));
                studentDetails.put("grade", rs.getString("grade"));
            }
        }
    }
    return studentDetails;
    }
}
