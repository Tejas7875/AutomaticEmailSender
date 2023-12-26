<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Email List</title>

    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="styles.css">

    <!-- Add your custom CSS styles -->
    <style>
        /* Custom background styles */
        body {
            background-image: url('https://wallpaperaccess.com/full/1471777.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            margin: 0;
            padding: 0;
        }

        /* Style for the content area */
        .email-card {
            background-color: white;
            padding: 20px;
            border-radius: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            color: black;
            width: 75%; /* Adjust the width as needed */
            margin: 0 auto; /* Center the card horizontally */
        }

        table {
            width: 100%; /* Adjust the width as needed */
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid black;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

    .custom-button {
                   background-color: #007BFF;
                   color: #fff;
                   padding: 10px 20px;
                   border: none;
                   border-radius: 5px;
                   cursor: pointer;
                   color: white;
                   margin-right: 10px; /* Add spacing between buttons */
               }

        .navbar-buttons {
            display: flex;
            flex-direction: row; /* Arrange buttons horizontally */
            gap: 10px;
        }
    </style>
</head>
<body>
     <!-- Navbar with buttons -->
       <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" style="background-color: rgba(255, 255, 255, 0.8);">
           <a class="navbar-brand" href="#">Automated Emailing App</a>
           <div class="collapse navbar-collapse" id="navbarNav">
               <ul class="navbar-nav">
                   <!-- Button to navigate to the "Add Email" page -->
                   <li class="nav-item">
                       <a href="addEmail" class="custom-button btn btn-primary nav-link">Add Email</a>
                   </li>

                   <!-- Button to navigate to the "listEmails" page -->
                   <li class="nav-item">
                       <a href="listEmails" class="custom-button btn btn-primary nav-link">Mail List</a>
                   </li>

                    <!-- Button to navigate to the "Compose" page -->
                    <li class="nav-item">
                         <a href="compose" class="custom-button btn btn-primary nav-link">Compose Email</a>
                    </li>

               </ul>
           </div>
       </nav>
    <div class="email-card">
        <h1>Email List</h1>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Email</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${emails}" var="emailEntity">
                    <tr>
                        <td>${emailEntity.email}</td>
                        <td>
                           <form action="/deleteEmail" method="post">
                               <input type="hidden" name="id" value="${emailEntity.email}" />
                               <button type="submit" class="btn btn-danger">Delete</button>
                           </form>

                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
