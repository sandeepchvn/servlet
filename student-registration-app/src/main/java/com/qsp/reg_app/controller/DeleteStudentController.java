package com.qsp.reg_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsp.reg_app.dao.StudentDao;

@WebServlet(value = "/delete")
public class DeleteStudentController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao dao = new StudentDao();
		dao.deletByEmail(req.getParameter("email"));
		RequestDispatcher rd = req.getRequestDispatcher("getAll");
		rd.forward(req, resp);
	}
}
