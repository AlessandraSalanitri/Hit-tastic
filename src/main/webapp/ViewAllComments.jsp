<%-- 
    Document   : ViewAllComments
    Created on : 7 Feb 2024, 11:56:05
    Author     : aless
--%>

<%@page import="Entities.Comments"%>
<%@page import="javax.xml.stream.events.Comment"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>All Comments</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: bisque;
                text-align: center;
                margin: 0;
                padding: 20px 0;
            }
            h1 {
                margin: 20px 0;
                font-size: 58px; /* Larger font size for the welcome message */
                color: darkgreen; /* Consistent color theme */
                margin-top: 50px; /* Space from the top */
                font-family: 'Gabriola', sans-serif;
            }
            table {
                margin: 0 auto; /* Center the table */
                border-collapse: collapse; /* Collapse borders for a cleaner look */
                width: 80%; /* Full width of its container */
                background-color: white;
            }
            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }
            th {
                background-color: #6B8E23;
                color: white;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
            tr:hover {
                background-color: #ddd;
            }
            input[type="submit"] {
                border: none;
                border-radius: 5px;
                padding: 5px 10px;
                cursor: pointer;
                background-color: darkgreen;
                color: white;
                margin-right: 5px;
            }
            input[type="submit"]:hover {
                background-color: forestgreen;
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
        <h1>All Comments</h1>
        <% List<Comments> commentList = (List<Comments>) request.getAttribute("commentsList"); %>
        <% if (commentList != null && !commentList.isEmpty()) { %>
        <table>
            <thead>
                <tr>
                    <th>Comment ID</th>
                    <th>User ID</th>
                    <th>Comment Text</th>
                    <th>Timestamp</th>
                    <th>POI ID</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% for (Comments comment : commentList) {%>
                <tr>
                    <td><%= comment.getComment_id()%></td>
                    <td><%= comment.getUser_id()%></td>
                    <td><%= comment.getComment_text()%></td>
                    <td><%= comment.getTimestamp()%></td>
                    <td><%= comment.getPoi_id()%></td>
                    <td>
                        <form action="ApproveCommentsServlet" method="post" style="display: inline;">
                            <input type="hidden" name="comment_id" value="<%= comment.getComment_id()%>">
                            <input type="submit" value="Approve">
                        </form>
                        <form action="DeleteCommentsServlet" method="post" style="display: inline;">
                            <input type="hidden" name="comment_id" value="<%= comment.getComment_id()%>">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <% } else { %>
        <p>No comments available for this point of interest.</p>
        <% }%>
        <div class="go-back">
            <a href="AdminPage.jsp">Go Back</a>
        </div>
    </body>
</html>