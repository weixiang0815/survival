<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>新增活動</title>
</head>
<body>
	<jsp:include page="../Layout/navbar_competition.jsp" />
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-10 col-md-6 col-lg-8">
				<h1>新增活動</h1>
				<div class="card">
					<div class="card-header">活動詳情表單</div>
					<div class="card-body">
						<form:form action="${contextRoot}/competition/create"
							modelAttribute="CompetitionBean">
							<div class="input-group">
								<fieldset>
									<legend>基本資料</legend>
									<label class="form-label" for="name_mandarin">中文活動名稱</label>
									<input class="form-control" type="text" name="mandarinName" id="name_mandarin" required>
									<label class="form-label" for="name_english">英文活動名稱</label>
									<input class="form-control" type="text" name="englishName" id="name_english" required>
									<label class="form-label" for="startDate">開始日期</label>
									<input class="form-control" type="text" id="startDate" name="startDate" required>
									<label for="start_timespan" class="form-label">開始時間</label>
									<select class="form-select" name="startTimespan" id="start_timespan">
										<option selected value="早上（6:00～12:00）">早上（6:00～12:00）</option>
										<option value="下午（12:00～18:00）">下午（12:00～18:00）</option>
										<option value="晚上（18:00～00:00）">晚上（18:00～00:00）</option>
										<option value="半夜（00:00～6:00）">半夜（00:00～6:00）</option>
									</select>
									<label class="form-label" for="endDate">結束日期</label>
									<input class="form-control" type="text" id="endDate" name="endDate" required>
									<label for="end_timespan" class="form-label">開始時間</label>
									<select class="form-select" name="endTimespan" id="end_timespan">
										<option selected value="早上（6:00～12:00）">早上（6:00～12:00）</option>
										<option value="下午（12:00～18:00）">下午（12:00～18:00）</option>
										<option value="晚上（18:00～00:00）">晚上（18:00～00:00）</option>
										<option value="半夜（00:00～6:00）">半夜（00:00～6:00）</option>
									</select>
								</fieldset>
								<fieldset>
									<legend>行政資料</legend>
									<label for="place" class="form-label">活動場地</label>
									<select class="form-select" name="place" id="place">
										<option selected value="台北場">台北場</option>
										<option value="台中場">台中場</option>
										<option value="南投場">南投場</option>
										<option value="高雄場">高雄場</option>
										<option value="屏東場">屏東場</option>
										<option value="宜蘭場">宜蘭場</option>
										<option value="台東場">台東場</option>
									</select>
									<label for="budget" class="form-label">預算</label>
									<input class="form-control" type="number" name="budget" id="budget">
									<label for="fee" class="form-label">報名費</label>
									<input class="form-control" type="number" name="fee" id="fee">
									<label for="capacity" class="form-label">預計報名人數</label>
									<input class="form-control" type="number" name="capacity" id="capacity">
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio" name="singleOrCrew" id="single" value="S">
										<label class="form-check-label" for="single">單人戰</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio" name="singleOrCrew" id="crew" value="C">
										<label class="form-check-label" for="crew">團體戰</label>
									</div>
								</fieldset>
								<fieldset>
									<legend>詳細資料</legend>
								</fieldset>
									<div class="sub">
										<input class="btn btn-primary" type="submit" value="送出">
										<input class="btn btn-primary" type="reset" value="清除">
									</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$(function() {
			const startDate = $("#startDate");
			const endDate = $("#endDate");

			function updateEndDate() {
				endDate.datepicker("option", "minDate", getDate(this));
			}

			startDate.datepicker({
				onSelect : updateEndDate,
				dateFormat : "mm/dd/yy"
			});

			endDate.datepicker({
				dateFormat : "mm/dd/yy"
			});
		});

		function getDate(element) {
			var date;
			try {
				date = $.datepicker.parseDate("mm/dd/yy", element.value);
			} catch (error) {
				date = null;
			}

			return date;
		}
	</script>
	<%-- <jsp:include page="../Layout/footer.jsp" /> --%>
</body>
</html>