<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
			<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<meta name="description" content="">
				<meta http-equiv="X-UA-Compatible" content="IE=edge">
				<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
				<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->
				<meta charset="UTF-8">
				<title>戰略商城</title>

				<!-- Favicon  -->
				<link rel="icon" href="${contextRoot}/img/market_favicon.ico">

				<!-- Core Style CSS -->
				<link rel="stylesheet" href="css/core-style.css">
				<link rel="stylesheet" href="style.css">

				<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
			</head>

			<style>
				* {
					margin: 0;
					padding: 0;
				}

				/* body {
		font-family: "Poppins", sans-serif;
		font-size: 14px;
		background-color: #ffffff;
		margin-top: 85px;
	} */

				@media only screen and (max-width: 767px) {
					body {
						margin-top: 80px;
					}
				}

				/* h1,
	h2,
	h3,
	h4,
	h5,
	h6 {
		color: #000000;
		line-height: 1.3;
		font-weight: 700;
		font-family: "Ubuntu", sans-serif;
	} */

				p {
					color: #787878;
					font-size: 14px;
					line-height: 2;
					font-weight: 400;
				}

				a {
					-webkit-transition: all 500ms ease 0s;
					transition: all 500ms ease 0s;
					text-decoration: none;
					outline: 0 solid transparent;
					color: #fbf5f5;
					font-weight: 600;
					/* font-size: 12px; */
				}

				a:hover,
				a:focus {
					-webkit-transition: all 500ms ease 0s;
					transition: all 500ms ease 0s;
					text-decoration: none;
					outline: 0 solid transparent;
					color: #000000;
					font-weight: 600;
					font-size: 12px;
				}

				ul,
				ol {
					margin: 0;
				}

				ul li,
				ol li {
					list-style: none;
				}

				img {
					height: auto;
					max-width: 100%;
				}

				/* Spacing */
				.mt-15 {
					margin-top: 15px !important;
				}

				.mt-30 {
					margin-top: 30px !important;
				}

				.mt-50 {
					margin-top: 50px !important;
				}

				.mt-70 {
					margin-top: 70px !important;
				}

				.mt-100 {
					margin-top: 100px !important;
				}

				.mb-15 {
					margin-bottom: 15px !important;
				}

				.mb-30 {
					margin-bottom: 30px !important;
				}

				.mb-50 {
					margin-bottom: 50px !important;
				}

				.mb-70 {
					margin-bottom: 70px !important;
				}

				.mb-100 {
					margin-bottom: 100px !important;
				}

				.ml-15 {
					margin-left: 15px !important;
				}

				.ml-30 {
					margin-left: 30px !important;
				}

				.ml-50 {
					margin-left: 50px !important;
				}

				.mr-15 {
					margin-right: 15px !important;
				}

				.mr-30 {
					margin-right: 30px !important;
				}

				.mr-50 {
					margin-right: 50px !important;
				}

				/* Height */
				.height-400 {
					height: 400px !important;
				}

				.height-500 {
					height: 500px !important;
				}

				.height-600 {
					height: 600px !important;
				}

				.height-700 {
					height: 700px !important;
				}

				.height-800 {
					height: 800px !important;
				}

				/* Section Padding */
				.section-padding-80 {
					padding-top: 80px;
					padding-bottom: 80px;
				}

				.section-padding-80-0 {
					padding-top: 80px;
					padding-bottom: 0;
				}

				.section-padding-0-80 {
					padding-top: 0;
					padding-bottom: 80px;
				}

				/* Section Heading */
				.section-heading {
					margin-bottom: 50px;
					position: relative;
					z-index: 1;
				}

				.section-heading h2 {
					font-size: 30px;
					margin-bottom: 0;
					text-transform: capitalize;
					font-weight: 600;
				}

				.section-heading.text-left {
					text-align: left !important;
				}

				/* Miscellaneous */
				.bg-img {
					background-position: center center;
					background-size: cover;
					background-repeat: no-repeat;
				}

				.bg-white {
					background-color: #ffffff !important;
				}

				.bg-dark {
					background-color: #000000 !important;
				}

				.bg-transparent {
					background-color: transparent !important;
				}

				.font-bold {
					font-weight: 700;
				}

				.font-light {
					font-weight: 300;
				}

				.bg-overlay,
				.bg-overlay-white {
					position: relative;
					z-index: 2;
					background-position: center center;
					background-size: cover;
				}

				.bg-overlay:hover,
				.bg-overlay-white:hover {
					position: absolute;
					z-index: -1;
					top: 0;
					left: 0;
					width: 100%;
					height: 100%;
					content: "";
				}

				.bg-overlay:hover {
					background-color: rgba(0, 0, 0, 0.5);
				}

				.bg-overlay-white:hover {
					background-color: rgba(255, 255, 255, 0.9);
				}

				/* ScrollUp */
				#scrollUp {
					background-color: #ff084e;
					border-radius: 0;
					bottom: 60px;
					box-shadow: 0 2px 6px 0 rgba(0, 0, 0, 0.3);
					color: #ffffff;
					font-size: 24px;
					height: 40px;
					line-height: 40px;
					right: 60px;
					text-align: center;
					width: 40px;
				}

				@media only screen and (max-width: 767px) {
					#scrollUp {
						bottom: 30px;
						right: 30px;
					}
				}

				/* Essence Button */
				.essence-btn {
					display: inline-block;
					min-width: 170px;
					height: 50px;
					color: #ffffff;
					border: none;
					border-radius: 0;
					padding: 0 40px;
					text-transform: uppercase;
					font-size: 12px;
					line-height: 50px;
					background-color: #0315ff;
					letter-spacing: 1.5px;
					font-weight: 600;
				}

				.essence-btn:hover,
				.essence-btn:focus {
					color: #ffffff;
					background-color: #dc0345;
				}

				/* :: 4.0 Header Area CSS */
				.header_area {
					position: fixed;
					z-index: 900;
					top: 0;
					left: 0;
					width: 100%;
					border-bottom: 1px solid #ebebeb;
					-webkit-transition-duration: 500ms;
					transition-duration: 500ms;
				}

				@media only screen and (max-width: 767px) {
					.header_area .classy-nav-container {
						-ms-flex-wrap: wrap;
						flex-wrap: wrap;
					}
				}

				@media only screen and (max-width: 767px) {
					.header_area .classy-nav-container .classy-navbar-toggler {
						margin-left: auto;
						margin-right: 15px;
					}
				}

				.header_area .classy-navbar,
				.header_area .header-meta {
					-webkit-box-flex: 0;
					-ms-flex: 0 0 50%;
					flex: 0 0 50%;
					min-width: 50%;
					width: 50%;
				}

				@media only screen and (max-width: 767px) {

					.header_area .classy-navbar,
					.header_area .header-meta {
						-webkit-box-flex: 0;
						-ms-flex: 0 0 100%;
						flex: 0 0 100%;
						min-width: 100%;
						width: 100%;
					}
				}

				.header_area .classy-navbar {
					height: 85px;
					padding: 5px 0 5px 5%;
				}

				@media only screen and (max-width: 767px) {
					.header_area .classy-navbar {
						height: 40px;
						border-bottom: 1px solid #ebebeb;
					}
				}

				.header_area .header-meta {
					height: 85px;
					position: relative;
					z-index: 1;
				}

				@media only screen and (max-width: 767px) {
					.header_area .header-meta {
						height: 40px;
					}
				}

				.header_area .classynav ul li a {
					font-size: 16px;
					color: #787878;
				}

				.header_area .classynav ul li a:hover {
					color: #000000;
				}

				.header_area .classynav ul li .megamenu li a,
				.header_area .classynav ul li .dropdown li a {
					font-size: 14px;
					color: #787878;
				}

				.header_area .classynav ul li .megamenu li a:hover,
				.header_area .classynav ul li .dropdown li a:hover {
					color: #000000;
				}

				.header_area .search-area form {
					position: relative;
					z-index: 1;
					height: 85px;
					border-left: 1px solid #ebebeb;
				}

				@media only screen and (max-width: 767px) {
					.header_area .search-area form {
						height: 40px;
						border-left: none;
					}
				}

				.header_area .search-area form input {
					border: none;
					background-color: #ffffff;
					width: 200px;
					height: 85px;
					padding: 0 15px 0 60px;
					color: #787878;
					font-size: 14px;
					font-weight: 500;
					-webkit-transition-duration: 500ms;
					transition-duration: 500ms;
				}

				@media only screen and (max-width: 767px) {
					.header_area .search-area form input {
						width: 170px;
						height: 40px;
						padding: 0 10px 0 30px;
					}
				}

				.header_area .search-area form input:focus {
					outline: none !important;
					width: 350px;
				}

				@media only screen and (min-width: 768px) and (max-width: 991px) {
					.header_area .search-area form input:focus {
						width: 300px;
					}
				}

				@media only screen and (max-width: 767px) {
					.header_area .search-area form input:focus {
						width: 170px;
					}
				}

				@media only screen and (min-width: 480px) and (max-width: 767px) {
					.header_area .search-area form input:focus {
						width: 270px;
					}
				}

				@media only screen and (min-width: 576px) and (max-width: 767px) {
					.header_area .search-area form input:focus {
						width: 300px;
					}
				}

				.header_area .search-area form button {
					position: absolute;
					z-index: 10;
					top: 50%;
					-webkit-transform: translateY(-50%);
					transform: translateY(-50%);
					left: 30px;
					background-color: transparent;
					border: none;
					color: #787878;
					font-size: 14px;
				}

				@media only screen and (max-width: 767px) {
					.header_area .search-area form button {
						left: 10px;
						height: 40px;
					}
				}

				.header_area .favourite-area a,
				.header_area .user-login-info a,
				.header_area .cart-area a {
					position: relative;
					z-index: 1;
					-webkit-box-flex: 0;
					-ms-flex: 0 0 90px;
					flex: 0 0 90px;
					width: 90px;
					display: block;
					text-align: center;
					border-left: 1px solid #ebebeb;
					height: 100%;
					line-height: 80px;
				}

				@media only screen and (max-width: 767px) {

					.header_area .favourite-area a,
					.header_area .user-login-info a,
					.header_area .cart-area a {
						-webkit-box-flex: 0;
						-ms-flex: 0 0 50px;
						flex: 0 0 50px;
						width: 50px;
						line-height: 40px;
					}
				}

				.header_area .favourite-area a img,
				.header_area .user-login-info a img,
				.header_area .cart-area a img {
					max-width: 20px;
				}

				.header_area .favourite-area a span,
				.header_area .user-login-info a span,
				.header_area .cart-area a span {
					font-family: "Ubuntu", sans-serif;
					font-size: 18px;
					color: #0315ff;
					font-weight: 700;
					position: absolute;
					top: -10px;
				}

				@media only screen and (max-width: 767px) {

					.header_area .favourite-area a span,
					.header_area .user-login-info a span,
					.header_area .cart-area a span {
						font-size: 14px;
					}
				}

				.header_area.sticky {
					position: fixed;
					z-index: 900;
					top: 0;
					left: 0;
					width: 100%;
					box-shadow: 0 5px 30px rgba(0, 0, 0, 0.15);
				}

				.cart-bg-overlay.cart-bg-overlay-on {
					-webkit-transition-duration: 1000ms;
					transition-duration: 1000ms;
					position: fixed;
					width: 100%;
					height: 100%;
					top: 0;
					left: 0;
					background-color: rgba(0, 0, 0, 0.4);
					z-index: 1050;
				}

				/* Cart Area CSS */
				.right-side-cart-area {
					position: fixed;
					width: 670px;
					height: 100%;
					top: 0;
					right: -800px;
					background-color: #ffffff;
					z-index: 1100;
					box-shadow: 0 0 30px 0 rgba(0, 0, 0, 0.1);
					-webkit-transition-duration: 800ms;
					transition-duration: 800ms;
				}

				@media only screen and (min-width: 768px) and (max-width: 991px) {
					.right-side-cart-area {
						width: 500px;
						right: -600px;
					}
				}

				@media only screen and (max-width: 767px) {
					.right-side-cart-area {
						width: 270px;
						right: -400px;
					}
				}

				@media only screen and (min-width: 576px) and (max-width: 767px) {
					.right-side-cart-area {
						width: 400px;
						right: -550px;
					}
				}

				.right-side-cart-area.cart-on {
					right: 0;
				}

				.right-side-cart-area .cart-button a {
					position: absolute;
					top: 0;
					right: 100%;
					z-index: 100;
					width: 90px;
					display: block;
					text-align: center;
					border-left: 1px solid #ebebeb;
					height: 85px;
					line-height: 80px;
					background-color: #f5f7f9;
				}

				@media only screen and (max-width: 767px) {
					.right-side-cart-area .cart-button a {
						width: 50px;
						height: 50px;
						line-height: 50px;
					}
				}

				.right-side-cart-area .cart-button a img {
					max-width: 20px;
				}

				.right-side-cart-area .cart-button a span {
					font-family: "Ubuntu", sans-serif;
					font-size: 18px;
					color: #0315ff;
					font-weight: 700;
					position: absolute;
					top: -10px;
				}

				.right-side-cart-area .cart-content {
					position: relative;
					z-index: 1;
					width: 100%;
					overflow-x: hidden;
					overflow-y: scroll;
					height: 100%;
				}

				.right-side-cart-area .cart-content .cart-list {
					position: relative;
					z-index: 10;
					-webkit-box-flex: 0;
					-ms-flex: 0 0 190px;
					flex: 0 0 190px;
					width: 190px;
				}

				@media only screen and (max-width: 767px) {
					.right-side-cart-area .cart-content .cart-list {
						-webkit-box-flex: 0;
						-ms-flex: 0 0 100px;
						flex: 0 0 100px;
						width: 100px;
					}
				}

				@media only screen and (min-width: 576px) and (max-width: 767px) {
					.right-side-cart-area .cart-content .cart-list {
						-webkit-box-flex: 0;
						-ms-flex: 0 0 150px;
						flex: 0 0 150px;
						width: 150px;
					}
				}

				.right-side-cart-area .cart-content .cart-list .single-cart-item {
					position: relative;
					z-index: 1;
					-webkit-transition-duration: 500ms;
					transition-duration: 500ms;
				}

				.right-side-cart-area .cart-content .cart-list .single-cart-item .product-image {
					position: relative;
					z-index: 1;
					display: block;
				}

				.right-side-cart-area .cart-content .cart-list .single-cart-item .product-image .cart-item-desc {
					position: absolute;
					top: 0;
					left: 0;
					width: 100%;
					height: 100%;
					background-color: rgba(0, 0, 0, 0.6);
					padding: 50px 15px 15px;
					-webkit-transition-duration: 500ms;
					transition-duration: 500ms;
				}

				@media only screen and (max-width: 767px) {
					.right-side-cart-area .cart-content .cart-list .single-cart-item .product-image .cart-item-desc {
						padding: 5px;
					}
				}

				@media only screen and (min-width: 576px) and (max-width: 767px) {
					.right-side-cart-area .cart-content .cart-list .single-cart-item .product-image .cart-item-desc {
						padding: 30px 20px;
					}
				}

				.right-side-cart-area .cart-content .cart-list .single-cart-item .product-image .cart-item-desc .product-remove {
					position: absolute;
					top: 15px;
					right: 15px;
					color: #ffffff;
					font-size: 12px;
					padding: 5px;
				}

				@media only screen and (max-width: 767px) {
					.right-side-cart-area .cart-content .cart-list .single-cart-item .product-image .cart-item-desc .product-remove {
						top: 5px;
						right: 5px;
					}
				}

				.right-side-cart-area .cart-content .cart-list .single-cart-item .product-image .cart-item-desc .badge {
					display: block;
					font-weight: 600;
					font-size: 10px;
					color: rgba(255, 255, 255, 0.5);
					text-transform: uppercase;
					margin-bottom: 5px;
					text-align: left;
					padding: 0;
				}

				.right-side-cart-area .cart-content .cart-list .single-cart-item .product-image .cart-item-desc h6 {
					font-size: 12px;
					color: #ffffff;
					text-transform: capitalize;
					margin-bottom: 30px;
				}

				@media only screen and (max-width: 767px) {
					.right-side-cart-area .cart-content .cart-list .single-cart-item .product-image .cart-item-desc h6 {
						margin-bottom: 10px;
					}
				}

				.right-side-cart-area .cart-content .cart-list .single-cart-item .product-image .cart-item-desc .size,
				.right-side-cart-area .cart-content .cart-list .single-cart-item .product-image .cart-item-desc .color {
					display: block;
					font-weight: 600;
					font-size: 10px;
					color: rgba(255, 255, 255, 0.5);
					text-transform: uppercase;
					margin-bottom: 5px;
					line-height: 1;
				}

				.right-side-cart-area .cart-content .cart-list .single-cart-item .product-image .cart-item-desc .price {
					font-family: "Ubuntu", sans-serif;
					font-size: 16px;
					font-weight: 700;
					margin-bottom: 0;
					margin-top: 30px;
					color: #ffffff;
				}

				@media only screen and (max-width: 767px) {
					.right-side-cart-area .cart-content .cart-list .single-cart-item .product-image .cart-item-desc .price {
						margin-top: 10px;
						font-size: 12px;
					}
				}

				.right-side-cart-area .cart-content .cart-list .single-cart-item:hover .product-image .cart-item-desc {
					background-color: rgba(0, 0, 0, 0.8);
				}

				.right-side-cart-area .cart-content .cart-amount-summary {
					padding: 100px 10%;
					position: relative;
					z-index: 10;
					-webkit-box-flex: 0;
					-ms-flex: 0 0 calc(100% - 190px);
					flex: 0 0 calc(100% - 190px);
					width: calc(100% - 190px);
				}

				@media only screen and (max-width: 767px) {
					.right-side-cart-area .cart-content .cart-amount-summary {
						-webkit-box-flex: 0;
						-ms-flex: 0 0 calc(100% - 100px);
						flex: 0 0 calc(100% - 100px);
						width: calc(100% - 100px);
						padding: 50px 15px;
					}
				}

				@media only screen and (min-width: 576px) and (max-width: 767px) {
					.right-side-cart-area .cart-content .cart-amount-summary {
						-webkit-box-flex: 0;
						-ms-flex: 0 0 calc(100% - 150px);
						flex: 0 0 calc(100% - 150px);
						width: calc(100% - 150px);
						padding: 50px 30px;
					}
				}

				.right-side-cart-area .cart-content .cart-amount-summary h2 {
					font-size: 30px;
					margin-bottom: 100px;
				}

				@media only screen and (max-width: 767px) {
					.right-side-cart-area .cart-content .cart-amount-summary h2 {
						font-size: 24px;
						margin-bottom: 30px;
					}
				}

				@media only screen and (max-width: 767px) {
					.right-side-cart-area .cart-content .cart-amount-summary h2 {
						font-size: 30px;
						margin-bottom: 50px;
					}
				}

				.right-side-cart-area .cart-content .cart-amount-summary .summary-table li {
					margin-bottom: 20px;
					color: #000000;
					font-size: 14px;
					letter-spacing: 0.75px;
					text-transform: uppercase;
					font-weight: 600;
					display: -webkit-box;
					display: -ms-flexbox;
					display: flex;
					-webkit-box-pack: justify;
					-ms-flex-pack: justify;
					justify-content: space-between;
				}

				@media only screen and (max-width: 767px) {
					.right-side-cart-area .cart-content .cart-amount-summary .summary-table li {
						font-size: 12px;
						margin-bottom: 10px;
					}
				}

				@media only screen and (min-width: 576px) and (max-width: 767px) {
					.right-side-cart-area .cart-content .cart-amount-summary .summary-table li {
						font-size: 14px;
						margin-bottom: 15px;
					}
				}

				.right-side-cart-area .cart-content .cart-amount-summary .summary-table li span:last-child {
					font-weight: 700;
					font-family: "Ubuntu", sans-serif;
				}

				@media only screen and (max-width: 767px) {
					.right-side-cart-area .cart-content .cart-amount-summary .essence-btn {
						min-width: 140px;
						width: 140px;
						padding: 0 15px;
					}
				}

				/* :: 5.0 Welcome Area CSS */
				.welcome_area {
					position: relative;
					z-index: 1;
					width: 100%;
					height: 600px;
				}

				@media only screen and (min-width: 768px) and (max-width: 991px) {
					.welcome_area {
						height: 450px;
					}
				}

				@media only screen and (max-width: 767px) {
					.welcome_area {
						height: 350px;
					}
				}

				.welcome_area .hero-content h6 {
					font-size: 18px;
					color: #787878;
					margin-bottom: 10px;
				}

				.welcome_area .hero-content h2 {
					font-size: 60px;
					color: #000000;
					margin-bottom: 50px;
				}

				@media only screen and (min-width: 768px) and (max-width: 991px) {
					.welcome_area .hero-content h2 {
						font-size: 48px;
					}
				}

				@media only screen and (max-width: 767px) {
					.welcome_area .hero-content h2 {
						font-size: 30px;
					}
				}

				/* :: 6.0 Top Catagory Area CSS */
				.single_catagory_area {
					position: relative;
					z-index: 1;
					width: 100%;
					height: 240px;
					-webkit-transition-duration: 500ms;
					transition-duration: 500ms;
				}

				@media only screen and (min-width: 768px) and (max-width: 991px) {
					.single_catagory_area {
						height: 180px;
					}
				}

				@media only screen and (max-width: 767px) {
					.single_catagory_area {
						height: 180px;
					}
				}

				@media only screen and (min-width: 576px) and (max-width: 767px) {
					.single_catagory_area {
						margin-bottom: 30px;
					}
				}

				.single_catagory_area:after {
					-webkit-transition-duration: 500ms;
					transition-duration: 500ms;
					content: "";
					width: 100%;
					height: 100%;
					background-color: rgba(255, 255, 255, 0.6);
					position: absolute;
					top: 0;
					left: 0;
					z-index: -10;
				}

				.single_catagory_area .catagory-content a {
					display: block;
					font-size: 30px;
					font-weight: 700;
					color: #000000;
					letter-spacing: 1px;
					text-transform: uppercase;
				}

				@media only screen and (min-width: 768px) and (max-width: 991px) {
					.single_catagory_area .catagory-content a {
						font-size: 20px;
					}
				}

				@media only screen and (max-width: 767px) {
					.single_catagory_area .catagory-content a {
						font-size: 18px;
					}
				}

				.single_catagory_area:hover .catagory-content a {
					color: #0315ff;
				}

				/* :: 7.0 CTA Area CSS */
				.cta-area {
					position: relative;
					z-index: 1;
				}

				.cta-area .cta-content {
					width: 100%;
					height: 550px;
				}

				@media only screen and (max-width: 767px) {
					.cta-area .cta-content {
						height: 400px;
					}
				}

				.cta-area .cta-content h6 {
					font-size: 24px;
					color: #dc0345;
					margin-bottom: 10px;
				}

				.cta-area .cta-content h2 {
					font-size: 60px;
					color: #000000;
					margin-bottom: 50px;
				}

				@media only screen and (min-width: 768px) and (max-width: 991px) {
					.cta-area .cta-content h2 {
						font-size: 48px;
					}
				}

				@media only screen and (max-width: 767px) {
					.cta-area .cta-content h2 {
						font-size: 30px;
					}
				}

				.cta-area .cta-content .cta--text {
					padding-right: 150px;
				}

				@media only screen and (min-width: 768px) and (max-width: 991px) {
					.cta-area .cta-content .cta--text {
						padding-right: 50px;
					}
				}

				@media only screen and (max-width: 767px) {
					.cta-area .cta-content .cta--text {
						padding-right: 0;
					}
				}

				/* :: 8.0 Popular Products Area CSS */
				.single-product-wrapper {
					position: relative;
					z-index: 1;
					margin-bottom: 50px;
					overflow: hidden;
					background-color: #ffffff;
				}

				.single-product-wrapper .product-img {
					position: relative;
					z-index: 1;
					overflow: hidden;
				}

				.single-product-wrapper .product-img img {
					width: 100%;
					-webkit-transition-duration: 500ms;
					transition-duration: 500ms;
				}

				.single-product-wrapper .product-img .hover-img {
					-webkit-transition-duration: 500ms;
					transition-duration: 500ms;
					position: absolute;
					top: 0;
					left: 0;
					width: 100%;
					z-index: 10;
					opacity: 0;
					visibility: hidden;
				}

				.single-product-wrapper .product-img .product-badge {
					height: 25px;
					background-color: #000000;
					color: #ffffff;
					font-family: "Ubuntu", sans-serif;
					font-weight: 700;
					font-size: 12px;
					padding: 0 10px;
					display: inline-block;
					line-height: 25px;
					position: absolute;
					top: 20px;
					left: 20px;
					z-index: 10;
				}

				.single-product-wrapper .product-img .product-badge.offer-badge {
					background-color: #dc0345;
				}

				.single-product-wrapper .product-img .product-badge.new-badge {
					background-color: #0315ff;
				}

				.single-product-wrapper .product-img .product-favourite a {
					position: absolute;
					height: 25px;
					width: 45px;
					font-size: 14px;
					color: #ccc;
					top: 20px;
					right: 20px;
					z-index: 10;
					line-height: 25px;
					background-color: #ffffff;
					box-shadow: 0 0 3px rgba(0, 0, 0, 0.15);
					text-align: center;
					opacity: 0;
					visibility: hidden;
				}

				.single-product-wrapper .product-img .product-favourite a.active {
					opacity: 1;
					visibility: visible;
				}

				.single-product-wrapper .product-description {
					position: relative;
					z-index: 1;
					padding-top: 25px;
				}

				.single-product-wrapper .product-description span {
					font-size: 10px;
					text-transform: uppercase;
					color: #787878;
					margin-bottom: 15px;
					letter-spacing: 0.75px;
					font-weight: 600;
				}

				.single-product-wrapper .product-description h6 {
					color: #222222;
					margin-bottom: 5px;
				}

				.single-product-wrapper .product-description p {
					margin-bottom: 0;
					font-size: 14px;
					font-family: "Ubuntu", sans-serif;
					font-weight: 700;
					color: #000000;
				}

				.single-product-wrapper .product-description p span {
					font-size: 14px;
					font-family: "Ubuntu", sans-serif;
					font-weight: 700;
					color: #aaaaaa;
					margin-right: 10px;
					text-decoration: line-through;
				}

				.single-product-wrapper .product-description .hover-content {
					position: absolute;
					width: calc(100% - 40px);
					top: -70px;
					left: 20px;
					right: 20px;
					opacity: 0;
					visibility: hidden;
					-webkit-transition-duration: 500ms;
					transition-duration: 500ms;
				}

				.single-product-wrapper .product-description .hover-content .essence-btn {
					width: 100%;
				}

				.single-product-wrapper .favme {
					cursor: pointer;
					color: #ccc;
				}

				.single-product-wrapper .favme.active {
					color: #dc0345 !important;
				}

				.single-product-wrapper .favme.is_animating {
					animation: favme-anime .5s;
				}

				.single-product-wrapper:hover .product-img .hover-img {
					opacity: 1;
					visibility: visible;
				}

				.single-product-wrapper:hover .product-img .product-favourite a {
					opacity: 1;
					visibility: visible;
				}

				.single-product-wrapper:hover .hover-content {
					opacity: 1;
					visibility: visible;
				}

				@keyframes favme-anime {
					0% {
						opacity: 1;
						font-size: 14px;
						-webkit-text-stroke-color: transparent;
					}

					25% {
						opacity: .6;
						color: #ffffff;
						font-size: 15px;
						-webkit-text-stroke-width: 1px;
						-webkit-text-stroke-color: #dc0345;
					}

					75% {
						opacity: .6;
						color: #ffffff;
						font-size: 15px;
						-webkit-text-stroke-width: 1px;
						-webkit-text-stroke-color: #dc0345;
					}

					100% {
						opacity: 1;
						font-size: 14px;
						-webkit-text-stroke-color: transparent;
					}
				}

				.pagination {
					position: relative;
					z-index: 1;
				}

				.pagination .page-item .page-link {
					width: 40px;
					height: 40px;
					border: 1px solid #ebebeb;
					font-size: 12px;
					font-weight: 600;
					line-height: 38px;
					padding: 0;
					text-align: center;
					color: #787878;
				}

				.pagination .page-item .page-link:hover,
				.pagination .page-item .page-link:focus {
					color: #0315ff;
					box-shadow: none;
				}

				.pagination .page-item:first-child {
					margin-right: 15px;
				}

				.pagination .page-item:first-child .page-link {
					margin-left: 0;
					border-top-left-radius: 0;
					border-bottom-left-radius: 0;
				}

				.pagination .page-item:last-child {
					margin-left: 15px;
				}

				.pagination .page-item:last-child .page-link {
					margin-left: 0;
					border-top-right-radius: 0;
					border-bottom-right-radius: 0;
				}

				/* :: 9.0 Brands Area CSS */
				/* .brands-area {
		position: relative;
		z-index: 1;
		background-color: #f5f7f9;
		padding: 100px 5%;
	}

	@media only screen and (max-width: 767px) {
		.brands-area {
			-ms-flex-wrap: wrap;
			flex-wrap: wrap;
			padding: 100px 5% 70px;
		}
	}

	@media only screen and (max-width: 767px) {
		.brands-area .single-brands-logo {
			-webkit-box-flex: 0;
			-ms-flex: 0 0 33.33333%;
			flex: 0 0 33.33333%;
			width: 33.33333%;
			max-width: 33.33333%;
		}
	}

	.brands-area .single-brands-logo img {
		max-width: 120px;
	}

	@media only screen and (min-width: 768px) and (max-width: 991px) {
		.brands-area .single-brands-logo img {
			max-width: 90px;
		}
	}

	@media only screen and (max-width: 767px) {
		.brands-area .single-brands-logo img {
			max-width: 80px;
			margin-bottom: 30px;
		}
	} */

				/* :: 10.0 Single Product Details Area CSS */
				.single_product_details_area {
					position: relative;
					z-index: 100;
					-ms-flex-wrap: wrap;
					flex-wrap: wrap;
				}

				.single_product_details_area .single_product_thumb,
				.single_product_details_area .single_product_desc {
					-webkit-box-flex: 0;
					-ms-flex: 0 0 50%;
					flex: 0 0 50%;
					max-width: 50%;
					width: 50%;
					position: relative;
					z-index: 1;
				}

				@media only screen and (max-width: 767px) {

					.single_product_details_area .single_product_thumb,
					.single_product_details_area .single_product_desc {
						-webkit-box-flex: 0;
						-ms-flex: 0 0 100%;
						flex: 0 0 100%;
						max-width: 100%;
						width: 100%;
					}
				}

				.single_product_details_area .product_thumbnail_slides {
					position: relative;
					z-index: 1;
				}

				.single_product_details_area .product_thumbnail_slides .owl-prev,
				.single_product_details_area .product_thumbnail_slides .owl-next {
					-webkit-transition-duration: 500ms;
					transition-duration: 500ms;
					position: absolute;
					top: 50%;
					z-index: 20;
					left: 30px;
					width: 40px;
					height: 40px;
					margin-top: -20px;
					padding: 5px;
					opacity: 0.4;
				}

				.single_product_details_area .product_thumbnail_slides .owl-prev:hover,
				.single_product_details_area .product_thumbnail_slides .owl-next:hover {
					opacity: 1;
				}

				.single_product_details_area .product_thumbnail_slides .owl-next {
					left: auto;
					right: 30px;
				}

				.single_product_details_area .single_product_desc {
					position: relative;
					z-index: 1;
					padding: 50px 5%;
				}

				@media only screen and (min-width: 992px) and (max-width: 1199px) {
					.single_product_details_area .single_product_desc {
						padding: 30px 4%;
					}
				}

				@media only screen and (min-width: 768px) and (max-width: 991px) {
					.single_product_details_area .single_product_desc {
						padding: 30px 3%;
					}
				}

				.single_product_details_area .single_product_desc span {
					font-size: 14px;
					text-transform: uppercase;
					font-weight: 600;
					color: #787878;
					margin-bottom: 10px;
					display: block;
				}

				.single_product_details_area .single_product_desc a>h2 {
					font-size: 30px;
					display: block;
					margin-bottom: 10px;
				}

				@media only screen and (min-width: 992px) and (max-width: 1199px) {
					.single_product_details_area .single_product_desc a>h2 {
						font-size: 24px;
					}
				}

				@media only screen and (min-width: 768px) and (max-width: 991px) {
					.single_product_details_area .single_product_desc a>h2 {
						font-size: 20px;
					}
				}

				.single_product_details_area .single_product_desc .product-price {
					margin-bottom: 0;
					font-family: "Ubuntu", sans-serif;
					font-size: 24px;
					color: #dc0345;
					font-weight: 700;
				}

				@media only screen and (min-width: 768px) and (max-width: 991px) {
					.single_product_details_area .single_product_desc .product-price {
						font-size: 20px;
					}
				}

				.single_product_details_area .single_product_desc .product-price span {
					display: inline-block;
					font-family: "Ubuntu", sans-serif;
					font-size: 24px;
					color: #787878;
					font-weight: 700;
					text-decoration: line-through;
					margin-right: 15px;
				}

				.single_product_details_area .single_product_desc .product-desc {
					font-size: 16px;
				}

				@media only screen and (min-width: 768px) and (max-width: 991px) {
					.single_product_details_area .single_product_desc .product-desc {
						font-size: 14px;
					}
				}

				.single_product_details_area .single_product_desc .nice-select {
					position: relative;
					z-index: 100;
					border: 1px solid #ebebeb;
					border-radius: 0;
					font-size: 14px;
					font-weight: 500;
					height: 60px;
					line-height: 60;
					margin: 0;
					text-transform: uppercase;
					width: 220px;
				}

				.single_product_details_area .single_product_desc .nice-select .current {
					line-height: 60px;
				}

				.single_product_details_area .single_product_desc .nice-select .list {
					background-color: #f6f6f6;
					border-radius: 0;
					border: none;
					width: 100%;
				}

				.single_product_details_area .single_product_desc .nice-select .list .option.selected {
					color: #0315ff;
				}

				.single_product_details_area .single_product_desc .cart-fav-box .favme {
					cursor: pointer;
					color: #ccc;
					font-size: 24px;
				}

				.single_product_details_area .single_product_desc .cart-fav-box .favme.active {
					color: #dc0345 !important;
				}



				/* :: 13.0 Product Sidebar Area CSS */
				.widget {
					position: relative;
					z-index: 1;
				}

				.widget .widget-title {
					font-size: 18px;
					text-transform: capitalize;
					font-weight: 600;
				}

				.widget .widget-title2 {
					text-transform: uppercase;
					font-size: 12px;
					margin-bottom: 15px;
					display: block;
					margin-bottom: 0;
					color: #000000;
					font-weight: 600;
				}

				.widget .catagories-menu li>a {
					text-transform: uppercase;
					font-size: 12px;
					margin-bottom: 15px;
					display: block;
				}

				.widget .catagories-menu .sub-menu {
					margin-left: 15px;
					margin-bottom: 15px;
				}

				.widget .catagories-menu .sub-menu li>a {
					text-transform: capitalize;
					font-size: 14px;
					margin-bottom: 5px;
					display: block;
					font-weight: 300;
					color: #787878;
				}

				.widget .catagories-menu .sub-menu li>a:hover {
					color: #0315ff;
				}

				.widget.price .ui-slider-handle {
					background-color: #000000;
					border: none;
					border-radius: 0;
					top: -6px;
					width: 4px;
					height: 15px;
					margin: 0;
				}

				.widget.price .ui-slider-range.ui-corner-all.ui-widget-header {
					background-color: #0315ff;
				}

				.widget.price .ui-slider-horizontal {
					height: 5px;
				}

				.widget.price .range-price {
					font-size: 12px;
					font-weight: 600;
					margin-top: 15px;
					text-transform: uppercase;
				}

				.widget.color .widget-desc ul {
					-ms-flex-wrap: wrap;
					flex-wrap: wrap;
				}

				.widget.color .widget-desc ul li {
					-webkit-box-flex: 0;
					-ms-flex: 0 0 20%;
					flex: 0 0 20%;
					width: 20%;
					margin-bottom: 15px;
				}

				.widget.color .widget-desc ul li a {
					width: 30px;
					height: 30px;
					display: block;
					background-color: #ffffff;
					position: relative;
					z-index: 1;
					box-shadow: 0 0 3px rgba(0, 0, 0, 0.15);
				}

				.widget.color .widget-desc ul li a.color1 {
					background-color: #ffffff;
				}

				.widget.color .widget-desc ul li a.color2 {
					background-color: #969696;
				}

				.widget.color .widget-desc ul li a.color3 {
					background-color: #030303;
				}

				.widget.color .widget-desc ul li a.color4 {
					background-color: #0315ff;
				}

				.widget.color .widget-desc ul li a.color5 {
					background-color: #dc0647;
				}

				.widget.color .widget-desc ul li a.color6 {
					background-color: #fff56a;
				}

				.widget.color .widget-desc ul li a.color7 {
					background-color: #f26e51;
				}

				.widget.color .widget-desc ul li a.color8 {
					background-color: #9a8777;
				}

				.widget.color .widget-desc ul li a.color9 {
					background-color: #5b862a;
				}

				.widget.color .widget-desc ul li a.color10 {
					background-color: #8662a9;
				}

				.widget.brands ul li {
					display: block;
				}

				.widget.brands ul li a {
					display: block;
					margin-bottom: 5px;
					font-size: 14px;
					color: #787878;
					font-weight: 300;
					text-transform: capitalize;
				}

				.widget.brands ul li a:hover {
					color: #0315ff;
				}

				.product-topbar {
					position: relative;
					z-index: 100;
					margin-bottom: 40px;
				}

				.product-topbar .total-products p {
					margin-bottom: 0;
					font-size: 12px;
					font-weight: 600;
					color: #000000;
					text-transform: uppercase;
					letter-spacing: 0.75px;
				}

				.product-topbar .total-products p span {
					color: #0315ff;
				}

				.product-topbar .product-sorting p {
					margin-bottom: 0;
					font-size: 12px;
					font-weight: 600;
					color: #000000;
					text-transform: uppercase;
					letter-spacing: 0.75px;
					margin-right: 15px;
				}

				.product-topbar .product-sorting form select {
					background-color: transparent;
					border: none;
				}

				.product-topbar .product-sorting form select option {
					font-size: 12px;
					font-weight: 600;
					color: #000000;
					text-transform: uppercase;
					letter-spacing: 0.75px;
				}

				.product-topbar .nice-select {
					border: none;
					font-size: 14px;
					font-weight: 500;
					height: auto;
					line-height: 1.5;
					padding-left: 0;
					margin: 0;
					text-transform: uppercase;
				}

				.product-topbar .nice-select .list {
					background-color: #f6f6f6;
					border-radius: 0;
					border: none;
				}

				.product-topbar .nice-select .list .option.selected {
					color: #0315ff;
				}

				/* :: 14.0 Checkout Area CSS */
				.checkout_details_area form label {
					font-size: 12px;
					text-transform: uppercase;
					font-weight: 600;
				}

				.checkout_details_area form label span {
					color: #0315ff;
				}

				.checkout_details_area form .form-control {
					height: 42px;
					border: 1px solid #ebebeb;
					background-color: transparent;
					border-radius: 0;
				}

				.checkout_details_area form .nice-select {
					border-radius: 0;
					border: 1px solid #ebebeb;
				}

				.checkout_details_area form .nice-select .list {
					width: 100%;
					border-radius: 0;
				}

				.order-details-confirmation {
					width: 100%;
					border: 2px solid #ebebeb;
					padding: 40px;
				}

				@media only screen and (max-width: 767px) {
					.order-details-confirmation {
						margin-top: 100px;
						padding: 20px;
					}
				}

				.order-details-confirmation .order-details-form li {
					display: -webkit-box;
					display: -ms-flexbox;
					display: flex;
					-webkit-box-align: center;
					-ms-flex-align: center;
					-ms-grid-row-align: center;
					align-items: center;
					-webkit-box-pack: justify;
					-ms-flex-pack: justify;
					justify-content: space-between;
					margin-bottom: 0;
					font-size: 12px;
					text-transform: uppercase;
					padding: 20px 0;
					border-bottom: 2px solid #ebebeb;
					font-weight: 600;
				}

				.order-details-confirmation .card-header h6 a {
					display: block;
					font-size: 14px;
					text-transform: uppercase;
				}

				.order-details-confirmation .card-header h6 a i {
					color: #9f9f9f;
				}

				.order-details-confirmation .card {
					border: none;
				}

				.order-details-confirmation .card-header {
					background-color: transparent;
					border-bottom: none;
				}

				.order-details-confirmation .card-body p {
					font-size: 12px;
					line-height: 2;
					color: #9f9f9f;
				}


				/* :: 16.0 Regular Page Area CSS */
				.regular-page-content-wrapper {
					position: relative;
					z-index: 1;
				}

				.regular-page-content-wrapper .regular-page-text h2 {
					font-size: 30px;
					line-height: 1.5;
					margin-bottom: 50px;
				}

				.regular-page-content-wrapper .regular-page-text p {
					font-size: 18px;
					font-weight: 300;
					margin-bottom: 50px;
				}

				.regular-page-content-wrapper .regular-page-text blockquote {
					margin-bottom: 50px;
				}

				.regular-page-content-wrapper .regular-page-text blockquote h6 {
					font-size: 18px;
					line-height: 2;
					display: -webkit-box;
					display: -ms-flexbox;
					display: flex;
				}

				.regular-page-content-wrapper .regular-page-text blockquote h6 i {
					margin-right: 30px;
					font-size: 30px;
					color: #0315ff;
				}

				.regular-page-content-wrapper .regular-page-text blockquote span {
					margin-left: 60px;
					font-size: 16px;
					font-weight: 600;
					color: rgba(0, 0, 0, 0.6);
				}

				/* :: 17.0 Contact Area CSS */
				.contact-area {
					position: relative;
					z-index: 1;
					-ms-flex-wrap: wrap;
					flex-wrap: wrap;
				}

				.contact-area .google-map {
					-webkit-box-flex: 0;
					-ms-flex: 0 0 60%;
					flex: 0 0 60%;
					max-width: 60%;
					width: 60%;
				}

				@media only screen and (min-width: 768px) and (max-width: 991px) {
					.contact-area .google-map {
						-webkit-box-flex: 0;
						-ms-flex: 0 0 55%;
						flex: 0 0 55%;
						max-width: 55%;
						width: 55%;
					}
				}

				@media only screen and (max-width: 767px) {
					.contact-area .google-map {
						-webkit-box-flex: 0;
						-ms-flex: 0 0 100%;
						flex: 0 0 100%;
						max-width: 100%;
						width: 100%;
					}
				}

				.contact-area .google-map #googleMap {
					width: 100%;
					height: 685px;
				}

				@media only screen and (max-width: 767px) {
					.contact-area .google-map #googleMap {
						height: 400px;
					}
				}

				.contact-area .contact-info {
					-webkit-box-flex: 0;
					-ms-flex: 0 0 40%;
					flex: 0 0 40%;
					max-width: 40%;
					width: 40%;
					padding: 50px 5%;
				}

				@media only screen and (min-width: 768px) and (max-width: 991px) {
					.contact-area .contact-info {
						-webkit-box-flex: 0;
						-ms-flex: 0 0 45%;
						flex: 0 0 45%;
						max-width: 45%;
						width: 45%;
						padding: 50px 3%;
					}
				}

				@media only screen and (max-width: 767px) {
					.contact-area .contact-info {
						-webkit-box-flex: 0;
						-ms-flex: 0 0 100%;
						flex: 0 0 100%;
						max-width: 100%;
						width: 100%;
						padding: 50px 5%;
					}
				}

				.contact-area .contact-info h2 {
					font-size: 30px;
					margin-bottom: 20px;
				}

				.contact-area .contact-info p {
					font-size: 16px;
					font-weight: 300;
				}

				.contact-area .contact-info .contact-address p {
					font-size: 12px;
					font-weight: 600;
					margin-bottom: 10px;
				}

				.contact-area .contact-info .contact-address p span {
					font-weight: 600;
					color: #000000;
					width: 100px;
					display: inline-block;
					text-transform: uppercase;
				}

				.contact-area .contact-info .contact-address p:last-child {
					margin-top: 100px;
				}

				.contact-area .contact-info .contact-address p:last-child a {
					font-size: 14px;
					font-weight: 300;
				}

				.contact-area .contact-info .contact-address p:last-child a:hover {
					color: #0315ff;
				}
			</style>

			<body>
				<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>

				<h1>查詢商品</h1>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">商品名稱</th>
							<th scope="col">商品圖片</th>
							<th scope="col">商品種類</th>
							<th scope="col">商品介紹</th>
							<th scope="col">租賃價格</th>
							<th scope="col">販賣價格</th>
							<!-- <th scope="col">修改商品</th>
				<th scope="col">刪除商品</th> -->
						</tr>
					</thead>
					<tbody>
						<jstl:forEach items="${SearchResult2}" var="product_class" varStatus="Status">
							<tr>
								<th scope="row">${Status.index+1}</th>
								<td>${product_class.name}</td>
								<td><img alt="" height="100" width="160"
										src="${contextRoot}/Market/id?id=${product_class.id}"></td>
								<td>${product_class.product_class}</td>
								<td>${product_class.context}</td>
								<td>${product_class.rent_fee}</td>
								<td>${product_class.price}</td>
								<!-- <td>
						<form action="${contextRoot}/Market/edit" method="get">
							<input name="id" type="hidden" value="${product_class.id}" /> <input
								type="submit" class="btn btn-info btn-sm" value="編輯" />
						</form>
					</td>
					<td>
						<form action="${contextRoot}/Market/delete" method="post">
							<input name="_method" type="hidden" value="delete" /> <input
								name="id" type="hidden" value="${show_AllProduct.id}" /> <input
								type="submit" class="btn btn-danger btn-sm" value="刪除" />
						</form>
					</td> -->
							</tr>
						</jstl:forEach>
					</tbody>
				</table>
				<!---------------------------------------------------------------------------------------------->


				<!-- jQuery (Necessary for All JavaScript Plugins) -->
				<script src="js/jquery/jquery-2.2.4.min.js"></script>
				<!-- Popper js -->
				<script src="js/popper.min.js"></script>
				<!-- Bootstrap js -->
				<script src="js/bootstrap.min.js"></script>
				<!-- Plugins js -->
				<script src="js/plugins.js"></script>
				<!-- Classy Nav js -->
				<script src="js/classy-nav.min.js"></script>
				<!-- Active js -->
				<script src="js/active.js"></script>

				<!---------------------------------------------------------------------------------------------->

				<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
				<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
			</body>

			<!---------------------------------------------------------------------------------------------->

			<script>
				(function ($) {
					'use strict';

					var $window = $(window);

					// :: Nav Active Code
					if ($.fn.classyNav) {
						$('#essenceNav').classyNav();
					}

					// :: Sliders Active Code
					if ($.fn.owlCarousel) {
						$('.popular-products-slides').owlCarousel({
							items: 4,
							margin: 30,
							loop: true,
							nav: false,
							dots: false,
							autoplay: true,
							autoplayTimeout: 5000,
							smartSpeed: 1000,
							responsive: {
								0: {
									items: 1
								},
								576: {
									items: 2
								},
								768: {
									items: 3
								},
								992: {
									items: 4
								}
							}
						});
						$('.product_thumbnail_slides').owlCarousel({
							items: 1,
							margin: 0,
							loop: true,
							nav: true,
							navText: ["<img src='img/core-img/long-arrow-left.svg' alt=''>", "<img src='img/core-img/long-arrow-right.svg' alt=''>"],
							dots: false,
							autoplay: true,
							autoplayTimeout: 5000,
							smartSpeed: 1000
						});
					}

					// :: Header Cart Active Code
					var cartbtn1 = $('#essenceCartBtn');
					var cartOverlay = $(".cart-bg-overlay");
					var cartWrapper = $(".right-side-cart-area");
					var cartbtn2 = $("#rightSideCart");
					var cartOverlayOn = "cart-bg-overlay-on";
					var cartOn = "cart-on";

					cartbtn1.on('click', function () {
						cartOverlay.toggleClass(cartOverlayOn);
						cartWrapper.toggleClass(cartOn);
					});
					cartOverlay.on('click', function () {
						$(this).removeClass(cartOverlayOn);
						cartWrapper.removeClass(cartOn);
					});
					cartbtn2.on('click', function () {
						cartOverlay.removeClass(cartOverlayOn);
						cartWrapper.removeClass(cartOn);
					});

					// :: ScrollUp Active Code
					if ($.fn.scrollUp) {
						$.scrollUp({
							scrollSpeed: 1000,
							easingType: 'easeInOutQuart',
							scrollText: '<i class="fa fa-angle-up" aria-hidden="true"></i>'
						});
					}

					// :: Sticky Active Code
					$window.on('scroll', function () {
						if ($window.scrollTop() > 0) {
							$('.header_area').addClass('sticky');
						} else {
							$('.header_area').removeClass('sticky');
						}
					});

					// :: Nice Select Active Code
					if ($.fn.niceSelect) {
						$('select').niceSelect();
					}

					// :: Slider Range Price Active Code
					$('.slider-range-price').each(function () {
						var min = jQuery(this).data('min');
						var max = jQuery(this).data('max');
						var unit = jQuery(this).data('unit');
						var value_min = jQuery(this).data('value-min');
						var value_max = jQuery(this).data('value-max');
						var label_result = jQuery(this).data('label-result');
						var t = $(this);
						$(this).slider({
							range: true,
							min: min,
							max: max,
							values: [value_min, value_max],
							slide: function (event, ui) {
								var result = label_result + " " + unit + ui.values[0] + ' - ' + unit + ui.values[1];
								console.log(t);
								t.closest('.slider-range').find('.range-price').html(result);
							}
						});
					});

					// :: Favorite Button Active Code
					var favme = $(".favme");

					favme.on('click', function () {
						$(this).toggleClass('active');
					});

					favme.on('click touchstart', function () {
						$(this).toggleClass('is_animating');
					});

					favme.on('animationend', function () {
						$(this).toggleClass('is_animating');
					});

					// :: Nicescroll Active Code
					if ($.fn.niceScroll) {
						$(".cart-list, .cart-content").niceScroll();
					}

					// :: wow Active Code
					if ($window.width() > 767) {
						new WOW().init();
					}

					// :: Tooltip Active Code
					if ($.fn.tooltip) {
						$('[data-toggle="tooltip"]').tooltip();
					}

					// :: PreventDefault a Click
					$("a[href='#']").on('click', function ($) {
						$.preventDefault();
					});

				})(jQuery);
			</script>

			</html>