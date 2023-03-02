<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>論壇系統首頁</title>

<style>
table{
width: 200px;
}
</style>
</head>
<body>
<jsp:include page="../../Template/admin.jsp"/>
	<div class="container">
		<h1>All Posts</h1>

		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th>貼文名</th>
					<th>貼文類別</th>
					
					<th colspan="2"></th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${List}" var="Post">
					<tr>
						
						<td>${Post.name}</td>
						<td>${Post.classify}</td>
						
						
						<td>
							<form action="${contextRoot}/post/edit" method="get">
								<input name="id" type="hidden" value="${Post.id}" /> 
								<input type="submit" class="btn btn-info btn-sm" value="編輯" />
							</form>
						</td>
						<td>
							<form action="${contextRoot}/post/delete" method="post">
								<input name="_method" type="hidden" value="delete" />
								<input name="id" type="hidden" value="${Post.id}" />
								<input type="submit" class="btn btn-danger btn-sm" value="刪除" />
							</form>
						</td>
					</tr>
	
				</jstl:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>