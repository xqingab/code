<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update.do" method="post" style="margin-top: 2em;">
		<fieldset>
			<legend>修改项目信息</legend>
			<input name="id" type="hidden" value="${vo.id}" />
			<input name="name" value="${vo.name}" />
			<button>修改</button>
		</fieldset>
	</form>
	<c:forEach items="${errMsg}" var="msg">
		<h3 style="color:red;">${msg}</h3>
	</c:forEach>
</body>
</html>