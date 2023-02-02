<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>
<c:choose>
<c:when test="${id != null}">
ID ${id} 查詢結果
</c:when>
<c:when test="${account != null}">
帳號 ${account} 查詢結果
</c:when>
</c:choose>
</title>
</head>
<body>
	<jsp:include page="../Layout/navbar_user.jsp" />
	<div class="container">
		<h3>
			<c:choose>
				<c:when test="${id != null}">
			ID ${id} 查詢結果
			</c:when>
				<c:when test="${account != null}">
			帳號 ${account} 查詢結果
			</c:when>
			</c:choose>
		</h3>
		<table class="table table-hover table-border">
			<tr>
				<td><label>使用者ID：</label>${user.id}
			<tr>
				<td><label>使用者名稱：</label>${user.name}
			<tr>
				<td><label>使用者帳號：</label>${user.account}
			<tr>
				<td><label>使用者密碼：</label>${user.password}
			<tr>
				<td><label>使用者暱稱：</label>${user.nickname}
			<tr>
				<td><label>使用者性別：</label> <c:choose>
						<c:when test="${user.sex == \"M\"}">男</c:when>
						<c:otherwise>女</c:otherwise>
					</c:choose>
			<tr>
				<td><label>使用者地址：</label>${user.address}
			<tr>
				<td><label>使用者電子信箱：</label>${user.email}
			<tr>
				<td><label>使用者年齡：</label>${user.age}
			<tr>
				<td><label>使用者圖片：</label> <c:choose>
						<c:when test="${user.thumbnail != null}">
							<img src="/Survival/showImg?id=${user.id}" />
						</c:when>
						<c:otherwise>
				查無圖片
				</c:otherwise>
					</c:choose>
		</table>
		<a href="updateUserById?id=${user.id}"><button
				class="btn btn-info">編輯此資料</button></a> <a
			href="deleteUserById?id=${user.id}"><button
				class="btn btn-danger">刪除此資料</button></a> <a
			href="searchmain.controller"><button class="btn btn-primary">回到搜尋頁</button></a>
	</div>
	<jsp:include page="../Layout/footer.jsp" />
</body>
</html>