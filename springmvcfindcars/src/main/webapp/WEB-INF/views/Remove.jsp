<%@page import="com.jspiders.springmvcfindcars.pojo.CarPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<CarPOJO> cars = (List<CarPOJO>) request.getAttribute("cars");
String msg = (String) request.getAttribute("msg");
%>
<jsp:include page="NavBar.jsp"></jsp:include>
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
form {
	margin-top: 10px;
}

form table {
	margin: auto;
	width: 100%;
}

tr {
	text-align: center;
}

#data {
	background-color: white;
	border: 1px solid black;
	width: 100%;
	border: 1px solid black;
}

#data td {
	border: 1px solid black;
	text-align: center;
}
fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

</style>

</head>
<body>
	<div align="center">
		<fieldset>
			<legend>Remove Car Details</legend>
			<form action="./remove" method="post">
				<table>
					<tr>
						<td>Id :</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
				<input type="submit" value="REMOVE">
			</form>
		</fieldset>

		<%
		if (msg != null) {
		%>
		<h3>
			<%=msg%>
		</h3>
		<%
		}
		%>
		
		<%
		if (cars != null) {
		%>
		<table id="data">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>BRAND</th>
				<th>FUELTYPE</th>
				<th>PRICE</th>
			</tr>

			<%
			for (CarPOJO pojo : cars) {
			%>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getBrand()%></td>
				<td><%=pojo.getFuelType()%></td>
				<td><%=pojo.getPrice()%></td>
			</tr>

			<%
			}
			%>
		</table>

		<%
		}
		%>
	</div>
</body>
</html>