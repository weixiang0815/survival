<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, tw.survival.model.User.UserBean"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢全部結果</title>
</head>
<body>
	<h3>查詢全部結果</h3>
	<table>
		<c:forEach items="${users}" var="user">
			<tr>
				<td><label>使用者ID：</label>${user.id}
				<td><label>使用者名稱：</label>${user.name}
				<td><label>使用者帳號：</label>${user.account}
				<td><label>使用者密碼：</label>${user.password}
				<td><label>使用者性別：</label>${user.sex}
				<td><label>使用者地址：</label>${user.address}
				<td><label>使用者電子信箱：</label>${user.email}
				<td><label>使用者年齡：</label>${user.age}
		</c:forEach>
	</table>
	<a href="searchmain.controller"><button>回到搜尋頁</button></a>
</body>
</html>