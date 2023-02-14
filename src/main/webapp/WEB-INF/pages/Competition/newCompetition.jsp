<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
							modelAttribute="competition">
							<div class="input-group">
								<fieldset>
									<legend>基本資料</legend>
									<form:label class="form-label" path="mandarinName">中文活動名稱</form:label>
									<form:input class="form-control" type="text" path="mandarinName" placeholder="請填寫中文" required="true"/>
									<form:label class="form-label" path="englishName">英文活動名稱</form:label>
									<form:input class="form-control" type="text" path="englishName" placeholder="English Only" required="true"/>
									<form:label class="form-label" path="startDate">開始日期</form:label>
									<form:input class="form-control" type="text" path="startDate" placeholder="MM/DD/YYYY" required="true"/>
									<form:label path="startTimespan" class="form-label">開始時間</form:label>
									<form:select class="form-select" path="startTimespan">
										<form:option value="早上" label="早上（6:00～12:00）"/>
										<form:option value="下午" label="下午（12:00～18:00）"/>
										<form:option value="晚上" label="晚上（18:00～00:00）"/>
										<form:option value="半夜" label="半夜（00:00～6:00）"/>
									</form:select>
									<form:label class="form-label" path="endDate">結束日期</form:label>
									<form:input class="form-control" type="text" id="endDate" path="endDate" placeholder="MM/DD/YYYY" required="true"/>
									<form:label path="endTimespan" class="form-label">結束時間</form:label>
									<form:select class="form-select" path="endTimespan" id="end_timespan">
										<form:option value="早上" label="早上（6:00～12:00）"/>
										<form:option value="下午" label="下午（12:00～18:00）"/>
										<form:option value="晚上" label="晚上（18:00～00:00）"/>
										<form:option value="半夜" label="半夜（00:00～6:00）"/>
									</form:select>
								</fieldset>
								<fieldset>
									<legend>行政資料</legend>
									<p>是否直接發布</p>
									<form:radiobutton name="status" class="form-check-input" path="status" id="publish" value="已發布" label="是" required="true"/>
									<form:radiobutton name="status" class="form-check-input" path="status" id="notPublish" value="未發布" label="否" required="true"/>									
									<br>
									<form:label path="place" class="form-label">活動場地</form:label>
									<form:select class="form-select" path="place" id="place">
										<form:option value="台北場">台北場</form:option>
										<form:option value="台中場">台中場</form:option>
										<form:option value="南投場">南投場</form:option>
										<form:option value="高雄場">高雄場</form:option>
										<form:option value="屏東場">屏東場</form:option>
										<form:option value="宜蘭場">宜蘭場</form:option>
										<form:option value="台東場">台東場</form:option>
									</form:select>
									<form:label path="budget" class="form-label">預算</form:label>
									<form:input class="form-control" type="number" min="0" pattern="[0-9]+" path="budget" id="budget" placeholder="以新台幣計算" required="true"/>
									<form:label path="fee" class="form-label">報名費</form:label>
									<form:input class="form-control" type="number" min="0" pattern="[0-9]+" path="fee" id="fee" placeholder="以新台幣計算" required="true"/>
									<form:label path="capacity" class="form-label">預計報名人數</form:label>
									<form:input class="form-control" type="number" min="0" pattern="[0-9]+" path="capacity" id="capacity" placeholder="請填寫整數" required="true"/>
									<p>競賽模式</p>
									<form:radiobutton name="singleOrCrew" class="form-check-input" path="singleOrCrew" id="single" value="S" label="單人戰" required="true"/>
									<form:radiobutton name="singleOrCrew" class="form-check-input" path="singleOrCrew" id="crew" value="M" label="團體戰" required="true"/>
								</fieldset>
								<fieldset>
									<legend>詳細資料</legend>
									<form:label path="rules" class="form-label">活動規定</form:label>
									<!-- 要在 controller 加 @RequestParam 接 String 陣列 -->
									<select title="按住 ctrl 選取多個選項" class="form-select" name="rules" id="rules" multiple required>
										<option value="台北場">台北場</option>
										<option value="台中場">台中場</option>
										<option value="南投場">南投場</option>
										<option value="高雄場">高雄場</option>
										<option value="屏東場">屏東場</option>
										<option value="宜蘭場">宜蘭場</option>
										<option value="台東場">台東場</option>
									</select>
									<form:label path="content" class="form-label">活動介紹</form:label>
									<form:textarea id="ckeditor" path="content" class="form-control"/>
								</fieldset>
								<div class="sub">
									<input class="btn btn-primary" type="submit" value="送出" />
									<input class="btn btn-primary" type="reset" value="清除" />
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="${contextRoot}/js/CKEditor5/ckeditor.js"></script>
	<script src="${contextRoot}/js/CKEditor5/script.js"></script>
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