<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>加入購物車測試</title>
</head>
<body>
	<jsp:include page="../../Template/admin.jsp" />
	<div class="container">
		<h1>商品編號：${product.id}</h1>
		<h1>商品名稱：${product.name}</h1>
		<h1>商品單價：${product.price}</h1>
		<h1>買家編號：${player.id}</h1>
		<h1>買家名稱：${player.name}</h1>
		<form:form action="${contextRoot}/Market/Cart/add" method="post"
			modelAttribute="cart">
			<form:input path="product" hidden="true" value="${product.id}" />
			<form:input path="player" hidden="true" value="${player.id}" />
			<form:button class="btn btn-primary btn-lg">加入購物車</form:button>
		</form:form>
	</div>
</body>
</html>