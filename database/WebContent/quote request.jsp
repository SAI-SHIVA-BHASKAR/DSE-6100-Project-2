<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Request for Quote</title>
  
</head>
<body>
    <center>
        <h1 class="title">Request for Quote</h1>
    </center>

    <div align="center">
        <table border="1" cellpadding="20">
            <caption><h2>Details of all added trees</h2></caption>
            <tr>
                <th>Tree ID</th>
                <th>Size</th>
                <th>Height</th>
                <th>Note</th>
            </tr>
            <c:forEach var="tree" items="${treesAdded}">
                <tr>
                    <td><c:out value="${tree.tree_id}" /></td>
                    <td><c:out value="${tree.size}" /></td>
                    <td><c:out value="${tree.height}" /></td>
                    <td><c:out value="${tree.note}" /></td>
                </tr>
            </c:forEach>
        </table>

        <p class="errormsg">${error}</p>

        <form>
            <div class="btns" align="center">
                <p class="add_tree_button"><a href="tree.jsp" target="_self">Add Tree Details</a></p>
                <p>
                    <a href="#" class="submit_button" onclick="goToPage('clientView.jsp');">Submit</a>
                </p>
            </div>
        </form>
    </div>

    <script>
        function goToPage(url) {
            window.location.href = url;
        }
    </script>
</body>
</html>