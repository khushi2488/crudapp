package com.royal.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(false);
	    if (session != null && session.getAttribute("adminLoggedIn") != null && (boolean) session.getAttribute("adminLoggedIn")) {
	        StudentDao dao = new StudentDao();
	        ArrayList<StudentBean> list = dao.getAllRecords();
	        request.setAttribute("list", list);
	        request.getRequestDispatcher("liststudents.jsp").forward(request, response);
	    } else {
	        response.sendRedirect("login.html"); 
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
