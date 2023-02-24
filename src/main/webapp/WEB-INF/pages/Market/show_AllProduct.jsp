<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有商品</title>
</head>
<body>
<jsp:include page="Layout/navbar_market.jsp"></jsp:include>
<h1>所有商品</h1>

<form action="${contextRoot}/Market/productIn" method="get">
  <input type="checkbox" id="vehicle1" name="product_class" value="手槍">
  <label for="vehicle1"> 手槍</label><br>

  <input type="checkbox" id="vehicle2" name="product_class" value="步槍">
  <label for="vehicle2"> 步槍</label><br>

  <input type="checkbox" id="vehicle3" name="product_class" value="衝鋒槍">
  <label for="vehicle3"> 衝鋒槍</label><br>
  
  <input type="checkbox" id="vehicle4" name="product_class" value="狙擊槍">
  <label for="vehicle3"> 狙擊槍</label><br>
  
  <input type="checkbox" id="vehicle5" name="product_class" value="霰彈槍">
  <label for="vehicle3"> 霰彈槍</label><br>

  <input type="submit" value="submit">
</form>

<!-- 改成用直接打勾就可以搜尋，要用監聽去看打勾選項與否的動作 -->

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
  <jstl:forEach items="${list}" var="show_AllProduct" varStatus="Status">
    <tr>
      <th scope="row">${Status.index+1}</th>
      <td>${show_AllProduct.name}</td>
      <td><img alt="" height="100" width="160" src="${contextRoot}/Market/id?id=${show_AllProduct.id}"></td>
      <td>${show_AllProduct.product_class}</td>
      <td>${show_AllProduct.context}</td>
      <td>${show_AllProduct.rent_fee}</td>
      <td>${show_AllProduct.price}</td>
      <td>
        <form action="${contextRoot}/Market/edit" method="get">
          <input name="id" type="hidden" value="${show_AllProduct.id}" />
          <input type="submit" class="btn btn-info btn-sm" value="編輯" />
        </form>
      </td>
      <td>
        <form action="${contextRoot}/Market/delete" method="post">
          <input name="_method" type="hidden" value="delete" />
          <input name="id" type="hidden" value="${show_AllProduct.id}" />
          <input type="submit" class="btn btn-danger btn-sm" value="刪除" />
      </form>
      </td>
    </tr>
  
  
  

  </jstl:forEach>
</tbody>
</table>

<%-- 除圖片外其他改成FORM FORM表單 --%>


</body>
</html>