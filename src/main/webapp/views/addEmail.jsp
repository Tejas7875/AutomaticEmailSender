<!DOCTYPE html>
<html>
<head>
    <title>Email Entry Form</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Include Custom CSS -->
    <link rel="stylesheet" type="text/css" href="styles.css">
    <!-- Include Google Fonts (Open Sans and Lobster) -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700|Lobster&display=swap" rel="stylesheet">


   <!-- Add your custom CSS styles -->
      <style>
          /* Your custom CSS styles can go here */
          .container {
              margin-top: 100px;
          }

           body {
                      background-image: url('https://wallpapercave.com/wp/wp5603596.jpg');
                      background-size: cover; /* Adjust this as needed */
                      background-repeat: no-repeat;
                      background-attachment: fixed; /* Fixed to prevent scrolling */
                      display: flex;
                      align-items: center;
                      justify-content: center;
                      min-height: 100vh;
                      margin: 0; /* Reset body margin */
                      padding: 0; /* Reset body padding */
                  }




          .jumbotron {
              background-color: #3498db; /* Blue background color */
              color: #ffffff; /* White text color */
              padding: 20px;
              border-radius: 10px;
          }

          h1
          {
              font-size: 36px;
          }

            .custom-button
            {
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

    <div class="container">
        <div class="row">
            <div class="col-lg-6 offset-lg-3">
                <div class="card mt-5">
                    <div class="card-body">
                        <h1 class="text-center fontlobster">Email Entry Form</h1>
                        <form action="saveEmail" method="post">
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Save Email</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Include Bootstrap JS (optional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
