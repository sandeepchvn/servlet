package com.qsp.reg_app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qsp.reg_app.dto.Student;

public class StudentDao {
	private static final String URL = "jdbc:postgresql://localhost:5432/project";
	private static final String USER = "postgres";
	private static final String PASSWORD = "root";
	static Connection con;
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void addStudent(Student student) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, student.getEmail());
			ps.setLong(2, student.getPhone());
			ps.setString(3, student.getName());
			ps.setString(4, student.getDegree());
			ps.setString(5, student.getStream());
			ps.setInt(6, student.getYearOfPassOut());
			ps.setString(7, student.getCourse());
			ps.setString(8, student.getGender());
			ps.setString(9, student.getFeesPaid());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean deletByEmail(String email) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from student where email=? ");
			ps.setString(1, email);
			if (1 == ps.executeUpdate()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Student> getAllStudent() {
		List<Student> list = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Student student = new Student();

				student.setCourse(rs.getString("course"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				student.setPhone((rs.getLong("phone")));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean updateStudent(Student student) {
		boolean isUpdated = false;
		PreparedStatement pstmt=null;
		try {

			// SQL query to update student details
			String sql = "UPDATE student SET phone = ?, name = ?, degree = ?, stream = ?, year_of_pass_out = ?, course = ?, gender = ?, fees_paid = ? WHERE email = ?";

			// Prepare the statement
			 pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, student.getPhone());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getDegree());
			pstmt.setString(4, student.getStream());
			pstmt.setInt(5, student.getYearOfPassOut());
			pstmt.setString(6, student.getCourse());
			pstmt.setString(7, student.getGender());
			pstmt.setString(8, student.getFeesPaid());
			pstmt.setString(9, student.getEmail());

			// Execute the update
			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				isUpdated = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isUpdated;
	}
	// Method to find a student by email
    public Student findByEmail(String email) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Student student = null;

        try {

            // SQL query to retrieve student details by email
            String sql = "SELECT * FROM student WHERE email = ?";

            // Prepare the statement
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, email);

            // Execute the query
            rs = pstmt.executeQuery();

            // If a result is returned, create a Student object and populate it
            if (rs.next()) {
                student = new Student();
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getLong("phone"));
                student.setName(rs.getString("name"));
                student.setDegree(rs.getString("degree"));
                student.setStream(rs.getString("stream"));
                student.setYearOfPassOut(rs.getInt("year_of_pass_out"));
                student.setCourse(rs.getString("course"));
                student.setGender(rs.getString("gender"));
                student.setFeesPaid(rs.getString("fees_paid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return student; // Returns the student object, or null if not found
    }
}
