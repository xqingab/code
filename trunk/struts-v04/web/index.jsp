<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="guess.do" method="post">
		输入一个1~100之间数字：<input name="num" />
		<button>Go</button>
	</form>
	<a href="reinit.do">初始化</a>
	<br> ${message}
</body>
</html>