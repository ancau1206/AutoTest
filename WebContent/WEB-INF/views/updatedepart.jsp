
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
		<h2>Sửa phòng ban</h2>
	<span>${thongbao}</span>
		<form:form action="xóa" method="post" modelAttribute="Staffs">
			<div class="form-group">
				<div>Id</div>
				<form:input path="id" class="form-control"  />
			</div>
			<div class="form-group">
				<div>Mã nhân viên</div>
				<form:input path="codeId" class="form-control"  />
			</div>
			<div class="form-group">
				<div>Tên</div>
				<form:input path="name" class="form-control"  />
			</div>
			<div class="form-group">
				<div>Phòng ban</div>
				<c:forEach var="u" items="${Departs}">
				<form:select path="Departs.id" class="form-control"  />
				</c:forEach>
			</div>
			<div class="form-group">
				<div>Giới tính</div>
				<form:radiobutton path="gender" value="0" class="form-control"  />Nam
				<form:radiobutton path="gender" value="1" class="form-control"  />Nữ
			</div>
			<div class="form-group">
				<div>Ngày sinh</div>
				<form:input path="birthday" class="form-control"  />
			</div>
			<div class="form-group">
				<div>Ảnh</div>
				<form:input path="photo" class="form-control"  />
			</div>
			<div class="form-group">
				<div>Email</div>
				<form:input path="email" class="form-control"  />
			</div>
			<div class="form-group">
				<div>Số điện thoại</div>
				<form:input path="phone" class="form-control"  />
			</div>
			<div class="form-group">
				<div>Lương</div>
				<form:input path="salary" class="form-control"  />
			</div>
			<div class="form-group">
				<div>Cấp độ</div>
				<form:input path="level" class="form-control"  />
			</div>
			<div class="form-group">
				<div>Ghi chú</div>
				<form:input path="notes" class="form-control"  />
			</div>
			
			
			<hr>
			<button class="btn btn-default">Lưu</button>
		</form:form>
		</div>
		<div class="col-sm-4"></div>
		 
	</div>
		
</body>
</html>
</body>
</html>