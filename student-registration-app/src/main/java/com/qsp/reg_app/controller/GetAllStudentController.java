package com.qsp.reg_app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsp.reg_app.dao.StudentDao;
import com.qsp.reg_app.dto.Student;
@WebServlet(value = "/getAll")
public class GetAllStudentController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao dao=new StudentDao();
		List<Student> students =dao.getAllStudent();
		req.setAttribute("list", students);
		RequestDispatcher rd=req.getRequestDispatcher("getAll.jsp");
		rd.forward(req, resp);
	}
}
