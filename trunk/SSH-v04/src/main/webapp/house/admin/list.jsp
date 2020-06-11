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
	return confirm("是否删除此数据？");
}
</script>
</head>
<body>
	你好：管理员
	<a href="save.html">添加新房源信息</a>
	<br>
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
						<td>
							<a href="gotoUpdate.do?id=${h.id}">修改</a>
							<a href="delete.do?id=${h.id}" onclick="return sureDel();">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<a href="list.do?pageNo=1">首页</a>
			<a href="list.do?pageNo=${ro.page.pageNo-1}">上页</a>
			<a href="list.do?pageNo=${ro.page.pageNo+1}">下页</a>
			<a href="list.do?pageNo=${ro.page.totalPage}">尾页</a>
		</c:otherwise>
	</c:choose>
</body>
</html>