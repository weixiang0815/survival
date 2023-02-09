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

<table>
  <jstl:forEach items="${list}" var="show_AllProduct">
<div>
      ${show_AllProduct.name},
      <img alt="" src="${contextRoot}/Market/id?id=${show_AllProduct.id}">,
      ${show_AllProduct.product_class},
      ${show_AllProduct.context},
      ${show_AllProduct.rent_fee},
      ${show_AllProduct.price}   
    <div>
  <form action="${contextRoot}/Market/edit" method="get">
    <input name="id" type="hidden" value="${show_AllProduct.id}" />
    <input type="submit" class="btn btn-info btn-sm" value="編輯" />
  </form>
  
  <form action="${contextRoot}/Market/delete" method="post">
    <input name="_method" type="hidden" value="delete" />
    <input name="id" type="hidden" value="${show_AllProduct.id}" />
    <input type="submit" class="btn btn-danger btn-sm" value="刪除" />
</form>
  </div>
</div>
  </jstl:forEach>
</table>



</body>
</html>