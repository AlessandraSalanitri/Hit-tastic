<%-- 
    Document   : PointOfInterest
    Created on : 8 Feb 2024, 20:05:06
    Author     : aless
--%>

<%@page import="java.util.List"%>
<%@page import="Entities.PointOfInterest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Point of Interest</title>
        <style>
            body {
                background-color: bisque; /*background color */
                text-align: center; /* Center-aligned text */
                font-family: 'Gabriola', sans-serif; /*font family */
            }
            h1, h3 {
                color: darkgreen;
                margin: 20px 0;
            }
            h1 {
                font-size: 48px;
                font-family:'Gabriola', sans-serif;
            }
            h3 {
                font-size: 35px;
                font-family: 'Gabriola', sans-serif;
            }
            label {
                display: block;
                margin: 10px auto;
                color: darkgreen;
                font-size: 20px;
            }
            select, input[type="submit"] {
                font-size: 18px;
                padding: 10px;
                margin: 10px 0;
                border-radius: 5px;
                border: 1px solid darkgreen;
            }
            input[type="submit"] {
                background-color: darkgreen;
                color: white;
                cursor: pointer;
                width: 150px;
            }
            input[type="submit"]:hover {
                background-color: forestgreen;
            }
            #typeSelection, #locationLetterSelection {
                display: none;
            }
            a {
                color: darkgreen;
                text-decoration: none;
                font-size: 55px;
            }
            a:hover {
                text-decoration: underline;
            }
            #alphabetLinks span {
                margin: 0 5px;
            }
        </style>
    </head>
    <body>

        <h1>Discover Hundred Places Around the World</h1>
        <h3>Search by Location or Type</h3>

        <form action="searchPOIServlet" method="post">
            <label for="searchType" style="font-size: 35px;">Search by:</label><br>
            <select id="searchType" name="searchType">
                <option value="type"> Category </option>
                <option value="locationLetter"> Location </option>
            </select><br>


            <div id="typeSelection">
                <label for="poiType">Select Type:</label><br>
                <select id="poiType" name="poi_type">
                    <option value="Historical">Historical</option>
                    <option value="Leisure">Leisure</option>
                    <option value="Landmark">Landmark</option>
                </select><br>
            </div>


            <!-- input field for location selection -->
            <div id="locationLetterSelection" style="font-size: 35px;">
                <label for="poiLocation">Select Location:</label><br>

                <!-- alphabet links for location selection -->
                <h3>Select a letter for see all the Point Of Interest with that initial letter</h3>
                <span id="alphabetLinks">
                    <a href="searchPOIServlet?searchType=locationLetter&letter=A">A</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=B">B</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=C">C</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=D">D</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=E">E</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=F">F</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=G">G</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=H">H</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=I">I</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=L">L</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=M">M</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=N">N</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=O">O</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=P">P</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=Q">Q</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=R">R</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=S">S</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=T">T</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=U">U</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=V">V</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=Z">Z</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=W">W</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=Y">Y</a> |
                    <a href="searchPOIServlet?searchType=locationLetter&letter=J">J</a> |
                    <br>
                </span>
                <br>
            </div>

            <input id="searchButton" type="submit" value="Search">
        </form>

        <script>
            document.getElementById("searchType").addEventListener("change", function () {
                var type = this.value;
                var form = document.querySelector("form"); // Assuming there's only one form
                if (type === "type") {
                    document.getElementById("typeSelection").style.display = "block";
                    document.getElementById("locationLetterSelection").style.display = "none";
                    form.action = "searchPOIServlet"; // Update form action if necessary
                } else if (type === "locationLetter") {
                    document.getElementById("typeSelection").style.display = "none";
                    document.getElementById("locationLetterSelection").style.display = "block";
                    form.action = "searchPOIServlet"; // Update form action if necessary
                }
            });
        </script>


    </body>
</html>
