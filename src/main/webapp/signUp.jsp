<%-- 
    Document   : signUp
    Created on : 5 Feb 2024, 21:36:58
    Author     : aless
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up Page</title>
        <style>
            body {
                background-color: bisque; /* Set background color to light green */
                text-align: center; /* Align text to the center */
            }
            h3 {
                font-size: 36px; /* Make font size bigger */
                color: darkgreen; /* Set font color to dark green */
            }
            table {
                margin: auto; /* Center the table */
                margin-top: 50px; /* Add some margin */
                background-color: darksalmon; /* Set background color to light sea green */
                border-collapse: collapse; /* Collapse table borders */
            }
            td {
                padding: 10px; /* Add padding */
            }
            b {
                font-size: 24px; /* Make font size bigger */
                color: darkgreen; /* Set font color to dark green */
            }
            input[type="text"], input[type="password"] {
                width: 300px; /* Set input width */
                height: 30px; /* Set input height */
                font-size: 18px; /* Make font size bigger */
            }
            input[type="submit"] {
                width: 120px; /* Set button width */
                height: 40px; /* Set button height */
                font-size: 20px; /* Make font size bigger */
                margin-top: 20px; /* Add some margin */
                background-color: darkgreen; /* Set background color to dark green */
                color: white; /* Set font color to white */
                border: none; /* Remove border */
                cursor: pointer; /* Add pointer cursor */
            }
            input[type="submit"]:hover {
                background-color: forestgreen; /* Change background color on hover */
            }
            input[type="text"], input[type="password"], select { /* Include select here */
                width: 300px; /* Set width to match other input boxes */
                height: 30px;
                font-size: 18px;
            }
            input[type="submit"] {
                width: 120px;
                height: 40px;
                font-size: 20px;
                margin-top: 20px;
                background-color: darkgreen;
                color: white;
                border: none;
                cursor: pointer;
            }
            input[type="submit"]:hover {
                background-color: forestgreen;
            </style>
        </head>
        <body>

            <h3>Enter your details to Sign Up!</h3>

            <form action="signUpServlet" method="post">
                <table>
                    <tr>
                        <td align="center"><b>Username:</b></td>
                        <td align="right"><input type="text" name="user_name" required></td>
                    </tr>
                    <tr>
                        <td align="center"><b>Email:</b></td>
                        <td align="right"><input type="text" name="email" required></td>
                    </tr>
                    <tr>
                        <td align="center"><b>Password:</b></td>
                        <td align="right"><input type="password" name="password" style="width: 300px;" required></td>
                    </tr>
                    <tr>
                        <td align="center"><b>User Role:</b></td>
                        <td align="right">
                            <select name="user_role" required>
                                <option value="user">User</option>
                                <option value="admin">Admin</option>
                            </select>
                        </td>
                    </tr>
                </table>
                <br>
                <input type="submit" value="Submit">
            </form>

        </body>
    </html>
