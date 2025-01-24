/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.mysql.cj.protocol.Message;
import com.mysql.cj.xdevapi.Session;
import com.sun.jdi.connect.Transport;
import java.awt.List;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author DELL
 */
public class Billing {
    private int studentId;
    private String month;
    private double amountPaid;
    private Date paymentDate;

    public Billing(int studentId, String month, double amountPaid) {
        this.studentId = studentId;
        this.month = month;
        this.amountPaid = amountPaid;
        
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

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    
    // Save payment details to the database
    public void saveBilling() throws SQLException {
        String query = "INSERT INTO billing (student_id, month, amount_paid) VALUES (?, ?,?)";
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query)) {
            ps.setInt(1, studentId);
            ps.setString(2, month);
            ps.setDouble(3, amountPaid);
            
            ps.executeUpdate();
        }
    }
    
    // Retrieve payment details for a student
    public static ArrayList<Billing> getBillingByStudentId(int studentId) throws SQLException {
        ArrayList<Billing> billingList = new ArrayList<>();
        String query = "SELECT * FROM billing WHERE student_id = ?";
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query)) {
            ps.setInt(1, studentId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Billing billing = new Billing(
                        rs.getInt("student_id"),
                        rs.getString("month"),
                        rs.getDouble("amount_paid"));
                    billing.paymentDate = rs.getDate("payment_date");
                    billingList.add(billing);
                }
            }
        }
        return billingList;
    }
    
    public static ArrayList<FeeSummary> getFeeSummaryData() {
    ArrayList<FeeSummary> feeSummaryList = new ArrayList<>();
    String query = """
    SELECT s.name AS student_name, b.amount_paid, b.payment_date, b.month
    FROM billing b
    JOIN students s ON b.student_id = s.student_id
    ORDER BY b.payment_date DESC
    """;

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement ps = connection.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            FeeSummary feeSummary = new FeeSummary(
                rs.getString("student_name"),
                rs.getDouble("amount_paid"),
                rs.getDate("payment_date"),
                rs.getString("month")
            );
            feeSummaryList.add(feeSummary);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return feeSummaryList;
}

    // Retrieve student email by student ID
private String getStudentEmail(int studentId) throws SQLException {
    String email = null;
    String query = "SELECT email FROM students WHERE student_id = ?";
    try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query)) {
        ps.setInt(1, studentId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            email = rs.getString("email");
        }
    }
    return email;
}

}
