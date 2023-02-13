<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show all place</title>
</head>
<body>
	<jsp:include page="../Layout/navbar_place.jsp"></jsp:include>
	<div class="container">
		<h1>All Place</h1>

		<table class="table table-hover table-bordered">
			<tr>
				<th>照片</th>
				<th>名稱</th>
				<th>地址</th>
				<th>費用/小時</th>
				<th>容納人數</th>
				<th colspan="2"></th>
			</tr>
			<jstl:forEach items="${list}" var="onePlace">
<<<<<<< HEAD

				<div>
					<img alt="" src="${contextRoot}/place/id?id=${onePlace.id}">


<<<<<<< HEAD
					場地名稱:${onePlace.place_name} 場地地址:${onePlace.place_address}

					場地費用/小時:${onePlace.place_fee} 容納人口數:${onePlace.place_capacity}
=======
					場地名稱:${onePlace.place_name}, 場地地址:${onePlace.place_address},

					場地費用/小時:${onePlace.place_fee}, 容納人口數:${onePlace.place_capacity}
>>>>>>> 3fd04a606c07b16f9c7ee4e80481969f5c0921a9


					<form action="${contextRoot}/place/edit" method="get">
						<input name="id" type="hidden" value="${onePlace.id}" /> <input
							type="submit" class="btn btn-info btn-sm" value="編輯" />
					</form>
					<form action="${contextRoot}/place/delete" method="post">
						<input name="_method" type="hidden" value="delete" /> <input
							name="id" type="hidden" value="${onePlace.id}" /> <input
							type="submit" class="btn btn-danger btn-sm" value="刪除" />
					</form>
				</div>

=======
				<tr>
					<td><img alt=""
						src="${contextRoot}/place/id?id=${onePlace.id}"></td>
					<td>${onePlace.place_name}</td>
					<td>${onePlace.place_address}</td>
					<td>${onePlace.place_fee}</td>
					<td>${onePlace.place_capacity}</td>
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
>>>>>>> a1d3652299ac9f65c8b28f18ee63b5d8aaf1e833
			</jstl:forEach>
		</table>
	</div>

</body>
</html>