<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>表單</title>
</head>
<body>
	<form action="hello2.controller" method="post">
		<table>
			<tr>
				<td>名字：</td>
				<td><input type="text" name="name" /></td>
				<td>${errors.name}</td>
			</tr>
			<tr>
				<td><input type="submit" value="送出" /></td>
			</tr>
		</table>
	</form>
</body>
</html>