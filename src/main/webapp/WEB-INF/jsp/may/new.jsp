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
		
		<form:form action="${pageContext.request.contextPath}/may/save"
			method="post" modelAttribute="mayForm">
			

				<div class="mb-3 justify-content-md-center">
				<div class=" input-group row justify-content-md-center">
					<form:label class="col-1 col-form-label" path="viTri">Vi tri</form:label>
					<form:input class="form-control col-sm-4" path="viTri" id="viTri"  />
					</div>
					<span class="text-danger" id="viTriError"></span>
				</div>
				
				<div class="mb-3 justify-content-md-center">
				<div class=" input-group row justify-content-md-center">
					<form:label class="col-1 col-form-label" path="trangThai">Trang thai</form:label>
					<form:select path="trangThai" class="custom-select col-sm-4"
						id="trangThai">
						<form:option value="">chon tinh trang</form:option>
						<form:option value="Ranh">Ranh</form:option>
						<form:option value="Ban">Ban</form:option>
						<form:option value="Sua Chua">Sua Chua</form:option>
					</form:select>
					
					</div>
					<span class="text-danger" id="trangThaiError"></span>
				</div>
				
				<div class="form-group">
					<form:button class="btn btn-outline-success col-sm-1" value="Add">Add</form:button>
				</div>

			
		</form:form>
	</div>
	<script type="text/javascript">

	$('#mayForm').submit(function (event) {
	    
	    const viTri = $(this.viTri);
	    const trangThai = $(this.trangThai);
	    
	   
	    let isValid = true;
	    if (
	        !handleDisplayError(
	        		trangThai,
	            isEmpty,
	            $('#trangThaiError'),
	            'Vui lòng không để trống'
	        )
	    ) {
	        isValid = false;
	    } else {
	        if (
	                !handleDisplayError(
	                	trangThai,
	                	checkLengthh,
	                    $('#trangThaiError'),
	                    'qua dai'
	                )
	            ) {
	                isValid = false;
	            }
	        }
	    if (
	        !handleDisplayError(
	        		viTri,
	            isEmpty,
	            $('#viTriError'),
	            'Vui lòng ko de trong'
	        )
	    ) {
	        isValid = false;
	    }else {
	        if (
	                !handleDisplayError(
	                		viTri,
	                	checkLengthh,
	                    $('#viTriError'),
	                    ' qua dai'
	                )
	            ) {
	                isValid = false;
	            }
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
	function checkLengthh(value) {
	    return value.length > 50;
	}
	</script>
	<footer>
		<jsp:include page="../../jsp/fragments/footer.jsp" />
	</footer>
</body>
</html>