<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="login.do" method="post">
		<input name="name" /><br>
		<input name="password" type="password" />
		<button>Login</button>
	</form>
	<h1>${msg}</h1>
</body>
</html>