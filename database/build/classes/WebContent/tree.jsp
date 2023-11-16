<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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

        h1 {
            color: #333;
            text-align: center;
            margin-top: 20px;
        }

        .form-container {
            max-width: 400px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .errormsg {
            color: red;
            margin-bottom: 10px;
        }

        .input-container {
            margin-bottom: 15px;
        }

        .user_name,
        .note,
        .file-input {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-top: 5px;
        }

        .file-input-container {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        .button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        .register_button {
            text-align: center;
            margin-top: 10px;
        }

        .register_button a {
            text-decoration: none;
            color: #007bff;
        }
    </style>
</head>

<body>
    <h1>Tree Details</h1>
    <div class="form-container">
        <p class="errormsg">${error}</p>
        <form action="addTree" method="post">
            <div class="input-container">
                <input class="user_name" type="text" name="size" placeholder="Size" autofocus>
            </div>
            <div class="input-container">
                <input class="user_name" type="text" name="height" placeholder="Height">
            </div>
            <div class="input-container">
                <input class="user_name" type="text" name="nearHouse" placeholder="Near House">
            </div>
            <div class="input-container">
                <input class="user_name" type="text" name="location" placeholder="Location">
            </div>
            <div class="input-container file-input-container">
                <label for="image1">Add Images:</label><br>
                <input class="file-input" type="file" id="image1" name="treeImage1" accept="image/*">
                <input class="file-input" type="file" id="image2" name="treeImage2" accept="image/*">
                <input class="file-input" type="file" id="image3" name="treeImage3" accept="image/*">
            </div>
            <div class="input-container">
                <label for="note">Note:</label><br>
                <textarea class="note" id="note" type="text" name="note" rows="4" placeholder="Note" autofocus></textarea>
            </div>
            <input class="button" type="submit" value="Add" />
        </form>
        <p class="register_button"><a href="quote request.jsp" target="_self">BACK</a></p>
    </div>
</body>

</html>
