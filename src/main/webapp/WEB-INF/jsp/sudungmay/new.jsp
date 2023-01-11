<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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
<title>New May</title>
</head>
<body>
	<header>
		<jsp:include page="../../jsp/fragments/header.jsp" />
	</header>
	<div align="center" style="margin: 55px">

		<form:form
			action="${pageContext.request.contextPath}/sudungmay/save"
			method="post" modelAttribute="sudungmayForm">



						<div class="mb-3 justify-content-md-center">
			<div class="justify-content-md-center row">
		
				<form:label class="col-sm-2" path="KhachHang.maKH">Khach Hang</form:label>
				
				<form:select path="KhachHang.maKH" class="custom-select col-sm-4"
						id="KhachHang">
						<form:option value="">chon...</form:option>
						<c:forEach var="c" items="${khachHangs}" varStatus="status">
						<option value="${c.maKH}">${c.tenKH}</option>
					
						</c:forEach>
						
					</form:select>
					
					</div>
					<span class="text-danger" id="KhachHangError"></span>
					
			</div>



			<div class="mb-3 justify-content-md-center">

			<div class="input-group justify-content-md-center row">

				<form:label class="col-sm-2" path="May.maMay">Dich Vu</form:label>


					<form:select path="May.maMay" class="custom-select col-sm-4"
						id="may">
						<form:option value="">chon...</form:option>
						<c:forEach var="c" items="${mays}" varStatus="status">
						<option value="${c.maMay}">${c.viTri}</option>
					
						</c:forEach>
						
					</form:select>
					
					</div>
					<span class="text-danger" id="mayError"></span>
				
			</div>

			<div class="mb-3 justify-content-md-center">
			<div class=" input-group row justify-content-md-center">
				<form:label class="col-2 col-form-label" path="ngayBatDauSuDung"> Ngay bat dau su dung </form:label>
				<form:input type="date" class="form-control col-sm-4"
					path="ngayBatDauSuDung" id="ngayBatDauSuDung"/>
					</div>
					
					<span class="text-danger" id="ngayBatDauSuDungError"></span>
			</div>
			<div class="mb-3 justify-content-md-center">
			<div class=" input-group row justify-content-md-center">
				<form:label class="col-2 col-form-label" path="gioBatDauSuDung"> gio bat dau su dung </form:label>
				<form:input type="time" class="form-control col-sm-4"
					path="gioBatDauSuDung" id="gioBatDauSuDung" />
					</div>
					
					<span class="text-danger" id="gioBatDauSuDungError"></span>
			</div>
			
			<div class="mb-3 justify-content-md-center">
			<div class=" input-group row justify-content-md-center">
				<form:label class="col-2 col-form-label" path="thoiGianSuDung"> Thoi gian su dung</form:label>
				<form:input type="number" class="form-control col-sm-4"
					path="thoiGianSuDung" id="thoiGianSuDung" />
				</div>
					
					<span class="text-danger" id="thoiGianSuDungError"></span>
			</div>
			

			<div class="form-group">
				<form:button class="btn btn-outline-success col-sm-1" value="Add">Add</form:button>
			</div>


		</form:form>
	</div>
	
<script type="text/javascript">

	$('#sudungmayForm').submit(function (event) {
	    
	    const ngayBatDauSuDung = $(this.ngayBatDauSuDung);
	    const gioBatDauSuDung = $(this.gioBatDauSuDung);
	    const thoiGianSuDung = $(this.thoiGianSuDung);
	    const khachHang = $(this.KhachHang);
	    const may = $(this.may);
	  
	    
	    let isValid = true;
	  
	   
	    if (
		        !handleDisplayError(
		        		may,
		        	isEmpty,
		            $('#mayError'),
		            'chon may'
		        )
		    ) {
		        isValid = false;
		    } 
	    if (
		        !handleDisplayError(
		        	khachHang,
		        	isEmpty,
		            $('#KhachHangError'),
		            'chon KH'
		        )
		    ) {
		        isValid = false;
		    } 
	    if (
	        !handleDisplayError(
	        	ngayBatDauSuDung,
	        	isEmpty,
	            $('#ngayBatDauSuDungError'),
	            'Sai dinh dang'
	        )
	    ) {
	        isValid = false;
	    } 
	    if (
		        !handleDisplayError(
		        	gioBatDauSuDung,
		        	isEmpty,
		            $('#gioBatDauSuDungError'),
		            'Sai dinh dang'
		        )
		    ) {
		        isValid = false;
		    } 
	    if (
		        !handleDisplayError(
		        	thoiGianSuDung,
		        	checkNumber,
		            $('#thoiGianSuDungError'),
		            'Sai dinh dang'
		        )
		    ) {
		        isValid = false;
		    } 
	 
	    
	    if(!isValid){
        	event.preventDefault();
        }
	    
	});
	function handleDisplayError(element, validateFunc, element_err, message) {
	    if (validateFunc(element.val())) {
	        element.addClass('is-invalid');
	        element_err.text(message);
	        return false;
	    }
	    element.removeClass('is-invalid');
	    element_err.text('');
	    return true;
	}
	function isEmpty(value) {
	    return !value || !value.trim();
	}
	

	
	function checkNumber(value) {
	    return value < 0;
	}
	
	
	
	</script>
	
	<footer style="bottom:0px ; position: fixed; width: 100% ; height: 50px">
		<jsp:include page="../../jsp/fragments/footer.jsp" />
	</footer>
</body>
</html>