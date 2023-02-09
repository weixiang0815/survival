<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>新增使用者</title>
</head>
<body>
<jsp:include page="../Layout/navbar_user.jsp"/>
	<h3>新增使用者</h3>
	<form action="addUser" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>使用者名稱：</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>帳號：</td>
				<td><input type="text" name="account" /></td>
			</tr>
			<tr>
				<td>密碼：</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>暱稱：</td>
				<td><input type="text" name="nickname" /></td>
			</tr>
			<tr>
				<td>性別：</td>
				<td><label>男:</label><input type="radio" name="sex" value="M" /><label>女:</label><input
					type="radio" name="sex" value="F" /></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Email：</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>年齡：</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>圖片:</td>
				<td><input type="file" name="thumbnail" />
			</tr>
			<tr>
				<td><input type="submit" value="註冊" /></td>
			</tr>
		</table>
	</form>
<jsp:include page="../Layout/footer.jsp"/>
</body>
</html>