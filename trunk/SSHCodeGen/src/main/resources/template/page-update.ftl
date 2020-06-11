<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
</head>
<body>
	<form action="update.do" method="post">
		<#list fields as field>
		<#if field.fieldName="id">
		<input name="id" type="hidden" value='${r"${"}vo.id${r"}"}'/>
		</#if>
		<#if field.fieldName!="id">
		<input name="${field.fieldName}" value='${r"${"}vo.${field.fieldName}${r"}"}'/><br>
		</#if>
		</#list>
		<button type="submit">修改</button>
	</form>
</body>
</html>
