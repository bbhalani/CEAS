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
<div id="wrapper">
	<!-- Sidebar -->
    <div id="sidebar-wrapper">
		<ul class="sidebar-nav">
    	    <%-- <li class="sidebar-brand">
            	<a href="CourseController?FacultyId=${sessionScope.NetId}&flag=AddMyCourseInfo">
            	Update My Course Info
            	</a>
           	</li> --%>
           	<li class="sidebar-brand">
           		<a href="PhDStudentController?flag=ViewPhDStudents">View All Ph.D Students</a>
            </li>
            <!-- <li class="sidebar-brand">
                <a href="ViewMyCourseInfo.jsp">View My Course Info</a>
            </li> -->
		</ul>
    </div>
</div>
<!-- /#wrapper -->
<div class="container">
	<h1>Student Details</h1>
	<div class="panel panel-default">
    	<div class="panel-body">
		<table class="table table-striped">
    	<thead>
      	
    	</thead>
    	<tbody>
    	<c:forEach var="StudentDetail" items="${sessionScope.StudentDetail}">
      	<tr><th class="col-sm-2">Name</th>
        	<td class="col-sm-10">${StudentDetail.firstname} ${StudentDetail.lastname}</td>
        </tr>
        <tr>
        	<th class="col-sm-2">Student Id</th>
        	<td class="col-sm-10">${StudentDetail.studentid}</td>
      	</tr>
      	<tr>
      		<th class="col-sm-2">Year Joined</th>
      		<td class="col-sm-10">${StudentDetail.yearjoined}</td>
      	</tr>
      	<tr>
      		<th class="col-sm-2">Current Sem </th>
      		<td class="col-sm-10">${StudentDetail.noofcurrentsem}
		</c:forEach>
		</tbody>
  		</table>
		</div>
	</div>
</div>
</body>
</html>