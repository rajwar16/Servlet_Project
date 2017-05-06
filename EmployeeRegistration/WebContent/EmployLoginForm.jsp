<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/design.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
<style type="text/css">
button {
	margin-left: "";
	border: none;
	border-radius: 8px;
	color: black;
	padding: 13px 150px;
	text-align: center;
	text-decoration: none;
	background-color: #E7EEF3;
	display: inline-block;
	font-size: 16px;
}

input[type=submit] {
	margin-left: 20px;
	border: none;
	border-radius: 8px;
	color: black;
	padding: 13px 150px;
	text-align: center;
	text-decoration: none;
	background-color: #E7EEF3;
	display: inline-block;
	font-size: 16px;
}

td {
	color: white;
	padding: 5px 20px;
	text-align: left;
	font-size: 18px;
}
</style>

<script type="text/javascript">
	function validName() {
		var name = document.getElementById("empName").value;
		if (name == "") {
			var message = "*User Id should not be empty";
			document.getElementById("p1").innerHTML = message;
			document.getElementById("empName").style.borderColor = "red";
			return false;
		} else {
			document.getElementById("p1").innerHTML = "";
			document.getElementById("empName").style.borderColor = "green";
			return true;
		}
		return true;
	}

	function validPassword() {
		var password = document.getElementById("Password").value;

		if (password == "") {

			var message = "*Password should not be empty";
			document.getElementById("p2").innerHTML = message;
			document.getElementById("Password").style.borderColor = "red";
			return false;
		} else if (password.length < 6) {
			var message = "*Password should be greater than 6";
			document.getElementById("p2").innerHTML = message;
			document.getElementById("Password").style.borderColor = "red";
			return false;
		} else {
			document.getElementById("p2").innerHTML = "";
			document.getElementById("Password").style.borderColor = "green";
			return true;
		}
		return true;
	}

	function validForm() {
		var name = validName();
		var password = validPassword();

		if (name == true && password == true) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<%-- <jsp:include page="header.jsp"></jsp:include><br> --%>
	<div class="container text-center">
		<!-- <div style="height: 696px; width: 1274px; background-color: gray; color: white; float: left;"> -->
		<%-- <% String error =(String)request.getAttribute("incorrectMassage"); %>
			<p id="p3" style="color: red">${error}</p> 
		--%>
				<div class="container"
					style="background-image: url(g.jpg);height: 450px; width: 1100px; background-color: #33A8FF; margin-top: 50px;margin-left: 50px ;color: black; float: left;">
				<form action="LoginForm" method="get" name="myform" id="myForm1"
				onsubmit="return validForm()">
				
				<div class="container"
					style="height: 450px; width: 400px; background-color: #33A8FT; margin-left: 300px;color: black">
					<table
						style="background-image: url(g2.jpg);height: 400px; width: 450px; margin: 10px; background-color: #33A8FF; color: black">
						<tr>
							<td>User Name:</td>

							<td><input type='text' name='userName'
								onblur="return validName()" id="empName">
								<p id="p1" style="color: white"></p></td>
						</tr>
						<tr>
							<td>Password :</td>
							<td><input type='password' name='password'
								onblur="validPassword()" id="Password">
								<p id="p2" style="color: white"></p></td>
						</tr>
						<tr>
							<td colspan="2"><input style="background-color: #E7EEF3;"
								type="submit" value="Submit"></td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: center;">Don't have an
								account? <!--<button style="background-color: #1E90FF;" type="submit" formaction="UserRegistration.jsp">Register</button>-->

								<button type="button"
									style="background-color: #E7EEF3; color: black"
									onclick="gotoUserRegisterPage()">Register</button> <script
									type="text/javascript">
										function gotoUserRegisterPage() {
											window.location = 'UserRegistration.jsp';
										}
									</script>
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>

	</div>
</body>
</html>