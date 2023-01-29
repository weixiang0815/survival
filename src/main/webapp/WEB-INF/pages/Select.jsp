<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢ID</title>
</head>
<body>
	<h3>查詢</h3>
	<form action="getOneUser" method="post">
		<table>
			<tr>
				<td>請輸入欲查詢使用者編號</td>
				<td><input type="text" name="id" /></td>
				<td>${errors.msg}</td>
			</tr>
			<tr>
				<td>請輸入欲查詢使用者帳號</td>
				<td><input type="text" name="account" /></td>
				<td>${errors.msg}</td>
			</tr>
			<tr>
				<td><input type="submit" value="查詢" /></td>
				<td>${errors.msg}</td>
			</tr>
		</table>
	</form>

	<form action="getUsers" method="post">
		<table>
			<tr>
				<td>請輸入查詢全部使用者帳號</td>
			</tr>
			<tr>
				<td><input type="submit" value="查詢全部" /></td>
				<td>${errors.msg}</td>
			</tr>
		</table>
	</form>
</body>
</html>