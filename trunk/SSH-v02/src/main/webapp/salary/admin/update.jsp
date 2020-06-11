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
	<form action="update.do" method="post">
		<input type="hidden" value="${vo.id}" name="id" />
		<input name="name" placeholder="姓名" value="${vo.name}" /><br>
		<input name="month" placeholder="工资月" value="${vo.month}" /><br>
		<input name="jbgz" placeholder="基本工资" type="number" value="${vo.jbgz}" /><br>
		<input name="gwjt" placeholder="岗位津贴" type="number" value="${vo.gwjt}" /><br>
		<input name="yjj" placeholder="月奖金" type="number" value="${vo.yjj}" /><br>
		<input name="ylbx" placeholder="养老保险" type="number" value="${vo.ylbx}" /><br>
		<input name="zfgjj" placeholder="住房公积金" type="number" value="${vo.zfgjj}" /><br>
		<button>修改</button>
	</form>
</body>
</html>