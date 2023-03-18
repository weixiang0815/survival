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
<style>
.container{
text-align: center;
}

</style>
</head>
<body>
	<jsp:include page="../../Template/admin.jsp"></jsp:include>

	<div class="container">
		<h1>場地詳情</h1>
		<br />
		<div class="row">
			<div class="col-12" style="border: #DDDDDD 2px solid">
				<img src="${contextRoot}/place/id?id=${place.id}" width="100%">
			</div>
		</div>
		<div class="row">
			<div class="col-3" style="border: #DDDDDD 2px solid"><br/><span>場地名稱:</span><br/><br/></div>
			<div class="col-9" style="border: #DDDDDD 2px solid"><br/><span>${place.place_name}</span><br/><br/></div>
		</div>
		<div class="row">
			<div class="col-3" style="border: #DDDDDD 2px solid"><br/><span>場地地址:</span><br/><br/></div>
			<div class="col-9" style="border: #DDDDDD 2px solid"><br/><span>${place.place_address}</span><br/><br/></div>
		</div>
		<div class="row">
			<div class="col-3" style="border: #DDDDDD 2px solid"><br/><span>場地費用/時段:</span><br/><br/></div>
			<div class="col-9" style="border: #DDDDDD 2px solid"><br/><span>${place.place_fee}元</span><br/><br/></div>
		</div>
		<div class="row" >
			<div class="col-3" style="border: #DDDDDD 2px solid"><br/><span>場地容納人數:</span><br/><br/></div>
			<div class="col-9" style="border: #DDDDDD 2px solid"><br/><span>${place.place_capacity}人</span><br/><br/></div>
		</div>
		<br />
		<div class="row">
			<form action="${contextRoot}/warehouse/all" method="get">
				<input name="id" type="hidden" value="${warehouse.id}" /> <input
					type="submit" class="btn btn-secondary btn-sm" value="返回" />
			</form>
		</div>
		<br/>

	</div>
</body>
</html>