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

	<div class="card">
		<div class="card-header">修改倉庫</div>
		<div class="card-body">
			<form:form action="${contextRoot}/warehouse/edit"
				modelAttribute="warehouse" method="put">

				<form:input type="hidden" path="id" />
				

				<div class="input-group">
				     <form:input class="form-control" path="place" />
					<form:input class="form-control" path="warehouseName" />
				</div>

				<br />
				<input type="submit" class="btn btn-outline-primary" value="送出"/>
			</form:form>
		</div>
	    </div>
	
</body>
</html>