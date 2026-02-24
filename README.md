# Student Management System (Java + MySQL + JDBC)

A console-based Student Management System built using Java and MySQL with JDBC connectivity.  
This project demonstrates CRUD operations, database integration, and Object-Oriented Programming concepts.

---

##  Features

-  Add Student
-  View Students
-  Delete Student
-  MySQL Database Integration
-  PreparedStatement to prevent SQL Injection
-  Modular architecture using OOP principles

---

##  Tech Stack

- Java
- MySQL
- JDBC (MySQL Connector/J)
- Object-Oriented Programming (OOP)
- Git & GitHub

---

##  Project Structure


Student-Management-System-Java
│
├── src
│ ├── Main.java
│ ├── DBConnection.java
│ ├── Student.java
│ └── StudentDAO.java
│
├── lib
│ └── mysql-connector-j-9.6.0.jar
│
├── .gitignore
└── README.md


---

##  Database Setup

Run the following SQL commands in MySQL:

```sql
CREATE DATABASE student_db;

USE student_db;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    course VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```sql

---

## Configuration

Update your MySQL password inside:

DBConnection.java
private static final String PASSWORD = "your_password";

How to Compile & Run
Compile:
javac -cp ".;lib/mysql-connector-j-9.6.0.jar" src/*.java     */
Run:
java -cp ".;lib/mysql-connector-j-9.6.0.jar" src.Main


Sample Output:

===== Student Management System =====
1. Add Student
2. View Students
3. Delete Student
4. Exit