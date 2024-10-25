<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SignUp</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="signup-form">
		<h1>Signup</h1>
		<form action="SignUpServlet" method="post">
			<label for="username">Username:</label> <input type="text"
				id="username" name="username" required> <label
				for="password">Password:</label> <input type="password"
				id="password" name="password" required> <label for="role">Role:</label>
			<select name="role" id="role" required>
				<option value="employee">Employee</option>
				<option value="admin">Admin</option>
				<option value="manager">Manager</option>
			</select>
			<button type="submit">Sign Up</button>
			<a href="login.jsp">Log In</a>
		</form>
	</div>
</body>
</html>