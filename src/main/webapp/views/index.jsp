<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Welcome to Automated Emailing App</title>

    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="styles.css">

    <!-- Add your custom CSS styles -->
    <style>
        /* Custom background styles */
        body {
            background-image: url('https://wallpapercave.com/wp/wp5603596.jpg');
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

        /* Jumbotron and button styles */
        .jumbotron {
            background-color: #3498db; /* Blue background color */
            color: #ffffff; /* White text color */
            padding: 20px;
            border-radius: 10px;
        }

        h1 {
            font-size: 36px;
        }

        /* Style for the custom button */
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

        .custom-button:hover {
            background-color: #0056b3;
        }

        /* Style for the content area */
        .content {
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 10px;
            padding: 20px;
        }
    </style>
</head>
<body>
    <!-- Navbar with buttons -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" style="background-color: rgba(0, 0, 0, 0.5);">
        <a class="navbar-brand" href="#">Automated Emailing App</a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <!-- Button to navigate to the "Add Email" page -->
                <li class="nav-item">
                    <a href="addEmail" class="custom-button btn btn-primary nav-link">Add Email</a>
                </li>

                <!-- Button to navigate to the "listEmails" page -->
                <li class="nav-item">
                    <a href="listEmails" class="custom-button btn btn-success nav-link">Mail List</a>
                </li>

                 <!-- Button to navigate to the "Compose" page -->
                 <li class="nav-item">
                      <a href="compose" class="custom-button btn btn-success nav-link">Compose Email</a>
                 </li>

            </ul>
        </div>
    </nav>











    <!-- Add Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
