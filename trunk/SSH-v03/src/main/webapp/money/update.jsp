<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<f:form action="update.do" method="post" modelAttribute="vo">
		<f:hidden path="id"/><br>
		<f:select path="projectId" items="${projectVoList}" itemValue="id" itemLabel="name"></f:select><br>
		<f:input path="reason" /><br>
		<f:input path="amount" /><br>
		<f:input path="bank" /><br>
		<f:input path="account" /><br>
		<button>修改</button>
	</f:form>
</body>
</html>