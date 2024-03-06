<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

*{
	margin:0px ;
	padding: 0px ;
	box-sizing: border-box;
}
	legend {
	border:3px solid black;
	text-align: center;
	background-color: orange;
	color:black;
	border-radius: 10px;
}
.inp{
	border-left: none;
	border-right: none;
	border-top: none;
	outline: none;
	border-radius: 20px;
}
 .inp:hover{
	box-shadow: 2px 2px 2px  olive;
}
.td{
	background-color: orange;
	color: black;
	border: 1px solid;
	border-radius: 10px 0px;
	
}
#in{
	height: 25px;
	width: 80px;
	border-radius: 0px 10px;
	color: yellow;
	background-color: purple;
}
#in:hover{
	box-shadow: 1px 2px 3px orange;
}
a{
	text-decoration: none;
	color: green;
}
a:hover{
	text-shadow: 1px 2px 2px ;
}

a:active {
	color: yellow;
}

fieldset {
	height: 300px;
	width:700px;
	margin: auto 20px;
	background-color: aqua;
	border-radius: 10px;
}
a:visited {
	color: red;
}

#data{
	margin: 40px;
}
#d1{
	margin: 50px;
}
</style>

</head>
<body>
	<div id="d1" align="center">

		<%
		if (msg != null) {
		%>
		<h4><%=msg%></h4>
		<%
		}
		%>
		<fieldset>
			<legend>Login Page</legend>

			<div id="data">
				<form action="./login" method="post">
				<table>
					<tr>
						<td class="td">Username :</td>
						<td><input class="inp" type="text" name="username"></td>
					</tr>
					<tr>
						<td class="td">Password :</td>
						<td><input class="inp" type="text" name="password"></td>
					</tr>
				</table>
				<input id="in" type="submit" value="LOGIN">
			</form>   
			</div>
			<h4>
				If already not present? Make sure you can <a
					href="http://localhost:8080/springmvcfindcars/createAccount">Create
					Account</a> Here..!
			</h4>
		</fieldset>
	</div>
</body>
</html>