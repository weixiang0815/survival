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
<title>修改場地</title>
</head>
<body>
<jsp:include page="../../Template/admin.jsp"></jsp:include>
<div class="container">
		<h1>修改場地資訊</h1>

		<div class="card">
			<div class="card-header">修改場地</div>
			<div class="card-body">
				<form action="${contextRoot}/place/edit" method="post"
					enctype="multipart/form-data">
					<input type="text" name="id" value="${place.id}" hidden />
					<table class="table table-hover">
						<tr>

							<td colspan="2"><img src="${contextRoot}/place/id?id=${place.id}" /></td>
						</tr>
						<tr>
							<td>場地圖片:</td>
							<td><input type="file" name="place_photo" />

						</tr>
						<tr>
							<td>場地名稱：</td>
							<td><input type="text" name="place_name" value="${plcae.place_name}" /></td>
						</tr>
						<tr>
							<td>場地地址：</td>
							<td><input type="text" name="place_address"
								value="${place.place_address}" /></td>
						</tr>
						<tr>
							<td>場地費用/小時：</td>
							<td><input type="text" name="place_fee"
								value="${place.place_fee}" /></td>
						</tr>
						<tr>
							<td>容納人口數：</td>
							<td><input type="text" name="place_capacity"
								value="${place.place_capacity}" /></td>
						</tr>
						
					</table>
					<input class="btn btn-primary" type="submit" value="更新" />

				</form>

			</div>
		</div>

	</div>
</body>
</html>