<%-- 
    Document   : LocationLetterSelection
    Created on : 6 Feb 2024, 18:48:43
    Author     : aless
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Location Letter Selection</title>
        <style>
            body {
                background-color: bisque;
                text-align: center;
                font-family: Arial, sans-serif;
            }
            h1 {
                font-size: 36px;
                color: darkgreen;
                margin-top: 50px;
                font-family: 'Gabriola', sans-serif;
            }
            h3 {
                font-size: 24px;
                color: darkgreen;
                margin-bottom: 30px;
                font-family: 'Gabriola', sans-serif;
            }
            .poi {
                background-color: #f9f9f9;
                border: 1px solid #ccc;
                padding: 20px;
                margin: 20px auto;
                max-width: 600px;
                text-align: left;
            }
            .poi h3 {
                margin: 0;
            }
            .poi p {
                margin: 10px 0;
            }
            .action-buttons {
                margin-top: 20px;
            }
            .action-buttons form {
                display: inline-block;
                margin-right: 10px;
            }
            .action-buttons button {
                width: 100px;
                height: 40px;
                font-size: 18px;
                background-color: darkgreen;
                color: white;
                border: none;
                border-radius: 20px;
                cursor: pointer;
            }
            .action-buttons button:hover {
                background-color: forestgreen;
            }
        </style>
    </head>
    <body>
        
        <h3>Here we go! Here's the Point of Interest Details..</h3>

    <c:forEach var="letter" items="${letters}">
        <a href="SearchServlet?searchType=location&letter=${letter}">${letter}</a>
    </c:forEach>


    <div class="searchResults">
        <h2>Search Results</h2>
        <c:choose>
            <c:when test="${empty searchResults}">
                <div class="error-message">No results found.</div>
            </c:when>
            <c:otherwise>
                <c:forEach var="poi" items="${searchResults}">
                    <div class="poi">
                        <h3>${poi.poi_name}</h3>
                        <p><strong>Type:</strong> ${poi.poi_type}</p>
                        <p><strong>Location:</strong> ${poi.poi_location}</p>
                        <p><strong>Likes:</strong> ${poi.poi_likes}</p>
                        <div class="action-buttons">
                            <form action="LikePOIServlet" method="post">
                                <input type="hidden" name="poiId" value="${poi.poi_id}">
                                <button type="submit">Like</button>
                            </form>
                            <form action="CommentServlet" method="post">
                                <input type="hidden" name="poiId" value="${poi.poi_id}">
                                <button type="submit">Comment</button>
                            </form>
                        </div>


                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>

</body>
</html>
