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
		return confirm("是否真的执行删除数据的操作呢？");
	}
	function firstPage(){
		var form = document.getElementById("searchForm");
		var pageNoInput = document.getElementById("pageNo");
		pageNoInput.value=1;
		form.submit();
	}
	function lastPage(){
		var form = document.getElementById("searchForm");
		var pageNoInput = document.getElementById("pageNo");
		pageNoInput.value=${ro.page.totalPage};
		form.submit();
	}
	function prePage(){
		var form = document.getElementById("searchForm");
		var pageNoInput = document.getElementById("pageNo");
		pageNoInput.value=parseInt(pageNoInput.value)-1;
		form.submit();
	}
	function nextPage(){
		var form = document.getElementById("searchForm");
		var pageNoInput = document.getElementById("pageNo");
		pageNoInput.value=parseInt(pageNoInput.value)+1;
		form.submit();
	}
</script>
</head>
<body>
	<form id="searchForm" action="list.do" method="post">
		<input name="username" value="${qo.username}" />
		<input name="content" value="${qo.content}" />
		<input id="pageNo" name="pageNo" value="${ro.page.pageNo}" />
		<input name="pageSize" value="${ro.page.pageSize}" />
		<button>查询</button>
	</form>
	<a href="/logout.do">退出</a>
	<c:if test="${ro.emptyData}">
		<h1>没有查询到符合条件的数据</h1>
	</c:if>
	<c:if test="${!ro.emptyData}">
		<table border="1">
			<tr>
				<th>序号</th>
				<th>留言人</th>
				<th>留言内容</th>
				<th>留言时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${ro.data}" var="nb" varStatus="s">
				<tr>
					<td>${s.index+1}</td>
					<td>${nb.username}</td>
					<td><span title="${nb.content}">${nb.shortContent}...</span></td>
					<td><fmt:formatDate value="${nb.createTime}"
							pattern="yyyy年MM月dd日 HH:mm:ss" /></td>
					<td>
						<a href="delete.do?id=${nb.id}" onclick="return sureDel();">删除</a>
						<a href="gotoUpdate.do?id=${nb.id}">修改</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div>
			共${ro.page.totalPage}页/第${ro.page.pageNo}页 
			共${ro.page.totalQuantity}条数据
			从${ro.page.firstResultNum+1}到${ro.page.lastResultNum}
			<c:if test="${!ro.page.firstPage}">
				<a href="#" onclick="firstPage();">首页</a>
				<a href="#" onclick="prePage();">上页</a>
			</c:if>
			<c:if test="${!ro.page.lastPage}">
				<a href="#" onclick="nextPage();">下页</a>
				<a href="#" onclick="lastPage();">尾页</a>
			</c:if>
		</div>
	</c:if>
</body>
</html>