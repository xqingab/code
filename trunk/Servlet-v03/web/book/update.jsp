<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改图书信息</title>
</head>
<body>
	<form action="update.do" method="post">
		<input name="id" value="${book.id}" type="hidden" />
		<input name="name" placeholder="图书名称" value="${book.name}" /><br>
		<input name="author" placeholder="作者" value="${book.author}" /><br>
		<input name="pubName" placeholder="出版社" list="pubList" value="${book.pubName}" /><br>
		<input name="price" placeholder="价格" type="number" value="80" step="0.1" max="100000" min="0" value="${book.price}" /><br>
		<input name="pubDate" placeholder="出版日期" type="date" value="${book.pubDate}" /><br>
		<button>修改</button><button type="reset">重置</button>
	</form>
	
	<datalist id="pubList">
		<option>人民邮电出版社</option>
		<option>清华大学出版社</option>
		<option>电子工业出版社</option>
		<option>人民教育出版社</option>
		<option>高等教育出版社</option>
	</datalist>
</body>
</html>