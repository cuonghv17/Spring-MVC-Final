<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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

</head>
<body>
	<header>
		<jsp:include page="../../jsp/fragments/header.jsp" />
	</header>
	<div align="center" style="margin: 55px">

		<form:form action="${pageContext.request.contextPath}/khachhang/save"
			method="post" modelAttribute="khachhangForm">

<form:hidden path="maKH" />
			<div class="mb-3 justify-content-md-center">
				<div class=" input-group row justify-content-md-center">
					<form:label class="col-2 col-form-label" path="tenKH">  Ten Khach Hang</form:label>
					<form:input type="text" class="form-control col-sm-4" path="tenKH"
						id="tenKH" />

				</div>
				<span class="text-danger" id="tenKHError"></span>
			</div>
			<div class="mb-3 justify-content-md-center">
				<div class=" input-group row justify-content-md-center">
					<form:label class="col-2 col-form-label" path="diaChi"> Dia chi</form:label>
					<form:input type="text" class="form-control col-sm-4" path="diaChi"
						id="diaChi" />
				</div>
				<span class="text-danger" id="diaChiError"></span>
			</div>
			<div class="mb-3 justify-content-md-center">
				<div class=" input-group row justify-content-md-center">
					<form:label class="col-2 col-form-label" path="soDienThoai"> So dien thoai</form:label>
					<form:input  class="form-control col-sm-4"
						path="soDienThoai" id="soDienThoai" />
				</div>
				<span class="text-danger" id="soDienThoaiError"></span>
			</div>
			<div class="mb-3 justify-content-md-center">
				<div class=" input-group row justify-content-md-center">
					<form:label class="col-2 col-form-label" path="diaChiEmail"> Email </form:label>
					<form:input type="email" class="form-control col-sm-4"
						path="diaChiEmail" id="diaChiEmail" />
				</div>
				<span class="text-danger" id="diaChiEmailError"></span>

			</div>


			<div class="form-group">
				<form:button class="btn btn-outline-success col-sm-1" value="Add">Add</form:button>
			</div>


		</form:form>
	</div>

<script type="text/javascript">

	$('#khachhangForm').submit(function (event) {
	    
	    const tenKH = $(this.tenKH);
	    const diaChi = $(this.diaChi);
	    const soDienThoai = $(this.soDienThoai);
	    const diaChiEmail = $(this.diaChiEmail);
	    let isValid = true;
	  
	    if (
	        !handleDisplayError(
	        	tenKH,
	            isEmpty,
	            $('#tenKHError'),
	            'Vui lòng không để trống'
	        )
	    ) {
	        isValid = false;
	    } else {
	        if (
	                !handleDisplayError(
	                	tenKH,
	                	checkLengthh,
	                    $('#tenKHError'),
	                    'Ten qua dai'
	                )
	            ) {
	                isValid = false;
	            }
	        }
	    if (
	        !handleDisplayError(
	        	diaChi,
	            isEmpty,
	            $('#diaChiError'),
	            'Vui lòng ko de trong'
	        )
	    ) {
	        isValid = false;
	    }else {
	        if (
	                !handleDisplayError(
	                	diaChi,
	                	checkLengthh,
	                    $('#diaChiError'),
	                    ' qua dai'
	                )
	            ) {
	                isValid = false;
	            }
	        }
	    if (
                !handleDisplayError(
                	soDienThoai,
                	checkSDT,
                    $('#soDienThoaiError'),
                    'Khong dung dinh dang'
                )
            ) {
                isValid = false;
            }
	    if (
                !handleDisplayError(
                	diaChiEmail,
                	checMail,
                    $('#diaChiEmailError'),
                    'Khong dung dinh dang'
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
	
	function checkSDT(value) {
		var vnf_regex = /((09|03|07|08|05)+([0-9]{8})\b)/g;
	   
	    return !value || !value.trim() || !value.match(vnf_regex);
	}
	function checMail(value) {
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	   
	    return !value || !value.trim() || !value.match(mailformat);
	}
	
	function checkLengthh(value) {
	    return value.length > 50;
	}
	</script>
	<footer>
		<jsp:include page="../../jsp/fragments/footer.jsp" />
	</footer>
</body>
</html>