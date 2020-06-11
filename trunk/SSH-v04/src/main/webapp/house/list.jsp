<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function toPage(x){
		document.getElementById('pageNo').value=x;
		document.getElementById('myform').submit();
	}
</script>
</head>
<body>
	你好：用户
	<f:form action="list.do" method="post" modelAttribute="qo" id="myform">
		<f:hidden path="pageNo" id="pageNo" />
		<f:hidden path="pageSize" id="pageSize" />
		<f:input path="title" placeholder="房源标题" />
		<f:input path="address" placeholder="房源地址" />
		<f:input path="type" placeholder="房源类型" />
		<f:input path="minPrice" placeholder="最低租金" />
		<f:input path="maxPrice" placeholder="最高租金" />
		<button>查询</button>
	</f:form>
	<c:choose>
		<c:when test="${ro.emptyData}">
			<h1>无房源信息</h1>
		</c:when>
		<c:otherwise>
			<table border="1">
				<c:forEach items="${ro.dataList}" var="h">
					<tr>
						<!-- 在img中的width和height属性用于预设图片的宽度和高度，不应该用于对图片进行大小的调整 -->
						<td><img src="${h.imgUrl}" height="200px" /></td>
						<td>
							标题：${h.title }<br>
							地址：${h.address }<br>
							租金：${h.price }<br>
							电话：${h.tel }<br>
							类型：${h.type }
						</td>
					</tr>
				</c:forEach>
			</table>
			第${ro.page.pageNo}页/共${ro.page.totalPage}页 第${ro.page.firstResultNum+1}条数据~${ro.page.lastResultNum}条数据 共${ro.page.totalQuantity}条数据
			<c:if test="${!ro.page.firstPage}">
				<a href="#" onclick="toPage(1);">首页</a>
				<a href="#" onclick="toPage(${ro.page.pageNo-1});">上页</a>
			</c:if>
			<c:if test="${!ro.page.lastPage}">
				<a href="#" onclick="toPage(${ro.page.pageNo+1});">下页</a>	
				<a href="#" onclick="toPage(${ro.page.totalPage});">尾页</a>
			</c:if>
		</c:otherwise>
	</c:choose>
</body>
</html>