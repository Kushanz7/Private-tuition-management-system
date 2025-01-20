/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Billing;

/**
 *
 * @author DELL
 */
public class BillingController {
    public void addBilling(int studentId, String month, double amountPaid) {
        try {
            Billing billing = new Billing(studentId, month, amountPaid);
            billing.saveBilling();
            JOptionPane.showMessageDialog(null, "Payment recorded successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error recording payment: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Billing> getBillingDetails(int studentId) {
        try {
            return Billing.getBillingByStudentId(studentId);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving billing details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }
}
