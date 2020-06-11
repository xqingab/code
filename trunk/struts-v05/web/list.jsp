<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="list" method="post">
		<s:textfield label="名称" name="name"></s:textfield>
		<s:submit value="OK"></s:submit>
	</s:form>
	<table>
		<tr>
			<th>名称</th>
			<th>上课时间</th>
			<th>教师</th>
			<th>学分</th>
		</tr>
		<s:iterator value="dataList" status="vo">
			<tr>
				<td>
					<s:property value="dataList[#vo.index].name"/>
				</td>
				<td>
					<s:property value="dataList[#vo.index].teachTime"/>
				</td>
				<td>
					<s:property value="dataList[#vo.index].teacher"/>
				</td>
				<td>
					<s:property value="dataList[#vo.index].credit"/>
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>