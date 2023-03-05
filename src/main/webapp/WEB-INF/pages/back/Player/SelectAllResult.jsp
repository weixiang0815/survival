<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<jsp:include page="../../Template/admin.jsp" />
	<div class="container">
		<h3>查詢全部結果</h3>
		<table class="table table-hover">
			<tr>
				<th>大頭貼</th>
				<th>名稱</th>
				<th>帳號</th>
				<th>密碼</th>
				<th>生日</th>
				<th>暱稱</th>
				<th>性別</th>
				<th>個人身分證</th>
				<th>縣市</th>
				<th>鄉鎮</th>
				<th>地址</th>
				<th>Email</th>
				<th>年齡</th>
				<th>電話</th>
				<!-- <th>個人介紹</th> -->
				<!-- <th>戰隊</th> -->
				<th colspan="2"></th>
			</tr>
			<c:forEach items="${player}" var="player">
				<tr>
					<td style="width: 100px;"><img alt="查無圖片"
						src="${contextRoot}/player/photo/${player.id}" /></td>
					<td>${player.name}</td>
					<td>${player.account}</td>
					<td>${player.password}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${player.birthday}" /></td>
					<td><c:choose>
							<c:when test="${player.nickname == null}">無</c:when>
							<c:otherwise>${player.nickname}</c:otherwise>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${player.sex == \"M\"}">男</c:when>
							<c:otherwise>女</c:otherwise>
						</c:choose></td>
					<td>${player.identity_number}</td>
					<td>${player.county}</td>
					<td>${player.district}</td>
					<td>${player.address}</td>
					<td>${player.email}</td>
					<td>${player.age}</td>
					<td>${player.phone}</td>
					<!-- <td>${player.info}</td> -->
					<!-- <tf>${player.crew}</tf> -->
					<td><form
							action="${contextRoot}/player/update/?id=${player.id}">
							<input name="id" type="hidden" value="${player.id}" /> <input
								type="submit" class="btn btn-info" value="編輯">
						</form>
						<form action="${contextRoot}/player/delete" method="post">
							<input name="_method" type="hidden" value="delete" /> <input
								name="id" type="hidden" value="${player.id}" /> <input
								type="submit" class="btn btn-danger" value="刪除" />
						</form>
				</tr>
			</c:forEach>
		</table>
		<a href="searchmain.controller"><button class="btn btn-primary">回到搜尋頁</button></a>
	</div>
</body>
</html>