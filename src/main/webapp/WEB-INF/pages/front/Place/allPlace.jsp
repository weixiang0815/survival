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
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
<style type="text/css">
h2.placeNames {
	color: red;
	display: inline-block;
	border-radius: 10px;
}

h2.placeNames:hover {
	color: white;
	background-color: red;
}
</style>
</head>
<body>
	<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>

	<div class="row">
		<div class="col-3"></div>
		<div class="col-6">
			<table class="table table-hover table-bordered">
				<jstl:forEach items="${placelist}" var="frontplace">
					<tr>
						<td class="text-center"><a
							href="${contextRoot}/front/place/detail?id=${frontplace.id}"><img
								alt="" src="${contextRoot}/front/place/id?id=${frontplace.id}"
								width="100%">
							<h2 class="placeNames">${frontplace.place_name}</h2></a></td>

					</tr>

				</jstl:forEach>
			</table>
		</div>
	</div>

	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>