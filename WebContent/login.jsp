<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src = "js/jquery-1.12.3.min.js" type = "text/javascript"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="js/bootstrap.min.js" type = "text/javascript"></script>

</head>
<body>
<div class="container">
<form action="LoginController" role="form" method="post">
		<div class="modal-dialog">
		<div class="modal-content">
		<!-- Header -->
		<div class="modal-header">
			
			<h2 class="modal-title">Log In</h2>
		</div>
		<!-- body -->
		<div class="modal-body">
			
				<div class="form-group">
					<input type="text" class="form-control" name="txtNetId" placeholder="Enter your Net Id">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" name="txtPassword" placeholder="Enter your Password">
				</div>
			
		</div>
		<!-- button -->
		<div>
		<a href="Registration.jsp" class="btn btn-link">Not Registered? Click here to register</a>
		</div><br>
		<div class="modal-footer">
			<input type="submit" class="btn btn-primary btn-block"  value = "Log in">	
		</div>
		
		</div>
		</div>
		</form>
	</div>
</body>
</html>