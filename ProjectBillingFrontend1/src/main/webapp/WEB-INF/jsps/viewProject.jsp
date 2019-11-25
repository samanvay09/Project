<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill by Project</title>
</head>
<body>
<div id="blankspace" >

<h2 align="center">Project Billing</h2><hr>
<core:if test="${param.errorMsg ne null}">
	    		<div class="alert alert-danger">
	    			${param.errorMsg}
	    		</div>
    		</core:if>	
    		
    		<form action="BillProject"  method="get">
		<label>Projects:</label>
		<div>
		
		
		<select name="projectId">
		
		<core:forEach items="${pro}" var="pOb">
            <option value="${pOb.projectId}">${pOb.projectName}</option>
             </core:forEach>
             
              </select><br>
		</div>
		
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
					
					<label>Year :</label>
		<input type="number" name="year" size="30" class="form-control" placeholder="Select Year" required/><br>
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
	</div>

</body>
</html>