<%-- 
    Document   : Comments
    Created on : 8 Feb 2024, 20:50:54
    Author     : aless
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Comments</title>
        <style>
            body {
                background-color: bisque;
                text-align: center; 
                font-family: Arial, sans-serif; 
            }
            h2 {
                font-size: 36px; 
                color: darkgreen; 
                margin-top: 50px; 
            }
            .comment {
                background-color: #f9f9f9; 
                border: 1px solid #ccc; 
                padding: 10px; 
                margin: 20px auto; 
                max-width: 600px; 
                text-align: left; 
            }
            .comment p {
                margin: 10px 0;
            }
            .comment p strong {
                color: darkgreen; 
            }
            a {
                color: darkgreen; 
                text-decoration: none;
            }
            a:hover {
                text-decoration: underline; 
            }
        </style>
    </head>
    <body>
        <h2>Comments</h2>
    <c:forEach var="comment" items="${commentsList}">
        <div class="comment">
            <p><strong>${comment.user_name}:</strong> ${comment.comment_text}</p>
            <p>Posted at: ${comment.timestamp}</p>
        </div>
    </c:forEach>

    <a href="PointOfInterest.jsp">Back to Points of Interest</a>
</body>
</html>
