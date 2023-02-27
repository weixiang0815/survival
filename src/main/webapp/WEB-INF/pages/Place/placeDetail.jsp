<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>場地詳情</title>
</head>
<body>
<jsp:include page="../Template/admin.jsp"></jsp:include>

<div class="container">
<h1>場地詳情</h1>
<br/>
<div class="row">
	<div class="col-2">場地照片:</div>
	<div class="col-6"><img src="${contextRoot}/place/id?id=${place.id}" width="50%"></div>
</div>
<br/>
<div class="row">
	<div class="col-2">場地名稱:</div>
	<div class="col-2">${place.place_name}</div>
</div>
<br/>
<div class="row">
	<div class="col-2">場地地址:</div>
	<div class="col-2">${place.place_address}</div>
</div>
<br/>
<div class="row">
	<div class="col-2">場地費用/時段:</div>
	<div class="col-2">${place.place_fee} 元</div>
</div>
<br/>
<div class="row">
	<div class="col-2">場地容納人數:</div>
	<div class="col-2">${place.place_capacity} 人</div>
</div>

</div>
</body>
</html>