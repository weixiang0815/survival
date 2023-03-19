<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="tw.survival.model.Market.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
			<div class="card-header">
				<span>修改物流訊息</span>
			</div>
			<div class="card-body">
				<form:form action="${contextRoot}/Market/editLogistics" method="put"
					modelAttribute="logistics">
					<form:input type="hidden" path="id" />
					<form:input type="hidden" path="Player" />
					<form:input type="hidden" path="OrderItem" />
					<table class="table table-hover">
						<tr>
							<td>
								<form:input type="hidden" path="start_date" placeholder="yyyy/mm/dd"
									required="true" />
							</td>
						</tr>
						<tr>
							<td>
								<form:label class="form-label" path="arrive_date">到貨日期</form:label>
							</td>
							<td>
								<form:input type="text" path="arrive_date" class="form-control"
									placeholder="yyyy/mm/dd" required="true" readonly="true" />
							</td>
						</tr>

						<tr>
							<td>訂單狀態</td>
							<td>
								<form:input type="text" class="form-control" path="status"
									required="true" readonly="true" />
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<button id="processing"
									class="formBtn btn btn-primary btn-sm">處理中</button>
								<button id="sentout" class="formBtn btn btn-primary btn-sm">已出貨</button>
								<button id="arrived" class="formBtn btn btn-primary btn-sm">已到貨</button>
								<button id="dropped" class="formBtn btn btn-primary btn-sm">棄單</button>
								<span id="result"></span>
							</td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
	<script>
		const buttons = document.querySelectorAll(".formBtn");
		const actionURL = "${contextRoot}/Market/";
		const logisticsId = document.getElementById("id").value;
		const resultPlace = document.getElementById("result");
		const statusPlace = document.getElementById("status");

		$(document).ready(function () {
			for (let i = 0; i < buttons.length; i++) {
				buttons[i].addEventListener("click", function (e) {
					e.preventDefault();
					let action = this.id;
					let status = this.innerText;
					let url = actionURL + action + "?id=" + parseInt(logisticsId);
					axios.get(url)
					.then(res => {
						let result = res.data;
						console.log(result);
						switch(result) {
							case 0:
								resultPlace.innerText = "修改失敗";
								resultPlace.setAttribute("style", "color: red;");
								break;
							case 1:
								statusPlace.innerText = status;
								statusPlace.value = status;
								resultPlace.innerText = "修改成功";
								resultPlace.setAttribute("style", "color: blue;");
								break;
						}
					}).catch(err => {
						console.log(err);
						resultPlace.innerText = "修改失敗";
						resultPlace.setAttribute("style", "color: red;");
					});
				})
			}
		});
	</script>
</body>

</html>