
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<div class="col-sm-4"></div>
	<div class="col-sm-4">
		<h2>Thông tin chi tiết nhân viên</h2>
	<span>${thongbao}</span>
		<form:form action="${pageContext.request.contextPath}/nhanvien/" method="post" modelAttribute="Staffs">
			
			<div class="form-group">
			<fieldset disabled>
				<div>Mã nhân viên</div>
				<form:input path="codeId"   class="form-control" />
				</fieldset>
			</div>
			<div class="form-group">
<fieldset disabled>			
				<div>Tên</div>
				<form:input path="name" class="form-control"  />
				</fieldset>
			</div>
			
			<div class="form-group">
			<fieldset disabled>
				<div>Phòng ban</div>
				<form:select path="departs.id" class="form-control"  >
				<form:options items="${Departs}" itemValue="id" itemLabel="name" />
				</form:select>
				</fieldset>
			</div>
				
			<div class="form-group">
			<fieldset disabled>
				<div>Giới tính</div>
				<form:radiobutton path="gender" value="true"  />Nam
				<form:radiobutton path="gender" value="false" />Nữ
			</fieldset>
			</div>
			<div class="form-group">
			<fieldset disabled>
				<div>Ngày sinh</div>
				<form:input path="birthday" class="form-control"  />
				</fieldset>
			</div>
			<div class="form-group">
			<fieldset disabled>
				<div>Ảnh</div>
				<form:input path="photo" class="form-control"  />
				</fieldset>
			</div>
			<div class="form-group">
			<fieldset disabled>
				<div>Email</div>
				<form:input path="email" class="form-control"  />
				</fieldset>
			</div>
			<div class="form-group">
			<fieldset disabled>
				<div>Số điện thoại</div>
				<form:input path="phone" class="form-control"  />
				</fieldset>
			</div>
			<div class="form-group">
			<fieldset disabled>
				<div>Lương</div>
				<form:input path="salary" class="form-control"  />
			</fieldset>
			</div>
			<div class="form-group">
				<fieldset disabled>
				<div>Cấp độ</div>
				<form:input path="level" class="form-control"  />
				</fieldset>
			</div>
			<div class="form-group">
			<fieldset disabled>
				<div>Ghi chú</div>
				<form:input path="notes" class="form-control"  />
				</fieldset>
			</div>
			
			
			<hr>
			<button type="submit" class="btn btn-default">Lưu</button>
		</form:form>
		</div>
		<div class="col-sm-4"></div>
		 
	</div>
		
</body>
</html>
</body>
</html>