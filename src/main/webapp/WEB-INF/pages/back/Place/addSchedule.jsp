<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang='en'>
<head>
<meta charset='utf-8' />
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.4/index.global.min.js'></script>
<script>

      
      
      document.addEventListener('DOMContentLoaded', function() {
        const calendarEl = document.getElementById('calendar');
        const calendar = new FullCalendar.Calendar(calendarEl, {
        	initialView: 'dayGridMonth',
//         	navLinks:true,
        	headerToolbar:{
        		left:'prev,next today',
        		center:'title',
        		right:'dayGridMonth,timeGridWeek',
        	},
        	locales: 'zh-tw',
//             initialDate: '2023-03-02',
//             navLinks: true, // can click day/week names to navigate views
//             businessHours: true, // display business hours
//             editable: true,
//             selectable: true,
//            eventsColor: function(events) {
//              if (events.type === '已發布') {
//              return 'purple';
//              } else if(events.type === '未發布'){
//             return 'green';
//             }else if(events.type === '已結束'){
//              return 'grey';
//             }else{
//             	return 'red';
//             }
//             },

        	
        	events:'${contextRoot}/schedule/all'
        	
        });
        calendar.render();
      });
    </script>

</head>
<body>
	<jsp:include page="../../Template/admin.jsp"></jsp:include>
	<div class="container">
		<div></div>
		<div id='calendar'></div>
	</div>
</body>
</html>