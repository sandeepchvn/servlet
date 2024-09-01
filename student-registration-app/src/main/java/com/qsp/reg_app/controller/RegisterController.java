package com.qsp.reg_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsp.reg_app.dao.StudentDao;
import com.qsp.reg_app.dto.Student;

@WebServlet(value = "/register")
public class RegisterController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve form parameters
		String email = request.getParameter("email");
		long phone = Long.parseLong(request.getParameter("phone"));
		String name = request.getParameter("name");
		String degree = request.getParameter("degree");
		String stream = request.getParameter("stream");
		int yearOfPassOut = Integer.parseInt(request.getParameter("yearOfPassOut"));
		String course = request.getParameter("course");
		String gender = request.getParameter("gender");
		String feesPaid = request.getParameter("feesPaid");

		// Create a new Student object
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

		// Save the student using DAO
		StudentDao studentDAO = new StudentDao();
		studentDAO.addStudent(student);

		RequestDispatcher rd = request.getRequestDispatcher("getAll");
		rd.forward(request, response);
	}
}
