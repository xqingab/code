<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link type="text/css" rel="stylesheet" href="../styles/css/reset.css">
<link type="text/css" rel="stylesheet" href="../styles/css/index.css">
</head>
<body>
	<s:form action="login.do" theme="xhtml">
		<s:textfield theme="xhtml" label="用户名" name="userName"></s:textfield>
		<s:password theme="xhtml" label="密码" name="password"></s:password>
		<s:submit value="Login"></s:submit>
	</s:form>
</body>
</html>