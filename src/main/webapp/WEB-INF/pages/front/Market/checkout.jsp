<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="tw.survival.model.Market.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結帳頁面</title>
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>
	<!-- Page Header Start -->
	<div class="container-fluid page-header py-5 mb-5 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container text-center py-5">
			<h1
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">結帳頁面</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}/front/Market/shop">戰略商城</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">結帳頁面</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->
	<div class="container">
		<div class="container text-center">
			<h1>確認您購買的商品</h1>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">商品名稱</th>
					<th scope="col">商品圖片</th>
					<th scope="col">種類</th>
					<th scope="col">商品介紹</th>
					<th scope="col">租賃價格</th>
					<th scope="col">販賣價格</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orderItem.products}" var="product"
					varStatus="Status">
					<tr>
						<th scope="row">${Status.index+1}</th>
						<td>${product.name}</td>
						<td><img alt="" height="100" width="160"
							src="${contextRoot}/Market/id?id=${product.id}"></td>
						<td>${product.product_class}</td>
						<td>${product.context}</td>
						<td>${product.rent_fee}</td>
						<td>${product.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container text-center">
			<a href="${contextRoot}/front/Market/getAllProductFront"
				class="nav-item nav-link active">返回商品頁</a>
		</div>
	</div>
	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
	<!-- <script>
		const checkout = $("#checkout");
		const cartIds = $("input[name='checkproduct']");

		$("document").ready(function() {
			cartIds.on({
				change : function() {
					let cartId = this.value;
					if(this.checked) {
						let str = `<input type="checkbox" name="cartIds"
							value="` + cartId + `" id="` + cartId + `" checked hidden>`;
						checkout.prepend(str);
					} else {
						document.getElementById(cartId).remove();
					}
					console.log(checkout.html());;
				}
			});
		});
	</script> -->
</body>

</html>