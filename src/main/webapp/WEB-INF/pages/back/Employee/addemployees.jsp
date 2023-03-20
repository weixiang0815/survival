<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../../Template/admin.jsp" />
	<h3>新增職員</h3>
	<form:form action="${contextRoot}/Employee/addEmployee"
		enctype="multipart/form-data" modelAttribute="Employee">
		<table>
			<tr>
				<td>使用者名稱：</td>
				<td><form:input type="text" path="name" /></td>
			</tr>
			<tr>
				<td>帳號：</td>
				<td><form:input type="text" path="account" /></td>
			</tr>
			<tr>
				<td>密碼：</td>
				<td><form:input type="password" path="password" /></td>
			</tr>
			<tr>
				<td>職位：</td>
				<td><form:input type="text" path="title" /></td>
			</tr>
			<tr>
				<td>性別：</td>
				<td><form:radiobutton path="sex" value="M" label="男" /> <form:radiobutton
						path="sex" value="F" label="女" /></td>
			</tr>
			<tr>
				<td>縣市:</td>
				<td class="twzipcode"><form:select data-role="county"
						path="county">
						<option >縣市</option>
					</form:select> <form:select data-role="district" name="district" path="district">
						<option data-value="district">鄉鎮市區</option>
					</form:select> <input type="text" data-role="zipcode" placeholder="郵遞區號"
					name="zipcode"></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><form:input type="text" path="address" /></td>
			</tr>
			<tr>
				<td>Email：</td>
				<td><form:input type="text" path="email" /></td>
			</tr>
			<tr>
				<td>年齡：</td>
				<td><form:input type="text" path="age" /></td>
			</tr>
			<tr>
				<td>圖片:</td>
				<td><form:input type="file" path="employeeImage" />
			</tr>
			<tr>
				<td>個人身分證：</td>
				<td><form:input type="text" path="identity_number" /></td>
			</tr>
			<tr>
				<td>薪水：</td>
				<td><form:input type="text" path="salary" /></td>
			</tr>
			<tr>
				<td>電話：</td>
				<td><form:input type="text" path="phone" /></td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><form:input type="date" path="birthday" /></td>
			</tr>
			<tr>
				<td>入職時間：</td>
				<td><form:input type="date" path="hired_date" /></td>
			</tr>
			<tr>
				<td><form:input  type="hidden" path="status" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="註冊" /></td>
				<td><button id="register-oneclick">一鍵註冊</button></td>
			</tr>
		</table>


	</form:form>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="${contextRoot}/js/twzipcode.js"></script>
	<script>
		const twzipcode = new TWzipcode();
		const county = $("select[data-role='county']");
		const district = $("select[data-role='district']");
		const zipcode = $("input[data-role='zipcode']");				
		const name = $("input[name='name']");
		const account = $("input[name='account']");
		const password = $("input[name='password']");
		const male = document.querySelector("#sex1");
		const address = $("input[name='address']");
		const email = $("input[name='email']");
		const age = $("input[name='age']");
		const identity_number = $("input[name='identity_number']");
		const phone = $("input[name='phone']");
		const birthday = $("input[name='birthday']");
		const salary=$("input[name='salary']");
		const title=$("input[name='title']");
		const hired_date=$("input[name='hired_date']");
		const register_oneclick = document.querySelector("#register-oneclick");
		register_oneclick.addEventListener("click", function(e) {
			e.preventDefault();
			fillForm();
		});
		function fillForm() {
			name.val("夏天雷");
			account.val("123456789");
			password.val("123456");
			salary.val("150000");
			title.val("老闆")
			male.checked = true;
			twzipcode.set("110");
			address.val("復興南路二段171巷");
			email.val("zzz963852789@gmail.com");
			age.val("30");
			identity_number.val("A168544839");
			phone.val("0228519348");
			birthday.val("1993-01-01");
			hired_date.val("2023-03-20");
		}
		
	</script>

</body>
</html>