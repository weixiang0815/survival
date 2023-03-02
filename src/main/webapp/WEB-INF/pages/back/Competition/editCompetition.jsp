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
<title>編輯活動資訊</title>
</head>
<body>
<%-- 	<jsp:include page="../Layout/navbar_competition.jsp" /> --%>
<jsp:include page="../../Template/admin.jsp" />
	<div class="container pt-3 pb-3">
		<div class="row justify-content-center">
			<div class="col-10 col-md-6 col-lg-8"
				style="border: 2px solid red; border-radius: 5px;">
				<h1>編輯活動資訊</h1>
				<span>${error}</span>
				<c:choose>
					<c:when test="${player == null && employee == null}">
						<h1>請先登入再新增活動呦😊～</h1>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
				<form:form action="${contextRoot}/competition/edit/send"
					modelAttribute="competition">
					<div class="input-group">
						<form:input hidden="true" path="id" value="${competition.id}" />
						<fieldset class="row mt-3 mb-3 p-3">
							<legend>基本資料</legend>
							<div class="col-6">
								<form:label class="form-label" path="mandarinName">中文活動名稱</form:label>
								<form:input class="form-control" type="text" path="mandarinName"
									placeholder="請填寫中文" required="true" />
							</div>
							<div class="col-6">
								<form:label class="form-label" path="englishName">英文活動名稱</form:label>
								<form:input class="form-control" type="text" path="englishName"
									placeholder="English Only" required="true" />
							</div>
							<div class="col-3">
								<form:label class="form-label" path="startDate">開始日期</form:label>
								<form:input class="form-control" type="text" path="startDate"
									placeholder="yyyy/mm/dd" required="true" />
							</div>
							<div class="col-3">
								<form:label path="startTimespan" class="form-label">開始時間</form:label>
								<form:select class="form-select" path="startTimespan">
									<form:option value="1" label="早上（6:00～12:00）" />
									<form:option value="2" label="下午（12:00～18:00）" />
									<form:option value="3" label="晚上（18:00～00:00）" />
									<form:option value="4" label="半夜（00:00～6:00）" />
								</form:select>
							</div>
							<div class="col-3">
								<form:label class="form-label" path="endDate">結束日期</form:label>
								<form:input class="form-control" type="text" id="endDate"
									path="endDate" placeholder="yyyy/mm/dd" required="true" />
							</div>
							<div class="col-3">
								<form:label path="endTimespan" class="form-label">結束時間</form:label>
								<form:select class="form-select" path="endTimespan"
									id="end_timespan">
									<form:option value="1" label="早上（6:00～12:00）" />
									<form:option value="2" label="下午（12:00～18:00）" />
									<form:option value="3" label="晚上（18:00～00:00）" />
									<form:option value="4" label="半夜（00:00～6:00）" />
								</form:select>
							</div>
						</fieldset>
						<fieldset class="row mt-3 mb-3 p-3">
							<legend>行政資料</legend>
							<div class="col-3">
								<p>是否直接發布</p>
								<form:radiobutton name="status" class="form-check-input"
									path="status" id="publish" value="已發布" label="是"
									required="true" />
								<form:radiobutton name="status" class="form-check-input"
									path="status" id="notPublish" value="未發布" label="否"
									required="true" />
							</div>
							<div class="col-3">
								<p>競賽模式</p>
								<form:radiobutton name="singleOrCrew" class="form-check-input"
									path="singleOrCrew" id="single" value="S" label="單人戰"
									required="true" />
								<form:radiobutton name="singleOrCrew" class="form-check-input"
									path="singleOrCrew" id="crew" value="C" label="團體戰"
									required="true" />
							</div>
							<div class="col-6"></div>
							<div class="col-12">
								<form:label path="place" class="form-label">活動場地</form:label>
								<form:select title="選擇一個場地" class="form-select" path="placeId"
									id="placeId">
									<c:forEach items="${placeList}" var="place">
										<c:choose>
											<c:when test="${player != null && employee == null}">
												<form:option value="${place.id}">${place.place_name}（費用/時段：${place.place_fee} 元，容納人數：${place.place_capacity} 人）</form:option>
											</c:when>
											<c:when test="${player == null && employee != null}">
												<form:option value="${place.id}">${place.place_name}（容納人數：${place.place_capacity} 人）</form:option>
											</c:when>
											<c:otherwise>
												<form:option value="${place.id}">${place.place_name}（費用/時段：${place.place_fee} 元，容納人數：${place.place_capacity} 人）</form:option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</form:select>
							</div>
							<div class="col-6">
								<form:label path="capacity" class="form-label">預計報名人數</form:label>
								<form:input class="form-control" type="number" min="0"
									pattern="[0-9]+" path="capacity" id="capacity"
									placeholder="請填寫整數" required="true" />
							</div>
							<div class="col-6">
								<form:label path="budget" class="form-label">預算</form:label>
								<form:input class="form-control" type="number" min="0"
									pattern="[0-9]+" path="budget" id="budget" placeholder="以新台幣計算"
									required="true" />
							</div>
							<div class="col-6">
								<form:label path="fee" class="form-label">報名費</form:label>
								<form:input class="form-control" type="number" min="0"
									pattern="[0-9]+" path="fee" id="fee" placeholder="以新台幣計算"
									required="true" />
							</div>
						</fieldset>
						<fieldset class="row mt-3 mb-3 p-3">
							<legend>詳細資料</legend>
							<div class="col">
								<form:label path="content" class="form-label">活動介紹</form:label>
								<form:textarea id="ckeditor" path="content" class="form-control" />
							</div>
						</fieldset>
						<fieldset class="row mt-3 mb-3 p-3">
							<button class="col auto m-3 btn btn-primary" type="submit">送出</button>
							<button class="col auto m-3 btn btn-danger" type="reset">清除</button>
						</fieldset>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<script src="${contextRoot}/js/CKEditor5/ckeditor.js"></script>
	<script src="${contextRoot}/js/CKEditor5/script.js"></script>
	<script>
		$(document).ready(function() {
			$("#startDate").datepicker({
				dateFormat : "yy-mm-dd",
				onSelect : function(date) {
					$("#endDate").datepicker("option", "minDate", date);
				}
			});
			$("#endDate").datepicker({
				dateFormat : "yy-mm-dd",
				onSelect : function(date) {
					$("#startDate").datepicker("option", "maxDate", date);
				}
			});
		});
	</script>
	<%-- <jsp:include page="../Layout/footer.jsp"/> --%>
</body>
</html>