<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>登入</title>
</head>
<body>
<jsp:include page="../Layout/navbar_user.jsp"/>
	<h3>登入</h3>
	<form action="checkLogin.controller" method="post">
		<table>
			<tr>
				<td>使用者名稱：</td>
				<td><input type="text" name="account" /></td>
				<td>${errors.account}</td>
			</tr>
			<tr>
				<td>密碼：</td>
				<td><input type="password" name="password" /></td>
				<td>${errors.password}</td>
			</tr>
			<tr>
				<td><input type="submit" value="登入" /></td>
				<td>${errors.msg}</td>
			</tr>
		</table>
	</form>
<jsp:include page="../Layout/footer.jsp"/>
</body>
</html>