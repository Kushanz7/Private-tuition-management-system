/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import model.DatabaseConnection;
import view.RegisterForm;
import model.tutor;
/**
 *
 * @author DELL
 */
public class TutorRegisController {
  
    public void saveTutorRegistration(String name, String email, String password) {
        try {
            DatabaseConnection.databaseConnect();
            tutor tutor = new tutor(name, email, password);
            tutor.saveTutor();
            JOptionPane.showMessageDialog(null, "Tutor Registered Successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }
}
