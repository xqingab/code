<!-- JSP文件是在服务器中运行的，通过JSP中的程序可以生成HTML文档结构，然后统一把生成的HTML文档以响应报文的形式发送到客户端浏览器上 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 向页面中引入JSP的核心标签库，需要在WEB-INF/lib中加入jstl的jar文件 -->
<!-- prefix="c"表示使用标签库中的标签时的前缀，主要用于在引入多个标签库时可能会出现的标签命名冲突 -->
<!-- uri="http://java.sun.com/jsp/jstl/core"作用是指定要引入标签库的URI -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<script type="text/javascript">
function sureDel(){
	return confirm("是否删除此数据");
}
</script>
</head>
<body>
	<div class="container">
		<div class="col-lg-8 col-lg-offset-2"><a href="regist.html">注册新用户</a></div>
		<div class="col-lg-8 col-lg-offset-2">
			<table class="table">
				<tr>
					<th>序号</th>
					<th>姓名</th>
					<th>年龄</th>
					<th>Email</th>
					<th>性别</th>
					<th>操作</th>
				</tr>
				<!-- 以下forEach标签用于在页面中执行某种循环结构，通常是用于遍历某个数据容器或数组 -->
				<!-- items="${list}"是要被遍历的数据容器或数组，${list}是EL表达式，其中的list对象转发来的request中的一个名为"list"的属性 -->
				<!-- var="user"为每次遍历的对象提供一个引用变量 -->
				<!-- varStatus="s"是当前被遍历对象的状态 -->
				<c:forEach items="${list}" var="user" varStatus="s">
					<!-- 每执行一次循环会在响应报文中生成一个tr -->
					<tr>
						<td>${s.index+1}</td>
						<td>${user.name}</td>
						<td>${user.age}</td>
						<td>${user.email}</td>
						<td>${user.genderText}</td>
						<td>
							<a href="delete.do?id=${user.id}" onclick="return sureDel();">删除</a>
							<a href="gotoUpdate.do?id=${user.id}">修改</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>