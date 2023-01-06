<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>home</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" >
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>
</head>
<body>
<header>
<jsp:include page="fragments/header.jsp"/>  
</header>
	<div align="center">
		<h2>Demo MVC - Home page</h2>
		<ul>
			<li><a href="may/add">tao may moi</a></li>
			<li><a href="dichvu/add">tao moi dich vu</a></li>
			<li><a href="category/list">All Category</a></li>
			<li><a href="khachhang/add">Add new Category</a></li>
		</ul>
	</div>
	<footer>
		<jsp:include page="fragments/footer.jsp" />
	</footer>
</body>
</html>
