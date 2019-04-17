<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
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
		<h2><s:message code="home.departs.add" /></h2>
	<span>${thongbao}</span>
		<form autocomplete="off" action="${departs != null ? '/Assiment/phongban/sua' : '/Assiment/phongban/them'}" method="post">
			<c:if test="${departs != null}">
				<input type="hidden" name="id" value="${departs.id}" id="id" />
			</c:if>
			<div class="form-group">
				<div><s:message code="home.departs.codeid" /></div>
				<input name="codeId" class="form-control" type="text" minlength="2" maxlength="10" id="codeId" required="required" value="${departs.codeId }"/>
				<span id="notiCodeId" style="color:red;"></span>
				
			</div>
			
			<div class="form-group">
				<div><s:message code="home.departs.name" /></div>
				<input name = "name" class="form-control" minlength="5" maxlength="50" id="name" type="text" required value="${departs.name }"/>
			</div>
			
			<hr>
			<button type="submit" id="frmSubmit" class="btn btn-default"><s:message code="home.submit" /></button>
		</form>
		</div>
		<div class="col-sm-4"></div>
		 
	</div>
		
</body>
<script type="text/javascript">
$(document).ready(function(){
    var checkCodeId = true;
    function check (checkC) {
		if (!checkC) {
			$("#codeId").css("border","1px solid red");
			$("#notiCodeId").text("CodeId is invalid");
		} else {
			$("#codeId").css("border","1px solid #ccc");
			$("#notiCodeId").text("");
		}
		if (checkC) {
			$("#frmSubmit").attr("disabled",false);
		} else {
			$("#frmSubmit").attr("disabled",true);
		}
	}
    $("#codeId").change(function(){
    	var codeId = $("#codeId").val();
        var id = $("#id").val();
        $.post( "/Assiment/check/depart/codeId", 
        		{ id: id, codeId: codeId },
        		function (data) {
    				if (data === "true") {
    					checkCodeId = true;
    				} else {
    					checkCodeId = false;
    				}
    				check(checkCodeId);
    			});
    });
});
</script>
</html>