/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.FeeSummary;
import model.marks;
import model.student;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author DELL
 */
public class PdfGenerator {
    public static void generateStudentDetailsReport(ArrayList<student> students, String filePath) {
    try {
        // Initialize PDF document
        PDDocument document = new PDDocument();

        // Add a page to the document
        PDPage page = new PDPage();
        document.addPage(page);

        // Set up the content stream
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Set up the font and size
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

        // Add title
        contentStream.beginText();
        contentStream.newLineAtOffset(200, 750);
        contentStream.showText("Student Details Report");
        contentStream.endText();

        // Set up table column headers
        float margin = 50;
        float yStart = 700;
        float tableWidth = 500;
        float yPosition = yStart;
        float rowHeight = 20;
        float cellMargin = 5f;
        float[] columnWidths = {1, 2, 2, 1, 2, 2};

        // Draw table headers
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
        float[] positions = {margin, margin + columnWidths[0] * 70, margin + (columnWidths[0] + columnWidths[1]) * 70,
                margin + (columnWidths[0] + columnWidths[1] + columnWidths[2]) * 70, margin + (columnWidths[0] + columnWidths[1] + columnWidths[2] + columnWidths[3]) * 70,
                margin + (columnWidths[0] + columnWidths[1] + columnWidths[2] + columnWidths[3] + columnWidths[4]) * 70};

        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition);
        contentStream.showText("ID");
        contentStream.endText();
        contentStream.beginText();
        contentStream.newLineAtOffset(positions[1], yPosition);
        contentStream.showText("Name");
        contentStream.endText();
        contentStream.beginText();
        contentStream.newLineAtOffset(positions[2], yPosition);
        contentStream.showText("Subject");
        contentStream.endText();
        contentStream.beginText();
        contentStream.newLineAtOffset(positions[3], yPosition);
        contentStream.showText("Grade");
        contentStream.endText();
        contentStream.beginText();
        contentStream.newLineAtOffset(positions[4], yPosition);
        contentStream.showText("Contact");
        contentStream.endText();
       
        yPosition -= rowHeight;

        // Add student data to the table
        contentStream.setFont(PDType1Font.HELVETICA, 10);
        for (student student : students) {
            contentStream.beginText();
            contentStream.newLineAtOffset(margin, yPosition);
            contentStream.showText(String.valueOf(student.getStudent_id()));
            contentStream.endText();
            contentStream.beginText();
            contentStream.newLineAtOffset(positions[1], yPosition);
            contentStream.showText(student.getName());
            contentStream.endText();
            contentStream.beginText();
            contentStream.newLineAtOffset(positions[2], yPosition);
            contentStream.showText(student.getSubject());
            contentStream.endText();
            contentStream.beginText();
            contentStream.newLineAtOffset(positions[3], yPosition);
            contentStream.showText(student.getGrade());
            contentStream.endText();
            contentStream.beginText();
            contentStream.newLineAtOffset(positions[4], yPosition);
            contentStream.showText(student.getPhoneNumber());
            contentStream.endText();
            yPosition -= rowHeight;
        }

        // Close content stream
        contentStream.close();

        // Save the document
        document.save(filePath);
        document.close();

        System.out.println("Student Details Report generated successfully: " + filePath);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public static void generateMarksReport(ArrayList<marks> marksList, String filePath) {
        try {
            // Initialize PDF document
            PDDocument document = new PDDocument();

            // Add a page to the document
            PDPage page = new PDPage();
            document.addPage(page);

            // Set up the content stream
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Set up the font and size
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

            // Add title
            contentStream.beginText();
            contentStream.newLineAtOffset(200, 750);
            contentStream.showText("Student Marks Report");
            contentStream.endText();

            // Set up table column headers
            float margin = 50;
            float yStart = 700;
            float tableWidth = 500;
            float yPosition = yStart;
            float rowHeight = 20;
            float cellMargin = 5f;
            float[] columnWidths = {1, 2, 2, 1};

            // Draw table headers
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
            float[] positions = {margin, margin + columnWidths[0] * 70, margin + (columnWidths[0] + columnWidths[1]) * 70,
                    margin + (columnWidths[0] + columnWidths[1] + columnWidths[2]) * 70, margin + (columnWidths[0] + columnWidths[1] + columnWidths[2] + columnWidths[3]) * 70};

            contentStream.beginText();
            contentStream.newLineAtOffset(margin, yPosition);
            contentStream.showText("Name");
            contentStream.endText();
            contentStream.beginText();
            contentStream.newLineAtOffset(positions[1], yPosition);
            contentStream.showText("Month");
            contentStream.endText();
            contentStream.beginText();
            contentStream.newLineAtOffset(positions[2], yPosition);
            contentStream.showText("Subject");
            contentStream.endText();
            contentStream.beginText();
            contentStream.newLineAtOffset(positions[3], yPosition);
            contentStream.showText("Marks");
            contentStream.endText();

            yPosition -= rowHeight;

            // Add marks data to the table
            contentStream.setFont(PDType1Font.HELVETICA, 10);
            for (marks mark : marksList) {
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText(mark.getNamme());
                contentStream.endText();
                contentStream.beginText();
                contentStream.newLineAtOffset(positions[1], yPosition);
                contentStream.showText(mark.getMonth());
                contentStream.endText();
                contentStream.beginText();
                contentStream.newLineAtOffset(positions[2], yPosition);
                contentStream.showText(mark.getSubject());
                contentStream.endText();
                contentStream.beginText();
                contentStream.newLineAtOffset(positions[3], yPosition);
                contentStream.showText(String.valueOf(mark.getMarks()));
                contentStream.endText();

                yPosition -= rowHeight;
            }

            // Close content stream
            contentStream.close();

            // Save the document
            document.save(filePath);
            document.close();

            System.out.println("Student Marks Report generated successfully: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateFeeSummaryReport(ArrayList<FeeSummary> feeSummaryList, String filePath) {
    try {
        // Initialize PDF document
        PDDocument document = new PDDocument();

        // Add a page to the document
        PDPage page = new PDPage();
        document.addPage(page);

        // Set up the content stream
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Set up the font and size
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

        // Add title
        contentStream.beginText();
        contentStream.newLineAtOffset(200, 750);
        contentStream.showText("Fee Summary Report");
        contentStream.endText();

        // Set up table column headers
        float margin = 50;
        float yStart = 700;
        float tableWidth = 500;
        float yPosition = yStart;
        float rowHeight = 20;
        float cellMargin = 5f;
        float[] columnWidths = {2, 2, 2, 1};

        // Draw table headers
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
        float[] positions = {margin, margin + columnWidths[0] * 70, margin + (columnWidths[0] + columnWidths[1]) * 70,
                margin + (columnWidths[0] + columnWidths[1] + columnWidths[2]) * 70};

        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition);
        contentStream.showText("Student Name");
        contentStream.endText();
        contentStream.beginText();
        contentStream.newLineAtOffset(positions[1], yPosition);
        contentStream.showText("Amount Paid");
        contentStream.endText();
        contentStream.beginText();
        contentStream.newLineAtOffset(positions[2], yPosition);
        contentStream.showText("Payment Date");
        contentStream.endText();
        contentStream.beginText();
        contentStream.newLineAtOffset(positions[3], yPosition);
        contentStream.showText("Month");
        contentStream.endText();

        yPosition -= rowHeight;

        // Add fee summary data to the table
        contentStream.setFont(PDType1Font.HELVETICA, 10);
        for (FeeSummary fee : feeSummaryList) {
            contentStream.beginText();
            contentStream.newLineAtOffset(margin, yPosition);
            contentStream.showText(fee.getStudentName());
            contentStream.endText();
            contentStream.beginText();
            contentStream.newLineAtOffset(positions[1], yPosition);
            contentStream.showText(String.valueOf(fee.getAmountPaid()));
            contentStream.endText();
            contentStream.beginText();
            contentStream.newLineAtOffset(positions[2], yPosition);
            contentStream.showText(fee.getPaymentDate().toString());
            contentStream.endText();
            contentStream.beginText();
            contentStream.newLineAtOffset(positions[3], yPosition);
            contentStream.showText(fee.getMonth());
            contentStream.endText();

            yPosition -= rowHeight;
        }

        // Calculate total amount paid per month
        Map<String, Double> monthlyTotalMap = new HashMap<>();
        for (FeeSummary fee : feeSummaryList) {
            monthlyTotalMap.put(fee.getMonth(),
                monthlyTotalMap.getOrDefault(fee.getMonth(), 0.0) + fee.getAmountPaid());
        }


        // Print total amount paid per month at the end of the table
        yPosition -= rowHeight;
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition);
        contentStream.showText("Total Amount Per Month:");
        contentStream.endText();

        yPosition -= rowHeight;
        for (Map.Entry<String, Double> entry : monthlyTotalMap.entrySet()) {
            contentStream.beginText();
            contentStream.newLineAtOffset(margin, yPosition);
            contentStream.showText("Month: " + entry.getKey() + " Total: " + entry.getValue());
            contentStream.endText();
            yPosition -= rowHeight;
        }

        // Close content stream
        contentStream.close();

        // Save the document
        document.save(filePath);
        document.close();

        System.out.println("Fee Summary Report generated successfully: " + filePath);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
