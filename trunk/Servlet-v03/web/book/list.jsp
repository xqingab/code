<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书信息列表</title>
<script type="text/javascript">
function sureDel(){
	return confirm("是否删除此数据？");
}
</script>
</head>
<body>
	你好：${sessionScope.loginedUser.name}！
	<a href="/logout.do">退出</a>
	<c:choose>
		<c:when test="${!empty errorMsg}">
			<h1>${errorMsg}</h1>
		</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<th>序号</th>
					<th>名称</th>
					<th>作者</th>
					<th>出版社</th>
					<th>出版日期</th>
					<th>上架时间</th>
					<th>价格</th>
					<th>折扣价格</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${data}" var="book" varStatus="s">
					<tr>
						<td>${s.index+1}</td>
						<td>${book.name}</td>
						<td>${book.author}</td>
						<td>${book.pubName}</td>
						<td>
							<fmt:formatDate value="${book.pubDate}" pattern="yyyy年MM月dd日" />
						</td>
						<td>
							<fmt:formatDate value="${book.createTime}" pattern="yyyy年MM月dd日 HH:mm" />
						</td>
						<td>
							<fmt:formatNumber value="${book.price}" pattern="######.#" />
						</td>
						<td>
							<fmt:formatNumber value="${book.price*0.75}" pattern="######.#" />
						</td>
						<td>
							<a href="delete.do?id=${book.id}" onclick="return sureDel();">删除</a>
							<a href="update.do?id=${book.id}">修改</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>