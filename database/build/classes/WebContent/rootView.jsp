<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Root Page</title>
  
</head>
<body>
    <center>
        <form action="initialize">
            <input type="submit" value="Initialize the Database" class="initialize-button" />
        </form>
        <a href="login.jsp" target="_self" class="logout-link">Logout</a><br><br>

        <div align="center">
            <table border="1" cellpadding="6">
                <caption><h2>List of Users</h2></caption>
                <tr>
                    <th>Email</th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Password</th>
                    <th>Role</th>
                </tr>
                <c:forEach var="users" items="${listUser}">
                    <tr style="text-align:center">
                        <td><c:out value="${users.email}" /></td>
                        <td><c:out value="${users.firstName}" /></td>
                        <td><c:out value="${users.lastName}" /></td>
                        <td><c:out value="${users.password}" /></td>
                        <td><c:out value="${users.role}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </center>
</body>
</html>