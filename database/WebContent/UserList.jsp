<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>All User list</title>
</head>
<body>
    <div align="center">
        <table border="1" cellpadding="12">
            <caption><h2>List of People</h2></caption>
            <tr>
                <th>Email</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Password</th>
                <th>Role</th>
            </tr>
            <c:forEach var="users" items="${listUser}">
                <tr style="text-align:center">
                    <td>${users.email}</td>
                    <td>${users.firstName}</td>
                    <td>${users.lastName}</td>
                    <td>${users.password}</td>
                    <td>${users.role}</td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>