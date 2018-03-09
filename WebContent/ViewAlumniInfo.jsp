<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ph.D Student Detail</title>
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
<jsp:include page="AlumniSidebar.jsp"></jsp:include>
<div class="container">
	<h1>Student Details</h1>
	<div class="panel panel-default">
    	<div class="panel-body">
		<table class="table table-striped">
    	<thead>
      	
    	</thead>
    	<tbody>
    	<c:forEach var="AlumniList" items="${sessionScope.AlumniList}">
    	<form action ="AlumniController" method = "get">
      	<tr><th class="col-sm-2">Name</th>
        	<td class="col-sm-10">${AlumniList.FirstName} ${AlumniList.LastName}</td>
        </tr>
        <tr>
        	<th class="col-sm-2">Address</th>
        	<td class="col-sm-10">${AlumniList.Address}</td>
      	</tr>
      	<tr>
      		<th class="col-sm-2">City</th>
      		<td class="col-sm-10">${AlumniList.City}</td>
      	</tr>
      	<tr>
      		<th class="col-sm-2">State</th>
      		<td class="col-sm-10">${AlumniList.State}</td>
      	</tr>
      	        <tr>
        	<th class="col-sm-2">Country</th>
        	<td class="col-sm-10">${AlumniList.Country}</td>
      	</tr>
      	        <tr>
        	<th class="col-sm-2">Zip</th>
        	<td class="col-sm-10">${AlumniList.Zip}</td>
      	</tr>
      	        <tr>
        	<th class="col-sm-2">Univesity Emailid</th>
        	<td class="col-sm-10">${AlumniList.UniversityEmail}</td>
      	</tr>
      	 <tr>
        	<th class="col-sm-2">Joining Year</th>
        	<td class="col-sm-10">${AlumniList.JoiningYear}</td>
      	</tr>
      	        <tr>
        	<th class="col-sm-2">Graduation Year</th>
        	<td class="col-sm-10">${AlumniList.GraduationYear}</td>
      	</tr>
      	        <tr>
        	<th class="col-sm-2">Employer</th>
        	<td class="col-sm-10">${AlumniList.Employer}</td>
      	</tr>
      	        <tr>
        	<th class="col-sm-2">Job Title</th>
        	<td class="col-sm-10">${AlumniList.JobTitle}</td>
      	</tr>
      	        <tr>
        	<th class="col-sm-2">Contact No</th>
        	<td class="col-sm-10">${AlumniList.ContactNo}</td>
      	</tr>
      	<tr>
      	<c:choose>
            
            <c:when test="${AlumniList.Adder == sessionScope.NetId}">
            <td><input type="hidden" name="AlumniId" value="${AlumniList.idAlumniId}"></td> 
            <td><input type="submit" name="Update" value="Update" /></td>
            <td><input type="hidden" name="flag" value="UpdateAlumniInfo"></td>
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