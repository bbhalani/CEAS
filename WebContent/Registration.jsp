<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css" yu="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<script src = "js/jquery-1.12.3.min.js" type = "text/javascript"></script>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous" type = "text/javascript"></script>
</head>
<body>
<%String msg=(String)request.getAttribute("msg"); %>

<c:if test="${not empty msg}">
    <script>   
    window.addEventListener("load",function(){
         var r=confirm("${msg}");
         if (r) {
             window.location.href='login.jsp';
         } else {
        	 window.location.href='Registration.jsp';
         }
    });
    </script>
</c:if>
<script type="text/javascript">

//Abhinav’s Work
$(document).ready(function(){
    $('input[type="radio"]').click(function(){
        if($(this).attr("value")=="Student"){
          $(".hideMe").show();
        }
        if($(this).attr("value")=="Faculty"){
            $(".hideMe").hide();
        }
        if($(this).attr("value")=="Staff"){
          $(".hideMe").hide();
        }
    });
});

</script>
	<div class="container">
	<form action="RegistrationController" method="post" role="form">
	<h1>Registration</h1>
	<div class="panel panel-default">
    <div class="panel-body">
  
		
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtNetId">NetId:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtNetId" placeholder="UAlbany name"><br>
					</div>
				</div>	
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtPassword">Password:</label>
					<div class="col-sm-10">
					<input type="password" class="form-control" name="txtPassword" placeholder="Password"><br>
				</div>
				</div>
				<label class="col-sm-2 control-label" for="rdbtnRole">Role:</label><br>
				<div class="col-sm-10">
				<div class="radio-inline">
  					<input type="radio" name="rdbtnRole" value="Student" >Student<br>
  					<input type="radio" name="rdbtnRole" value="Faculty" >Faculty<br>
  					<input type="radio" name="rdbtnRole" value="Staff" >Staff<br><br>
  				</div>
  				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtFirstname">First name:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtFirstname" placeholder="First name"><br>
				</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtLastname">Last name:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtLastname" placeholder="Last name"><br>
				</div>
				</div>
				<div class="form-group hideMe">
					<label class="col-sm-2 control-label" for="txtYearJoined" >Year of Joining:</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtYearJoined" placeholder="Year of join" ><br>
				</div>
				</div>
				<label class="col-sm-2 control-label hideMe" for="rdbtnProgram">Program:</label><br>
				<div class="col-sm-10 hideMe">
				<div class="radio-inline">
					
  					<input type="radio" name="rdbtnProgram" value="BS" >BS<br>
  					<input type="radio" name="rdbtnProgram" value="BA" >BA<br>
  					<input type="radio" name="rdbtnProgram" value="MS" >MS<br>
  					<input type="radio" name="rdbtnProgram" value="Ph.D" >Ph.D<br>
  					
  				</div>
  				</div>
  				<p>
  				<div class="form-group">
  				<div class="col-sm-12">
  					<br><button type="submit" class="btn btn-primary btn-block">Register</button><br>
  				</div>
  				</div>
			
		</div>	
		</div>
		</form>
	</div>
</body>
</html>