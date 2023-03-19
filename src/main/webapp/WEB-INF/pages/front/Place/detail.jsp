<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>場地詳情</title>
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
<style type="text/css">
.container {
	text-align: center;
}
</style>

</head>
<body>
	<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>

	<div class="container">
		<h1>場地詳情</h1>
		<br />
		<div class="row">
			<div class="col-12" style="border: #FF0000 2px solid">
				<img src="${contextRoot}/front/place/id?id=${placeDetail.id}"
					width="70%">
			</div>
		</div>
		<div class="row">
			<div class="col-3" style="border: #FF0000 2px solid">
				<br />
				<span style="color: #AAAAAA">場地名稱:</span><br />
				<br />
			</div>
			<div class="col-9" style="border: #FF0000 2px solid">
				<br />
				<span style="color: #AAAAAA">${placeDetail.place_name}</span><br />
				<br />
			</div>
		</div>
		<div class="row">
			<div class="col-3" style="border: #FF0000 2px solid">
				<br />
				<span style="color: #AAAAAA">場地地址:</span><br />
				<br />
			</div>
			<div class="col-9" style="border: #FF0000 2px solid">
				<br />
				<span style="color: #AAAAAA">${placeDetail.place_address}</span><br />
				<br />
			</div>
		</div>
		<div class="row">
			<div class="col-3" style="border: #FF0000 2px solid">
				<br />
				<span style="color: #AAAAAA">場地費用/時段:</span><br />
				<br />
			</div>
			<div class="col-9" style="border: #FF0000 2px solid">
				<br />
				<span style="color: #AAAAAA">${placeDetail.place_fee}元</span><br />
				<br />
			</div>
		</div>
		<div class="row">
			<div class="col-3" style="border: #FF0000 2px solid">
				<br />
				<span style="color: #AAAAAA">場地容納人數:</span><br />
				<br />
			</div>
			<div class="col-9" style="border: #FF0000 2px solid">
				<br />
				<span style="color: #AAAAAA">${placeDetail.place_capacity}人</span><br />
				<br />
			</div>
		</div>
		<br />
		<div class="row">
			<form action="${contextRoot}/front/place/all" method="get">
				<input type="submit" class="btn btn-secondary btn-sm" value="返回" />
			</form>
		</div>

	</div>



	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>