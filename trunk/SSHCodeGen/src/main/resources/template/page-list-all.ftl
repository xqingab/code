<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表</title>
<script type="text/javascript">
	function sureDel() {
		if (confirm("是否删除此数据")) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	你好：${'${'}sessionScope.userVo.name${'}'}！<br>
	<table border="1">
			<tr>
				<th>序号</th>
				<#list fields as field>
				<th>${field.fieldName}</th>
				</#list>
				<th>操作</th>
			</tr>
			<c:forEach items="${'${'}voList${'}'}" var="vo" varStatus="s">
				<tr>
					<td>${'${'}s.index+1${'}'}</td>
					<#list fields as field>
					<td>${'${'}vo.${field.fieldName}${'}'}</td>
					</#list>
					<td>
						<a href="gotoUpdate.do?id=${'${'}vo.id${'}'}">修改</a> | 
						<a href="delete.do?id=${'${'}vo.id${'}'}" onclick="return sureDel();">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>
