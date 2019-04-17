<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>Login</title>


	

<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" >
<link href="<c:url value="/resources/css/bootstrap-theme.css" />" rel="stylesheet" >
<link href="<c:url value="/resources/css/elegant-icons-style.css" />" rel="stylesheet" >
<link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet" >
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" >
<link href="<c:url value="/resources/css/style-responsive.css" />" rel="stylesheet" >



</head>

<body class="login-img3-body">

  <div class="container">
    
    <form class="login-form" action="${pageContext.request.contextPath}/checkLogin" method="POST">
      <div class="login-wrap">
        <p class="login-img"><i class="icon_lock_alt"></i></p>
        <div class="input-group">
          <span class="input-group-addon"><i class="icon_profile"></i></span>
          <input type="text" id="usename" class="form-control" required="required" placeholder="Username" name="Username" autofocus>
        </div>
        <div class="input-group">
          <span class="input-group-addon"><i class="icon_key_alt"></i></span>
          <input type="password" id="password" required="required" class="form-control" placeholder="Password" name="Password">
        </div>
       <% try { if (request.getParameter("error").equals("true")) { %><h4 style="color:black;">Sai tài khoản hoặc mật khẩu</h5> <% } } catch (Exception e){ }%>
        <label class="checkbox">
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        <button class="btn btn-primary btn-lg btn-block" id="submit" type="submit">Login</button>
        <button class="btn btn-info btn-lg btn-block" type="reset">Reset</button>
      </div>
    </form>
    <div class="text-right">
      <div class="credits">
          Designed by <a href="https://www.facebook.com/ancau1206">cau hat hay</a>
        </div>
    </div>
  </div>
 <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
  <script src="js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/js/jquery.nicescroll.js" />"></script>
  <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
 <script src="<c:url value="/resources/js/scripts.js" />"></script>
    <script src="js/scripts.js"></script>

</body>
</html>