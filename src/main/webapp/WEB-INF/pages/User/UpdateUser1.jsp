<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>使用者修改資料</title>
<style type="text/css">
img {
	max-width: 100%;
}
</style>
</head>
<body>
	<jsp:include page="../Layout/navbar_user.jsp" />
	<div class="container">
		<h3>使用者修改資料</h3>
		<form action="updateUser" method="post">
			<table class="table table-hover table-border">
				<tr>
					<td colspan="2" style="width: 100px;"><c:choose>
							<c:when test="${user.thumbnail != null}">
								<img src="/Survival/showImg?id=${user.id}" />
							</c:when>
							<c:otherwise>
				查無圖片
				</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td>大頭貼：</td>
					<td><input type="file" name="thumbnail"/>
				</tr>
				<tr>
					<td>ID：</td>
					<td><input type="text" name="id" value="${user.id}" readOnly /></td>
				</tr>
				<tr>
					<td>名稱：</td>
					<td><input type="text" name="name" value="${user.name}" /></td>
				</tr>
				<tr>
					<td>帳號：</td>
					<td><input type="text" name="account" value="${user.account}" /></td>
				</tr>
				<tr>
					<td>密碼：</td>
					<td><input type="password" name="password"
						value="${user.password}" /></td>
				</tr>
				<tr>
					<td>暱稱：</td>
					<td><input type="text" name="nickname"
						value="${user.nickname}" /></td>
				</tr>
				<tr>
					<td>性別：</td>
					<td><c:choose>
							<c:when test="${user.sex == \"M\"}">
								<input type="radio" name="sex" value="M" checked="checked" />
								<label>男</label>
								<input type="radio" name="sex" value="F" />
								<label>女</label>
							</c:when>
							<c:otherwise>
								<input type="radio" name="sex" value="M" />
								<label>男</label>
								<input type="radio" name="sex" value="F" checked="checked" />
								<label>女</label>
							</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td>地址：</td>
					<td><input type="text" name="address" value="${user.address}" /></td>
				</tr>
				<tr>
					<td>Email：</td>
					<td><input type="text" name="email" value="${user.email}" /></td>
				</tr>
				<tr>
					<td>年齡：</td>
					<td><input type="text" name="age" value="${user.age}" /></td>
				</tr>
			</table>
			<input class="btn btn-primary" type="submit" value="更新" />
		</form>
	</div>
	<jsp:include page="../Layout/footer.jsp" />
</body>
</html>