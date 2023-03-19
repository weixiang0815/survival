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
<title>訂單詳情</title>
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
<style>
	a.logistics_links {
		font-weight: bolder;
	}

	a.logistics_links:hover {
		color: white;
		background-color: red;
		transition: .2s, ease-in-out;
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
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">訂單詳情</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}/player/${sessionScope.player.id}">個人資料</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">訂單詳情</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->
	<div class="container">
		<h1>產品訂單</h1>
		<table class="table table-hover table-bordered">
			<tr>
				<th>訂單ID</th>
				<th>收件人</th>
				<th>建立日期</th>
				<th>物流詳情</th>
				<th>狀態</th>
				<td></td>
			</tr>
			<c:forEach items="${orderList}" var="show">
				<tr>
					<td>${show.id}</td>
					<td>${show.player.name}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${show.order_create_date}" /></td>
					<c:choose>
					<c:when test="${show.status.equals(\"已棄單\")}">
					<td>已棄單</td>
					<td id="status_${show.id}">已棄單</td>
					<td><button class="formBtn btn btn-secondary btn-sm" disabled>已棄單</button></td>
					</c:when>
					<c:otherwise>
					<td><a class="logistics_links" href="${contextRoot}/front/Market/logistics/${show.id}">物流</a></td>
					<td id="status_${show.id}">${show.status}</td>
					<td><button class="formBtn btn btn-danger btn-sm">棄單</button></td>
					</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
	<script>
		const formBtn = document.getElementsByClassName("formBtn");

		$(document).ready(function() {
			for (let i = 0; i < formBtn.length; i++) {
				let btn = formBtn[i];
				btn.addEventListener("click", function() {
					if (confirm("您確定要棄單嗎？")) {
						let orderid = btn.closest("tr").querySelector("td:first-child").textContent;
						$.ajax({
							url: "${contextRoot}/front/Market/order/dropped3?id=" + orderid,
							method: "get",
							success: function(res){
								if (res == 1) {
									btn.innerHTML = "已棄單";
									btn.classList.remove("btn-danger");
									btn.classList.add("btn-secondary");
									btn.disabled = true;
									document.getElementById("status_" + orderid).innerText = "已棄單";
								}
								$(btn).parent().prevAll().eq(1).html("已棄單");
							},
							error: function(err) {
								console.log(err);
							}
						});
					}
				});
			}
		});
	</script>
</body>
</html>
