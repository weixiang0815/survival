<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>員工首頁</title>
</head>
	<jsp:include page="../../Template/admin.jsp" />
<body>
<p>${employee.name}</p>
</body>
</html>