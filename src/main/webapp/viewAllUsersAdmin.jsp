<%-- 
    Document   : viewAllUsersAdmin
    Created on : 6 Feb 2024, 21:31:34
    Author     : aless
--%>

<%@page import="java.util.List"%>
<%@page import="Entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Users</title>
        <style>
            body {
                font-family: Arial, sans-serif; /* Consistent font across pages */
                background-color: bisque; /* Background color as requested */
                text-align: center; /* Central alignment for content */
                margin: 0; 
                padding: 20px 0; 
            }
            .container {
                width: 80%;
                margin: 0 auto; 
                text-align: left; 
            }
            h1 {
                font-size: 58px; 
                color: darkgreen; 
                margin-top: 50px;
                text-align: center;
                font-family: 'Gabriola', sans-serif; 
            }
            table {
                margin: 0 auto; /* Center the table */
                border-collapse: collapse; /* Collapse borders for a cleaner look */
                width: 100%; /* Full width of its container */
                background-color: white; /* Background color for table results */
            }
            th, td {
                padding: 10px; /* Padding inside cells */
                border: 1px solid #ddd; /* Light border for cells */
                text-align: left; /* Align text to the left in cells */
            }
            th {
                background-color: #6B8E23; /* Darker shade of bisque for headers */
                color: white; /* Text color for headers */
            }
            tr:nth-child(even) {
                background-color: #f2f2f2; /* Zebra striping for rows */
            }
            a {
                display: inline-block;
                background-color: darkgreen; /* Button background */
                color: white; /* Button text color */
                padding: 5px 10px; /* Padding around text */
                margin: 5px; /* Space between buttons */
                text-decoration: none; /* No underline */
                border-radius: 10px; /* Rounded edges for buttons */
                font-size: 16px; /* Font size for button text */
            }
            a:hover {
                background-color: forestgreen; /* Lighter green on hover */
            }
            .go-back a {
                background-color: #8B4513; 
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>All Users</h1>
            <table>
                <thead>
                    <tr>
                        <th>User ID</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th>User Role</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<User> userList = (List<User>) request.getAttribute("userList"); %>
                    <% if (userList != null && !userList.isEmpty()) { %>
                    <% for (User user : userList) {%>
                    <tr>
                        <td><%= user.getUser_id()%></td>
                        <td><%= user.getUser_name()%></td>
                        <td><%= user.getEmail()%></td>
                        <td><%= user.getUser_role()%></td>
                        <td><%= user.getPassword()%></td>
                        <td>
                            <a href="ModifyUser.jsp?user_id=<%= user.getUser_id()%>">Modify</a>
                            <a href="DeleteUser.jsp?user_id=<%= user.getUser_id()%>">Delete</a>
                        </td>
                    </tr>
                    <% } %>
                    <% } else { %>
                    <tr>
                        <td colspan="6">No users found</td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
            <div class="go-back">
                <a href="AdminPage.jsp">Go Back</a>
            </div>
        </div>
    </body>
</html>
