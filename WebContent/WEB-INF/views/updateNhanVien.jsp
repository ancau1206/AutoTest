<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
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
	<h4>Thêm nhân viên</h4>
		
	<span>${message}</span>
		<form:form autocomplete="off" action="${pageContext.request.contextPath}/nhanvien/${url}" method="post" enctype="multipart/form-data" modelAttribute="Staffs">
			<div class="form-group">
				<form:hidden path="id" class="form-control" id="id"  />
			</div>
			<div class="form-group">
				<div><s:message code="home.staffs.codeid" /></div>
				<form:input path="codeId" type="text" minlength="2" maxlength="10" required="required"  id="code" />
				<span id="notiCodeId" style="color:red;"></span>
			</div>
			<div class="form-group">
				<div><s:message code="home.staffs.name" /></div>
				<form:input path="name" type="text" minlength="5" maxlength="50" required="required" class="form-control" id="name" />
			</div>
			
			<div class="form-group">
				<div><s:message code="home.staffs.departs" /></div>
				<form:select path="departs.id" class="form-control" id="departId" >
				<form:options items="${Departs}" itemValue="id" itemLabel="name" />
				</form:select>
			</div>
				
			<div class="form-group">
				<div><s:message code="home.staffs.gender" /></div>
				<form:radiobutton path="gender" value="true"  />Nam
				<form:radiobutton path="gender" value="false" />Nữ
			</div>
			<div class="form-group">
				<div><s:message code="home.staffs.birthday" /></div>
				<form:input type="date" id="birthday" required="required" path="birthday" class="form-control"  />
			</div>
			<div class="form-group">
				<div><s:message code="home.staffs.image" /></div>
				
				<input type="file"  id="photo" accept="image/gif, image/jpeg, image/png" name="photo2">
				<form:input type="text"  path="photo" readonly="true"/>	
			
			</div>
			<div class="form-group">
				<div><s:message code="home.staffs.email" /></div>
				<form:input type="email" id="email" maxlength="30" minlength="8" path="email" class="form-control" required="required" />
			</div>
			<div class="form-group">
				<div><s:message code="home.staffs.phone" /></div>
				
				<form:input path="phone" class="form-control" type="text" id="phone" data-validation="number" pattern="\d*" minlength="9" maxlength="15" required="required" />
				<span id="notiPhone" style="color:red;"></span>
			</div>
			<div class="form-group">
				<div><s:message code="home.staffs.salary" /></div>
				<form:input path="salary" id="salary" name="salary" type="number" required="required" min="100" max="10000" class="form-control"  />
			</div>
			<div class="form-group">
				<div><s:message code="home.staffs.level" /></div>
				
				<select name="level"  class="form-control">
				<option value="1">Cấp độ 1</option>
				<option value="2">Cấp độ 2</option>
				<option value="3">Cấp độ 3</option>
				<option value="4">Cấp độ 4</option>
				<option value="5">Cấp độ 5</option>
				<option value="6">Cấp độ 6</option>
				<option value="7">Cấp độ 7</option>
				<option value="8">Cấp độ 8</option>
			<option value="9">Cấp độ 9</option>
				<option value="10">Cấp độ 10</option>
				<select>
				
			</div>
			<div class="form-group">
				<div><s:message code="home.staffs.notes" /></div>
				<form:textarea id="notes" path="notes" required="required" minlength="10" maxlength="100" class="form-control"  />
			</div>
			<hr>
			<button type="submit" id="frmSubmit" class="btn btn-default"><s:message code="home.submit" /></button>
		</form:form>
		</div>
		<div class="col-sm-4"></div>
		 
	</div>
		
</body>

</html>
</body>
</html>