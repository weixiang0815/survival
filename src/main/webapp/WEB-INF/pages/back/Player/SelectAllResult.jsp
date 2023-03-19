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
	max-width: 50px;
}
#text{
border:"1px soild #000";
width:"500px";
height:"120px";
overflow:auto;
}
</style>
</head>
<body>
	<jsp:include page="../../Template/admin.jsp" />
	<div class="container" id="text">
		<h3>查詢全部結果</h3>
		<form action="${contextRoot}/player/namelike" method="post">
			<input type="search" name="name" /> <input type="submit" value="搜尋" />
		</form>
		<table class="table table-hover">
			<tr>
				<th>大頭貼</th>
				<th>名稱</th>
				<th>生日</th>
				<th>性別</th>
				<th>縣市</th>
				<th>地址</th>
				<th>Email</th>
				<th colspan="2"></th>
			</tr>
			<c:forEach items="${player}" var="player">
				<tr>
					<td >
					<img src="${contextRoot}/player/photo/${player.id}" /></td>
					<td>${player.name}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${player.birthday}" /></td>
					<td><c:choose>
							<c:when test="${player.sex == \"M\"}">男</c:when>
							<c:otherwise>女</c:otherwise>
						</c:choose></td>
					<td>${player.county}</td>
					<td>${player.address}</td>
					<td>${player.email}</td>
					<td><form
							action="${contextRoot}/player/update/?id=${player.id}">
							<input name="id" type="hidden" value="${player.id}" /> <input
								type="submit" class="btn btn-info" value="編輯">
						</form>
						<td>
						<form action="${contextRoot}/player/delete" method="post" id="delete-form">
						<input name="_method" type="hidden" value="delete" />
					    <input name="id" type="hidden" value="${player.id}" />
						<button type="submit" id="delete" class="btn btn-danger" >刪除</button>								
						</form>
				</tr>
			</c:forEach>
		</table>
		<a href="searchmain.controller"><button class="btn btn-primary">回到搜尋頁</button></a>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script>
		$(document).ready(function() {
	        $("button[type='submit']").click(function(e) {
	            if (!confirm("確定要刪除這個玩家嗎？")) {
	                e.preventDefault();
	            }
	        });
	    });
		</script>
</body>
</html>