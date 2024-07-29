<%@page import="java.util.ArrayList"%>
<%@page import="com.royal.bean.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }

    h2,p {
        text-align: center;
        margin-top: 20px;
        margin-bottom: 20px;
        color: #333;
    }

    table {
        width: 80%;
        margin: 0 auto;
        border-collapse: collapse;
        border: 1px solid #ddd;
        background-color: #fff;
    }

    th, td {
        padding: 10px;
        border: 1px solid #ddd;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    tr:hover {
        background-color: #f1f1f1;
    }

    td.actions {
        text-align: center;
    }

    a {
        text-decoration: none;
        color: #333;
    }

    a:hover {
        color: #f00;
    }
     button {
        display: block;
        margin: 20px auto;
        padding: 10px 20px;
        background-color: #333;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    button:hover {
        background-color: #555;
    }
</style>
<body>
<h2>Here is the list of students:</h2>
<p>This table displays the details of all registered students. You can edit or delete a student's information using the actions provided.</p>
<button onclick="window.location.href='insertstudent.jsp'">Register Another Student</button>
<button onclick="window.location.href='logout.jsp'">Logout</button>



 <table border="1">

<tr>

      <td>Rno</td>
      <td>Name</td>
      <td>Std</td>
      <td>Marks</td>
      <td>Hobbies</td>
      

       <td>Actions</td>

</tr>

<%

ArrayList<StudentBean> list =(ArrayList<StudentBean>)request.getAttribute("list");

for(int i=0; i<list.size(); i++)

{

StudentBean s = list.get(i);
%>
<tr>

<td><%=s.getRno() %></td>

<td><%=s.getName() %></td>

<td><%=s.getStd() %></td>
<td><%=s.getMarks() %></td>
<td>
    <% 
        ArrayList<String> hobbies = s.getHobbies();
        if (hobbies != null && hobbies.size() > 0) {
            out.print(hobbies.get(0));
            for (int j = 1; j < hobbies.size(); j++) {
                out.print(", " + hobbies.get(j));
            }
        }
    %>
</td>

<td><a href="EditStudentServlet?rno=<%=s.getRno()%>">EDIT</a> | <a href="DeletStudentServlet?rno=<%=s.getRno()%>">DELETE</a></td>



</tr>



<%} %>

</table>
</body>
</html>