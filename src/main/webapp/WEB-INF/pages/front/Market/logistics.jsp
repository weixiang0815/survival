<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="tw.survival.model.Market.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>物流詳情</title>
<link rel="stylesheet" href="style.css">
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	List-style: none;
}

.step {
	width: 500px;
	margin: 100px auto;
}

ul#comp-link>li {
	list-style-type: none;
}

ul li {
	list-style: none;
}

.list {
	width: 100%;
	display: flex;
	justify-content: center;
}

.list li {
	font-family: 'Noto Sans TC', sans-serif;
	display: flex;
	flex-direction: column;
	justify-content: center;
	text-align: center;
	width: 125px;
	height: 125px;
	background-image: linear-gradient(9deg, #185a9d, #43cea2);
	border-radius: 50%;
	position: relative;
	font-size: 20px;
	color: #fff;
	box-shadow: 0px 0px 0px 4px #fff;
}

.list li .fa {
	font-size: 20px;
	margin-bottom: 6px;
}

.list li+li {
	margin-Left: 100px;
}

.list li+li::before {
	content: '';
	position: absolute;
	width: 100px;
	height: 5px;
	background-color: #43cea2;
	z-index: -1;
	box-shadow: 0px 0px 0px 5px #fff;
	top: 0;
	bottom: 0;
	left: -100px;
	margin: auto;
}

.list li.active ~ li {
	background-image: linear-gradient(9deg, #999, #ccc);
}

.list li.active ~ li::before {
	background-color: #999;
}

.list fmt {
	font-size: 5px;
}
</style>

</head>
<body>
	<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>
	<!-- Page Header Start -->
	<div class="container-fluid page-header py-5 mb-5 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container text-center py-5">
			<h1
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">物流詳情</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}/player/${sessionScope.player.id}">個人資料</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">物流詳情</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->
	<div class="container">
		<h1>物流詳情</h1>
		<br> <br> <br> 
		<table class="table table-hover table-bordered">
			<ol class="list">
				<li class="${logistics.status eq '收到訂單' ? 'active' : ''}"><i
					class="fa fa-file-text" aria-hidden="true"></i>收到訂單 <fmt:formatDate
						pattern="yyyy/MM/dd " value="${logistics.start_date}" /></li>
				<li class="${logistics.status eq '處理中' ? 'active' : ''}"><i
					class="fa fa-archive" aria-hidden="true"></i>處理中</li>
				<li class="${logistics.status eq '已出貨' ? 'active' : ''}"><i
					class="fa fa-truck" aria-hidden="true"></i>已出貨</li>
				<li class="${logistics.status eq '已到貨' ? 'active' : ''}"><i
					class="fa fa-check-circle" aria-hidden="true"></i>已到貨 <fmt:formatDate
						pattern="yyyy/MM/dd " value="${logistics.arrive_date}" /></li>
			</ol>
		</table>
	</div>

	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>