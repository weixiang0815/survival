<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<jsp:include page="../Layout/navbar_user.jsp"/>
<h3>使用者修改資料</h3>
	<form:form action="${contextRoot}/player/update1" method="put" modelAttribute="player" enctype="multipart/form-data">
		<table class="table table-hover">
		    <tr>
				<td>大頭貼:</td>
				<td><input type="file" name="thumbnail" />
			</tr>
			<tr>
				<td>ID：</td>
				<td><input type="text" name="id" value="${player.id}" /></td>
			</tr>
			<tr>
				<td>名稱：</td>
				<td><input type="text" name="name" value="${player.name}" /></td>
			</tr>
			<tr>
				<td>帳號：</td>
				<td><input type="text" name="account" value="${player.account}" /></td>
			</tr>
			<tr>
				<td>密碼：</td>
				<td><input type="password" name="password"
					value="${player.password}" /></td>
			</tr>
			<tr>
				<td>暱稱：</td>
				<td><input type="text" name="nickname" value="${player.nickname}" /></td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><input type="Date" name="birthday"  value="${player.birthday}" /></td>
			</tr>
			<tr>
				<td>性別：</td>
				<td>
				<c:choose>
				<c:when test="${player.sex == 'M'}">
					<input type="radio" name="sex" class="form-check-input"  value="M"   checked="checked"/><label>男</label>
					<input type="radio" name="sex" class="form-check-input"  value="F"   /><label>女</label>
				</c:when>
				<c:otherwise>
					<input type="radio" name="sex" class="form-check-input"  value="M"  /><label>男</label>
					<input type="radio" name="sex" class="form-check-input"  value="F"  checked="checked"/><label>女</label>
				</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>縣市：</td>
				<td><input type="text" name="region" value="${player.region}" /></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><input type="text" name="address" value="${player.address}" /></td>
			</tr>
			<tr>
				<td>電話：</td>
				<td><input type="text" name="phone" value="${player.phone}" /></td>
			</tr>
			<tr>
				<td>Email：</td>
				<td><input type="text" name="email" value="${player.email}" /></td>
			</tr>
			<tr>
				<td>年齡：</td>
				<td><input type="text" name="age" value="${player.age}" /></td>
			</tr>
			<tr>
				<td>個人身分證：</td>
				<td><input type="text" name="identity" value="${player.identity_number}" /></td>
			</tr>
			<tr>
				<td>個人介紹：</td>
				<td><input type="hidden" name="info" /></td>
			</tr>	
		</table>
		<input class="btn btn-outline-primary" type="submit"  value="更新"/>
	</form:form>
<jsp:include page="../Layout/footer.jsp"/>
</body>
</html>