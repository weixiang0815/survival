<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增商品</title>
</head>
<body>
<jsp:include page="Layout/navbar_market.jsp"></jsp:include>
<div class="container">
<h1>新增商品</h1>
<form action="${contextRoot}/ProductRepository/addproduct" method="post" enctype="multipart/form-data">

    <br>
    <input type="text" name="photoName" />商品名稱
    <br>
    <input type="text" name="photoContext" />商品介紹
    <br>
    <input type="text" name="Product_class" />商品種類
    <br>
    <input type="text" name="Price" />商品售出價格
    <br>
    <input type="text" name="setRent_fee" />商品租賃價格
    <br>
    商品圖片
    <input type="file" name="photoFile" id="photoFileInput">
    <br>
    <input id="uploadBtn" type="submit" value="上傳">
  </form>


</div>
</body>
</html>