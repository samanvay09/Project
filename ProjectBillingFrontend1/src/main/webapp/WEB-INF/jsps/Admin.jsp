<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>


<div align="center">
<h1 style="background-color:lightblue;padding-left:500px;padding-right:50px ">Welcome Admin <a href="logout" style=" padding-left:400px; text-align:right">Logout</a></h1>
</div>
<div class="dropdown" align="right">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
      Admin Options
    </button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="Configurat">Configure Billing</a>
      <a class="dropdown-item" href="Allocation">Allocate Project</a>
      <a class="dropdown-item" href="viewDeveloper">View Developer</a>
      <a class="dropdown-item" href="viewProject">View Project</a>
      
    </div>
    
    
    
</body>
</html>