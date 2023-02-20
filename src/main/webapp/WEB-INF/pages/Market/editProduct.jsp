<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改訊息</title>
</head>
<body>
	<jsp:include page="Layout/navbar_market.jsp"></jsp:include>

	<div class="container">
		<h1>修改訊息 Page</h1>

		<div class="card">
			<div class="card-header">修改訊息</div>
			<div class="card-body">
				<form action="${contextRoot}/Market/edit" method="post"
					enctype="multipart/form-data">
					<input type="text" name="id" value="${product.id}" hidden />
					<table class="table table-hover">
						<tr>
							<td colspan="2"><img style="max-width: 100%;"
								src="${contextRoot}/Market/id?id=${product.id}" /></td>
						</tr>
						<tr>
							<td>商品圖片:</td>
							<td><input type="file" name="img" />
						</tr>
						<tr>
							<td>商品名稱：</td>
							<td><input type="text" name="name" value="${product.name}" /></td>
						</tr>
						<tr>
							<td>商品分類：</td>
							<td><select  type="text" name="Product_class">
								<option>請選擇商品種類</option>
								<option>手槍</option>
								<option>步槍</option>
								<option>衝鋒槍</option>
								<option>狙擊槍</option>
								<option>霰彈槍</option>
							</select></td>
							<!-- <td><input type="text" name="product_class"
								value="${product.product_class}" /></td> -->
						</tr>
						<tr>
							<td>商品敘述：</td>
							<td><input type="text" name="context"
								value="${product.context}" /></td>
						</tr>
						<tr>
							<td>租賃價格：</td>
							<td><input type="text" name="rent_fee"
								value="${product.rent_fee}" /></td>
						</tr>
						<tr>
							<td>買賣價格：</td>
							<td><input type="text" name="price" value="${product.price}" /></td>
						</tr>

					</table>
					<input class="btn btn-primary" type="submit" value="更新" />

				</form>

			</div>
		</div>

	</div>
</body>
</html>