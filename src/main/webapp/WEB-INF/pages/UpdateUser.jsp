<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用者修改資料</title>
</head>
<body>
<h3>使用者修改資料</h3>
	<form action="updateUser" method="post">
		<table>
			<tr>
				<td>使用者名稱：</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>帳號：</td>
				<td><input type="text" name="account" /></td>
			</tr>
			<tr>
				<td>密碼：</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>性別：</td>
				<td><label>男:</label><input type="radio" name="sex" value="M" /><label>女:</label><input type="radio" name="sex" value="F" /></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Email：</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>年齡：</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="修改" /></td>
			</tr>
		</table>
	</form>
</body>
</html>