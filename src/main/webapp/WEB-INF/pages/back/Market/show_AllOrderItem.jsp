<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="tw.survival.model.Market.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有訂單</title>
</head>
<body>
	<jsp:include page="../../Template/admin.jsp"></jsp:include>
	<div class="container">
		<h1>所有訂單</h1>
		<div>
			<input class="form-check-input" type="checkbox" name="condition" id="all">
			<label class="form-check-label" for="all">全部</label>
			<input class="form-check-input" type="checkbox" name="condition" id="processing">
			<label class="form-check-label" for="processing">處理中</label>
			<input class="form-check-input" type="checkbox" name="condition" id="sentout">
			<label class="form-check-label" for="sentout">已出貨</label>
			<input class="form-check-input" type="checkbox" name="condition" id="arrived">
			<label class="form-check-label" for="arrived">已到貨</label>
			<input class="form-check-input" type="checkbox" name="condition" id="received">
			<label class="form-check-label" for="received">已取貨</label>
			<input class="form-check-input" type="checkbox" name="condition" id="dropped">
			<label class="form-check-label" for="dropped">棄單</label>
		</div>
		<table class="table table-hover table-bordered table-dark">
			<thead>
				<tr>
					<th>訂單 ID</th>
					<th>收件人</th>
					<th>建立日期</th>
					<th>狀態</th>
					<td colspan="2"></td>
				</tr>
			</thead>
			<tbody id="tbody">
				<jstl:forEach items="${orderList}" var="show">
					<tr>
						<td>${show.id}</td>
						<td>${show.player.name}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd"
								value="${show.order_create_date}" /></td>
						<td>${show.status}</td>
						<td><form action="${contextRoot}/Market/editOrder"
								method="get">
								<input name="id" type="hidden" value="${show.id}" /> <input
									type="submit" class="btn btn-info btn-sm" value="編輯" />
							</form></td>
						<td><form action="${contextRoot}/Market/deleteOrder"
								method="post">
								<input name="_method" type="hidden" value="delete" /> <input
									name="id" type="hidden" value="${show.id}" /> <input
									type="submit" class="btn btn-danger btn-sm" value="刪除" />
							</form></td>
					</tr>
				</jstl:forEach>
			</tbody>
		</table>
	</div>
	<script>
		const checkboxes = $("input[name='condition']");
		const tbody = $("#tbody");

		$(document).ready(function () {
			console.log(checkboxes);
			checkboxes.attr("checked", false);
			checkboxes.on({
				change: function () {
					let box = $(this);
					if (this.id == 'all') {
						let conditions = box.nextAll().filter("input");
						if (conditions.filter(":checked").length != 5) {
							conditions.attr("checked", true);
							$.each(conditions, (index, el) => {
								el.checked = true;
							});
						} else {
							conditions.attr("checked", false);
							$.each(conditions, (index, el) => {
								el.checked = false;
							});
						}
					}

					let status = checkboxes.not("#all").filter(":checked");
					let status_str = new Array();
					$.each(status, (index, el) => {
						let id = el.id;
						let str = $("label[for='" + id + "']").text();
						status_str.push(str);
					});

					$.ajax({
						url: "${contextRoot}/Market/order/multi-search",
						method: "post",
						data: JSON.stringify(status_str),
						contentType: "application/json",
						success: function(res) {
							console.log(res);
							htmlMaker(res);
						},
						error: function(err) {
							console.log(err);
						}
					})
				}
			});
		});

		function htmlMaker(list) {
			let str = ``;
			if (list.length != 0) {
				$.each(list, (index, show) => {
					str += `
						<tr>
							<td>` + show.id + `</td>
							<td>` + show.player.name + `</td>
							<td class="date">` + show.order_create_date + `</td>
							<td>` + show.status + `</td>
							<td><form action="${contextRoot}/Market/editOrder"
									method="get">
									<input name="id" type="hidden" value="` + show.id + `" /> <input
										type="submit" class="btn btn-info btn-sm" value="編輯" />
								</form></td>
							<td><form action="${contextRoot}/Market/deleteOrder"
									method="post">
									<input name="_method" type="hidden" value="delete" /> <input
										name="id" type="hidden" value="` + show.id + `" /> <input
										type="submit" class="btn btn-danger btn-sm" value="刪除" />
								</form></td>
						</tr>`;
				});
			} else {
				str += `<tr><td class="text-center" colspan="6">查無資料</td></tr>`;
			}
			tbody.html(str);
		}
	</script>
</body>
</html>