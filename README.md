# Private Tuition Management System

Welcome to the Private Tuition Management System! This project is designed to manage the operations of a private tuition center efficiently, including handling student details, managing payments, tracking marks for monthly tests, scheduling classes, and generating comprehensive reports.

## Table of Contents

- [About the Project](#about-the-project)
  - [Features](#features)
  - [Built With](#built-with)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
- [Usage](#usage)
  - [User Interface](#user-interface)
  - [Generating Reports](#generating-reports)
- [Acknowledgements](#acknowledgements)

## About the Project

The Private Tuition Management System is a comprehensive solution for managing the operations of a tuition center. The system simplifies student management, payment tracking, marks entry, and class scheduling while providing powerful reporting features to analyze the data.

### Features

- **Student Management:** Add, update, and delete student details, including their personal and academic information.
- **Payment Management:** Track and manage payments, including monthly tuition fees, and generate payment reports.
- **Marks Management:** Record and manage marks for students based on their monthly test results.
- **Class Scheduling:** Schedule and manage classes for students, ensuring efficient time management.
- **Reporting:** Generate detailed reports, including:
  - **Student Details Report**: Overview of all students and their details.
  - **Payment Report**: Insights into tuition fee payments.
  - **Marks Report**: Performance analysis of students based on monthly tests.

### Built With

- **Java**
- **Swing** (for GUI development)
- **MySQL** (for database management)
- **JasperReports** (for report generation)

## Getting Started

To get a local copy up and running, follow these steps:

### Prerequisites

- Java Development Kit (JDK) 8 or later.
- MySQL Database.
- JasperReports Library.
- IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans).

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Kushanz7/Private-tuition-management-system.git
   ```
2. Set up the database:
   - Import the provided SQL script to create the database schema.
   - Update the database connection settings in the project.
3. Install JasperReports Library in your project dependencies.

## Usage

### User Interface

#### Login
Login and Registration for tutors.

<p align="center">
  <img src="https://github.com/Kushanz7/Private-tuition-management-system/blob/main/img/Login.png" alt="">
</p>

<p align="center">
  <img src="https://github.com/Kushanz7/Private-tuition-management-system/blob/main/img/Regis.png" alt="">
</p>

#### Dashboard
The main hub for navigating the system's features.

<p align="center">
  <img src="https://github.com/Kushanz7/Private-tuition-management-system/blob/main/img/Dash.png" alt="">
</p>

#### Student Management
Add, update, or delete student details.

<p align="center">
  <img src="https://github.com/Kushanz7/Private-tuition-management-system/blob/main/img/Students.png" alt="">
</p>


#### Payment Management
Manage tuition fee payments and view the payment history.

<p align="center">
  <img src="https://github.com/Kushanz7/Private-tuition-management-system/blob/main/img/Payment.png" alt="">
</p>


#### Marks Management
Record and manage student marks for monthly tests.

<p align="center">
  <img src="https://github.com/Kushanz7/Private-tuition-management-system/blob/main/img/MarksAdd.png" alt="">
</p>
<p align="center">
  <img src="https://github.com/Kushanz7/Private-tuition-management-system/blob/main/img/CheckResults.png" alt="">
</p>


#### Class Scheduling
Easily schedule and manage classes for students, ensuring no conflicts and smooth operations.

<p align="center">
  <img src="https://github.com/Kushanz7/Private-tuition-management-system/blob/main/img/Schedule.png" alt="">
</p>


#### Report Generation
Generate detailed reports:

<p align="center">
  <img src="https://github.com/Kushanz7/Private-tuition-management-system/blob/main/img/Reports.png" alt="">
</p>

- **Student Details Report**: Provides information on all registered students.

<p align="center">
  <img src="https://github.com/Kushanz7/Private-tuition-management-system/blob/main/img/StudentDetailsReport.png" alt="">
</p>

- **Payment Report**: Shows payment history and summaries.

<p align="center">
  <img src="https://github.com/Kushanz7/Private-tuition-management-system/blob/main/img/PaymentReport.png" alt="">
</p>

- **Marks Report**: Displays student performance data based on monthly test results.

<p align="center">
  <img src="https://github.com/Kushanz7/Private-tuition-management-system/blob/main/img/MarksReport.png" alt="">
</p>

### Generating Reports
The system uses JasperReports to generate professional and customizable PDF reports. Users can generate reports directly from the interface with just a few clicks.


## Acknowledgements

- JasperReports for providing robust reporting capabilities.
- MySQL for database management.
