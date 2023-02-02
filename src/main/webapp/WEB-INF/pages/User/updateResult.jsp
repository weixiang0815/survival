<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>修改成功</title>
</head>
<body>
	<jsp:include page="../Layout/navbar_user.jsp" />
	<c:choose>
		<c:when test="${msg.success != null}">
			<h3 style="color: green;">${msg.success}</h3>
		</c:when>
		<c:otherwise>
			<h3 style="color: red;">${msg.fail}</h3>
		</c:otherwise>
	</c:choose>
	<a href="searchmain.controller"><button class="btn btn-primary">回到搜尋頁</button></a>
	<jsp:include page="../Layout/footer.jsp" />
</body>
</html>