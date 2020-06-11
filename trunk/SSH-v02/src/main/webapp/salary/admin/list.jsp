<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function sureDel(){
		return confirm("是否删除数据？");
	}
</script>
</head>
<body>
	<form action="list.do" method="post">
		<input name="name" value="${qo.name}" /> <input name="month"
			value="${qo.month}" />
		<button>查询</button>
	</form>
	<div>
		<a href="save.html">添加工资信息</a>
		<a href="/logout.do">退出</a>
	</div>
	<table border="1">
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>月份</th>
			<th>基本工资</th>
			<th>岗位津贴</th>
			<th>奖金</th>
			<th>养老保险</th>
			<th>住房公积金</th>
			<th>应发工资</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${data}" var="sa" varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${sa.name}</td>
				<td>${sa.month}</td>
				<td>${sa.jbgz}</td>
				<td>${sa.gwjt}</td>
				<td>${sa.yjj}</td>
				<td>${sa.ylbx}</td>
				<td>${sa.zfgjj}</td>
				<td>${sa.finalSalary}</td>
				<td>
					<a href="gotoUpdate.do?id=${sa.id}">修改</a>
					<a href="delete.do?id=${sa.id}" onclick="return sureDel();">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>