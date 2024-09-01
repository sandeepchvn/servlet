<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Student List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #FAFAFA;
            color: #333;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin-bottom: 20px;
            background-color: #FFFFFF;
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #DBDBDB;
        }
        th {
            background-color: #F5F5F5;
            color: #262626;
        }
        tr:hover {
            background-color: #F9F9F9;
        }
        .action-buttons {
            display: flex;
            gap: 10px;
        }
        .action-buttons a {
            background-color: #3897F0;
            color: #FFFFFF;
            padding: 8px 12px;
            border-radius: 4px;
            text-decoration: none;
            font-weight: bold;
            text-align: center;
            display: inline-block;
            width: 60px;
        }
        .action-buttons a.delete {
            background-color: #E74C3C;
        }
        .action-buttons a:hover {
            background-color: #307DF0;
        }
        .action-buttons a.delete:hover {
            background-color: #C0392B;
        }
        .add-button {
            background-color: #3897F0;
            color: #FFFFFF;
            padding: 10px 15px;
            border-radius: 4px;
            text-decoration: none;
            font-weight: bold;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }
        .add-button:hover {
            background-color: #307DF0;
        }
    </style>
</head>
<body>
    <h2>Student List</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Course</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="student" items="${list}">
            <tr>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.course}</td>
                <td>
                    <div class="action-buttons">
                        <a href="findByMail?email=${student.email}">Edit</a>
                        <a href="delete?email=${student.email}" class="delete">Delete</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="register.jsp" class="add-button">Add New Student</a>
</body>
</html>
