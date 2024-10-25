<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="usermanagement.Software"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Access</title>
<link rel="stylesheet" href="req.css">
</head>
<body>
	<a href="RequestServlet" class="request-access-container">View All
		Software To Request Access</a>
	<%
	ResultSet rs = (ResultSet) request.getAttribute("softwareList");
	%>
	<table border="1">
		<thead>
			<tr>
				<td>Id</td>
				<td>Software Name</td>
				<td>Description</td>
				<td>Request</td>
			</tr>
		</thead>
		<tbody>
			<%
			if (rs != null) {
				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt(1)%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><a>Request</a></td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
</body>
</html>