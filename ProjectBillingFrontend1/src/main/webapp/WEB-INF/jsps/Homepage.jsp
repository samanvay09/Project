<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>



.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: green;
   color: white;
   text-align: center;
}

.flip-card {
  background-color: transparent;
  width: 300px;
  height: 300px;
  perspective: 1000px;
}

.flip-card-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.6s;
  transform-style: preserve-3d;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
}

.flip-card:hover .flip-card-inner {
  transform: rotateY(180deg);
}

.flip-card-front, .flip-card-back {
  position: absolute;
  width: 100%;
  height: 100%;
  backface-visibility: hidden;
}

.flip-card-front {
  background-color: #bbb;
  color: black;
}

.flip-card-back {
  background-color: #2980b9;
  color: white;
  transform: rotateY(180deg);
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
 
<h2 align="center" style="padding-top:100px;font-size:30px;font-family: verdana">Project Billing Management System</h2>
<div align="center">
<a href="getSignInForm"><h2>Click Here To Log In<h2></a><br/>
</div>
<div>
<p>${msg}</p>
</div>
<div class="flip-card">
  <div class="flip-card-inner">
    <div class="flip-card-front">
      <img src="${path}/resources/images/iris.gif" alt="Avatar" style="width:300px;height:300px;">
    </div>
    <div class="flip-card-back">
      <h1>Samanvay Jain</h1> 
      <p>Graduate Engineer Trainee</p> 
      <p>IRIS SOFTWARE</p>
    </div>
  </div>
</div>

<div class="footer">
  <p>@Copyright 2015-2022</p>
  <p>All rights reserved . Powered by the Iris platform.
</div>
</body>
</html>