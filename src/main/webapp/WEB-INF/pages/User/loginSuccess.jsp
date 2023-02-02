<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>登入成功</title>
</head>
<body>
	<jsp:include page="../Layout/navbar_user.jsp" />
	<div class="container">
		<h3>${loginsuccess}</h3>
		<a href="updateUserById?id=${id}"><button class="btn btn-info">使用者資訊</button></a>
		<a href="/"><button class="btn btn-primary">返回首頁</button></a>
	</div>
	<jsp:include page="../Layout/footer.jsp" />
</body>
</html>