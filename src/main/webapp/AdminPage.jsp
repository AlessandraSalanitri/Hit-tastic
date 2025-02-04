<%-- 
    Document   : AdminPage
    Created on : 5 Feb 2024, 21:59:38
    Author     : aless
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body {
                background-color: bisque; 
                text-align: center; 
                font-family: 'Arial', sans-serif; 
            }
            h1 {
                font-size: 58px; 
                color: darkgreen; 
                margin-top: 50px; 
                font-family: 'Gabriola', sans-serif; 
            }
            ul {
                list-style-type: none; 
                padding: 0; 
                display: block; 
                margin-top: 30px; 
            }
            li {
                margin: 20px 0; 
            }
            a {
                text-decoration: none; 
                color: darkgreen; 
                font-size: 24px; 
                background-color: white; 
                padding: 10px 20px; 
                border-radius: 15px; 
                display: inline-block; 
                border: 2px solid darkgreen;
            }
            a:hover {
                color: forestgreen; /* Change color on hover */
                background-color: #f9f9f9; /* Slightly different background on hover */
            }
        </style>
    </head>
    <body>

        <h1>Welcome, Admin!</h1>

        <ul>
            <li><a href="ViewAllUsersServlet">View All Users</a></li>
            <li><a href="ViewAllCommentsServlet">View All Comments</a></li>
            <li><a href="ViewAllPointsOfInterestServlet">View or Add Points of Interest</a></li>
            
        </ul>

    </body>
</html>