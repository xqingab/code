<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do" method="post">
		<input name="name" /><br>
		<input name="password" type="password" /><br>
		<button>登录</button>
	</form>
	${message }
</body>
</html>