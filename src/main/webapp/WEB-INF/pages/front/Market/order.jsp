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
<link rel="stylesheet" href="style.css">
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>

	<div class="container">
		<h1>產品物流</h1>
		<table class="table table-hover table-bordered">
			<tr>
				<th>訂單ID</th>
				<th>收件人</th>
				<th>建立日期</th>
				<th>狀態</th>
				<td colspan="2.5"></td>
			</tr>
			
			<c:forEach items="${orderList}" var="show">
				<tr>
					<td>${show.id}</td>
					<td>${show.player.name}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${show.order_create_date}" /></td>
					<td >${show.status}</td>
					<td><button onclick="toggleStatus(this)"
							class="formBtn btn btn-danger btn-sm">棄單</button></td>
				</tr>
			</c:forEach>
		</table>
		<script>
			function toggleStatus(button) {
				if (confirm("您確定要棄單嗎？")) {
					if (button.innerHTML == "棄單") {
						button.innerHTML = "已棄單";
						button.classList.remove("btn-danger");
						button.classList.add("btn-secondary");
						button.disabled = true;
					} else {
						button.innerHTML = "棄單";
						button.classList.remove("btn-secondary");
						button.classList.add("btn-danger");
					}
				}
			}const buttons = document.querySelectorAll(".formBtn");
			const actionURL = "${contextRoot}/front/Market/order";
			const orderid = document.getElementById("id").value;
			const resultPlace = document.getElementById("result");
			const statusPlace = document.getElementById("status");

			$(document).ready(function () {
				for (let i = 0; i < buttons.length; i++) {
					buttons[i].addEventListener("click", function (e) {
						e.preventDefault();
						let action = this.id;
						let status = this.innerText;
						let url = actionURL + action + "?id=" + parseInt(orderid);
						axios.get(url)
						.then(res => {
							let result = res.data;
							console.log(result);
						}).catch(err => {
							console.log(err);
						});
					})
				}
			});
		</script>
	</div>

	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>