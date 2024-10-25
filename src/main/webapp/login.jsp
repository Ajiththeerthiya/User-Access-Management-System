<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<title>Login</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 20px;
}

.login-form {
	width: 300px;
	margin: 10px auto;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 10px;
}

h1 {
	text-align: center;
	margin-bottom: 20px;
}

label {
	display: block;
	margin-bottom: 10px;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 12px 20px;
	border: 1px solid #ccc;
	border-radius: 3px;
	box-sizing: border-box;
	margin-bottom: 16px;
}

button[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

button[type="submit"]:hover {
	background-color: #45a049;
}

.error-message {
	color: red;
	font-weight: bold;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<div class="login-form">
		<h1>Login</h1>
		<p class="error-message">
			<%
			String error = (String) request.getAttribute("error");
			if(error != null){
				out.println(error);
			}
			%>
		</p>
		<form action="LoginServlet" method="post">
			<label for="username">Username:</label> <input type="text"
				id="username" name="username" required> <label
				for="password">Password:</label> <input type="password"
				id="password" name="password" required>
			<button type="submit">Login</button>
		</form>
	</div>
</body>
</html>