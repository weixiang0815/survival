<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="tw.survival.model.Market.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改物流訊息</title>
</head>
<body>
	<jsp:include page="../../Template/admin.jsp"></jsp:include>
	<div class="container">
		<h1>修改物流訊息</h1>
		<div class="card">
			<div class="card-header">修改物流訊息<span id="result"></span></div>
			<div class="card-body">
				<form:form action="${contextRoot}/Market/editLogistics" method="put"
					modelAttribute="logistics">
					<form:input type="hidden" path="id" />
					<form:input type="hidden" path="Player" />
					<form:input type="hidden" path="OrderItem" />
					<table class="table table-hover">
						<tr>
							<td><form:input type="hidden" path="start_date"
									placeholder="yyyy/mm/dd" required="true" /></td>
						</tr>
						<tr>
							<td><form:label class="form-label" path="arrive_date">到貨日期</form:label></td>
							<td><form:input type="text" path="arrive_date"
									class="form-control" placeholder="yyyy/mm/dd" required="true"
									readonly="true" /></td>
						</tr>

						<tr>
							<td>訂單狀態</td>
							<td><form:input type="text" class="form-control"
									path="status" required="true" readonly="true" /></td>
						</tr>
						<tr>
							<td></td>
							<td>
								<button id="processing" class="formBtn btn btn-primary btn-sm">處理中</button>
								<button id="sentout" class="formBtn btn btn-primary btn-sm">已出貨</button>
								<button id="arrived" class="formBtn btn btn-primary btn-sm">已到貨</button>
								<button id="dropped" class="formBtn btn btn-primary btn-sm">棄單</button>
							</td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
	<script>
		const buttons = $(".formBtn");
		const actionURL = "${contextRoot}/Market/";
		const logisticsId = $("input#id");
		const resultPlace = $("#result");
		const statusPlace = $("#status");

		$(document).ready(function() {
			for(let i = 0; i < buttons.length; i++) {
				let btn = buttons[i];
				console.log(btn);
				$(btn).on({
					click : function(e) {
						e.preventDefault();
						let action = $(this).attr("id");
						let status = $(this).text();
						console.log(actionURL + action);
						console.log(status);
						changeStatus(logisticsId, action, status);
					}
				});
			}
		});

		function changeStatus(id, action, status) {
			$.ajax({
				url : actionURL + action,
				method : "post",
				data : {
					logisticsId : id
				},
				success : res => {
					console.log(res);
					statusPlace.text(status);
					statusPlace.val(status);
					resultPlace.text("修改成功");
					resultPlace.css("color", "blue");
				},
				error : err => {
					console.log(err);
					resultPlace.text("修改失敗");
					resultPlace.css("color", "red");
				}
			});
		}
	</script>
</body>
</html>