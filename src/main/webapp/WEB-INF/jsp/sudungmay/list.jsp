
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<style>
.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>

<meta charset="ISO-8859-1">
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


<meta charset="ISO-8859-1">

</head>
<body>

	<header>
		<jsp:include page="../../jsp/fragments/header.jsp" />
	</header>

	<div align="center" style="margin: 25px">
<h3>List SD May</h3> 
		<div align="center">
			<form action="${pageContext.request.contextPath}/sudungmay/search"
				method="get" class=" input-group mb-3 mt-3" style="width: 50%">



				<input class="form-control " style="width: 50%" type="text"
					name="searchKey"> <input type="submit" value="Search">
			</form>

		</div>
		<table class="table col-8 text-center">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Ma may</th>
					<th scope="col">Ma KH</th>
					<th scope="col"> Ngay Bat Dau SD</th>
					<th scope="col">Gio BDSD</th>
					<th width="20%">Thoi Gian SD</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${suDungMayS}" varStatus="status">
					<tr>
						<td scope="row">${c.may.maMay}</td>
						<td>${c.khachHang.maKH}</td>
						<td>${c.ngayBatDauSuDung}</td>
						<td>${c.gioBatDauSuDung}</td>
						<td>${c.thoiGianSuDung}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />

		<div class="pagination col-8">
			<c:if test="${currentPage > 1}">
				<a href="list?page=${currentPage-1}">Previous</a>
			</c:if>
			<c:forEach begin="1" end="${totalPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<a class="active"> ${i} </a>
					</c:when>
					<c:otherwise>
						<a href="list?page=${i}">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:if test="${currentPage lt totalPages}">
				<a href="list?page=${currentPage+1}">Next</a>
			</c:if>
		</div>
		</div>
		<footer style="bottom:0px ; position: fixed; width: 100% ; height: 50px">
		<jsp:include page="../../jsp/fragments/footer.jsp" />
	</footer>

	
	
</body>
</html>
