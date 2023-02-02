<%@ page language="java" contentType="text/html; charset=UTF-8"
import="java.util.*, tw.survival.model.Employee.EmployeeBean"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
</head>
<body>
<h1>Employee</h1>
<table>
		<c:forEach items="${emploee}" var="employee">
			<tr>
				<td><label>職員ID：</label>${employee.id}				
				<td><label>職員職稱：</label>${employee.title}
				<td><label>職員入職：</label>${employee.hired_date}
				<td><label>職員工作地點：</label>${employee.fk_workplace_id}
				<td><label>上司：</label>${employee.fk_supervisor_id}				
		</c:forEach>
	</table>
	<a href="searchmain.controller"><button>回到搜尋頁</button></a>
</body>
</html>