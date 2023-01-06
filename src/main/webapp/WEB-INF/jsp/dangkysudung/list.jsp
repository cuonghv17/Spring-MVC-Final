
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
<title>List May</title>

<meta charset="ISO-8859-1">

</head>
<body>

	<header>
		<jsp:include page="../../jsp/fragments/header.jsp" />
	</header>

	<div align="center" style="margin: 25px">

		<h3>List May</h3> 
		<div align="center">
			<form action="${pageContext.request.contextPath}/dangkysudung/search"
				method="get" class=" input-group mb-3 mt-3" style="width: 50%">



				<input class="form-control " style="width: 50%" type="text"
					name="searchKey"> <input type="submit" value="Search">
			</form>

		</div>
		<table class="table ">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Ma KH</th>
					<th scope="col">Ten KH</th>
					<th scope="col">Ma MAY</th>
					<th scope="col"> Vi tri</th>
					<th scope="col"> Trang thai </th>
					<th scope="col"> Ngay BD SD may</th>
					<th scope="col"> Gio BD SD may</th>
					<th scope="col"> Thoi gian SD may</th>
					<th scope="col"> Ma DV </th>
					<th scope="col"> Ngay SD dv</th>
					<th scope="col"> Gio SD DV </th>
					<th scope="col"> So luong </th>
					<th scope="col"> Tong Tien </th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${lists}" varStatus="status">
				
					<tr >
					
					<td scope="row">${c[0]}</td>
						<td>${c[1]}</td>
						<td>${c[2]}</td>
						<td>${c[3]}</td>
						<td>${c[4]}</td>
						<td>${c[5]}</td>
						<td>${c[6]}</td>
						<td>${c[7]}</td>
						<td>${c[8]}</td>
						<td>${c[9]}</td>
						<td>${c[10]}</td>
						<td>${c[11]}</td>
						<td>${c[12]}</td>
						
				
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

</body>
</html>
