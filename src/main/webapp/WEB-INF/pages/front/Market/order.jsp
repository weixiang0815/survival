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
					<td>${show.status}</td>
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
						
						let orderid = button.closest("tr").querySelector("td:first-child").textContent;
						let xhr = new XMLHttpRequest();
						xhr.onreadystatechange = function() {
							if (this.readyState === 4 && this.status === 200) {
								location.reload();
							}
						}
						xhr.open("GET", "${contextRoot}/front/Market/order/dropped3?id=" + orderid, true);
						xhr.send();
					}
				}
			}
		</script>
	</div>

	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>
