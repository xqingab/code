<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>项目名称</th>
			<th>汇款事由</th>
			<th>汇款金额</th>
			<th>对方银行</th>
			<th>对方帐号</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${voList}" var="m">
			<tr>
				<td>${m.projectName}</td>
				<td>${m.reason}</td>
				<td>${m.amount}</td>
				<td>${m.bank}</td>
				<td>${m.account}</td>
				<td>${m.stateDesc}</td>
				<td><a href="gotoUpdate.do?id=${m.id}">修改</a></td>
			</tr>
		</c:forEach>
	</table>
	<form action="save.do" method="post">
		项目名称： <select name="projectId">
			<c:forEach items="${projectVoList}" var="p">
				<option value="${p.id}">${p.name}</option>
			</c:forEach>
		</select> <br> 汇款原因：<input name="reason" /><br> 汇款金额：<input
			name="amount" /><br> 对方银行：<input name="bank" /><br> 对方帐号：<input
			name="account" /><br>
		<button>Save</button>

	</form>
</body>
</html>