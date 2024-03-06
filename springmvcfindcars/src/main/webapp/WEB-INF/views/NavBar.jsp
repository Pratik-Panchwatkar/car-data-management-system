<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style type="text/css">
body {
	background-color:orange;
	background-size: 100%;
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
	color: olive;
	background-color: #333;
}

ul {
	list-style-type: none;
	background-color: black;
	overflow: hidden;
	background-color: #333;
}

li {
	float: right;
}

li a {
	display: block;
	margin: 0px;
	padding: 15px;
	text-decoration: none;
}

li a:hover {
	background-color: black;
}
</style>
</head>
<body>
	<ul>
		<li><a style="color: white;" href="./logout">Logout</a></li>
		<li><a style="color: white;" href="./search">Search Car</a></li>
		<li><a style="color: white;" href="./add">Add Car</a></li>
		<li><a style="color: white;" href="./update">Update Car</a></li>
		<li><a style="color: white;" href="./remove">Remove Car</a></li>
		<li><a style="color: white;" href="./home">Home</a></li>
	</ul>
</body>
</html>