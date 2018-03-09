<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddExam</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css" yu="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<script src = "js/jquery-1.12.3.min.js" type = "text/javascript"></script>
<!-- Latest compiled and minified JavaScript -->
<link rel="stylesheet" href="css/sidebar.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>
<script src="js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous" type = "text/javascript"></script>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import = "model.User" %>
<%@page import = "model.Course" %>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="ExamSidebar.jsp"></jsp:include>
<% String msg=(String)request.getAttribute("msg"); %>

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

	<div class="container">
	<h1>Add Exam</h1>
	<div class="panel panel-default">
    <div class="panel-body">
  
		<form action="ExamController" role="form" method="post">
			<div class="form-group">
					<label class="col-sm-2 control-label" for="txtExamName">Exam Name:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtExamName" placeholder="Enter exam name"><br>
				</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtExamDate">Exam Date:</label>
					<div class="col-sm-10">
					<input type="date" class="form-control" name="txtExamDate" placeholder="select date"><br>
					</div>
					</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtOptionalLinks">Optional Links</label>
					<div class="col-sm-10">
					<textarea class="form-control" name="txtOptionalLinks" placeholder="Enter optional links"></textarea><br>
					</div>
					</div>
				
          
			<div class="form-group">
  				<div class="col-sm-12">
  					<br><button type="submit" class="btn btn-default btn-block" >Add Exam</button><br>
  					<input type="hidden" name="flag" value="AddExam">
  				</div>
  				</div>
		</form>
		</div>	
		</div>
	</div>
</body>
</html>