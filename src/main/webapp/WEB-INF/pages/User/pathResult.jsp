<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>Path Result</title>
</head>
<body>
<jsp:include page="../Layout/navbar_user.jsp"/>
	result: ${memberId}
	<br/>
<jsp:include page="../Layout/footer.jsp"/>
</body>
</html>