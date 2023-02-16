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
<title>修改倉庫</title>
</head>
<body>
	<jsp:include page="../Layout/navbar_place.jsp"></jsp:include>
	<div class="container">
		<div class="card">
			<div class="card-header">修改倉庫</div>
			<div class="card-body">
				<div class="row">
					<form:form action="${contextRoot}/warehouse/edit"
						modelAttribute="warehouse" method="put">
						<form:input type="hidden" path="id" />
						<div class="input-group">
							<div class="col-6">${place.place_name}</div>
							<div class="col-6">
								<form:input class="form-control" path="warehouseName" />
							</div>
						</div>
						<div class="col">
							<input type="submit" class="btn btn-outline-primary" value="送出" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>