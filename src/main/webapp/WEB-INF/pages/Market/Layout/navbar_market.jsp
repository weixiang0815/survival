<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet" />


</head>
<body>

	<nav class="navbar navbar-expand-lg" style="background-color: #DCDCDC">
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
					<li class="nav-item"><a class="nav-link" href="${contextRoot}/????????">服裝</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${contextRoot}/????????">消耗品</a>
					</li>
					
					
				</ul>
			</div>
		</div>
	</nav>
	
	<script src="https://unpkg.com/axios@1.1.2/dist/axios.min.js"></script>
	<script type="text/javascript"
		src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
		<script type="text/javascript"
		src="${contextRoot}/js/jquery-3.6.3.min.js"></script>
		
		
</body>
</html>