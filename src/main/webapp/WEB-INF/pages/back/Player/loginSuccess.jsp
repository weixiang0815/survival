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
<jsp:include page="../../Template/admin.jsp"/>
<h3>成功</h3>
帳號：${player.account}<br>
密碼：${player.password}
<a href="${contextRoot}/logout" >登出</a>
</body>
</html>