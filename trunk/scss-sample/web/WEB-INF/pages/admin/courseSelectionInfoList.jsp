<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../styles/css/reset.css">
<link type="text/css" rel="stylesheet" href="../styles/css/index.css">
<title>选课情况统计</title>
</head>
<body>
	<table>
		<tr>
			<td><a href="gotoCourseList.do">课程维护</a></td>
			<td><a href="gotoSelectionInfoList.do">选课情况统计</a></td>
		</tr>
	</table>
	<BR>
	<table class="rc_tab01" cellspacing="0" cellpadding="0">
		<tbody>
			<tr>
				<th style="width: 10%; text-align: center;">课程名</th>
				<th style="width: 10%; text-align: center;">选课人</th>
				<th style="width: 20%; text-align: center;">选课人数</th>
			</tr>
			<s:iterator value="selectionInfoDtoList" status="dto">
				<tr>
					<td><s:property value="selectionInfoDtoList[#dto.index].name" /></td>
					<td><s:property
							value="selectionInfoDtoList[#dto.index].studentNames" /></td>
					<td><s:property
							value="selectionInfoDtoList[#dto.index].studentCount" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>