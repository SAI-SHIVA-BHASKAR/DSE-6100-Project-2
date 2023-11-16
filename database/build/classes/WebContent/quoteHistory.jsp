<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quote History Page</title>
 
</head>
<body>
 
<div align = "center">
 <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Quotes</h2></caption>
            <tr>
                <th> Id</th>
			   <th>client Id</th>
                <th>Quote Id</th>
                <th>Propose Date</th>
                <th>price</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Status</th>
                <th>Note</th>
         
            </tr>
          
		    <c:forEach var="quote" items="${quotesHistory}">
		        <tr style="text-align:center">
                        <td><c:out value="${quote.id}" /></td>
                        <td><c:out value="${quote.client_id}" /></td>
		                <td><c:out value="${quote.quote_id}" /></td>
		                <td><c:out value="${quote.propose_date}" /></td>
		                <td><c:out value="${quote.price}" /></td>
		                <td><c:out value="${quote.start_date}" /></td>
		                <td><c:out value="${quote.end_date}" /></td>
		                <td><c:out value="${quote.status}" /></td>
		                <td><c:out value="${quote.note}" /></td>
  
	
		        </tr>
		    </c:forEach>	
        </table>
	</div>
	</div>
	<script>
		function goBack() {
    	window.history.back();
	}
</script>
</body>
</html>