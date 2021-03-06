<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Resource</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css" yu="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="css/sidebar.css">
<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<script src = "js/jquery-1.12.3.min.js" type = "text/javascript"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous" type = "text/javascript"></script>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import = "model.User" %>
</head>
<body>
<script type="text/javascript">

</script>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="ResourceSidebar.jsp"></jsp:include>
<div class="container">
	<h1>Add New Resource</h1>
	<div class="panel panel-default">
    <div class="panel-body">
  
		<form action="ResourceController" role="form" method="post">
			<div class="form-group">
					<label class="col-sm-2 control-label" for="ddlResourceType">Resource Type:</label>
					<div class="col-sm-10">
					<div>
					<select class="form-control" name="ddlResourceType">
    					<option>Select Resource Type</option>
    					<c:forEach var="ResourceType" items="${sessionScope.ResourceType}">
      					<option value="${ResourceType.idResourceTypeId}">${ResourceType.ResourceType}</option>
      					</c:forEach>
      				    </select>
  					</div><br>
				</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtResourceName">Resource Name:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtResourceName" placeholder="Enter Unique Resource Name"><br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtDescription">Resource Information:</label>
					<div class="col-sm-10">
					<textarea class="form-control" name="txtDescription" placeholder="Resource Description"></textarea><br>
					</div>
				</div> 
				<div class="form-group">
  				<div class="col-sm-12">
  				<input type="hidden" name="flag" value="AddResource">
  					<br><button type="submit" class="btn btn-primary btn-block">Add</button><br>
  				</div>
  				</div>
	
			
		</form>
		
		</div>	
		</div>
				</div>
			</body>
</html>