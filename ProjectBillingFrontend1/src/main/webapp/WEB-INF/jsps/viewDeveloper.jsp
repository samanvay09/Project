<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.header-right {
  float: right;
  
}

.form
{
width:40%;
text-align:center;
margin-left:30%;

}
</style>
</head>
<body>
<div class="header-right" style= "font-size:30px">
  <a href="logout">Logout</a>
  </div>
<h1 style="text-align: center;font-family: verdana;color:#000080">View Developer </h1>
<div class="form">
<fieldset>
<legend>View Developer</legend>
<form action="Bill"  method="get">

<div>
						<label>Developer Name :</label>
						<select name="devId" class="form-control" >
						 	 <core:forEach items="${devL}" var="pOb">
								<option value="${pOb.devId.devId}" >${pOb.devId.devName}</option>
							 </core:forEach>
						</select><br>
					</div>
                    <br/>
                     <div>
						<label>Month :</label>
						<select  name="month" class="form-control" required="true">
							<option value="january">January</option>
							<option value="february">February</option>
							<option value="march">March</option>
							<option value="april">April</option>
							<option value="may">May</option>
							<option value="june">June</option>
							<option value="july">July</option>
							<option value="august">August</option>
							<option value="september">September</option>
							<option value="october">October</option>
							<option value="november">November</option>
							<option value="december">December</option>
						</select>
						<br>
					</div>
					<br/>
					
					<div>
					<label>Year :</label>
					<input type="number" name="year" size="30" class="form-control" placeholder="Select Year" required/><br>
					</div>
					<br/>
					
					<div class="form-group">
							    <button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form>
				</fieldset>
				</div>

</body>
</html>