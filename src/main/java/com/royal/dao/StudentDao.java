package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import com.royal.bean.StudentBean;
import com.royal.util.DBConnection;

public class StudentDao {
    public int insertStudent(StudentBean sbean) {
        String insertQuery = "INSERT INTO student(name,std,marks,hobbies) VALUES(?,?,?,?)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        int rowsAffected = 0;
        if (conn != null) {
            try {
                pstmt = conn.prepareStatement(insertQuery);
                pstmt.setString(1, sbean.getName());
                pstmt.setString(2, sbean.getStd());
                pstmt.setString(3, sbean.getMarks());
                String hobbies = String.join(",", sbean.getHobbies());
                pstmt.setString(4, hobbies);
                rowsAffected = pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("StudentDao: Db not connected: " + conn);
        }
        return rowsAffected;
    }

    public StudentBean getStudentByRno(int rno) {
        String selectQuery = "SELECT * FROM student WHERE rno = ?";
        Connection conn = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        StudentBean s = null;
        if (conn != null) {
            try {
                pstmt = conn.prepareStatement(selectQuery);
                pstmt.setInt(1, rno);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    String std = rs.getString("std");
                    String marks = rs.getString("marks");
                    String hobbiesString = rs.getString("hobbies");
                    ArrayList<String> hobbies = new ArrayList<>();
                    if (hobbiesString != null) {
                        String[] hobbiesArray = hobbiesString.split(",");
                        hobbies = new ArrayList<>(Arrays.asList(hobbiesArray));
                    }
                    s = new StudentBean(rno, name, std, marks, hobbies);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (pstmt != null) {
                        pstmt.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("StudentDao: Db not connected: " + conn);
        }
        return s;
    }

    public int updateStudent(int rno, StudentBean sbean) {
	    String updateQuery = "UPDATE student SET name=?, std=?, marks=?, hobbies=? WHERE rno=?";
	    Connection conn = DBConnection.getConnection();
	    PreparedStatement pstmt = null;
	    int rowsAffected = 0;
	    if (conn != null) {
	        try {
	            pstmt = conn.prepareStatement(updateQuery);
	            pstmt.setString(1, sbean.getName());
	            pstmt.setString(2, sbean.getStd());
	            pstmt.setString(3, sbean.getMarks());
	            String hobbies = String.join(",", sbean.getHobbies());
	            pstmt.setString(4, hobbies);
	            pstmt.setInt(5, rno);
	            rowsAffected = pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (pstmt != null) {
	                    pstmt.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    } else {
	        System.out.println("StudentDao: Db not connected: " + conn);
	    }
	    return rowsAffected;
	}

    public int deletStudent(int rno) {
    	String deleteQuery="DELETE FROM student WHERE rno = ?"; 
    	Connection conn = DBConnection.getConnection();

    	PreparedStatement pstmt=null;

    	int rowsAffected = 0;

    	if (conn!=null){

    	try

    	{

    	pstmt = conn.prepareStatement(deleteQuery);

    	pstmt.setInt(1, rno);

    	rowsAffected =pstmt.executeUpdate();

    	} catch (SQLException e)

    	{
    		e.printStackTrace();
    	}
    	}else

    	{ System.out.println("StudenDao: Db not connected: " + conn);

    	} 
    	return rowsAffected;
    	  
    }

    public ArrayList<StudentBean> getAllRecords() {
        String selectQuery = "SELECT * FROM student";
        Connection conn = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        StudentBean s = null;
        ArrayList<StudentBean> list = new ArrayList<StudentBean>();
        if (conn != null) {
            try {
                pstmt = conn.prepareStatement(selectQuery);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    int rno = rs.getInt(1);
                    String name = rs.getString(2);
                    String std = rs.getString(3);
                    String marks = rs.getString(4);
                    String hobbiesString = rs.getString("hobbies");
                    ArrayList<String> hobbies = new ArrayList<>();
                    if (hobbiesString != null) {
                        String[] hobbiesArray = hobbiesString.split(",");
                        hobbies = new ArrayList<>(Arrays.asList(hobbiesArray));
                    }
                    s = new StudentBean(rno, name, std, marks, hobbies);
                    list.add(s);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (pstmt != null) {
                        pstmt.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("StudentDao: Db not connected: " + conn);
        }
        return list;
    }

    public static void main(String[] args) {
        // Main method code
    }
}
