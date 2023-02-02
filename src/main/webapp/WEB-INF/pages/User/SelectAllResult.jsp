<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>查詢全部結果</title>
<style type="text/css">
img {
	max-width: 100%;
}
</style>
</head>
<body>
	<jsp:include page="../Layout/navbar_user.jsp" />
	<div class="container">
		<h3>查詢全部結果</h3>
		<table class="table table-hover table-border">
			<tr>
				<th>大頭貼</th>
				<th>名稱</th>
				<th>帳號</th>
				<th>密碼</th>
				<th>暱稱</th>
				<th>性別</th>
				<th>地址</th>
				<th>Email</th>
				<th>年齡</th>
				<th colspan="2"></th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td style="width: 100px;"><c:choose>
							<c:when test="${user.thumbnail != null}">
								<img src="/Survival/showImg?id=${user.id}" />
							</c:when>
							<c:otherwise>
				查無圖片
				</c:otherwise>
						</c:choose></td>
					<td>${user.name}</td>
					<td>${user.account}</td>
					<td>${user.password}</td>
					<td><c:choose>
							<c:when test="${user.nickname == null}">無</c:when>
							<c:otherwise>${user.nickname}</c:otherwise>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${user.sex == \"M\"}">男</c:when>
							<c:otherwise>女</c:otherwise>
						</c:choose></td>
					<td>${user.address}</td>
					<td>${user.email}</td>
					<td>${user.age}</td>
					<td><a href="updateUserById?id=${user.id}"><button
								class="btn btn-info">編輯</button></a>
					<td><a href="deleteUserById?id=${user.id}"><button
								class="btn btn-danger">刪除</button></a>
				</tr>
			</c:forEach>
		</table>
		<a href="searchmain.controller"><button class="btn btn-primary">回到搜尋頁</button></a>
	</div>
	<jsp:include page="../Layout/footer.jsp" />
</body>
</html>