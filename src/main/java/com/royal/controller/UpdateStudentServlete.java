package com.royal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateStudentServlete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rno = Integer.parseInt(request.getParameter("rno"));
        String name = request.getParameter("name");
        String std = request.getParameter("std");
        String marks = request.getParameter("marks");
        String[] hobbies = request.getParameterValues("hobbies");

        ArrayList<String> hobbiesList = hobbies != null ? new ArrayList<>(Arrays.asList(hobbies)) : new ArrayList<>();

        StudentBean sbean = new StudentBean(rno, name, std, marks, hobbiesList);

        StudentDao dao = new StudentDao();

        int rowsAffected = dao.updateStudent(rno, sbean);

        RequestDispatcher rd = null;

        if (rowsAffected > 0) {
            rd = request.getRequestDispatcher("ListStudentServlet");
        } else {
            rd = request.getRequestDispatcher("EditStudentServlet?rno=" + rno);
        }

        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
