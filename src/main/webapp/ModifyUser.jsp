<%-- 
    Document   : ModifyUser
    Created on : 6 Feb 2024, 21:58:51
    Author     : aless
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Modify User Details</title>
        <style>
            body {
                background-color: bisque; 
                text-align: center; 
                font-family: Arial, sans-serif; 
                margin: 0;
                padding: 20px;
            }
            h1 {
                color: darkgreen;
                margin-bottom: 20px; 
            }
            .container {
                max-width: 400px;
                margin: auto; 
                background-color: #fff;
                padding: 20px;
                border-radius: 10px; 
                box-shadow: 0 2px 4px rgba(0,0,0,0.2); 
            }
            form {
                display: flex;
                flex-direction: column;
            }
            label {
                margin-bottom: 10px;
                color: darkgreen; 
                font-size: 18px; 
            }
            input[type="text"],
            input[type="email"],
            input[type="password"],
            input[type="submit"] {
                width: calc(100% - 20px);
                padding: 10px;
                margin: 10px 0; 
                border-radius: 5px; 
                border: 1px solid darkgreen; 
                font-size: 16px; 
            }
            input[type="submit"] {
                background-color: darkgreen; 
                color: white; 
                cursor: pointer; 
            }
            input[type="submit"]:hover {
                background-color: forestgreen;
            }
            .error {
                color: red; 
                margin-top: 10px; 
            }
        </style>
    </head>
    <body>
        <h1>Modify User Details</h1>
        <div class="container">
            <form action="ModifyUserServlet" method="post">
                <input type="hidden" name="user_id" value="<%= request.getParameter("user_id")%>"> 
                <label for="newUser_name">New Username:</label>
                <input type="text" id="newUser_name" name="newUser_name" required>
                <label for="newEmail">New Email:</label>
                <input type="email" id="newEmail" name="newEmail" required>
                <label for="newPassword">New Password:</label>
                <input type="password" id="newPassword" name="newPassword" required>
                <label for="newUser_role">New Role:</label>
                <input type="text" id="newUser_role" name="newUser_role" required>
                <input type="submit" value="Modify User">
            </form>
        </div>
    </body>
</html>

