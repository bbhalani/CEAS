<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css" yu="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

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

<%
	User user = (User)session.getAttribute("USER");
	//System.out.println(user.getFirstName());
	
	if(!(user==null))
	{
%>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
		<!-- logo -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mainNavBar">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a href="#" class="navbar-brand">UAlbany CS Department</a>
			</div>
		<!-- menu Items -->
			<div class="collapse navbar-collapse" id="mainNavBar">
				<ul class="nav navbar-nav">
					<li class="active">
						<a href="header.jsp">Home</a>
					</li>
					<li>
						<a href="AddCourse.jsp" id="Course">Course</a>
					</li>
					<li>
						<a href="PhDStudentController?flag=ViewPhDStudents" id="StudentStatus" >View Ph.D Student</a>
					</li>
					<li>
						<a href="AddResourceType.jsp" id="Resources">Resources</a>
					</li>
					<li>
						<a href="AnnouncementController?flag=ViewEvent" id="Announcements">Announcements</a>
					</li>
					<li>
						<a href="DiscussionBoard.jsp" id="DiscussionBoard">Discussion Board</a>
					</li>
					<li>
						<a href="AddAlumniInfo.jsp" id="AlumniInfo">Alumni Info</a>
					</li>
					<li>
						<a href="AddExam.jsp" id="Exam">Exam</a>
					</li>
				</ul>	
				<ul class="nav navbar-nav navbar-right">
				
						<!-- <a data-toggle="dropdown" href="#"> -->
						<li><a href="#"><span class="glyphicon glyphicon-user"> Hi ${username}  </span></a></li>
						<li><a href="logout.jsp"><span class="glyphicon glyphicon-log-out"> Logout</span></a></li>
					
				</ul>
			</div>
		</div>
	</nav>
	
	<%} 
	else
	{
		request.getRequestDispatcher("login.jsp").forward(request, response);		
	}
	%>
</body>
</html>