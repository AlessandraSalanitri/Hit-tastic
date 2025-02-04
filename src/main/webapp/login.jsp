<%-- 
    Document   : login
    Created on : 5 Feb 2024, 21:35:54
    Author     : aless
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
            body {
                background-color: bisque; /* Keep the background color consistent */
                text-align: center; /* Central alignment for the content */
                font-family: Arial, sans-serif; /* Consistent font family */
            }
            h1 {
                font-size: 48px; /* Consistent font size for headings */
                color: darkgreen; /* Consistent color scheme */
                font-family: 'Gabriola', sans-serif; /* Specified font for consistency */
            }
            form {
                display: inline-block; /* Center the form on the page */
                margin-top: 50px; /* Add some margin for spacing */
                text-align: left; /* Align form elements to the left */
            }
            label {
                font-size: 24px; /* Bigger font size for readability */
                color: darkgreen; /* Consistent color scheme */
                display: block; /* Make labels block elements for alignment */
                margin: 10px 0; /* Spacing around labels */
            }
            input[type="text"],
            input[type="password"] {
                width: 300px; /* Set width to make inputs align */
                height: 30px; /* Height for comfortable typing space */
                font-size: 18px; /* Larger font size for readability */
                border-radius: 15px; /* Rounded corners for inputs */
                border: 1px solid darkgreen; /* Border to match the theme */
                padding-left: 10px; /* Padding for text inside inputs */
            }
            button {
                width: 150px; /* Button width for a balanced look */
                height: 40px; /* Height for better clickability */
                font-size: 20px; /* Larger font size for visibility */
                margin-top: 20px; /* Spacing above the button */
                background-color: darkgreen; /* Theme consistent background */
                color: white; /* Text color for contrast */
                border: none; /* No border for a cleaner look */
                border-radius: 20px; /* Rounded edges for the button */
                cursor: pointer; /* Cursor to indicate clickable */
            }
            button:hover {
                background-color: forestgreen; /* Slightly lighter green on hover for feedback */
            }
        </style>
    </head>
    <body>

        <h1>Login Page</h1>
        <form action="loginServlet" method="post">
            <label for="email">Email:</label>
            <input type="text" name="email" id="email">
            <br>
            <label for="password">Password:</label>
            <input type="password" name="password" id="password">
            <br><br>
            <button type="submit">Login</button>
        </form>

    </body>
</html>