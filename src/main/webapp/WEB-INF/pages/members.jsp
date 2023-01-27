<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員</title>
</head>
<body>
	<h3>會員</h3>
	<form:form action="addMembers" method="post" modelAttribute="members">
		<table>
			<tr>
				<td><form:label path="memberName">會員名稱</form:label></td>
				<td><form:input path="memberName"/></td>
			<tr>
				<td><form:label path="gender">性別</form:label></td>
				<td><form:input path="gender"/></td>
			<tr>
				<td><form:label path="age">年齡</form:label></td>
				<td><form:input path="age"/></td>
			<tr>
				<td colspan="2"><form:button value="send">送出</form:button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>