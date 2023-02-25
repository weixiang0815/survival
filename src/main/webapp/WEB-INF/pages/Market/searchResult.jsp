<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢商品</title>
</head>
<body>
	<jsp:include page="../Template/admin.jsp"></jsp:include>
	<h1>查詢商品</h1>
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
				<th scope="col">修改商品</th>
				<th scope="col">刪除商品</th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach items="${SearchResult}" var="search" varStatus="Status">
				<tr>
					<th scope="row">${Status.index+1}</th>
					<td>${search.name}</td>
					<td><img alt="" height="100" width="160"
						src="${contextRoot}/Market/id?id=${search.id}"></td>
					<td>${search.product_class}</td>
					<td>${search.context}</td>
					<td>${search.rent_fee}</td>
					<td>${search.price}</td>
					<td>
						<form action="${contextRoot}/Market/edit" method="get">
							<input name="id" type="hidden" value="${search.id}" /> <input
								type="submit" class="btn btn-info btn-sm" value="編輯" />
						</form>
					</td>
					<td>
						<form action="${contextRoot}/Market/delete" method="post">
							<input name="_method" type="hidden" value="delete" /> <input
								name="id" type="hidden" value="${show_AllProduct.id}" /> <input
								type="submit" class="btn btn-danger btn-sm" value="刪除" />
						</form>
					</td>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
</body>
</html>