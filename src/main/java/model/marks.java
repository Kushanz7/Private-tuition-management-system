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
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class marks {
    private int studentId;
    private String month;
    private String subject;
    private int marks;
    private  String namme;

    public marks( String namme,String month, String subject, int marks) {
        this.month = month;
        this.subject = subject;
        this.marks = marks;
        this.namme = namme;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getNamme() {
        return namme;
    }

    public void setNamme(String namme) {
        this.namme = namme;
    }

    public marks(int studentId, String month, String subject, int marks) {
        this.studentId = studentId;
        this.month = month;
        this.subject = subject;
        this.marks = marks;
    }

    public marks() {
    }
    
    
    
    public void saveMarks() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        String query = "INSERT INTO marks (student_id, month, subject, marks) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, studentId);
        ps.setString(2, month);
        ps.setString(3, subject);
        ps.setInt(4, marks);

        ps.executeUpdate();
    }
    
    public boolean updateMarks() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        String query = "UPDATE marks SET marks = ? WHERE student_id = ? AND month = ? AND subject = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, this.marks);
        ps.setInt(2, this.studentId);
        ps.setString(3, this.month);
        ps.setString(4, this.subject);

        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;
    }


    public Vector<Vector<Object>> getAllMarks() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        String query = "SELECT student_id, month, subject, marks FROM marks";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        Vector<Vector<Object>> data = new Vector<>();

        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            row.add(rs.getInt("student_id"));
            row.add(rs.getString("month"));
            row.add(rs.getString("subject"));
            row.add(rs.getInt("marks"));
            data.add(row);
        }

        return data;
    }
    
     
    public static ArrayList<marks> getMarksByStudentId(int studentId) {
        ArrayList<marks> marksList = new ArrayList<>();
        String query = """
        SELECT s.name AS student_name, m.month, m.subject, m.marks
        FROM marks m
        JOIN students s ON m.student_id = s.student_id
        WHERE m.student_id = ?
        """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, studentId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    marks mark = new marks(
                        rs.getString("student_name"),
                        rs.getString("month"),
                        rs.getString("subject"),
                        rs.getInt("marks")
                    );
                    marksList.add(mark);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return marksList;
    }
    
}
