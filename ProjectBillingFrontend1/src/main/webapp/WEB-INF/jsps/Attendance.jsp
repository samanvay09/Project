<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendance</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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

<h1 style="text-align: center;font-family: verdana;color:#000080">Attendance! </h1>
<div class="form">
<fieldset>
<legend>Allocation</legend>
<f:form action="submitAttendance" modelAttribute="dataObj" method="get">
<div>
<label>Projects:</label>
			<f:select path="projectId.projectId"  id="projects">
			<f:option value="0">----Select Project--------</f:option>
			<core:forEach items="${pro}" var="pOb">
            <f:option value="${pOb.projectId}">${pOb.projectName}</f:option>
             </core:forEach>
             
             </f:select><br>
             
             </div>
             
             <br/>
             <div>
		<label>Developer Name :</label>
		<f:select path="devId.devId" id="developer" cssClass="form-control">
 	 		<f:option value="0">----Select Developer--------</f:option>
		</f:select><br>
		<div id="msg"></div>
		</div>
		
		
             <br/>
		
		<div>
		<label>Month :</label>
		<f:select path="month" cssClass="form-control" required="true">
		<f:option value="january">January</f:option>
			<f:option value="february">February</f:option>
			<f:option value="march">March</f:option>
			<f:option value="april">April</f:option>
			<f:option value="may">May</f:option>
			<f:option value="june">June</f:option>
			<f:option value="july">July</f:option>
			<f:option value="august">August</f:option>
			<f:option value="september">September</f:option>
			<f:option value="october">October</f:option>
			<f:option value="november">November</f:option>
			<f:option value="december">December</f:option>
		</f:select>
		<br>
		</div>
		
		
             <br/>
		
		<div>
		<label>Year :</label>
		<f:select path="year" id="year" cssClass="form-control" required="true">
			<f:option value="0">Select year</f:option>
		</f:select>
		
		<script type="text/javascript">
			for(y=2015;y<2029;y++){
				var optn = document.createElement("OPTION");
				optn.text=y;
				optn.value=y;
				
				if(y==2019){
					optn.selected=true;
				}
				document.getElementById('year').options.add(optn);
			}
		</script>
		</div>
	
             <br/>
		
		<div>
		<label>Half day:</label>
		<f:input path="halfDay" size="30" cssClass="form-control" placeholder="Enter Number of Half Days" required="true"/><br>
		</div>
		
		
             <br/>
		
		<div>	
			<label>Full Day:</label>
			<f:input path="fullDay" size="30" cssClass="form-control" placeholder="Enter Number of Full Days" required="true"/><br>
		</div>
		
		
             <br/>
		
		<div class="form-group">
		    <button type="submit" class="btn btn-primary">Submit</button>
		 </div>
	</f:form>
	</fieldset>
	</div>
	<script type="text/javascript">
	$('select#projects').on('change', function() {
		$('#developer').empty()
		console.log('I m here');
		$("div#msg").html("");
		var projectId=this.value;
		console.log('ProjectId : '+projectId);
		$.get("getDeveloperList?projectId="+projectId, function(data, status){
		
			 console.log(data.length);
			    if(data.length!=0){
			    console.log('I m in if');
			    data.forEach(function(el, index) {
			    	console.log('Hello I m in for Each..');
			    	 console.log(el.devId+" "+el.devName);
			    	 
			    	 var o = new Option(el.devName, el.devId);
			    	 $(o).html(el.devName);
	                 $("#developer").append(o)
			    });
			    }
			    else {
			    	console.log('I m in else');
			    	$("div#msg").html("No Developer exist for the given project...");
			    	
			    	$("#developer").hide();
		}
		 });
	
	});
	
	</script>	
	
	
	</body>
</html>