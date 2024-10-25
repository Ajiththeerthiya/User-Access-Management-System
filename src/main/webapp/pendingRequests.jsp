<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.ResultSet"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pending Requests</title>
<link rel="stylesheet" href="req.css">

</head>
<body>
<a href="ApplovedServlet" class="request-access-container">View All
		Pending Software</a>
	<%
	ResultSet rs = (ResultSet) request.getAttribute("requestList");
	%>
	<table border="1">
		<thead>
			<tr>
				<td>Id</td>
				<td>user id</td>
				<td>software id</td>
				<td>access type</td>
				<td>reason</td>
				<td>status</td>
			</tr>
		</thead>
		<tbody>
			<%
			if (rs != null) {
				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt(1)%></td>
				<td><%=rs.getInt(2)%></td>
				<td><%=rs.getInt(3)%></td>
				<td><%=rs.getString(4)%></td>
				<td><%=rs.getString(5)%></td>
			    <td><%=rs.getString(6)%></td>
				
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
</body>
</html>