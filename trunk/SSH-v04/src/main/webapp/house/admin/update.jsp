<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<f:form action="update.do" method="POST" enctype="multipart/form-data" modelAttribute="vo">
		<f:hidden path="id"/>
		<f:hidden path="imgUrl"/>
		<f:input path="title"/><br>
		<f:input path="address"/><br>
		<f:input path="price"/><br>
		<f:input path="tel"/><br>
		<f:input path="type"/><br>
		<input type="file" name="img" /><br>
		<img src="${vo.imgUrl}" height="200px" /><br>
		<button>修改</button>
	</f:form>
</body>
</html>