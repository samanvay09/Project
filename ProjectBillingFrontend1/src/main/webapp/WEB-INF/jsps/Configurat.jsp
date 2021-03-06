<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Configure</title>

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

<h1 style="text-align: center;font-family: verdana;color:#000080">Configure Here! </h1>

<core:if test="${param.msg ne null}">
	    		<div class="alert alert-success">
	    			${param.msg}
	    		</div>
    		</core:if>	
    		<core:if test="${param.errorMsg ne null}">
	    		<div class="alert alert-danger">
	    			${param.errorMsg}
	    		</div>
    		</core:if>
<div class="form">
<fieldset>
<legend>Configuration</legend>
 <f:form action="submitConfig" modelAttribute="pObj" method="get" id="projectform">
 <label>Projects:</label>
			<f:select path="projectId.projectId" >
            <core:forEach items="${pro}" var="pOb">
            <f:option value="${pOb.projectId}">${pOb.projectName}</f:option>
             </core:forEach>
             
             </f:select><br>
 			<div>
 			
 			<br/>
 			
			<label>Role:</label>
			<f:select path="roleId.roleId">
			<core:forEach items="${role}" var="rOb">
			<f:option value="${rOb.roleId}">${rOb.roleName} </f:option>
			 </core:forEach>
				</f:select><br>
			</div>
			
			<br/>
			
 		<label>Location:</label>
			<div>
			<div class="custom-control custom-radio">
			<f:radiobutton path="loc" value="Onsite" id="Onsite"/>
			<label  for="Onsite">Onsite</label>
				</div>
				<div class="custom-control custom-radio">
				<f:radiobutton path="loc" value="Offshore"  id="Offshore" checked = "checked"/>
					<label  for="Offshore">Offshore</label>
				</div>
			</div>	
			
			<br/>
			
 			<br><div >
 			<label>Per Hour Billing  : </label>
 			<f:input type="number" path="perHourBilling" size="30" cssClass="form-control" placeholder="Enter Per Hour Billing" required="required"/>
	    			<f:errors path="perHourBilling"></f:errors>	
	    			 </div>
	    			 
	    			 <br/>
			
			<div class="form-group">
			    <button type="submit" class="btn btn-primary">Submit</button>
			 </div>
 			
			
 </f:form>
 </fieldset>
 </div>
</body>
</html>