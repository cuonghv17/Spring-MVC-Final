<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" >
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>

</head>
<body>
	<header>
		<jsp:include page="../../jsp/fragments/header.jsp" />
	</header>
	<div align="center" style="margin: 55px">
		
		<form:form action="${pageContext.request.contextPath}/dichvu/save"
			method="post" modelAttribute="dichVuForm" id="dichVuForm">
			

				<div class="mb-3 justify-content-md-center mb-3">
					<div class=" input-group row justify-content-md-center">
					<form:label class="col-1 col-form-label" path="tenDV">Ten DV</form:label>
					<form:input class="form-control col-sm-4" id="tenDV" path="tenDV"   />
					</div>
					<span class="text-danger" id="tenDVError"></span>
				</div>
				
				<div class="mb-3 justify-content-md-center">
				<div class=" input-group row justify-content-md-center">
					<form:label class="col-1 col-form-label" path="donViTinh">Don vi tinh</form:label>
					<form:input class="form-control col-sm-4" path="donViTinh" id="donViTinh" />
					 </div>
					<span class="text-danger" id="donViTinhError"></span>
				</div>
				<div class="mb-3 justify-content-md-center">
				<div class=" input-group row justify-content-md-center">
					<form:label class="col-1 col-form-label" path="donGia">Don gia</form:label>
					<form:input class="form-control col-sm-4" path="donGia" id="donGia" />
					</div>
				<span class="text-danger" id="donGiaError"></span>

				</div>
				<form:hidden path="maDV" />
				<div class="form-group">
					<form:button class="btn btn-outline-success col-sm-1" id="btn-register" value="Add">Add</form:button>
				</div>

			
		</form:form>
	</div>
	<script type="text/javascript">

	$('#dichVuForm').submit(function (event) {
	    
	    const tenDV = $(this.tenDV);
	    const donViTinh = $(this.donViTinh);
	    const donGia = $(this.donGia);
	   
	    let isValid = true;
	    if (
	        !handleDisplayError(
	        	tenDV,
	            isEmpty,
	            $('#tenDVError'),
	            'Vui lòng không để trống tên'
	        )
	    ) {
	        isValid = false;
	    } else {
	        if (
	                !handleDisplayError(
	                	tenDV,
	                	checkLengthh,
	                    $('#tenDVError'),
	                    'Ten qua dai'
	                )
	            ) {
	                isValid = false;
	            }
	        }
	    if (
	        !handleDisplayError(
	        	donViTinh,
	            isEmpty,
	            $('#donViTinhError'),
	            'Vui lòng ko de trong'
	        )
	    ) {
	        isValid = false;
	    }else {
	        if (
	                !handleDisplayError(
	                	donViTinh,
	                	checkLengthh,
	                    $('#donViTinhError'),
	                    ' qua dai'
	                )
	            ) {
	                isValid = false;
	            }
	        }
        if (
                !handleDisplayError(
                	donGia,
                	checkNumber,
                    $('#donGiaError'),
                    'Khong duoc nho hon 0'
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
	function checkLengthh(value) {
	    return value.length > 50;
	}
	</script>
	<footer>
		<jsp:include page="../../jsp/fragments/footer.jsp" />
	</footer>
</body>

</html>