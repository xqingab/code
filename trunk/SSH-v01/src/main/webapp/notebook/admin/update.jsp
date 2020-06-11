<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update.do" method="post">
		<input name="username" value="${vo.username}" /><br>
		<textarea name="content" rows="5" cols="40">${vo.content}</textarea>
		<input type="hidden" name="id" value="${vo.id}" /> <br>
		<button>修改</button>
		<button type="reset">重置</button>
	</form>
</body>
</html>