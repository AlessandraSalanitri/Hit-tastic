<%-- 
    Document   : AddPointOfInterest
    Created on : 5 Feb 2024, 22:11:54
    Author     : aless
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Add Point of Interest</title>
    </head>
    <body>
        <h1>Add a Point of Interest</h1>
        <form action="AddNewPointOfInterestServlet" method="post">
            Name: <input type="text" name="poi_name"><br>
            Location: <input type="text" name="poi_location"><br>
            Type: <input type="text" name="poi_type"><br>
            <!-- Display likes count -->
            Likes: <span id="likesCount">0</span><br>
            <!-- Button to increment likes count -->
            <button type="button" onclick="incrementLikes()">Increment Likes</button><br>
            <input type="submit" value="Add Point of Interest">
        </form>

        <script>
            function incrementLikes() {
                // Fetch the current likes count
                var likesCountElement = document.getElementById("likesCount");
                var currentLikesCount = parseInt(likesCountElement.innerText);

                // Increment the likes count
                var newLikesCount = currentLikesCount + 1;

                // Update the likes count displayed on the page
                likesCountElement.innerText = newLikesCount;
            }
        </script>
    </body>
</html>