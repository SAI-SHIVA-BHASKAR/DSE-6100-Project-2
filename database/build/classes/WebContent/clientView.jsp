<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Client View</title>

</head>
<body>
    <center>
        <div class="welcome-box">
            <h1>Welcome to Client View</h1>
        </div>
        <div class="button-container">
            <a class="viewQuotes-button" href="Quotes" target="_self">View Quotes</a>
            <a class="request-button" href="createQuote" target="_self">Request Quote</a>
            <a class="logout-button" href="login.jsp" target="_self">Logout</a>
        </div>
    </center>
</body>
</html>