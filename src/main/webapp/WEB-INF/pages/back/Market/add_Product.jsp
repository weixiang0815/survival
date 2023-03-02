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
<title>新增商品</title>
<style>
.st1 {
	width: 450px;
	margin: 20px;
	padding-bottom: 10px;
}

.t1 {
	width: 100px;
	float: left;
	text-align: right;
}

/* .img{
              float: right;
              text-align: right;
              clear:left;
              margin: 0 auto;
            } */
.sub {
	/* width: 450px;
            margin: 20px; */
	text-align: center;
}
</style>

</head>

<body>
	<jsp:include page="../../Template/admin.jsp"></jsp:include>
	<div class="container">
		<div class="st1">
			<h1>新增商品</h1>
		</div>
		<form action="${contextRoot}/Market/addproduct" method="post"
			enctype="multipart/form-data">

			<div class="st1">
				<label class="t1"> 商品名稱: </label> <input type="text"
					style="width: 253px" name="ProductName" />
			</div>

			<div class="st1">
				<label class="t1"> 商品介紹: </label>
				<textarea name="ProductContext" id="comment1" cols="30" rows="5"></textarea>
				<!-- <input type="text"  name="photoContext" /> -->
			</div>

			<div class="st1">
				<label class="t1"> 商品種類: </label> <select type="text"
					name="Product_class">
					<option>請選擇商品種類</option>
					<option>手槍</option>
					<option>步槍</option>
					<option>衝鋒槍</option>
					<option>狙擊槍</option>
					<option>霰彈槍</option>
				</select>
				<!-- <input type="text" style="width:253px" name="Product_class" /> -->
			</div>

			<div class="st1">
				<label class="t1"> 售出價格: </label> <input type="text"
					style="width: 253px" name="Price" />
			</div>

			<div class="st1">
				<label class="t1"> 租賃價格: </label> <input type="text"
					style="width: 253px" name="setRent_fee" />
			</div>

			<div class="st1">
				<label class="t1"> 商品圖片: </label> <input accept="image/*"
					type="file" name="ProductFile" id="ProductFileInput"> <label
					class="t1"> <img id="blah" height="150" src="#" alt="" /></label>
			</div>


			<div class="sub">
				<input id="uploadBtn" type="submit" value="新增商品">
			</div>

		</form>

		<script>
              ProductFileInput.onchange = evt => {
                  const [file] = ProductFileInput.files
                  if (file) {
                    blah.src = URL.createObjectURL(file)
                  }
                }
              </script>
	</div>
</body>

</html>