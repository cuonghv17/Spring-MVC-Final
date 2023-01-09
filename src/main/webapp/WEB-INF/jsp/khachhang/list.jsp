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
			<form action="${pageContext.request.contextPath}/khachhang/search"
				method="get" class=" input-group mb-3 mt-3" style="width: 50%">



				<input class="form-control " style="width: 50%" type="text"
					name="searchKey"> <input type="submit" value="Search">
			</form>

		</div>
		<table class="table col-8">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Ma KH</th>
					<th scope="col">Ten KH</th>
					<th scope="col">Dia chi</th>
					<th scope="col">So dien thoai</th>
					<th scope="col">email</th>
					<th width="20%">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${khachHangs}" varStatus="status">
					<tr>
						<td scope="row">${c.maKH}</td>
						<td>${c.tenKH}</td>
						<td>${c.diaChi}</td>
						<td>${c.soDienThoai}</td>
						<td>${c.diaChiEmail}</td>
						<td><a class="btn btn-danger btn-sm" onclick="showConfig('${c.maKH}')" >Delete</a> <a class="btn btn-warning btn-sm"
							href="update/${c.maKH}">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<script type="text/javascript">
			function showConfig(id) {
				$('#maKH').text(id);
				$('#yesOptionConfirm').attr('href',
						'delete?maKH=${c.maKH}' + id);
				$('#configmationConfirmId').modal('show');
			}
		</script>

		<!-- Modal -->
		<div class="modal" id="configmationConfirmId">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Xác nhận</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<p>
							Bạn có muốn xác nhan xoa DK có mã "<span id="maKH"></span>" ?
						</p>
					</div>
					<div class="modal-footer">
						<a id="yesOptionConfirm" type="button" class="btn btn-info">Có</a>
						<button type="button" class="btn btn-danger" data-dismiss="modal">Không</button>
					</div>
				</div>
			</div>
		</div>
		
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
	<footer>
		<jsp:include page="../../jsp/fragments/footer.jsp" />
	</footer>
</body>
</html>