<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保存</title>
</head>
<body>
	<form action="save.do" method="post">
		<#list fields as field>
		<#if field.fieldName!="id">
		${field.fieldName}：<input name="${field.fieldName}" /><br>
		</#if>
		</#list>
		<button type="submit">保存</button>
	</form>
</body>
</html>
