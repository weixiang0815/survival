<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<p:set var="contextRoot" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="${contextRoot}/place">場地首頁</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
<!-- 					<ul class="navbar-nav"> -->
<!-- 						<li class="nav-item"><a class="nav-link active" -->
<%-- 							aria-current="page" href="${contextRoot}/place">場地系統首頁</a></li> --%>
<!-- 						<li class="nav-item"><a class="nav-link" -->
<%-- 							href="${contextRoot}/place/uploadPage">新增場地</a></li> --%>
<!-- 						<li class="nav-item"><a class="nav-link" -->
<%-- 							href="${contextRoot}/place/all">所有場地</a></li> --%>
<!-- 						<li class="nav-item"><a class="nav-link" -->
<%-- 							href="${contextRoot}/warehouse/new">新增倉庫</a></li>		 --%>
<!-- 						<li class="nav-item"><a class="nav-link" -->
<%-- 							href="${contextRoot}/warehouse/all">所有倉庫</a></li> --%>
<!-- 						<li class="nav-item"><a class="nav-link" -->
<%-- 							href="${contextRoot}/inventory/new">新增庫存表</a></li>	 --%>
<!-- 						<li class="nav-item"><a class="nav-link" -->
<%-- 							href="${contextRoot}/inventory/all">所有庫存表</a></li>		 --%>
<!-- 					</ul> -->
				</div>
			</div>
		</nav>
	</header>
<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://unpkg.com/axios@1.1.2/dist/axios.min.js"></script>
	<script type="text/javascript"
		src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
		<script type="text/javascript"
		src="${contextRoot}/js/jquery-3.6.3.min.js"></script>		
</body>
</html>