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
	<form action="list.do" method="post">
		<select name="projectId">
			<option value="">请选择项目</option>
			<c:forEach items="${projectVoList}" var="p">
				<option value="${p.id}">${p.name}</option>
			</c:forEach>
		</select>
		<button>查询</button>
	</form>
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
				<td>
					<a href="changeState.do?id=${m.id}">
						<c:if test="${m.state.index==0}">审核通过</c:if>
						<c:if test="${m.state.index==1}">报销完成</c:if>
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>