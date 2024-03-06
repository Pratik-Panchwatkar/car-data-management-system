<%@page import="com.jspiders.springmvcfindcars.pojo.CarPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<CarPOJO> cars = (List<CarPOJO>) request.getAttribute("cars");
CarPOJO pojo = (CarPOJO) request.getAttribute("car");
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
		<%
		if (pojo == null) {
		%>
		<fieldset>
			<legend>Select Car</legend>
			<form action="./update">
				<table>
					<tr>
						<td>Enter ID:</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
				<input type="submit" value="SELECT">
			</form>
		</fieldset>
		<%
		if (msg != null) {
		%>
		<h3><%=msg%></h3>
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
			for (CarPOJO car : cars) {
			%>
			<tr>
				<td><%=car.getId()%></td>
				<td><%=car.getName()%></td>
				<td><%=car.getBrand()%></td>
				<td><%=car.getFuelType()%></td>
				<td><%=car.getPrice()%></td>
			</tr>

			<%
			}
			%>
		</table>

		<%
		}
		} else {
		%>
		<fieldset>
			<legend>Update Car</legend>
			<form action="./updateCar" method="post">
				<table>
					<tr>
						<td>ID</td>
						<td><%=pojo.getId()%></td>
						<td><input type="text" name="id" value="<%=pojo.getId()%>">
						</td>
					</tr>

					<tr>
						<td>NAME</td>
						<td><input type="text" name="name"
							value="<%=pojo.getName()%>"></td>
					</tr>

					<tr>
						<td>BRAND</td>
						<td><input type="text" name="brand"
							value="<%=pojo.getBrand()%>"></td>
					</tr>

					<tr>
						<td>FUELTYPE</td>
						<td><input type="text" name="fuelType"
							value="<%=pojo.getFuelType()%>"></td>
					</tr>

					<tr>
						<td>PRICE</td>
						<td><input type="text" name="price"
							value="<%=pojo.getPrice()%>"></td>
					</tr>

				</table>
				<input type="submit" value="UPDATE">
			</form>
		</fieldset>
		<%
		}
		%>
	</div>
</body>
</html>