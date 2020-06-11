<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="save" method="post">
		<s:textfield label="名称" name="course.name"></s:textfield>
		<s:textfield label="时间" name="course.teachTime"></s:textfield>
		<s:textfield label="老师" name="course.teacher"></s:textfield>
		<s:textfield label="学分" name="course.credit"></s:textfield>
		<s:submit value="Save"></s:submit>
	</s:form>
	<s:property value="message"/>
</body>
</html>