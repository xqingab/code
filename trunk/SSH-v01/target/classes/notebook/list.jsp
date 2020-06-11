<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${voList}" var="nb" varStatus="s">
		<div>
			<div>${voList.size()-s.index}楼 ${nb.username}于<fmt:formatDate value="${nb.createTime}" pattern="yyyy年MM月dd日 HH:mm:ss"/>发表了留言</div>
			<div>${nb.content}</div>
		</div>
		<hr>
	</c:forEach>
	<form action="save.do" method="post">
		<input name="username" /><br>
		<textarea name="content" rows="5" cols="40"></textarea><br>
		<button>留言</button><button type="reset">重置</button>
	</form>
</body>
</html>