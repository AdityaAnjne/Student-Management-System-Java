package src;

import java.sql.*;
import java.util.logging.Logger;

public class StudentDAO {

    private static final Logger logger = Logger.getLogger(StudentDAO.class.getName());

    // Email Validation Method
    private void validateEmail(String email) throws InvalidEmailException {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (email == null || !email.matches(emailRegex)) {
            throw new InvalidEmailException("Invalid Email Format!");
        }
    }

    public void addStudent(Student student) {

        String query = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection()) {

            // Validate Email before inserting
            validateEmail(student.getEmail());

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());

            ps.executeUpdate();

            logger.info("Student added successfully: " + student.getEmail());
            System.out.println("Student Added Successfully!");

        } catch (InvalidEmailException e) {
            logger.warning("Invalid email attempt: " + student.getEmail());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            logger.severe("Error adding student: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void viewStudents() {

        String query = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            logger.info("Fetching student records...");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email") + " | " +
                        rs.getString("course")
                );
            }

        } catch (Exception e) {
            logger.severe("Error fetching students: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {

        String query = "DELETE FROM students WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            logger.info("Student deleted with ID: " + id);
            System.out.println("Student Deleted Successfully!");

        } catch (Exception e) {
            logger.severe("Error deleting student: " + e.getMessage());
            e.printStackTrace();
        }
    }
}