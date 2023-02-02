<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>查詢ID</title>
</head>
<body>
<jsp:include page="../Layout/navbar_user.jsp"/>
	<h3>查詢</h3>
	<form action="getOneUserById" method="post">
		<table>
			<tr>
				<td>請輸入欲查詢使用者編號：</td>
				<td><input type="text" name="id" /></td>
				<td>${errors.idNotFound}</td>
				<td><input type="submit" value="查詢" /></td>
				<td>${errors.mustNotEmpty}</td>
			</tr>
		</table>
	</form>
	<form action="getOneUserByAccount" method="post">
		<table>
			<tr>
				<td>請輸入欲查詢使用者帳號：</td>
				<td><input type="text" name="account" /></td>
				<td>${errors.accountNotFound}</td>
				<td><input type="submit" value="查詢" /></td>
				<td>${errors.mustNotEmpty}</td>
			</tr>
		</table>
	</form>

	<form action="getUsers" method="post">
		<table>
			<tr>
				<td>查詢全部使用者帳號</td>
				<td><input type="submit" value="查詢全部" /></td>
			</tr>
		</table>
	</form>
<jsp:include page="../Layout/footer.jsp"/>
</body>
</html>