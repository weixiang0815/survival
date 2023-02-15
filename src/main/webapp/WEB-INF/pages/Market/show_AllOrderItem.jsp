<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有訂單</title>
</head>
<body>
<jsp:include page="Layout/navbar_market.jsp"></jsp:include>
<h1>所有訂單</h1>

<table>
  <jstl:forEach items="${list}" var="show_AllOrderItem">
<div>
	  ${show_AllOrderItem.id}
      ${show_AllOrderItem.order_create_date},
      ${show_AllProduct.status}   
    <div>
    <form action="${contextRoot}/Market/edit" method="get">
    <input name="id" type="hidden" value="${show_AllOrderItem.id}" />
    <input type="submit" class="btn btn-info btn-sm" value="編輯" />
  </form>
  
  <form action="${contextRoot}/Market/delete" method="post">
    <input name="_method" type="hidden" value="delete" />
    <input name="id" type="hidden" value="${show_AllOrderItem.id}" />
    <input type="submit" class="btn btn-danger btn-sm" value="刪除" />
</form>
  </div>
</div>
  </jstl:forEach>
</table>



</body>
</html>