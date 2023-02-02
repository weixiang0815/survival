<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>註冊成功</title>
</head>
<body>
	<jsp:include page="../Layout/navbar_user.jsp" />
	<h2>註冊成功</h2>
	<a href="updateUserById?id=${id}"><button class="btn btn-info">使用者資訊</button></a>
	<a href="${contextRoot}/"><button class="btn btn-primary">返回首頁</button></a>
	<jsp:include page="../Layout/footer.jsp" />
</body>
</html>