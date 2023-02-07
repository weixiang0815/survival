<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="${contextRoot}/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-expand-lg" style="background-color: #DCDCDC">
		<div class="container-fluid">
			<a class="navbar-brand" href="${contextRoot}/">新抖音</a>
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
					<li class="nav-item"><a class="nav-link" href="${contextRoot}/messages/add">新增訊息</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${contextRoot}/message/page">查看訊息</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${contextRoot}/playAjax/intro1">Ajax Intro1</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${contextRoot}/playAjax/sendPage">Ajax Send</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${contextRoot}/playAjax/message">Ajax Message</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${contextRoot}/goodphoto/uploadPage">UploadPage</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${contextRoot}/goodphoto/uploadPageAjax">UploadPageAjax</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${contextRoot}/goodphoto/all">All Photo</a>
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