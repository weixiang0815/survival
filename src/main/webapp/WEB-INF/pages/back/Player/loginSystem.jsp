<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>登入</title>
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>
<div class="container text-center">
	<h3>登入</h3>
	<form action="${contextRoot}/Player/loginSystem"method="post">
		<table>
			<tr>
				<td>會員帳號：</td>
				<td><input type="text" name="account" /></td>
				<td>${errors.account}</td>
			</tr>
			<tr>
				<td>會員密碼：</td>
				<td><input type="password" name="password" /></td>
				<td>${errors.password}</td>
			</tr>
			<tr>
				<td><input type="submit" value="登入" /></td>
				<td>${errors.msg}</td>
			</tr>
		</table>
	</form>
	<a href="${contextRoot}/Employee/login">職員登入</a>
	<a href="${contextRoot}/player/add">會員註冊</a>
	</div>
<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>