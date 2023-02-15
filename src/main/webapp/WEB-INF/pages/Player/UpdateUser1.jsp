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
	<form:form action="${contextRoot}/player/update1" method="put" modelAttribute="player">
		<table class="table table-hover">
		    <tr>
				<td>大頭貼:</td>
				<td><input type="file" name="thumbnail" value="上傳圖片" />
			</tr>
			<tr>
				<td>ID：</td>
				<td><form:input type="text" path="id" value="${player.id}" /></td>
			</tr>
			<tr>
				<td>名稱：</td>
				<td><form:input type="text" path="name" value="${player.name}" /></td>
			</tr>
			<tr>
				<td>帳號：</td>
				<td><form:input type="text" path="account" value="${player.account}" /></td>
			</tr>
			<tr>
				<td>密碼：</td>
				<td><form:input type="password" path="password"
					value="${player.password}" /></td>
			</tr>
			<tr>
				<td>暱稱：</td>
				<td><form:input type="text" path="nickname" value="${player.nickname}" /></td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><form:input type="Date" path="birthday" value="${player.birthday}" /></td>
			</tr>
			<tr>
				<td>性別：</td>
				<td>
				<c:choose>
				<c:when test="${player.sex == 'M'}">
					<form:radiobutton name="sex" class="form-check-input" path="sex" value="M" label="男" required="true" checked="checked"/>
					<form:radiobutton name="sex" class="form-check-input" path="sex" value="F" label="女" required="true" />
				</c:when>
				<c:otherwise>
					<form:radiobutton name="sex" class="form-check-input" path="sex" value="M" label="男" required="true"/>
					<form:radiobutton name="sex" class="form-check-input" path="sex" value="F" label="女" required="true" checked="checked"/>
				</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>縣市：</td>
				<td><form:input type="text" path="region" value="${player.region}" /></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><form:input type="text" path="address" value="${player.address}" /></td>
			</tr>
			<tr>
				<td>電話：</td>
				<td><form:input type="text" path="phone" value="${player.phone}" /></td>
			</tr>
			<tr>
				<td>Email：</td>
				<td><form:input type="text" path="email" value="${player.email}" /></td>
			</tr>
			<tr>
				<td>年齡：</td>
				<td><form:input type="text" path="age" value="${player.age}" /></td>
			</tr>
			<tr>
				<td>個人身分證：</td>
				<td><form:input type="text" path="identity_number" value="${player.identity_number}" /></td>
			</tr>
		</table>
		<input class="btn btn-outline-primary" type="submit"  value="更新"/>
	</form:form>
<jsp:include page="../Layout/footer.jsp"/>
</body>
</html>