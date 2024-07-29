<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.royal.bean.StudentBean"%>
<%
    StudentBean s = (StudentBean) request.getAttribute("sbean");
%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
    <style>
        <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        h2 {
            text-align: center;
            margin-top: 20px;
            margin-bottom: 20px;
            color: #333;
        }
        form {
            width: 80%;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        table {
            width: 100%;
        }
        table tr td {
            padding: 10px;
        }
        input[type="text"], input[type="submit"] {
            padding: 5px 10px;
            margin-bottom: 10px;
            width: 100%;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #333;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
    <h2>Edit Student Information</h2>
    <p>Use the form below to update the student's information:</p>
    <form action="UpdateStudentServlete" method="post">
        <table>
            <tr>
                <td>Roll Number</td>
                <td><input type="text" name="rno" value="<%=s.getRno()%>" readonly></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="<%=s.getName()%>" /></td>
            </tr>
            <tr>
                <td>Std</td>
                <td><input type="text" name="std" value="<%=s.getStd()%>" /></td>
            </tr>
            <tr>
                <td>Marks</td>
                <td><input type="text" name="marks" value="<%=s.getMarks() %>" /></td>
            </tr>
          <tr>
    <td>Hobbies:</td>
    <td>
        <input type="checkbox" name="hobbies" value="Cricket" <%= s.getHobbies().contains("Cricket") ? "checked" : "" %>/>Cricket
        <input type="checkbox" name="hobbies" value="Carem" <%= s.getHobbies().contains("Carem") ? "checked" : "" %>/>Carem
        <input type="checkbox" name="hobbies" value="Reading" <%= s.getHobbies().contains("Reading") ? "checked" : "" %>/>Reading
        <input type="checkbox" name="hobbies" value="Painting" <%= s.getHobbies().contains("Painting") ? "checked" : "" %>/>Painting
    </td>
</tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update"></td>
            </tr>
        </table>
    </form>
    <form action="LogoutServlet" method="post">
    <button type="submit">Logout</button>
</form>
</body>
</html>