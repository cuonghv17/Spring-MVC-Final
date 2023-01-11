<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>home</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/index">CMD</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-expanded="false"> May </a>
					<div class="dropdown-menu">
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/may/add">Tao moi</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/may/list">Danh Sach</a>
					</div></li>
				<li class="nav-item dropdown active"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown"> Dich vu </a>
					<div class="dropdown-menu">
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/dichvu/add">Tao moi</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/dichvu/list">Danh
							Sach</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-expanded="false"> Khach hang </a>
					<div class="dropdown-menu">
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/khachhang/add">Tao moi</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/khachhang/list">Danh
							Sach</a>
					</div></li>
				<li class="nav-item dropdown active"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-expanded="false"> Dang ky su dung </a>
					<div class="dropdown-menu">
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/sudungdichvu/add">Dich Vu</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/sudungmay/add">May</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-expanded="false"> Danh sach dang ky dich vu </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="${pageContext.request.contextPath}/dangkysudung/list"> List Dang Ky</a> 
						<a class="dropdown-item" href="${pageContext.request.contextPath}/sudungmay/list"> List DK SD May</a> 
					<a class="dropdown-item" href="${pageContext.request.contextPath}/sudungdichvu/list"> List DK DV</a> 
						
					</div></li>

			</ul>

		</div>
	</nav>
</body>
</html>