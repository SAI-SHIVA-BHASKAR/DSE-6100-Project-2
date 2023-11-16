<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tree Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    a {
        text-decoration: none;
        color: #007bff;
    }

    .logout {
        float: right;
        margin: 10px;
        font-size: 16px;
    }

    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 12px;
        text-align: center;
    }

    th {
        background-color: #f2f2f2;
    }

    caption {
        font-size: 20px;
        margin-bottom: 10px;
    }

    .returntologin {
        text-align: center;
        margin-top: 20px;
    }

    .returntologin a {
        display: inline-block;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
        color: #fff;
        background-color: #4caf50;
        border-radius: 5px;
        font-size: 16px;
    }
</style>
</head>
<body>
    <div align="center">
        <a class="logout" href="login.jsp" target="_self">Logout</a><br><br>
        <div align="center">
            <table border="1" cellpadding="6">
                <caption><h2>Tree Details</h2></caption>
                <tr>
                    <th>Tree Id</th>
                    <th>Quote Id</th>
                    <th>Size</th>
                    <th>Height</th>
                    <th>Location</th>
                    <th>Note</th>
                </tr>
                <c:forEach var="tree" items="${listOfTrees}">
                    <tr>
                        <input type="hidden" name="quote_id" value="${tree.quote_id}" />
                        <td><c:out value="${tree.tree_id}" /></td>
                        <td><c:out value="${tree.quote_id}" /></td>
                        <td><c:out value="${tree.size}" /></td>
                        <td><c:out value="${tree.height}" /></td>
                        <td><c:out value="${tree.location}" /></td>
                        <td><c:out value="${tree.note}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <p class="returntologin">
            <a href="#" onclick="goBack();">BACK</a>
        </p>
    </div>
    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>
