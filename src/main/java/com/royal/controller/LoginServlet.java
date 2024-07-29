package com.royal.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        
        if (isValidUser(username, password)) {
        	
        	 HttpSession session = request.getSession();
        	    session.setAttribute("adminLoggedIn", true);
            
        	
            response.sendRedirect("insertstudent.jsp");
        } else {
            
            response.sendRedirect("login.html");
        }
    }

    private boolean isValidUser(String username, String password) {
       
        return "admin".equals(username) && "admin@123".equals(password);
    }

}

