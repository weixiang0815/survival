<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>搜尋活動</title>
</head>
<body>
<jsp:include page="../Layout/navbar_competition.jsp"/>
<div class="container">
<h1>搜尋活動</h1>
<form action="${contextRoot}/competition/search/result" method="get">
    <label for="searchAll">搜尋全部</label>
    <input type="submit" value="搜尋">
</form>
</div>
<%-- <jsp:include page="../Layout/footer.jsp"/> --%>
</body>
</html>