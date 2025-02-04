<%-- 
    Document   : error
    Created on : 6 Feb 2024, 12:54:51
    Author     : aless
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Error</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                padding: 0;
                text-align: center;
            }

            .container {
                margin: 50px auto;
                padding: 20px;
                width: 80%;
                max-width: 600px;
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h1 {
                color: #ff6347;
                margin-bottom: 20px;
            }

            p {
                color: #333;
                margin-bottom: 20px;
            }

            a {
                color: #007bff;
                text-decoration: none;
            }

            a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>

        <div class="container">
            <h1>Error</h1>
            <p>An error occurred while processing your request:</p>
            <p><%= request.getAttribute("errorMessage")%></p>
            <p><a href="index.html">Go back to Home Page</a></p>
        </div>

    </body>
</html>

