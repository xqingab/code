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
	<table border="1">
		<tr>
			<th>项目名称</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${voList}" var="p">
			<tr>
				<td>${p.name}</td>
				<td>
					<a href="gotoUpdate.do?id=${p.id}">修改</a>
					<a href="delete.do?id=${p.id}" onclick="return sureDel();">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form action="save.do" method="post" style="margin-top: 5em;">
		<fieldset>
			<legend>添加新项目</legend>
			<input name="name" />
			<button>保存</button>
		</fieldset>
	</form>
	<c:forEach items="${errMsg}" var="msg">
		<h3 style="color:red;">${msg}</h3>
	</c:forEach>
</body>
</html>