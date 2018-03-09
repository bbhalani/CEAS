<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Events</title>
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
<jsp:include page="AnnouncementSidebar.jsp"></jsp:include>
<%String msg=(String)request.getAttribute("msg"); %>

<c:if test="${not empty msg}">
    <script>   
    window.addEventListener("load",function(){
         var r=confirm("${msg}");
         if (r) {
             window.location.href='ViewAnnouncement.jsp';
         } else {
        	 //window.location.href='CourseController?flag=ViewCourses';
         }
    });
    </script>
</c:if>
<div class="container">
	<h1>Events</h1>
	<div class="panel panel-default">
    	<div class="panel-body">
    	<form action="AnnouncementController" role="form" method="post">
			
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtEvent">Event Information:</label>
					<div class="col-sm-10">
					<textarea class="form-control" name="txtEvent" placeholder="Enter Event Information"></textarea><br>
				</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtLink">Link</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtLink" placeholder="Enter link"><br>
				</div>
				</div>
				<div class="form-group">
				<div class="col-sm-4"></div>
  				<div class="col-sm-4">
  					<br><button type="submit" class="btn btn-default btn-block" >Add</button><br>
  					<input type="hidden" name="flag" value="AddEvent">
  				</div>
  				</div>
		</form>
		</div>
		</div>
		<div class="panel panel-default">
    	<div class="panel-body">
		<table class="table table-striped">
		
    	<c:forEach var="EventList" items="${sessionScope.EventList}">
    	<form action ="AnnouncementController" method = "get" role="form">
      	<tr>
      		<th class="col-sm-2">Event</th>
        	<td class="col-sm-6">${EventList.content}</td>
        	<td class="col-sm-2">${EventList.creationdate}</td>
        	<c:choose>
            <c:when test="${EventList.announcerid == sessionScope.NetId}">
            <td><input type="hidden" name="AnnouncementId" value="${EventList.announcementid}"></td> 
            <td><input type="submit" name="Update/Delete" value="Update/Delete" /></td>
            <td><input type="hidden" name="flag" value="UpdateDeleteAnnouncement"></td>
            </c:when>
            <c:otherwise>
            <TD></TD>
            <td></td>
            <td></td>
            </c:otherwise>
            </c:choose>
      	</tr>
      	<tr>
      	<th class="col-sm-2">Link</th>
      	<td class="col-sm-6">
      	<a href="${EventList.link}" class="btn btn-link">${EventList.link}</a>
      	</td>
        <td class="col-sm-2"></td>
      	<td></td>
      	 <td></td>
            <td></td>
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