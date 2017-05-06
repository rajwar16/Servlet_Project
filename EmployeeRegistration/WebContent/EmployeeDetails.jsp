<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List"%>
<%@ page import="java.sql.ResultSet" %>
<% List employeeDeatailss = (List)session.getAttribute("employeeDeatailss");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Details</title>
<style>
input[type=submit] 
{
	border: none;
	border-radius: 8px;
    color: white;
    padding: 13px 30px;
    text-align: right;
    text-decoration: none;
    background-color: #4CAF50;
    display: inline-block;
    font-size: 16px;
}

td,th
{
	text-align:center;
	cellspacing: 30px;
	font-size: 18px;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include><br>
  <div class="container text-center">
  <!-- <div style="height: 696px; width: 1274px; background-color: gray; color: white; float: left;"> -->
    		
			<div style="height: 696px; width: 820px; background-color: white; color: black; float: left;">
			
				<form action="EmployeeDetails" method="get" name="myform"  onsubmit="validateform()">
				
				<%-- <table style="height:700;width:700;margin:40px;background-color:white;color:black">
					<%String id = (String)request.getAttribute("id");%>
					<%String name = (String)request.getAttribute("ename");%>
					<%String gender = (String)request.getAttribute("gender");%>
					<%String emilid = (String)request.getAttribute("emilid");%>
					<%String address = (String)request.getAttribute("address");%>
					<%String specialized = (String)request.getAttribute("specialized");%>
					<%String language = (String)request.getAttribute("language");%>
					<%String contacNo = (String)request.getAttribute("contacNo");%>
					<%String age = (String)request.getAttribute("age");%>
					<%String salary = (String)request.getAttribute("salary");%> --%>
					
					<%-- <table cellspacing="30px" style="border:1px; height: 500; width: 700; margin: 50px; padding-right:20; color: black;">
					<%=employeeDeatailss%>
						<tr style="padding: 15px;">
							<th colspan="2"><h3>Employ Registration Form</h3></th>
						</tr>
						<tbody>
        				<c:forEach items="${employeeDeatailss}" var="employee">
        					<tr>
            					<td>Employee ID: <c:out value="${employee.eid}"/></td>
            					<td>Employee Pass: <c:out value="${employee.ename}"/></td>  
        					</tr>
    					</c:forEach>
   						 </tbody>
					</table> --%>
					
					<table class="table table-striped">
					<tr>
					<th>Emplyoee_Id</th>
					<th>EmployeeName</th>
					<th>gender</th>
					<th>Age</th>
					<th>Email_Id</th>
					<th>specialized</th>
					<th>language</th>
					<th>contactNo</th>
					<th>salary</th>
					</tr>
					<%  
							ResultSet resultSet =(ResultSet) request.getAttribute("resultSet");
        					while (resultSet.next()) {
        						int id=resultSet.getInt(1);
        						String employeeName=resultSet.getString(2);
        						String password=resultSet.getString(3);
        						String gender=resultSet.getString(4);
        						String emailId=resultSet.getString(5);
        						String address=resultSet.getString(6);
        						String specialized=resultSet.getString(7);
        						String language=resultSet.getString(8);
        						long contactNo=resultSet.getLong(9);
        						int age=resultSet.getInt(10);
        						float salary=resultSet.getFloat(11);
            					out.println("<tr><td>"+id+"</td><td>"+employeeName+"</td><td>"+gender+"</td><td>"+age+"</td><td>"+emailId+"</td><td>"+specialized+"</td><td>"+language+"</td><td>"+contactNo+"</td><td>"+salary+"</td></tr>");
        					}
    				%>
    				
    				</table>
				</form>

			</div>
    </div>
</body>
</html>