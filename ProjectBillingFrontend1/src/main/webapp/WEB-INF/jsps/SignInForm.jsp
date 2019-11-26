<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style> 
input[type=text],input[type=password] {
  width: 130px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
  background-color: white;
  background-image: url('searchicon.png');
  background-position: 10px 10px; 
  background-repeat: no-repeat;
  padding: 12px 20px 12px 40px;
  -webkit-transition: width 0.4s ease-in-out;
  transition: width 0.4s ease-in-out;
}

.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: green;
   color: white;
   text-align: center;
}

input[type=text]:focus,input[type=password]:focus {
  width: 100%;
}

body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}



/* Float cancel and signup buttons and add an equal width */
 .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
  padding: 16px;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
   .signinbtn {
     width: 100%;
  }
}
.fixed-header {
        width: 100%;
        position: fixed;        
        background:#008000;
        padding: 10px 0;
        color: #80e5ff;
    }
    .fixed-header{
        top: 0;
    }
    .container{
        width: 100%;
         text-align: center; /* Center the DIV horizontally */
    }
    
</style>

</head>
<body>

<div class="fixed-header">
        <div class="container">
            <nav>
                 <h1>IRIS SOFTWARE</h1>   
            </nav>
        </div>
    </div>
	
		<form action="signIn"    method="post"  >
			<div style="padding-top: 200px"class="container">
  
    
    

    <label for="UserId"><b>UserId</b></label>
    <input type="text" placeholder="Enter User Id" name="userId" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    
    
    
    
   

    <div class="clearfix">
      
      <button type="submit" class="signinbtn">Sign In</button>
    </div>
  </div>
		</form>
		
		<div class="footer">
  <p>@Copyright 2015-2022</p>
  <p>All rights reserved . Powered by the Iris platform.
</div>
</body>
</html>