<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Discussion Detail</title>
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
	<h1>Discussion</h1>
	<div class="panel panel-default">
    	<div class="panel-body">
    	<form action="DiscussionBoardController" role="form" method="post">
	
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txtQuestion">Post Question</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" name="txtQuestion" placeholder="Enter link"><br>
				</div>
				</div>
				<div class="form-group">
				<div class="col-sm-4"></div>
  				<div class="col-sm-4">
  					<br><button type="submit" class="btn btn-default btn-block" >Post Question</button><br>
  					<input type="hidden" name="flag" value="AddQuestion">
  					<input type="hidden" name="DiscussionId" value="${sessionScope.DiscussionId}">
  				</div>
  				</div>
		</form>
		</div>
		</div>
		
		
		
		
		
		
	<div class="panel panel-default">
    	<div class="panel-body">
    	
    	
    	<%ArrayList<Map> DiscussionDetails=  (ArrayList<Map>)session.getAttribute("DiscussionDetail");
    	ArrayList<Map> temp=  (ArrayList<Map>)session.getAttribute("DiscussionDetail");
    	String DiscussionId = (String)session.getAttribute("DiscussionId");
		Iterator<Map> it = DiscussionDetails.iterator();
		Iterator<Map> itt = temp.iterator();
		Map m;
		
			m = itt.next();
	      int c = 0;
		while(it.hasNext()){
			Map map = it.next();
			try{
				m = itt.next();
				}catch(Exception e){
				c++;	
				}
			
		%>
    	
    	
    	
    	<form action ="DiscussionBoardController" method = "get">
    	
    	<table class="table table-striped">
    	
    	
    	<%if(!map.get("QQuestion").equals("")){ %>
      	<tr>
        	<th class="col-sm-8"><%=map.get("QQuestion") %></th>
        	<th class="col-sm-4"><%out.print(map.get("RFirstName")+" "+map.get("RLastName")+" on "+map.get("QDateCreated")); %> </th>
                	
        	<th></th>
        	</tr>
        	<%} %>
      	
      
       <%-- <td colspan="2">${DiscussionList.QDateCreated}</td></tr> --%>
     
            <tr>
            <td class="col-sm-2"></td>
            <td class="col-sm-10"><%=map.get("RPreply") %></td>
            <td><input type="hidden" name="QuestionId" value="<%=map.get("QidQuestionId")%>"/></td>
            </tr>
            
            
            
            <%if(!m.get("QidQuestionId").equals(map.get("QidQuestionId"))) {%>
            <tr>
            <td><input type="hidden" name="DiscussionId" value="<%=DiscussionId%>"></td>
            <td><input type="text" name="txtReply" placeholder="reply to this post" /></td>
            <td><input type="submit" name="replyButton" value="reply" /></td>           
            <td><input type="hidden" name="flag" value="AddReply"></td>
           <%--  <TD><input type="hidden" name="id" value="${DiscussionDetail.QidQuestionId}"></TD> --%>
            </tr>
           <%}else{
        	   if(c==1){ %>
        		   <tr>
            <td><input type="hidden" name="DiscussionId" value="<%=DiscussionId%>"></td>
            <td><input type="text" name="txtReply" placeholder="reply to this post" /></td>
            <td><input type="submit" name="replyButton" value="reply" /></td>           
            <td><input type="hidden" name="flag" value="AddReply"></td>
           <%--  <TD><input type="hidden" name="id" value="${DiscussionDetail.QidQuestionId}"></TD> --%>
            </tr>
        	  <% }}
        	   %>
           
            

      	</table>
      	</form>
		<%
		} %>
		
		
  	
		</div>
	</div>
</div>
</body>
</html>