<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有場地</title>
</head>
<body>
	<jsp:include page="../../Template/admin.jsp"></jsp:include>
	<div class="container">
		<h1>所有場地</h1>

		<table class="table table-hover table-bordered text-center">
			<tr>
				<th>照片</th>
				<th>名稱</th>
				<th>地址</th>
				<th>費用/時段</th>
				<th>容納人數</th>
				<th colspan="2"></th>
			</tr>
			<jstl:forEach items="${list}" var="onePlace">
				<tr>
					<td class="col-5"><img alt=""
						src="${contextRoot}/place/id?id=${onePlace.id}" width="100%"></td>
					<td class="col-1">${onePlace.place_name}</td>
					<td class="col-3">${onePlace.place_address}</td>
					<td class="col-1">${onePlace.place_fee} 元</td>
					<td class="col-1">${onePlace.place_capacity} 人</td>
					<td>
						<form action="${contextRoot}/place/edit" method="get">
							<input name="id" type="hidden" value="${onePlace.id}" /> <input
								type="submit" class="btn btn-info btn-sm" value="編輯" />
						</form>
					</td>
					<td>
						<form action="${contextRoot}/place/delete" method="post">
							<input name="_method" type="hidden" value="delete" />
							<input name="id" type="hidden" value="${onePlace.id}" />
							<input type="submit" class="btn btn-danger btn-sm" value="刪除" />
						</form>
					</td>
				</tr>

			</jstl:forEach>
		</table>
	</div>

</body>
</html>