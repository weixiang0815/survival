<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>論壇</title>
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>
<div class="container text-center">
<h1>論壇</h1>
</div>
<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>