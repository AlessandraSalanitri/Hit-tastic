<%-- 
    Document   : DeleteUser
    Created on : 6 Feb 2024, 22:01:06
    Author     : aless
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Delete User</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: bisque; /* Consistent background color */
                margin: 0;
                padding: 20px;
                box-sizing: border-box;
            }
            .container {
                max-width: 600px; /* Adjusted for consistency */
                margin: 40px auto; /* Centered with more vertical space */
                background-color: #fff;
                padding: 40px; /* More padding for a spacious layout */
                border-radius: 10px; /* Rounded corners */
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2); /* Subtle shadow */
            }
            h1 {
                color: darkgreen; /* Adjusted to fit the theme */
                margin-bottom: 20px; /* Spacing below the header */
            }
            p {
                color: #555; /* Slightly darker for better readability */
                font-size: 18px; /* Larger font size */
                margin-bottom: 30px; /* Increased bottom margin */
            }
            .btn-container {
                display: flex;
                justify-content: center;
                gap: 20px; /* Space between buttons */
            }
            .btn, a.btn {
                padding: 12px 25px; /* Larger buttons */
                border: none;
                border-radius: 5px; /* Rounded edges */
                font-size: 16px; /* Larger font size */
                cursor: pointer;
                text-decoration: none; /* Remove underline from anchor */
                display: inline-block; /* Align buttons correctly */
            }
            .btn {
                background-color: #f44336; /* Delete button color */
                color: white; /* Text color */
            }
            a.btn {
                background-color: darkgreen; /* Cancel button color */
                color: white; /* Text color */
            }
            .btn:hover, a.btn:hover {
                opacity: 0.9; /* Slight opacity change on hover */
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Delete User</h1>
            <p>Are you sure you want to delete this user?</p>
            <div class="btn-container">
                <form action="DeleteUserServlet" method="post" style="margin: 0;">
                    <input type="hidden" name="user_id" value="<%= request.getParameter("user_id")%>"> 
                    <button type="submit" class="btn">Delete</button>
                </form>
                <a href="viewAllUsersAdmin.jsp" class="btn">Exit</a>
            </div>
        </div>
    </body>
</html>
