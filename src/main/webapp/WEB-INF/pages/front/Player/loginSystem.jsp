<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
			<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
			<!DOCTYPE html>
			<html lang="zh-hant-tw">

			<head>
				<meta charset="UTF-8">
				<title>登入</title>
				<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
			</head>
			<style type="text/css">
				div.container-login {
					margin: auto;
					width: 40%;
					border: 2px solid red;
					width: 40%;
				}

				.error {
					color: white;
				}

				.biggerfont {
					font-size: 1.25rem;
				}

				input[type="submit"],
				button {
					background-color: black;
					border: 1px solid red;
					border-radius: 5px;
					color: red;
				}

				input[type="submit"]:hover {
					background-color: red;
					color: white;
				}

				button:hover {
					background-color: red;
					color: white;
				}
			</style>

			<body>
				<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>
				<div class="container-login mt-5 mb-5 pt-5 pb-3 text-center biggerfont">
					<h3>玩家登入</h3>
					<form action="${contextRoot}/Player/loginSystem" method="post">
						<div class="row mt-5 mb-3">
							<div class="col-5 text-end">
								<label>玩家帳號：</label>
							</div>
							<div class="col-7 text-start">
								<input type="text" name="account" />
							</div>
						</div>
						<div class="row mb-5">
							<div class="col-5 text-end">
								<label>玩家密碼：</label>
							</div>
							<div class="col-7 text-start">
								<input type="password" name="password" />
							</div>
						</div>
						<div class="row">
							<div class="col text-end">
								<input type="submit" value="登入" />
							</div>
							<div class="col text-start">
								<button id="register-oneclick">一鍵填寫</button>
							</div>

							<fb:login-button scope="public_profile,email" onlogin="checkLoginState();"
							 >
							</fb:login-button><!-- facebook 按鈕 -->

							<div id="status"></div>
						</div>
					</form>
					<div class="row mt-2">
						<div class="col text-end">
							<a href="${contextRoot}/Employee/login"><button>職員登入</button></a>
						</div>
						<div class="col text-start">
							<a href="${contextRoot}/player.main"><button>會員註冊</button></a>
						</div>
					</div>

					<div class="row mt-3 mb-3">
						<c:forEach items="${errors}" var="error">
							<div class="col-12 error">＊&nbsp;${error.defaultMessage}</div>
						</c:forEach>
					</div>
				</div>
				<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
				<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
				<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js"></script>
				<script>
					const account = $("input[name='account']");
					const password = $("input[name='password']");
					const register_oneclick = document.querySelector("#register-oneclick");
					register_oneclick.addEventListener("click", function (e) {
						e.preventDefault();
						fillForm();
					});
					function fillForm() {
						account.val("W3gdXeHw");
						password.val("xxbytdzF");
					}
					//fb第三方登入
					function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
						console.log('statusChangeCallback');
						console.log(response);                   // The current login status of the person.
						if (response.status === 'connected') {   // Logged into your webpage and Facebook.		    	
							testAPI()
						}
						else {                                 // Not logged into your webpage or we are unable to tell.
							document.getElementById('status').innerHTML = 'Please log ' +
								'into this webpage.';
						}
					}


					function checkLoginState() {               // Called when a person is finished with the Login Button.
						FB.getLoginStatus(function (response) {   // See the onlogin handler
							statusChangeCallback(response);
						});
					}


					window.fbAsyncInit = function () {
						FB.init({
							appId: '1204179997131932',
							cookie: true,                     // Enable cookies to allow the server to access the session.
							xfbml: true,                     // Parse social plugins on this webpage.
							version: 'v2.7'           // Use this Graph API version for this call.
						});

						FB.getLoginStatus(function (response) {   // Called after the JS SDK has been initialized.
							statusChangeCallback(response);        // Returns the login status.
						});
					};
					// Load the SDK asynchronously
					(function (d, s, id) {
						var js, fjs = d.getElementsByTagName(s)[0];
						if (d.getElementById(id)) return;
						js = d.createElement(s); js.id = id;
						js.src = "https://connect.facebook.net/en_US/sdk.js";
						fjs.parentNode.insertBefore(js, fjs);
					}(document, 'script', 'facebook-jssdk'));

					function testAPI() {                      // Testing Graph API after login.  See statusChangeCallback() for when this call is made.
						console.log('Welcome!  Fetching your information.... ');
						FB.api('/me', function (response) {
							console.log('Successful login for: ' + response.name);
							document.getElementById('status').innerHTML =
								'Thanks for logging in, ' + response.name + '!';
						});
					}
				</script>
			</body>

			</html>