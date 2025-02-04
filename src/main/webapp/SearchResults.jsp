<%-- 
    Document   : SearchResults
    Created on : 8 Feb 2024, 19:47:09
    Author     : aless
--%>
<%@ page import="java.util.List" %>
<%@ page import="Entities.PointOfInterest" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Search Results</title>
        <style>
            body {
                font-family: 'Gabriola', sans-serif;
                background-color: bisque;
                margin: 0;
                padding: 0;
            }
            .container {
                width: 80%;
                margin: 20px auto;
            }
            h2 {
                text-align: center;
                margin-bottom: 40px;
                font-size: 48px;
                font-family:'Gabriola', sans-serif;
                color: darkgreen;

            }
            .poi {
                border: 1px solid #ddd;
                border-radius: 5px;
                padding: 20px;
                margin-bottom: 20px;
                background-color: #fff;
                text-align: center; /* Center content */
            }
            .poi h3 {
                font-size: 38px; /* Larger font size for POI name */
                margin-top: 0;

            }
            .details {
                font-size: 20px; /* Larger font size for details */
                display: flex;
                justify-content: center; /* Align details in the center */
                gap: 30px; /* Space between detail items */
            }
            button {
                padding: 10px 20px;
                font-size: 18px; /* Larger font size for buttons */
                border-radius: 20px; /* Rounded edges for buttons */
                border: none;
                cursor: pointer;
                background-color: darkgreen;
                color: white;
                margin: 10px 5px; /* Space around buttons */
            }
            button:hover {
                background-color: forestgreen;
            }
            .error-message {
                color: red;
                text-align: center;
                font-size: 20px; /* Larger font size for error message */
            }
            a {
                display: inline-block;
                margin-top: 20px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Here we go! Here's the Point of Interest Details..</h2>


            <c:forEach var="poi" items="${searchResults}">
                <div class="poi">
                    <h3>${poi.poi_name}</h3>
                    <div class="details">
                        <span><strong>Type:</strong> ${poi.poi_type}</span>
                        <span><strong>Location:</strong> ${poi.poi_location}</span>
                        <span><strong>Likes:</strong> ${poi.poi_likes}</span>
                    </div>
                    <div>


                        <!-- Like/comment section -->
                        <form action="LikeServlet" method="post" style="display: inline;">
                            <input type="hidden" name="poi_id" value="${poi.poi_id}">
                            <button type="submit">Like</button>
                        </form>

                        <form action="CommentServlet" method="post" style="display: inline;">
                            <input type="hidden" name="poi_id" value="${poi.poi_id}">
                            <button type="submit">Comment</button>
                        </form>
                    </div>
                </div>
            </c:forEach>

            <!-- Handle case "no search results are found" -->
            <c:if test="${empty searchResults}">
                <h2><div class="error-message">No results found.</div><h2>
                        </c:if>

                        <!-- Back button -->
                        <p><a href="javascript:history.back()">Back</a></p>
                        </div>
                        </body>
                        </html>

