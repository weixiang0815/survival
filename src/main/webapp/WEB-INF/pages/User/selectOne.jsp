<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>查詢結果</title>
</head>
<body>
<jsp:include page="../Layout/navbar_user.jsp"/>
	<h3>查詢結果</h3>
		<table>
				<tr><td><label>使用者ID：</label>${user.id}
				<tr><td><label>使用者名稱：</label>${user.name}
				<tr><td><label>使用者帳號：</label>${user.account}
				<tr><td><label>使用者密碼：</label>${user.password}
				<tr><td><label>使用者暱稱：</label>${user.nickname}
				<tr><td><label>使用者性別：</label>
				<c:choose>
				<c:when test="${user.sex == \"M\"}">男</c:when>
				<c:otherwise>女</c:otherwise>
				</c:choose>
				<tr><td><label>使用者地址：</label>${user.address}
				<tr><td><label>使用者電子信箱：</label>${user.email}
				<tr><td><label>使用者年齡：</label>${user.age}
		</table>
		<a href="updateUserById?id=${user.id}"><button>編輯此資料</button></a>
		<a href="deleteUserById?id=${user.id}"><button>刪除此資料</button></a>
		<a href="searchmain.controller"><button>回到搜尋頁</button></a>
<jsp:include page="../Layout/footer.jsp"/>
</body>
</html>