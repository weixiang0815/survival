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
	<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
	<div class="container">
		<h3>個人資料</h3>
		<table class="table table-hover">
			<tr>
				<td>><label>大頭貼></label>
				<td><label>名稱</label>
				<td><label>帳號</label>
				<td><label>密碼</label>
				<td><label>生日</label>
				<td><label>暱稱</label>
				<td><label>性別</label>
				<td><label>個人身分證</label>
				<td><label>縣市</label>
				<td><label>鄉鎮</label>
				<td><label>地址</label>
				<td><label>Email</label>
				<td><label>年齡</label>
				<td><label>電話</label>
			</tr>
			<c:forEach items="${player}" var="player">
				<tr>
				    <td>${player.id}</td>
					<td style="width: 100px;">
					<img src="${contextRoot}/player/photo/${player.id}" /></td>
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
					<td><form
							action="${contextRoot}/player/frontupdate/?id=${player.id}">
							<input name="id" type="hidden" value="${player.id}" /> <input
								type="submit" class="btn btn-info" value="編輯">
						</form>
				</tr>
			</c:forEach>
		</table>
		<a href="searchmain.controller"><button class="btn btn-primary">回到搜尋頁</button></a>
	</div>
</body>
</html>