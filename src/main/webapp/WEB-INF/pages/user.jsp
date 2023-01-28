<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增使用者</title>
</head>
<body>
	<h3>新增使用者</h3>
	<form:form action="addUser" method="post" modelAttribute="user">
		<table>
			<tr>
				<td><form:label path="name">使用者名稱</form:label></td>
				<td><form:input path="name" /></td>
			<tr>
				<td><form:label path="account">帳號</form:label></td>
				<td><form:input path="account" /></td>
			<tr>
				<td><form:label path="password">密碼</form:label></td>
				<td><form:input path="password" /></td>
			<tr>
				<td><form:label path="sex">性別</form:label></td>
				<td><form:input path="sex" /></td>
			<tr>
				<td><form:label path="address">地址</form:label></td>
				<td><form:input path="address" /></td>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
			<tr>
				<td><form:label path="age">年齡</form:label></td>
				<td><form:input path="age" /></td>
			<tr>
				<td colspan="2"><form:button value="send">送出</form:button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>