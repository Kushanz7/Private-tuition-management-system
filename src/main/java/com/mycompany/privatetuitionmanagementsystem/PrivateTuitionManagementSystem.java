/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.privatetuitionmanagementsystem;
import javax.swing.SwingUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.okapi.lib.reporting.ReportGenerator;
import view.LoginPage;
/**
 *
 * @author DELL
 */
public class PrivateTuitionManagementSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override            
            public void run(){
                new LoginPage().setVisible(true);
            }
    });
       
    
    }
}
