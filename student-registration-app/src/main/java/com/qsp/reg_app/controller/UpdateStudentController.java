package com.qsp.reg_app.controller;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsp.reg_app.dao.StudentDao;
import com.qsp.reg_app.dto.Student;

@WebServlet(value = "/update")
public class UpdateStudentController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String email = request.getParameter("email");
		long phone = Long.parseLong(request.getParameter("phone"));
		String name = request.getParameter("name");
		String degree = request.getParameter("degree");
		String stream = request.getParameter("stream");
		int yearOfPassOut = Integer.parseInt(request.getParameter("yearOfPassOut"));
		String course = request.getParameter("course");
		String gender = request.getParameter("gender");
		String feesPaid = request.getParameter("feesPaid");

		// Create Student object with updated details
		Student student = new Student();
		student.setEmail(email);
		student.setPhone(phone);
		student.setName(name);
		student.setDegree(degree);
		student.setStream(stream);
		student.setYearOfPassOut(yearOfPassOut);
		student.setCourse(course);
		student.setGender(gender);
		student.setFeesPaid(feesPaid);

		// Update student details in the database
		StudentDao studentDAO = new StudentDao();
		boolean isUpdated = studentDAO.updateStudent(student);
		RequestDispatcher rd = request.getRequestDispatcher("getAll");
		rd.forward(request, resp);

	}
}
