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
	max-width: 100px;
}
</style>
</head>
<body>
	<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
	<div class="container">
		<h3>個人資料</h3>
		<table class="table table-hover" style="color:white">			
			<tr>
				<td><label>大頭貼</label>
				<td colspan="2" style="width: 100px;"><img
					src="${contextRoot}/player/photo/${player.id}" /></td>
			</tr>
			<tr>
				<td><label>名稱</label>
				<td>${player.name}</td>
			</tr>
			<tr>
				<td><label>生日</label>
				<td><fmt:formatDate pattern="yyyy-MM-dd"
						value="${player.birthday}" /></td>
			</tr>
			<tr>
				<td><label>暱稱</label>
				<td><c:choose>
						<c:when test="${player.nickname == null}">無</c:when>
						<c:otherwise>${player.nickname}</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td><label>性別</label>
				<td><c:choose>
						<c:when test="${player.sex == \"M\"}">男</c:when>
						<c:otherwise>女</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td><label>個人身分證</label>
				<td>${player.identity_number}</td>
			</tr>
			<tr>
				<td><label>縣市</label>
				<td>${player.county}</td>
			</tr>
			<tr>
				<td><label>鄉鎮</label>
				<td>${player.district}</td>
			</tr>
			<tr>
				<td><label>地址</label>
				<td>${player.address}</td>
			</tr>
			<tr>
				<td><label>Email</label>
				<td>${player.email}</td>
			</tr>
			<tr>
				<td><label>年齡</label>
				<td>${player.age}</td>
			</tr>
			<tr>
				<td><label>電話</label>
				<td>${player.phone}</td>
			</tr>
			<tr>
				<td>
					<form action="${contextRoot}/player/frontupdate/?id=${player.id}">
						<input name="id" type="hidden" value="${player.id}" /> <input
							type="submit" class="btn btn-info" value="編輯">
					</form>
			</tr>
		</table>
		<a href="${contextRoot}/"><button class="btn btn-primary">回到搜尋頁</button></a>
	</div>
	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>	
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>