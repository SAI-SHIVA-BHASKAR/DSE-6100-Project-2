<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View Page</title>
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

        .back {
            margin-top: 20px;
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

        .action-buttons {
            display: flex;
            justify-content: space-around;
        }

        .negotiate-button,
        .accept-button {
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
        }

        .negotiate-button {
            background-color: #ffc107;
        }

        .accept-button {
            background-color: #28a745;
        }
    </style>
</head>
<body>

<div align="center">
    <a class="back" onclick="goBack();" target ="_self" >Back</a><br><br>

    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Quotes</h2></caption>
            <tr>
                <th>Quote Id</th>
                <th>Request Date</th>
                <th>Price</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Status</th>
                <th>Note</th>
                <th>Action</th>
            </tr>
            <c:forEach var="quote" items="${quotes}">
                <tr>
                    <td><c:out value="${quote.quote_id}" /></td>
                    <td><c:out value="${quote.propose_date}" /></td>
                    <td><c:out value="${quote.price}" /></td>
                    <td><c:out value="${quote.start_date}" /></td>
                    <td><c:out value="${quote.end_date}" /></td>
                    <td><c:out value="${quote.status}" /></td>
                    <td> <input type="text" name="note" value="${quote.note}" /></td>
                    <td class="action-buttons">
                        <form action="negotiation" method="post">
                            <input type="hidden" name="quote_id" value="${quote.quote_id}" />
                            <input type="hidden" name="client_id" value="${quote.client_id}" />
                            <button type="submit" class="negotiate-button">Negotiate</button>
                        </form>
                        <form action="acceptQuote" method="post">
                            <input type="hidden" name="quote_id" value="${quote.quote_id}" />
                            <button type="submit" class="accept-button">Accept</button>
                        </form>
                    </td>
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
