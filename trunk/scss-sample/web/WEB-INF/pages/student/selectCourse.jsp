<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../styles/css/reset.css">
<link type="text/css" rel="stylesheet" href="../styles/css/index.css">
<title>课程选择</title>
</head>
<body>
	你好
	<s:property value="userName" /><br>
	<s:form action="selectCourse.do">
		<table class="rc_tab01" cellspacing="0" cellpadding="0">
			<tbody>
				<tr>
					<th style="width: 10%; text-align: center;">选择</th>
					<th style="width: 10%; text-align: center;">课程名</th>
					<th style="width: 10%; text-align: center;">上课时间</th>
					<th style="width: 20%; text-align: center;">任课教师</th>
					<th style="width: 20%; text-align: center;">学分</th>
				</tr>
				<s:iterator value="courseDtoList" status="dto">
					<tr>
						<td><s:checkbox theme="idtheme" name="courseId"
								id="%{courseDtoList[#dto.index].id}"></s:checkbox></td>
						<td><s:property value="courseDtoList[#dto.index].name" /></td>
						<td><s:property value="courseDtoList[#dto.index].teachTime" /></td>
						<td><s:property value="courseDtoList[#dto.index].teacherName" /></td>
						<td><s:property value="courseDtoList[#dto.index].credit" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<s:submit value="选课"></s:submit>
	</s:form>
</body>
</html>