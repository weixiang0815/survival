<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
      <th scope="col">修改商品</th>
      <th scope="col">刪除商品</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${Cart_List}" var="show_CartProduct" varStatus="Status">
    <tr>
      <th scope="row">${Status.index+1}</th>
      <td>${show_CartProduct.name}</td>
      <td><img alt="" height="100" width="160" src="${contextRoot}/Market/id?id=${show_CartProduct.id}"></td>
      <td>${show_CartProduct.product_class}</td>
      <td>${show_CartProduct.context}</td>
      <td>${show_CartProduct.rent_fee}</td>
      <td>${show_CartProduct.price}</td>
      <td>
        <form action="${contextRoot}/back/Market/edit" method="get">
          <input name="id" type="hidden" value="${show_CartProduct.id}" />
          <input type="submit" class="btn btn-info btn-sm" value="編輯" />
        </form>
      </td>
      <td>
        <form action="${contextRoot}/back/Market/delete" method="post">
          <input name="_method" type="hidden" value="delete" />
          <input name="id" type="hidden" value="${show_CartProduct.id}" />
          <input type="submit" class="btn btn-danger btn-sm" value="刪除" />
      </form>
      </td>
    </tr>
  
  
  

  </c:forEach>
</tbody>
</table>





<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>