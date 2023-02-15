<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../Layout/navbar_place.jsp"></jsp:include>
<div class="container">
<div class="row justify-content-center">
			<div class="col-10 col-md-6 col-lg-8">
				<h1>新增活動排程</h1>
				<div class="card">
					<div class="card-header">活動排程表單</div>
					<div class="card-body">
						<form:form action="${contextRoot}/schedule/post" modelAttribute="scheduleBean">
							<div class="input-group">
								<fieldset>
									<form:label class="form-label" path="scheduleName">排程名稱</form:label>
									<form:input class="form-control" path="scheduleName" />
									
									<form:label class="form-label" path="scheduleDatetime">排程日期</form:label>
									<form:input class="form-control" type="text" path="scheduleDatetime" placeholder="MM/DD/YYYY" required="true" id="scheduleDatetime"/>
									<form:label path="scheduleTimespan" class="form-label">排程時段</form:label>
									<form:select class="form-select" path="scheduleTimespan">
										<form:option value="早上" label="早上（6:00～12:00）"/>
										<form:option value="下午" label="下午（12:00～18:00）"/>
										<form:option value="晚上" label="晚上（18:00～00:00）"/>
										<form:option value="半夜" label="半夜（00:00～6:00）"/>
									</form:select>
									
									<form:label path="scheduleStatus" class="form-label">預約狀態</form:label>
									<form:select class="form-select" path="scheduleStatus" >
										<form:option value="未預約" label="未預約"/>
										<form:option value="已預約" label="已預約"/>
										
									</form:select>
								</fieldset>
								<fieldset>
									
									<form:label path="place" class="form-label">活動場地</form:label>
									<form:select class="form-select" path="place" id="place">
										<form:option value="1">台北場</form:option>
										<form:option value="2">新竹場</form:option>
										<form:option value="3">南投場</form:option>
										<form:option value="4">台中場</form:option>
										<form:option value="5">台南場</form:option>
										<form:option value="6">高雄場</form:option>
										<form:option value="7">宜蘭場</form:option>
										<form:option value="8">花蓮場</form:option>
										<form:option value="9">台東場</form:option>
									</form:select>
									
									
								</fieldset>
								
								<div class="sub">
									<input class="btn btn-primary" type="submit" value="送出" />
<!-- 									<input class="btn btn-primary" type="reset" value="清除" /> -->
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
			const scheduleDatetime = $("#scheduleDatetime");
			

			function updatescheduleDatetime() {
				scheduleDatetime.datepicker("option", "minDate", getDate(this));
			}

			scheduleDatetime.datepicker({
				
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


</body>
</html>