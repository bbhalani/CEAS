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
	<h1>All Ph.D Students</h1>
	<div class="panel panel-default">
    	<div class="panel-body">
		<table class="table table-striped">
		
    	<thead>
      	<tr>
        	<th>Name</th>
        	<th></th>
        	<th></th>
        	<th></th>
      	</tr>
    	</thead>
    	<tbody>
    	<c:forEach var="StudentList" items="${sessionScope.StudentList}">
    	<form action ="PhDStudentController" method = "get">
      	<tr>
        	<td>${StudentList.firstname} ${StudentList.lastname}</td>
        	<c:choose>
            
            <c:when test="${StudentList.adviserid == sessionScope.NetId}">
            <td><input type="hidden" name="StudentId" value="${StudentList.netid}"></td> 
            <td><input type="submit" name="ViewDetails" value="ViewDetails" /></td>
            <td><input type="hidden" name="flag" value="ViewPhDStudentDetail"></td>
            </c:when>
            <c:otherwise>
            <TD></TD>
            <td></td>
            <td></td>
            </c:otherwise>
            
            </c:choose>
      	</tr>
      	</form>
		</c:forEach>
		</tbody>
  		</table>
		</div>
	</div>
</div>
</body>
</html>