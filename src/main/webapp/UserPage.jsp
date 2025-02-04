<%-- 
    Document   : UserPage
    Created on : 5 Feb 2024, 21:59:31
    Author     : aless
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>User Page</title>
        <style>
            body {
                background-color: bisque; /* Consistent background color */
                text-align: center; /* Center text alignment */
                font-family: 'Arial', sans-serif; /* Consistent font family */
            }
            h1 {
                font-size: 58px; /* Larger font size for the welcome message */
                color: darkgreen; /* Consistent color theme */
                margin-top: 50px; /* Space from the top */
                font-family: 'Gabriola', sans-serif; /* Special font for headings */
            }
            ul {
                list-style-type: none; /* Remove bullet points */
                padding: 0; /* Remove default padding */
                display: block; /* Block display for vertical alignment */
                margin-top: 30px; /* Additional space above the list */
            }
            li {
                margin: 20px 0; /* Space between list items */
            }
            a {
                text-decoration: none; /* Remove underline from links */
                color: darkgreen; /* Consistent link color */
                font-size: 24px; /* Larger font size for links */
                background-color: white; /* Background color for links */
                padding: 10px 20px; /* Padding around links for better appearance */
                border-radius: 15px; /* Rounded corners for links */
                display: inline-block; /* Allow for padding and margin adjustments */
                border: 2px solid darkgreen; /* Border to match the theme */
            }
            a:hover {
                color: forestgreen; /* Change color on hover */
                background-color: #f9f9f9; /* Slightly different background on hover */
            }
        </style>
    </head>
    <body>

        <%-- Retrieve username from session attribute --%>
        <% String user_name = (String) session.getAttribute("user_name");%>

        <h1>Welcome <%= user_name%>!</h1>
    

        <ul>
            <li><a href="PointOfInterest.jsp">Search for a Point of Interest</a></li>
            <li><a href="ViewAllPointsOfInterestServlet">View All Points of Interest</a></li>
        </ul>

    </body>
</html>
