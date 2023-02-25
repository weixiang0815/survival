<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />


</head>
<body>

	<nav class="navbar navbar-expand-lg" style="background-color: #DCDCDC ">
		<div class="container-fluid">
			<a class="navbar-brand" href="${contextRoot}/">赫赫商城</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="${contextRoot}/">首頁</a></li>
					<li class="nav-item"><a class="nav-link" href="${contextRoot}/Market/add_Product">新增商品</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${contextRoot}/Market/allProduct">全部商品</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${contextRoot}/Market/add_OrderItem">新增訂單</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${contextRoot}/Market/all_OrderItem">所有訂單</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${contextRoot}/Market/add_Logistics">新增物流訂單</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${contextRoot}/Market/all_Logistics">查看物流訂單</a>
					</li>
					
					
				</ul>
			</div>
		</div>
		
		<!-- 搜尋欄位 -->
		<form class="d-flex" role="search" action="${contextRoot}/Market/productNameLike" method="post">
			<input name="Search" class="form-control me-2" type="search" placeholder="Search"
				aria-label="Search">
			<button id="Search" class="btn btn-outline-success" type="submit">Search</button>
		</form>

	</nav>

	<script src="https://unpkg.com/axios@1.1.2/dist/axios.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>


</body>
</html>