<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>活動搜尋結果</title>
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.2/css/jquery.dataTables.min.css">
</head>
<body>
<jsp:include page="../Layout/navbar_competition.jsp"/>
<div class="container">
<h1>活動搜尋結果</h1>
<table class="table table-hover table-bordered table-dark" id="compTable">
    <thead>
        <tr>
            <th>中文名稱</th>
            <th>英文名稱</th>
            <th>競賽模式</th>
            <th>活動場地</th>
            <th>開始日期</th>
            <th>結束日期</th>
            <th>預計報名人數</th>
            <th>狀態</th>
            <th colspan="2"></th>
        </tr>
    </thead>
    <tbody>
    	<c:forEach items="${compList}" var="comp">
    		<td>${comp.nameMandarin}</td>
    		<td>${comp.nameEnglish}</td>
    		<td>
    			<c:choose>
    				<c:when test="${comp.singleOrCrew == 'C'}">
    					團體戰
    				</c:when>
    				<c:when test="${comp.singleOrCrew == 'S'}">
    					單人戰
    				</c:when>
    				<c:otherwise>
    					未定
    				</c:otherwise>
    			</c:choose>
    		</td>
    		<td>台北場</td>
    		<td>${comp.startDate}</td>
    		<td>${comp.endDate}</td>
    		<td>${comp.capacity}</td>
    		<td>${comp.status}</td>
    		<td><a href="${contextRoot}/competition/edit?id=${comp.id}"><button class="btn btn-primary">編輯</button></a></td>
    		<td><a href="${contextRoot}//competition/delete?id=${comp.id}"><button class="btn btn-danger">刪除</button></a></td>
    	</c:forEach>
    </tbody>
</table>
</div>
<script src="https://cdn.datatables.net/1.13.2/js/jquery.dataTables.min.js"></script>
<script>
    // 以下使用 jQuery 擴充套件 DataTables 來顯示表格資料
$(document).ready(function () {
    // 此處用程式寫出 1000 筆假資料
//     let str = '';
//     let i = 0;
//     for (; i < 1000; i++) {
//         str += `
//     <tr>
//         <td>Tiger Nixon</td>
//         <td>System Architect</td>
//         <td>Edinburgh</td>
//         <td>61</td>
//         <td>2011/04/25</td>
//         <td>$320,800</td>
//     </tr>`;
//     }
//     $('tbody').append(str);

    // 以下為啟動 DataTable 的方法
    var table = $('#compTable').DataTable({
        "pagingType": "full_numbers",   //  pagingType 屬性提供使用者選擇每頁顯示幾筆資料的功能
        // language 屬性將顯示畫面從預設英文改為繁體中文
        language: {
            url: 'https://cdn.datatables.net/plug-ins/1.13.2/i18n/zh-HANT.json'
        }
    });

    // 以下為使用者改變每頁顯示資料筆數的事件繫節
    $('#page-length-select').on('change', function () {
        table.page.len(this.value).draw();
    });
});
</script>
<%-- <jsp:include page="../Layout/footer.jsp"/> --%>
</body>
</html>