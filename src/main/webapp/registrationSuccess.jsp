<%-- 
    Document   : registrationSuccess
    Created on : 6 Feb 2024, 19:22:59
    Author     : aless
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Success</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                text-align: center;
                background-color: #f2f2f2;
                margin: 0;
                padding: 0;
            }
            .container {
                margin-top: 100px;
            }
            h1 {
                color: #333;
            }
            .button {
                display: inline-block;
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                text-decoration: none;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s;
            }
            .button:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Congratulations! You're one of us now!</h1>
            <a href="login.jsp" class="button">Login</a>
        </div>
    </body>
</html>
