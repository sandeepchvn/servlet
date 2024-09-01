<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #FAFAFA;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .form-container {
            background-color: #FFFFFF;
            border: 1px solid #DBDBDB;
            padding: 20px;
            width: 300px;
            border-radius: 12px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #262626;
            font-size: 24px;
            margin-bottom: 20px;
        }
        label {
            font-weight: bold;
            color: #555;
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #DBDBDB;
            border-radius: 4px;
            font-size: 14px;
            background-color: #FAFAFA;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #3897F0;
            border: none;
            border-radius: 4px;
            color: #FFFFFF;
            font-weight: bold;
            cursor: pointer;
            font-size: 14px;
        }
        input[type="submit"]:hover {
            background-color: #307DF0;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Update Student Details</h2>
        <form action="update" >
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" readonly value="${student.email}">
            
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" value="${student.phone}">
            
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${student.name}">
            
            <label for="degree">Degree:</label>
            <input type="text" id="degree" name="degree" value="${student.degree}">
            
            <label for="stream">Stream:</label>
            <input type="text" id="stream" name="stream" value="${student.stream}">
            
            <label for="yearOfPassOut">Year of Pass Out:</label>
            <input type="text" id="yearOfPassOut" name="yearOfPassOut" value="${student.yearOfPassOut}">
            
            <label for="course">Course:</label>
            <input type="text" id="course" name="course" value="${student.course}">
            
            <label for="gender">Gender:</label>
            <input type="text" id="gender" name="gender" value="${student.gender}">
            
            <label for="feesPaid">Fees Paid:</label>
            <input type="text" id="feesPaid" name="feesPaid" value="${student.feesPaid}">
            
            <input type="submit" value="Update">
        </form>
    </div>
</body>
</html>
