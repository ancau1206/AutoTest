<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><head>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>Quản lý công ty</title>

<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" >
<link href="<c:url value="/resources/css/elegant-icons-style.css" />" rel="stylesheet" >
<link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet" >
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" >
<link href="<c:url value="/resources/css/jquery-ui-1.10.4.min.css" />" rel="stylesheet" >
<link href="<c:url value="/resources/css/bootstrap-theme.css" />" rel="stylesheet" >
<link href="<c:url value="/resources/img" />" rel="stylesheet" >

 <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="css/elegant-icons-style.css" rel="stylesheet">
  <link href="css/font-awesome.min.css" rel="stylesheet">
 
  <link href="css/style.css" rel="stylesheet">
  <link href="css/jquery-ui-1.10.4.min.css" rel="stylesheet">



<style type="text/css">.jqstooltip { position: absolute;left: 0px;top: 0px;display: block;visibility: hidden;background: rgb(0, 0, 0) transparent;background-color: rgba(0,0,0,0.6);filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000);-ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000)";color: white;font: 10px arial, san serif;text-align: left;white-space: nowrap;border: 1px solid white;z-index: 10000;}.jqsfield { color: white;padding: 5px 5px 8px 5px;font: 10px arial, san serif;text-align: left;}</style><style type="text/css">.jqstooltip { position: absolute;left: 0px;top: 0px;display: block;visibility: hidden;background: rgb(0, 0, 0) transparent;background-color: rgba(0,0,0,0.6);filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000);-ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000)";color: white;font: 10px arial, san serif;text-align: left;white-space: nowrap;border: 1px solid white;z-index: 10000;}.jqsfield { color: white;padding: 5px 5px 8px 5px;font: 10px arial, san serif;text-align: left;}</style></head>

<body style="">

  <!-- container section start -->
  <section id="container" class="">


    <header class="header dark-bg">
      <div class="toggle-nav">
        <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
      </div>

      <!--logo start-->
      <a href="index.html" class="logo">Nice <span class="lite">Admin</span></a>
      <!--logo end-->

      <div class="nav search-row" id="top_menu">
        <!--  search form start -->
        <ul class="nav top-menu">
          <li>
            <form class="navbar-form">
              <input class="form-control" placeholder="Search" type="text">
            </form>
          </li>
        </ul>
        <!--  search form end -->
      </div>

      <div class="top-nav notification-row">
        <!-- notificatoin dropdown start-->
        <ul class="nav pull-right top-menu">

         
          
          <!-- inbox notificatoin end -->
          <!-- alert notification start-->
         
          <!-- alert notification end-->
          <!-- user login dropdown start-->
          <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="profile-ava">
                                <img alt="" src="img/avatar1_small.jpg">
                            </span>
                            <span class="username">Admin</span>
                            <b class="caret"></b>
                        </a>
            <ul class="dropdown-menu extended logout">
              <div class="log-arrow-up"></div>
              
              
              
              
              <li>
                <a href="logout"><i class="icon_key_alt"></i><s:message code="home.logout" /></a>
                 <a href="?language=vi"><s:message code="home.vietnam" /></a>
                <a href="?language=en"><s:message code="home.tienganh" /></a>
              </li>
              
              
            </ul>
          </li>
          <!-- user login dropdown end -->
        </ul>
        <!-- notificatoin dropdown end-->
      </div>
    </header>
    <!--header end-->

    <!--sidebar start-->
      <aside>
      <div id="sidebar" class="nav-collapse " tabindex="5000" style="overflow: hidden; outline: none; margin-left: 0px;">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" style="display: block;">
          <li class="active">
            <a class="" href="${pageContext.request.contextPath}/index">
                          <i class="icon_house_alt"></i>
                          <span><s:message code="home.dashboard" /></span>
                      </a>
          </li>
          
          
          <li>
            <a class="" href="${pageContext.request.contextPath}/nhanvien/list">
                          <i class="icon_genius"></i>
                          <span><s:message code="home.staffs" /></span>
                      </a>
          </li>
 <li>
            <a class="" href="${pageContext.request.contextPath}/phongban/list">
                          <i class="icon_documents_alt"></i>
                          <span><s:message code="home.departs" /></span>
                      </a>
          </li>
          <li class="sub-menu">
            <a href="javascript:;" class="">
                          <i class="icon_piechart"></i>
                          <span><s:message code="home.add.top" /></span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
            <ul class="sub">
              <li><a class="" href="${pageContext.request.contextPath}/xephang"><s:message code="home.staffs" /></a></li>
              <li><a class="" href="${pageContext.request.contextPath}/xephangphongban"><s:message code="home.departs" /></a></li>
            </ul>
          </li>

          

        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
    <!--sidebar end-->

    <!--main content start-->
  <section id="main-content" style="margin-left: 180px;">
      <section class="wrapper">
        <!--overview start-->
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa-laptop"></i><s:message code="home.dashboard.top10" /> </h3>
            <ol class="breadcrumb"> 
            </ol>
          </div>
        </div>

        
        <!--/.row-->


        


        <!-- Today status end -->


        <div class="panel-body">
                <table class="table bootstrap-datatable countries">
                  <thead>
                    <tr>
                      <th><s:message code="home.staffs.name" /></th>
                      <th><s:message code="home.staffs.image" /></th>
                      <th><s:message code="home.staffs.departs" /></th>
                      <th><s:message code="home.aad.discipline" /></th>
                      <th><s:message code="home.aad.score" /></th>
                    </tr>
                  </thead>
                  <tbody>
      <c:forEach var="records" items="${records}" varStatus="status">     
                     <tr>
                     <td>${status.index+1}. ${records[0]}</td>
                     <td><img alt="Image" width="150px" height="150px" src="${pageContext.request.contextPath}/resources/img/${records[5]}"></td>
                     <td>${records[4]}</td>
                     <td>-${records[2]}</td>
                     <td>+${records[1]}</td>
                   
                    </tr>
                 </c:forEach> 
                  </tbody>
                </table>
              </div>



        <!-- statics end -->




        <!-- project team & activity start -->
        <br><br>

        
        <!-- project team & activity end -->

      </section>
      <div class="text-right">
        
      </div>
    </section>
    <!--main content end-->
  </section>
  <!-- container section start -->

  <!-- javascripts -->
  <script src="js/jquery.js"></script>
 
  <!-- bootstrap -->
  <script src="js/bootstrap.min.js"></script>
  <!-- nice scroll -->

  <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
 
    <!--custome script for all page-->
    <script src="js/scripts.js"></script>
    <!-- custom script for this page--><script src="<c:url value="/resources/js/jquery.js" />"></script>
  <script src="js/jquery.js"></script>
 <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
  <script src="js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/js/jquery.nicescroll.js" />"></script>
  <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
 <script src="<c:url value="/resources/js/scripts.js" />"></script>
    <script src="js/scripts.js"></script>
    
    <script>
      //knob
      $(function() {
        $(".knob").knob({
          'draw': function() {
            $(this.i).val(this.cv + '%')
          }
        })
      });

      //carousel
      $(document).ready(function() {
        $("#owl-slider").owlCarousel({
          navigation: true,
          slideSpeed: 300,
          paginationSpeed: 400,
          singleItem: true

        });
      });

      //custom select box

      $(function() {
        $('select.styled').customSelect();
      });

      /* ---------- Map ---------- */
      $(function() {
        $('#map').vectorMap({
          map: 'world_mill_en',
          series: {
            regions: [{
              values: gdpData,
              scale: ['#000', '#000'],
              normalizeFunction: 'polynomial'
            }]
          },
          backgroundColor: '#eef3f7',
          onLabelShow: function(e, el, code) {
            el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
          }
        });
      });
    </script>




<div id="ascrail2000" class="nicescroll-rails" style="width: 6px; z-index: 1000; background: rgb(247, 247, 247); cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; opacity: 0; display: none;"><div style="position: relative; top: 0px; float: right; width: 6px; height: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2000-hr" class="nicescroll-rails" style="height: 6px; z-index: 1000; background: rgb(247, 247, 247); position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0;"><div style="position: relative; top: 0px; height: 6px; width: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px; left: 0px;"></div></div><div id="ascrail2001" class="nicescroll-rails" style="width: 3px; z-index: auto; background: rgb(247, 247, 247); cursor: default; position: fixed; top: 0px; left: 177px; height: 657px; display: none;"><div style="position: relative; top: 0px; float: right; width: 3px; height: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2001-hr" class="nicescroll-rails" style="height: 3px; z-index: auto; background: rgb(247, 247, 247); top: 654px; left: 0px; position: fixed; cursor: default; display: none;"><div style="position: relative; top: 0px; height: 3px; width: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px;"></div></div><div class="jvectormap-label"></div><div id="ascrail2002" class="nicescroll-rails" style="width: 6px; z-index: 1000; background: rgb(247, 247, 247); cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; display: none;"><div style="position: relative; top: 0px; float: right; width: 6px; height: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2002-hr" class="nicescroll-rails" style="height: 6px; z-index: 1000; background: rgb(247, 247, 247); position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none;"><div style="position: relative; top: 0px; height: 6px; width: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2003" class="nicescroll-rails" style="width: 3px; z-index: auto; background: rgb(247, 247, 247); cursor: default; position: fixed; top: 0px; left: 177px; height: 613px; display: none; opacity: 0;"><div style="position: relative; top: 0px; float: right; width: 3px; height: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2003-hr" class="nicescroll-rails" style="height: 3px; z-index: auto; background: rgb(247, 247, 247); top: 610px; left: 0px; position: fixed; cursor: default; display: none; opacity: 0;"><div style="position: relative; top: 0px; height: 3px; width: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px; left: 0px;"></div></div><div class="jvectormap-label"></div><div id="ascrail2004" class="nicescroll-rails" style="width: 6px; z-index: 1000; background: rgb(247, 247, 247); cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; display: none;"><div style="position: relative; top: 0px; float: right; width: 6px; height: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2004-hr" class="nicescroll-rails" style="height: 6px; z-index: 1000; background: rgb(247, 247, 247); position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none;"><div style="position: relative; top: 0px; height: 6px; width: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2005" class="nicescroll-rails" style="width: 3px; z-index: auto; background: rgb(247, 247, 247); cursor: default; position: fixed; top: 0px; left: 177px; height: 657px; display: none; opacity: 0;"><div style="position: relative; top: 0px; float: right; width: 3px; height: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2005-hr" class="nicescroll-rails" style="height: 3px; z-index: auto; background: rgb(247, 247, 247); top: 654px; left: 0px; position: fixed; cursor: default; display: none; opacity: 0;"><div style="position: relative; top: 0px; height: 3px; width: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px; left: 0px;"></div></div><div id="ascrail2006" class="nicescroll-rails" style="width: 6px; z-index: 1000; background: rgb(247, 247, 247); cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; display: none;"><div style="position: relative; top: 0px; float: right; width: 6px; height: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2006-hr" class="nicescroll-rails" style="height: 6px; z-index: 1000; background: rgb(247, 247, 247); position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none;"><div style="position: relative; top: 0px; height: 6px; width: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2007" class="nicescroll-rails" style="width: 3px; z-index: auto; background: rgb(247, 247, 247); cursor: default; position: fixed; top: 0px; left: 177px; height: 657px; display: none;"><div style="position: relative; top: 0px; float: right; width: 3px; height: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2007-hr" class="nicescroll-rails" style="height: 3px; z-index: auto; background: rgb(247, 247, 247); top: 654px; left: 0px; position: fixed; cursor: default; display: none;"><div style="position: relative; top: 0px; height: 3px; width: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2008" class="nicescroll-rails" style="width: 6px; z-index: 1000; background: rgb(247, 247, 247); cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; display: none;"><div style="position: relative; top: 0px; float: right; width: 6px; height: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2008-hr" class="nicescroll-rails" style="height: 6px; z-index: 1000; background: rgb(247, 247, 247); position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none;"><div style="position: relative; top: 0px; height: 6px; width: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2009" class="nicescroll-rails" style="width: 3px; z-index: auto; background: rgb(247, 247, 247); cursor: default; position: fixed; top: 0px; left: 177px; height: 657px; display: none;"><div style="position: relative; top: 0px; float: right; width: 3px; height: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2009-hr" class="nicescroll-rails" style="height: 3px; z-index: auto; background: rgb(247, 247, 247); top: 654px; left: 0px; position: fixed; cursor: default; display: none;"><div style="position: relative; top: 0px; height: 3px; width: 0px; background-color: rgb(0, 122, 255); background-clip: padding-box; border-radius: 10px;"></div></div></body></html>