/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
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
}
