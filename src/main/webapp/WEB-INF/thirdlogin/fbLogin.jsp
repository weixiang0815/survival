<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<fb:login-button scope="public_profile,email"
		onlogin="checkLoginState();"
		auto_logout_link="true"
		size="large"
		show_faces="true">
	</fb:login-button>

	<div id="status"></div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js"></script>	
	<script>
	FB.getLoginStatus(function(response) {
	    statusChangeCallback(response);
	});
	</script>
</body>
</html>