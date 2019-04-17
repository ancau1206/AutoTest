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
		<h2>Thêm thành tích</h2>
	<span>${thongbao}</span>
		<form action="${pageContext.request.contextPath}/themmm" method="POST">
		
			<div class="form-group">
				<div>Loại</div>
				<input name="type" type="radio" required="required" value="1" >Thưởng
				<input type="radio" name="type" required="required" value="0" >Phạt
			</div>
			<div class="form-group">
				<div>Lí do</div>
				<textarea name="reason" maxlength="200" required="required" class="form-control"></textarea>
			</div>
			<hr>
			<button class="btn btn-default">Lưu</button>
			<input type="hidden"  name="id2" value="${id}">
			<input type="hidden" name="email" value="${email}">
		</form>
		</div>
		<div class="col-sm-4"></div>
		 
	</div>
		
</body>
</html>