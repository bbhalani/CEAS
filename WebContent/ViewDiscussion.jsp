<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Discussion</title>
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
<jsp:include page="DiscussionBoardSidebar.jsp"></jsp:include>
<div class="container">
	<h1>All Discussion Topic</h1>
	<div class="panel panel-default">
    	<div class="panel-body">
    	<c:forEach var="DiscussionList" items="${sessionScope.DiscussionList}">
    	<form action ="DiscussionBoardController" method = "get">
    	<table class="table table-striped">
    	<thead>
      	<tr>
        	<th>${DiscussionList.Topic}</th>
      	<tr>
      	</thead>
      	<tbody>
	        <tr><td class="col-sm-8">Posted by : ${DiscussionList.FirstName} ${DiscussionList.LastName}</td><td colspan="2">${DiscussionList.DateCreated}</td></tr>
        	<tr><td><input type="hidden" name="DiscussionId" value="${DiscussionList.idDiscussiontopicId}"/></td>
            <td><input type="submit" name="ViewDetails" value="ViewDetails" /></td>
            <td><input type="hidden" name="flag" value="ViewDiscussionDetails"></td>
            </tr>
      	</tbody>
      	</table>
      	</form>
		</c:forEach>
		</div>
	</div>
</div>
</body>
</html>