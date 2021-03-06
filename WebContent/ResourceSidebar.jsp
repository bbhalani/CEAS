<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ResourceSidebar</title>
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
<div id="wrapper">
	<!-- Sidebar -->
    <div id="sidebar-wrapper">
		<ul class="sidebar-nav">
		<li class="sidebar-brand">
            	<a href="AddResourceType.jsp">
            	Add Resource Type
            	</a>
           	</li>
           		<li class="sidebar-brand">
           		<a href="ResourceController?flag=GetResourceType">Add Resource</a>
            </li>
    	    <li class="sidebar-brand">
            	<a href="ResourceController?NetId=${sessionScope.NetId}&flag=">
            	Reserve Resource
            	</a>
           	</li>
           
            <li class="sidebar-brand">
                <a href="ExamController?NetId=${sessionScope.NetId}&flag=ViewMyExams">Post/Update Exam Results</a>
            </li>
		</ul>
    </div>
</div>
<!-- /#wrapper -->
</body>
</html>