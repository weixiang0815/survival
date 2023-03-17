<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="tw.survival.model.Market.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>購物車</title>
			<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
		</head>

		<body>
			<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>

			<div class="container text-center">
				<h1>您的購物車</h1>
			</div>

			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">商品名稱</th>
						<th scope="col">商品圖片</th>
						<th scope="col">商品種類</th>
						<th scope="col">商品介紹</th>
						<th scope="col">租賃價格</th>
						<th scope="col">販賣價格</th>
						<th scope="col">刪除商品</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${Cart_List}" var="Cart_List" varStatus="Status">
						<tr>
							<th scope="row">${Status.index+1}</th>
							<td>${Cart_List.product.name}</td>
							<td><img alt="" height="100" width="160" src="${contextRoot}/Market/id?id=${Cart_List.product.id}">
							</td>
							<td>${Cart_List.product.product_class}</td>
							<td>${Cart_List.product.context}</td>
							<td>${Cart_List.product.rent_fee}</td>
							<td>${Cart_List.product.price}</td>
							<td>
								<form action="${contextRoot}/Market/Cart/delete" method="post">
									<input name="_method" type="hidden" value="delete" /> 
									<input name="id" type="hidden" value="${Cart_List.id}" /> 
									<input type="submit" class="btn btn-danger btn-sm"
										value="刪除" />
								</form>
							</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>


			<%-- <c:if test="${Cart_List.isEmpty()}">
				<div>
					<h3>目前購物車裡沒有商品</h3>
				</div>
				</c:if>--%>

				<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
				<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
		</body>

		</html>