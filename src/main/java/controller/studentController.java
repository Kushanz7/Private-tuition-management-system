/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.student;

/**
 *
 * @author DELL
 */
public class studentController {
    public void addStudent(int id,String name, String phoneNumber, String email, String subject, String grade) {
        try {
            student student = new student(id,name, phoneNumber, email, subject, grade);
            boolean isSaved = student.saveStudent();

            if (isSaved) {
                JOptionPane.showMessageDialog(null, "Student added successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add student. Please try again.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public boolean updateStudent(int studentId, String name, String phone, String email, String subject, String grade) {
        try {
            student student = new student(studentId, name, phone, email, subject, grade);
            return student.updateStudent();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteStudent(int studentId) {
        try {
            student student = new student(studentId, null, null, null, null, null);
            return student.deleteStudent();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }

    public void loadAllStudents(javax.swing.JTable table) {
        try {
            ArrayList<student> students = student.getAllStudents();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (student student : students) {
                model.addRow(new Object[]{
                    student.getStudent_id(),
                    student.getName(),
                    student.getPhoneNumber(),
                    student.getEmail(),
                    student.getSubject(),
                    student.getGrade()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public Map<String, String> getStudentDetails(int studentId) {
        try {
            student studentModel = new student();
            return studentModel.getStudentDetails(studentId);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving student details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    
    public ArrayList<student> getAllStudents() throws SQLException {
        return student.getAllStudents();
    }
    
    public void generateStudentDetailsReport(String filePath) {
        ArrayList<student> students = student.getAllStudents();
        
        
    }

}
