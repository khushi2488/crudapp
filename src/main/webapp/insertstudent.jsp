<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>

</head>
<style>
   body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }

    header {
        background-color: #333;
        color: white;
        text-align: center;
        padding: 10px 0;
    }

    form {
        max-width: 400px;
        margin: 20px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        animation: fadeIn 0.5s ease;
    }

    @keyframes fadeIn {
        from {
            opacity: 0;
            transform: translateY(-20px);
        }
        to {
            opacity: 1;
            transform: translateY(0);
        }
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    table, th, td {
        border: none;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }

    td {
        background-color: #fff;
    }

    input[type="text"], input[type="submit"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 4px;
        transition: border-color 0.3s;
    }

    input[type="text"]:focus, input[type="submit"]:hover {
        border-color: #4CAF50;
    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
        color: #333;
    }

    .checkbox-container {
        margin-top: 5px;
    }

    .checkbox-container label {
        display: inline-block;
        margin-right: 10px;
    }

   
    
</style>
<body>
<header>
    <h1>Student Registration Form</h1>
</header>
<form action="InsertStudentServlet" method="post">
          <h2>Please fill in the following information:</h2>
          <p>This form is for registering new students. Please provide the required information below.</p>
   <table>
      <tr>
            <td>Name</td> 
            <td><input type="text" name="name" value="${name}"/>${errName}</td>
        </tr>
        <tr>
            <td>Std</td>
            <td><input type="text" name="std" value="${std}"/>${errStd}</td>
        </tr>
        <tr>
            <td>Marks</td>
            <td><input type="text" name="marks" value="${marks}"/>${errMarks}</td>
        </tr>
      <tr>
       <td>Hobbies:</td>
                <td><input type="checkbox" name="hobbies"value="Cricket"/>Cricket</td>
                <td><input type="checkbox" name="hobbies" value="Carem"/>Carem</td>
                <td><input type="checkbox" name="hobbies" value="Reading"/>Reading</td>
                <td><input type="checkbox" name="hobbies" value="painting"/>painting</td>
                <td>${errHobbies}</td>
      </tr>
      <tr>
       <td></td>
        <td><input type="submit"></td>
      </tr>
    
    
    


    </table>

</form>
<form action="LogoutServlet" method="post">
    <input type="submit" value="Logout">
</form>



</body>
</html>