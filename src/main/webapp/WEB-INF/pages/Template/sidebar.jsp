<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
		<div class="position-sticky pt-3 sidebar-sticky">
			<ul class="nav flex-column">
				<li class="nav-item"><a class="nav-link active" aria-current="page" href="${contextRoot}/template/">
						<span data-feather="home" class="align-text-bottom"></span> 後台介面首頁
					</a></li>
				<li class="nav-item"><a class="nav-link" href="${contextRoot}/competition"> <span data-feather="file"
							class="align-text-bottom"></span> 活動系統
					</a></li>
				<li class="nav-item"><a class="nav-link" href="${contextRoot}/Market/marketMain">
						<span data-feather="shopping-cart" class="align-text-bottom"></span>
						商城系統
					</a></li>
				<li class="nav-item"><a class="nav-link" href="${contextRoot}/player.main"> <span data-feather="users"
							class="align-text-bottom"></span> 會員系統
					</a></li>
				<li class="nav-item"><a class="nav-link" href="${contextRoot}/player.main"><i
							class="bi bi-person-badge"></i>&nbsp;&nbsp;員工系統
					</a></li>
				<li class="nav-item"><a class="nav-link" href="${contextRoot}/place"><i
							class="bi bi-building"></i>&nbsp;&nbsp;場地系統
					</a></li>
				<li class="nav-item"><a class="nav-link" href="${contextRoot}/forum.main"><i
							class="bi bi-file-text"></i>&nbsp;&nbsp;論壇系統
					</a></li>
			</ul>
			<h6
				class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted text-uppercase">
				<span>已儲存報告</span> <a class="link-secondary" href="${contextRoot}/" aria-label="Add a new report"> <span
						data-feather="plus-circle" class="align-text-bottom"></span>
				</a>
			</h6>
			<ul class="nav flex-column mb-2">
				<li class="nav-item"><a class="nav-link" href="${contextRoot}/">
						<span data-feather="file-text" class="align-text-bottom"></span> 本月
					</a></li>
				<li class="nav-item"><a class="nav-link" href="${contextRoot}/">
						<span data-feather="file-text" class="align-text-bottom"></span>
						上個季度
					</a></li>
				<li class="nav-item"><a class="nav-link" href="${contextRoot}/">
						<span data-feather="file-text" class="align-text-bottom"></span>
						社交影響
					</a></li>
				<li class="nav-item"><a class="nav-link" href="${contextRoot}/">
						<span data-feather="file-text" class="align-text-bottom"></span>
						年尾銷量
					</a></li>
			</ul>
		</div>
	</nav>
	<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
		<div
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">