<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="utf-8">
<title>${statusCode}錯誤</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<jsp:include page="../Template/front/includedinhead.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../Template/front/navbar.jsp"></jsp:include>
	<div class="container-xxl py-5 wow fadeInUp" data-wow-delay="0.1s">
		<div class="container text-center">
			<div class="row justify-content-center">
				<div class="col-lg-6">
					<i class="bi bi-exclamation-triangle display-1 text-primary"></i>
					<c:choose>
						<c:when test="${statusCode == 400}">
							<h1 class="display-1">${statusCode}</h1>
							<h1 class="mb-4">錯誤請求</h1>
							<p class="mb-4">很抱歉，你尋找的頁面不在我們的網站裡。要不要回到首頁？</p>
						</c:when>
						<c:when test="${statusCode == 403}">
							<h1 class="display-1">${statusCode}</h1>
							<h1 class="mb-4">沒有權限</h1>
							<p class="mb-4">很抱歉，你尋找的頁面不在我們的網站裡。要不要回到首頁？</p>
						</c:when>
						<c:when test="${statusCode == 404}">
							<h1 class="display-1">${statusCode}</h1>
							<h1 class="mb-4">頁面不存在</h1>
							<p class="mb-4">很抱歉，我們的程式功力不足😥，歡迎一個月花五萬培養我們👍</p>
							<p class="mb-4">要不要回到首頁？</p>
						</c:when>
						<c:when test="${statusCode == 405}">
							<h1 class="display-1">${statusCode}</h1>
							<h1 class="mb-4">請求方法被禁或不可用</h1>
							<p class="mb-4">很抱歉，你尋找的頁面不在我們的網站裡。要不要回到首頁？</p>
						</c:when>
						<c:when test="${statusCode == 500}">
							<h1 class="display-1">${statusCode}</h1>
							<h1 class="mb-4">伺服器發生錯誤</h1>
							<p class="mb-4">很抱歉，你尋找的頁面不在我們的網站裡。要不要回到首頁？</p>
						</c:when>
						<c:otherwise>
							<h1 class="display-1">${statusCode}</h1>
							<h1 class="mb-4">出現錯誤</h1>
							<p class="mb-4">很抱歉，我們的程式功力不足😥。要不要回到首頁？</p>
						</c:otherwise>
					</c:choose>
					<a id="no" class="btn btn-primary py-3 px-5" data-bs-toggle="modal"
						data-bs-target="#no-modal" href="${contextRoot}">我才不要</a> <a
						class="btn btn-primary py-3 px-5" href="${contextRoot}">回到首頁</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Scrollable modal -->
	<div class="modal fade" id="no-modal" tabindex="-1"
		aria-labelledby="terms-title" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 style="color: black;" class="modal-title fs-5" id="terms-title">你確定🤨</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<img style="max-width: 100%;" src="${contextRoot}/images/404梗圖.png">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">關閉</button>
				</div>
			</div>
		</div>
	</div>
	<!-- ${statusCode} End -->
	<jsp:include page="../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>