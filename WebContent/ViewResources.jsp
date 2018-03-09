<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Courses</title>
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
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="ResourceSidebar.jsp"></jsp:include>
<div class="container">
	<h1>All Courses</h1>
	<div class="panel panel-default">
    	<div class="panel-body">
		<table class="table table-striped">
    	<thead>
      	<tr>
        	<th>Course No.</th>
        	<th>Course Name</th>
      	</tr>
    	</thead>
    	<tbody>
    	<c:forEach var="CourseList" items="${sessionScope.CourseList}">
      	<tr>
        	<td>${CourseList.courseno}</td>
        	<td>${CourseList.coursename}</td>
      	</tr>
		</c:forEach>
		</tbody>
  		</table>
		</div>
	</div>
</div>
</body>
</html>