package com.royal.controller;

import java.io.IOException;
import java.sql.Array;
import java.util.Arrays;

import java.util.ArrayList;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class InsertStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String name = request.getParameter("name");
	    String std = request.getParameter("std");
	    String marks = request.getParameter("marks");
	    String[] hobbiesArray = request.getParameterValues("hobbies");
	    ArrayList<String> hobbies = new ArrayList<>();
	    if (hobbiesArray != null) {
	        hobbies.addAll(Arrays.asList(hobbiesArray));
	    }

	    boolean flag = false;
	    boolean hobbiesFlag = false;
	    StudentBean sbean = new StudentBean(0, name, std, marks, hobbies);

	    if ((name != null) && (name.trim().length() > 0)) {
	        request.setAttribute("name", name);
	        sbean.setName(name);
	    } else {
	        flag = true;
	        request.setAttribute("errName", "<font color='red'>Please enter valid Name</font>");
	    }
	    if ((std != null) && (std.trim().length() > 0)) {
	        request.setAttribute("std", std);
	        sbean.setStd(std);
	    } else {
	        flag = true;
	        request.setAttribute("errStd", "<font color='red'>Please enter valid Std</font>");
	    }
	    if ((marks != null) && (marks.trim().length() > 0)) {
	        request.setAttribute("marks", marks);
	        sbean.setMarks(marks);
	    } else {
	        flag = true;
	        request.setAttribute("errMarks", "<font color='red'>Please enter valid Marks</font>");
	    }
	    if (hobbies.isEmpty()) {
            flag = true;
            hobbiesFlag = true;
            request.setAttribute("errHobbies", "<font color='red'>Please select at least one hobby</font>");
        }

	    RequestDispatcher rd = null;
	    if (flag) {
	        System.out.println("if flag :" + flag);
	        rd = request.getRequestDispatcher("insertstudent.jsp");
	        rd.forward(request, response);
	    } else {
	        StudentDao dao = new StudentDao();
	        int rowsAffected = dao.insertStudent(sbean);
	        if (rowsAffected > 0) {
	        	HttpSession session = request.getSession();
	            session.setAttribute("adminLoggedIn", true);
	            response.sendRedirect("ListStudentServlet");
	        } else {
	            rd = request.getRequestDispatcher("insertstudent.jsp");
	            rd.forward(request, response);
	        }
	    }
	}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
