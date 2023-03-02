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
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.4/index.global.min.js'></script>
    <script>

      document.addEventListener('DOMContentLoaded', function() {
        const calendarEl = document.getElementById('calendar');
        const calendar = new FullCalendar.Calendar(calendarEl, {
        	initialView: 'dayGridMonth',
        	navLinks:true,
        	headerToolbar:{
        		left:'prev,next today',
        		center:'title',
        		right:'dayGridMonth,timeGridWeek'
        	},
        	
        	events:'${contextRoot}/schedule/all'
        });
        calendar.render();
      });
    </script>
    
  </head>
  <body>
  <jsp:include page="../../Template/admin.jsp"></jsp:include>
  <div class="container">
    <div id='calendar'></div>
  </div>  
  </body>
</html>