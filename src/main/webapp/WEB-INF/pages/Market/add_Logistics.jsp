<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增物流訂單</title>
</head>
<body>
<jsp:include page="Layout/navbar_market.jsp"></jsp:include>
<div class="container">
<h1>新增物流訂單</h1>
<form action="${contextRoot}/Market/addLogistics" method="post" >

	<br>
	物流開始時間:<input type="date" name="start_date" />
	<br>
	物流抵達時間:<input type="date" name="arrive_date" />
	<br>
	物流狀況:<input type="text" name="Logistics_status" />
	<br>   	    
	<input id="uploadBtn" type="submit" value="上傳">
	
</form>

</div>
</body>
</html>