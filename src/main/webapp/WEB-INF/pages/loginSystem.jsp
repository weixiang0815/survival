<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入</title>
</head>
<body>
	<h3>登入</h3>
	<form action="checkLogin.controller" method="post">
		<table>
			<tr>
				<td>使用者名稱：</td>
				<td><input type="text" name="account" /></td>
				<td>${errors.user}</td>
			</tr>
			<tr>
				<td>密碼：</td>
				<td><input type="password" name="password" /></td>
				<td>${errors.pwd}</td>
			</tr>
			<tr>
				<td><input type="submit" value="登入" /></td>
				<td>${errors.msg}</td>
			</tr>
		</table>
	</form>
</body>
</html>