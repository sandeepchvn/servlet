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

@WebServlet(value = "/findByMail")
public class FInByMail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao dao = new StudentDao();
		Student student = dao.findByEmail(req.getParameter("email"));
		req.setAttribute("student", student);
		RequestDispatcher rd = req.getRequestDispatcher("update.jsp");
		rd.forward(req, resp);
	}
}
