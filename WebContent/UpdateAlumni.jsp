<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UpdateAlumni</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css" yu="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<script src = "js/jquery-1.12.3.min.js" type = "text/javascript"></script>
<!-- Latest compiled and minified JavaScript -->
<link rel="stylesheet" href="css/sidebar.css">
<script src="js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous" type = "text/javascript"></script>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import = "model.User" %>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<%String msg=(String)request.getAttribute("msg"); %>

<c:if test="${not empty msg}">
    <script>   
    window.addEventListener("load",function(){
         var r=confirm("${msg}");
         if (r) {
             window.location.href='AddCourse.jsp';
         } else {
        	 window.location.href='CourseController?flag=ViewCourses';
         }
    });
    </script>
</c:if>
<jsp:include page="AlumniSidebar.jsp"></jsp:include>
	<div class="container">
	<h1>Update Alumni Info</h1>
	<div class="panel panel-default">
    <div class="panel-body">
  
		<form action="AlumniController" role="form" method="post">
		<c:forEach var="AlumniList" items="${sessionScope.AlumniList}">
		<td><input type="hidden" name="AlumniId" value="${AlumniList.idAlumniId}"/></td> 
			<div class="form-group">
					<label class="col-sm-2 control-label" for="txtFirstname">First name:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtFirstname" placeholder="First name" value="${AlumniList.FirstName}"><br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtLastname">Last name:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtLastname" placeholder="Last name" value="${AlumniList.LastName}"><br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtUniversityEmail" >University Email Id:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtUniversityEmail" placeholder="Enter your university email id" value="${AlumniList.UniversityEmail}"><br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtContactNo">Contact No:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtContactNo" placeholder="Contact No:" value="${AlumniList.ContactNo}"><br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtYearJoined" >Year of Joining:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtYearJoined" placeholder="Year of join"  value="${AlumniList.JoiningYear}"><br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtGraduationYear" >Graduation Year:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtGraduationYear" placeholder="Enter your graduation year" value="${AlumniList.GraduationYear}"><br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtAddress">Address:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtAddress" placeholder="Enter your address" value="${AlumniList.Address}"><br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtCity">City:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtCity" placeholder="Enter your city" value="${AlumniList.City}"><br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtState">State:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtState" placeholder="Enter State" value="${AlumniList.State}"><br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtCountry">Country:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtCountry" placeholder="Enter your country" value="${AlumniList.Country}"><br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtZip">Zip:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtZip" placeholder="Enter zip code" value="${AlumniList.Zip}"><br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtEmployer">Employer:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtEmployer" placeholder="Enter Employer" value="${AlumniList.Employer}"><br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtJobTitle">Job Title:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtJobTitle" placeholder="Enter Job Title" value="${AlumniList.JobTitle}"><br>
					</div>
				</div>
				<div class="form-group">
  					<div class="col-sm-12">
  						<br><button type="submit" class="btn btn-default btn-block" >Update</button><br>
  						<input type="hidden" name="flag" value="UpdateAlumni">
  					</div>
  				</div>
  				</c:forEach>
			</form>
		</div>	
		</div>
	</div>
	
	
</body>
</html>