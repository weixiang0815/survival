<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="tw.survival.model.Market.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有物流</title>
</head>
<body>
	<jsp:include page="../../Template/admin.jsp"></jsp:include>
	<h1>所有物流</h1>
	<div>
		<input class="form-check-input" type="checkbox" name="condition"
			id="all"> <label class="form-check-label" for="all">全部</label>
		<input class="form-check-input" type="checkbox" name="condition"
			id="processing"> <label class="form-check-label"
			for="processing">處理中</label> <input class="form-check-input"
			type="checkbox" name="condition" id="sentout"> <label
			class="form-check-label" for="sentout">已出貨</label> <input
			class="form-check-input" type="checkbox" name="condition"
			id="arrived"> <label class="form-check-label" for="arrived">已到貨</label>
		<input class="form-check-input" type="checkbox" name="condition"
			id="received"> <label class="form-check-label" for="dropped">棄單</label>
	</div>
	<table class="table table-hover table-bordered">
		<thead>
			<tr>
				<td>ID</td>
				<td>收件人</td>
				<td>起始日期</td>
				<td>到貨日期</td>
				<td>狀態</td>
			</tr>
		</thead>
		<tbody id="tbody">
			<jstl:forEach items="${list}" var="logistics">
				<tr>
					<td>${logistics.id}</td>
					<td>${logistics.player.name}</td>
					<td><fmt:formatDate pattern="yyyy/MM/dd "
							value="${logistics.start_date}" /></td>
					<td><fmt:formatDate pattern="yyyy/MM/dd "
							value="${logistics.arrive_date}" /></td>
					<td>${logistics.status}</td>
					<td><form action="${contextRoot}/Market/editLogistics"
							method="get">
							<input name="id" type="hidden" value="${logistics.id}" /> <input
								type="submit" class="btn btn-info btn-sm" value="編輯" />
						</form></td>

					<td>
						<form action="${contextRoot}/Market/deletelogistics" method="post">
							<input name="_method" type="hidden" value="delete" /> <input
								name="id" type="hidden" value="${logistics.id}" /> <input
								type="submit" class="btn btn-danger btn-sm" value="刪除" />
						</form>
					</td>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
	<script>
			const checkboxes = $("input[name='condition']")
			const tbody = $("#tbody")
			
			$(document).ready(function(){
				console.log(checkboxes);
				checkboxes.attr("checked", false);
				checkboxes.on({
					change: function () {
						let box = $(this);
						if (this.id == 'all') {
							let conditions = box.nextAll().filter("input");
							if (conditions.filter(":checked").length != 4){
								conditions.attr("checked", true);
								$.each(conditions, (index, el)=>{
									el.checked = true;	
								});
								}else{
									conditions.attr("checked", false);
									$.each(conditions, (index, el) =>{
										el.checked = false;
									}):
								}
							}
							
							}
							}
			})
		
		
		</script>
</body>
</html>