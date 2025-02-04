<%-- 
    Document   : viewAllPointsOfInterest
    Created on : 8 Feb 2024, 00:49:24
    Author     : aless
--%>

<%@page import="Entities.PointOfInterest"%>
<%@page import="Entities.PointOfInterest"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>All Points of Interest</title>
        <style>
            body {
                font-family: "Times New Roman", Times, serif;
                background-color: bisque;
                color: darkgreen;
                text-align: center;
            }
            h1 {
                font-size: 48px; /* font size for h1*/
                color: darkgreen; /*color scheme */
                font-family: 'Gabriola', sans-serif; /* font */
            }
            h2 {
                font-size: 30px; /*font size for h2*/
                color: darkgreen; /* color scheme */
                font-family: 'Gabriola', sans-serif; /* font */
            }
            table {
                margin: 20px auto;
                width: 80%; /* table width */
                background-color: white; /* Background*/
            }
            th {
                background-color: darkolivegreen; /*color for headers */
                color: white; /* Text color for headers */
                padding: 15px; /*padding */
                font-size: 20px;
            }
            td {
                padding: 12px; /*padding */
                border: 1px solid #ddd; /*border for each cell */
            }
            .add-button {
                margin-top: 20px;
                background-color: darkgreen; /* Background color */
                color: white; /* Text color */
                padding: 15px 30px; /*padding */
                font-size: 20px; /*font size */
                border: none; 
                cursor: pointer; 
                border-radius: 5px; 
            }
            .add-button:hover {
                background-color: forestgreen; 
            }
            .modal {
                display: none;
                position: fixed;
                z-index: 1;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                overflow: auto;
                background-color: rgba(0,0,0,0.4);
            }
            .modal-content {
                background-color: white;
                margin: 15% auto;
                padding: 20px;
                border: 1px solid #888;
                width: 50%; 
            }

            .modal-content {
                background-color: white;
                margin: 10% auto; 
                padding: 40px; 
                border: 1px solid #888;
                width: 60%; 
                border-radius: 10px; 
                font-size: 20px; 
            }
            .modal-content input[type="text"], .modal-content input[type="submit"] {
                width: 90%; 
                padding: 15px; 
                margin: 10px 0;
                font-size: 18px; 
                border-radius: 5px; 
                border: 1px solid darkgreen; 
            }
            .modal-content input[type="submit"] {
                background-color: darkgreen; 
                color: white; 
                cursor: pointer; 
                font-weight: bold; 
            }
            .modal-content input[type="submit"]:hover {
                background-color: forestgreen; 
            }

            .close {
                color: #aaa;
                float: right;
                font-size: 28px;
                font-weight: bold;
            }
            .close:hover,
            .close:focus {
                color: black;
                text-decoration: none;
                cursor: pointer;
            }


        </style>
    </head>
    <body>
        <h1>All Points of Interest</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Point of Interest ID</th>
                    <th>Name</th>
                    <th>Location</th>
                    <th>Type</th>
                    <th>Likes</th>
                </tr>
            </thead>
            <tbody>

                <% List<PointOfInterest> pointsOfInterest = (List<PointOfInterest>) request.getAttribute("pointsOfInterest"); %>
                <% if (pointsOfInterest != null && !pointsOfInterest.isEmpty()) { %>
                <% for (PointOfInterest poi : pointsOfInterest) {%>
                <tr>
                    <td><%= poi.getPoi_id()%></td>
                    <td><%= poi.getPoi_name()%></td>
                    <td><%= poi.getPoi_location()%></td>
                    <td><%= poi.getPoi_type()%></td>
                    <td><%= poi.getPoi_likes()%></td>
                </tr>
                <% } %>
                <% } else { %>
                <tr>
                    <td colspan="5">No points of interest found</td>
                </tr>
                <% }%>
            </tbody>
        </table>

        <h2>Add a New Point Of Interest Form</h2>
        <button class="add-button" onclick="openAddPOIModal()">Add New Point of Interest</button>

        <!-- Modal for adding a new point of interest -->
        <div id="addPOIModal" class="modal">
            <div class="modal-content">
                <span class="close" onclick="closeAddPOIModal()">&times;</span>
                <h2>Add New Point of Interest</h2>
                <form action="AddNewPointOfInterestServlet" method="post">
                    Name: <input type="text" name="poi_name"><br>
                    Location: <input type="text" name="poi_location"><br>
                    Type: <input type="text" name="poi_type"><br>
                    <input type="submit" value="Add">
                </form>
            </div>
        </div>

        <script>
            var modal = document.getElementById('addPOIModal');
            function openAddPOIModal() {
                modal.style.display = 'block';
            }
            function closeAddPOIModal() {
                modal.style.display = 'none';
            }
        </script>
    </body>
</html>
