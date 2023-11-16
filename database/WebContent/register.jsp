<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registration</title>
    
</head>
<body>
    <center>
        <h1>Welcome to Registration Page</h1>
        <div class="registration-box">
            <p>${errorOne }</p>
            <p>${errorTwo }</p>
            <form action="register">
                <table border="1" cellpadding="5">
                    <tr>
                        <th>Username: </th>
                        <td align="center" colspan="3">
                            <input type="text" name="email" size="45" value="example@gmail.com" onfocus="this.value=''">
                        </td>
                    </tr>
                    <tr>
                        <th>First Name: </th>
                        <td align="center" colspan="3">
                            <input type="text" name="firstName" size="45" value="FirstName" onfocus="this.value=''">
                        </td>
                    </tr>
                    <tr>
                        <th>Last Name: </th>
                        <td align="center" colspan="3">
                            <input type="text" name="lastName" size="45" value="LastName" onfocus="this.value=''">
                        </td>
                    </tr>
                    <tr>
                        <th>Password: </th>
                        <td align="center" colspan="3"> 
                            <input type="password" name="password" size="45" value="password" onfocus="this.value=''">
                        </td>
                    </tr>
                    <tr>
                        <th>Password Confirmation: </th>
                        <td align="center" colspan="3">
                            <input type="password" name="confirm" size="45" value="confirm" onfocus="this.value=''">
                        </td>
                    </tr>
                    <tr>
                        <th>Phone: </th>
                        <td align="center" colspan="3">
                            <input type="phone" name="phone" size="45" value="phone" onfocus="this.value=''">
                        </td>
                    </tr>
                    <tr>
                        <th>Address: </th>
                        <td align="center" colspan="3">
                            <input type="address" name="address" size="45" value="address" onfocus="this.value=''">
                        </td>
                    </tr>
                    <tr>
                        <th>Credit card info: </th>
                        <td align="center" colspan="3">
                            <input type="credit card info" name="credit_card_info" size="45" value="credit_card_info" onfocus="this.value=''">
                        </td>
                    </tr>
                    <tr>
                        <th>Role: </th>
                        <td align="center" colspan="3">
                            <select id="role" name="role">
                                <option value="root">Root</option>
                                <option value="clients">Client</option>
                                <option value="david_smith">David Smith</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align="center" colspan="5">
                            <input type="submit" value="Register" class="register-button">
                        </td>
                    </tr>
                </table>
            </form>
            <a href="login.jsp" target="_self" class="return-link">Return to Login Page</a>
        </div>
    </center>
</body>
</html>