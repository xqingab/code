<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息维护</title>
<link rel="stylesheet" href="../css/bootstrap.css" />
<style type="text/css">
body{
	margin-top: 5em;
}

.container{
	border: 1px sold #eee;
	border-radius: 15px;
	box-shadow: 2px 2px 3px 3px #ccc;
	padding: 2em;
}
</style>
</head>
<body>
	<div class="container col-lg-8 col-lg-offset-2">
		<h2 class="text-center">用户信息维护</h2>
		<form action="update.do" method="post" class="form-horizontal col-lg-5 col-lg-offset-3">
			<div class="form-group">
				<label class="col-lg-4 control-label">用户名：</label>
				<div class="col-lg-8">
					<input name="username" class="form-control" value="${user.name}" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-4 control-label">性别：</label>
				<div class="col-lg-8">
					<label class="radio-inline"><input name="gender" value="M" type="radio" <c:if test="${user.gender=='M'}">checked="checked"</c:if> />男</label>
					<label class="radio-inline"><input name="gender" value="F" type="radio" <c:if test="${user.gender=='F'}">checked="checked"</c:if>/>女</label>
					<label class="radio-inline"><input name="gender" value="U" type="radio" <c:if test="${user.gender=='U'}">checked="checked"</c:if> />保密</label>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-4 control-label">电子邮箱：</label>
				<div class="col-lg-8">
					<input name="email" type="email" class="form-control" value="${user.email}" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-4 control-label">年龄：</label>
				<div class="col-lg-8">
					<input name="age" type="number" class="form-control" min="0" max="150" value="${user.age}" />
				</div>
			</div>
			<input type="hidden" name="id" value="${user.id}" />
			<div class="text-center">
				<button class="btn btn-success">修改</button>
				<button type="reset" class="btn btn-danger">重置</button>
			</div>
		</form>
	</div>
</body>
</html>