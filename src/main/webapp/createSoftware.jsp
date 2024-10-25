<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Create Software</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="create-software-form">
		<h1>Create Software</h1>
		<p class="error-message">
			<%
			String soft = (String) request.getAttribute("software");
			if (soft != null) {
				out.println(soft);
			}
			%>
		</p>
		<form action="SoftwareServlet" method="post">
			<label for="softwareName">Software Name:</label> <input type="text"
				id="softwareName" name="softwareName" required> <label
				for="description">Description:</label>
			<textarea id="description" name="description" rows="5" cols="30"
				required></textarea>
			<label for="accessLevels">Access Levels:</label> <select
				name="accessLevels" id="accessLevels" required>
				<option value="Read">Read</option>
				<option value="Write">Write</option>
				<option value="Admin">Admin</option>
			</select>
			<button type="submit">Create Software</button>
		</form>
	</div>
</body>
</html>