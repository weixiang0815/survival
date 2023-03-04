<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang='en'>
<head>
<meta charset='UTF-8' />
<title>排程表</title>
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>
	<div class="container">
		<div>
			<div class="col-3">
				<select id="placeId" class="form-select">
					<option selected>-- 請選擇一個場地 --</option>
					<c:forEach items="${placeList}" var="place">
						<option value="${place.id}">${place.place_name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<br />
		<div id='calendar'></div>
	</div>
	<script
		src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.4/index.global.min.js'></script>
	<script>
		const calendarEl = document.getElementById('calendar');
		const findAllURL = '${contextRoot}/front/schedule/all';
		const findByPlaceIdURL = "${contextRoot}/front/schedule/select/";
		let calendar;
		$(document).on("DOMContentLoaded", function() {
			renderCalendar(findAllURL);
			const placeId = $("#placeId");
			placeId.on("change", function() {
				let placeId_value = placeId.val();
				console.log(placeId_value);
				$.ajax({
					url: findByPlaceIdURL + placeId_value,
					method: "GET",
					success: function (res) {
						console.log(res);
						let url = findByPlaceIdURL + placeId_value;
						console.log(url);
						//	重新渲染整個排程表
						renderCalendar(url);
					},
					error: function (err) {
						console.log(err);
					}
				});
			});
		});

		function renderCalendar(url) {
			calendar = new FullCalendar.Calendar(calendarEl, {
				initialView : 'dayGridMonth',
				navLinks : true,
				headerToolbar : {
					left : 'prev,next today',
					center : 'title',
					right : 'dayGridMonth,timeGridWeek',
				},
				locales : 'zh-tw',
				events : url,
			});
			calendar.render();
		}
	</script>
<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>	
</body>
</html>