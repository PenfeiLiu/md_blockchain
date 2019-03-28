<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"
          + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="">
<head>
  <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description" content="Modern admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities with bitcoin dashboard.">
<meta name="keywords" content="admin template, modern admin template, dashboard template, flat admin template, responsive admin template, web app, crypto dashboard, bitcoin dashboard">
<meta name="author" content="PIXINVENT">
<title>中国网络安全审查与认证区块链平台-用户注册详情</title>
<link rel="apple-touch-icon" href="statics/images/ico/apple-icon-120.png">
<link rel="shortcut icon" type="image/x-icon" href="statics/images/ico/favicon.ico">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Quicksand:300,400,500,700"
  rel="stylesheet">
<link href="https://maxcdn.icons8.com/fonts/line-awesome/1.1/css/line-awesome.min.css"
  rel="stylesheet">
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css" href="statics/css/vendors.css">
<link rel="stylesheet" type="text/css" href="statics/vendors/css/tables/jsgrid/jsgrid-theme.min.css">
<link rel="stylesheet" type="text/css" href="statics/vendors/css/tables/jsgrid/jsgrid.min.css">
<!-- END VENDOR CSS-->
<!-- BEGIN MODERN CSS-->
<link rel="stylesheet" type="text/css" href="statics/css/app.css">
<!-- END MODERN CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css" href="statics/css/core/menu/menu-types/vertical-menu.css">
<link rel="stylesheet" type="text/css" href="statics/css/core/colors/palette-gradient.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="statics/css/style.css">
<!-- END Custom CSS-->

<style type="text/css">
body {
	font-family:microsoft yahei!important;
}
</style>
</head>
<body class="vertical-layout vertical-menu 2-columns   menu-expanded fixed-navbar"
data-open="click" data-menu="vertical-menu" data-col="2-columns">
<!-- fixed-top-->
<nav class="header-navbar navbar-expand-md navbar navbar-with-menu navbar-without-dd-arrow fixed-top navbar-semi-light bg-info navbar-shadow">
  <div class="navbar-wrapper">
    <div class="navbar-header">
      <ul class="nav navbar-nav flex-row">
        <li class="nav-item mobile-menu d-md-none mr-auto"><a class="nav-link nav-menu-main menu-toggle hidden-xs" href="#"><i class="ft-menu font-large-1"></i></a></li>
        <li class="nav-item"> <a class="navbar-brand" href="index.jsp"> <img class="brand-logo" alt="modern admin logo" src="statics/images/logo/logo.png">
          <h3 class="brand-text" style="color:#fff!important;font-size:16px;">质量认证区块链平台</h3>
          </a> </li>
        <li class="nav-item d-md-none"> <a class="nav-link open-navbar-container" data-toggle="collapse" data-target="#navbar-mobile"><i class="la la-ellipsis-v"></i></a> </li>
      </ul>
    </div>
    <div class="navbar-container content">
      <div class="collapse navbar-collapse" id="navbar-mobile">
        <ul class="nav navbar-nav mr-auto float-left">
          <li class="nav-item d-none d-md-block"><a class="nav-link nav-menu-main menu-toggle hidden-xs" href="#"><i class="ft-menu"></i></a></li>
          <li class="nav-item d-none d-md-block"><a class="nav-link nav-link-expand" href="#"><i class="ficon ft-maximize"></i></a></li>
          <!--<li class="dropdown nav-item mega-dropdown"><a class="dropdown-toggle nav-link" href="#" data-toggle="dropdown">Mega</a>
              <ul class="mega-dropdown-menu dropdown-menu row">
                <li class="col-md-2">
                  <h6 class="dropdown-menu-header text-uppercase mb-1"><i class="la la-newspaper-o"></i> News</h6>
                  <div id="mega-menu-carousel-example">
                    <div>
                      <img class="rounded img-fluid mb-1" src="statics/images/slider/slider-2.png"
                      alt="First slide"><a class="news-title mb-0" href="#">Poster Frame PSD</a>
                      <p class="news-content">
                        <span class="font-small-2">January 26, 2018</span>
                      </p>
                    </div>
                  </div>
                </li>
                <li class="col-md-3">
                  <h6 class="dropdown-menu-header text-uppercase"><i class="la la-random"></i> Drill down menu</h6>
                  <ul class="drilldown-menu">
                    <li class="menu-list">
                      <ul>
                        <li>
                          <a class="dropdown-item" href="layout-2-columns.jsp"><i class="ft-file"></i> Page layouts & Templates</a>
                        </li>
                        <li><a href="#"><i class="ft-align-left"></i> Multi level menu</a>
                          <ul>
                            <li><a class="dropdown-item" href="#"><i class="la la-bookmark-o"></i>  Second level</a></li>
                            <li><a href="#"><i class="la la-lemon-o"></i> Second level menu</a>
                              <ul>
                                <li><a class="dropdown-item" href="#"><i class="la la-heart-o"></i>  Third level</a></li>
                                <li><a class="dropdown-item" href="#"><i class="la la-file-o"></i> Third level</a></li>
                                <li><a class="dropdown-item" href="#"><i class="la la-trash-o"></i> Third level</a></li>
                                <li><a class="dropdown-item" href="#"><i class="la la-clock-o"></i> Third level</a></li>
                              </ul>
                            </li>
                            <li><a class="dropdown-item" href="#"><i class="la la-hdd-o"></i> Second level, third link</a></li>
                            <li><a class="dropdown-item" href="#"><i class="la la-floppy-o"></i> Second level, fourth link</a></li>
                          </ul>
                        </li>
                        <li>
                          <a class="dropdown-item" href="color-palette-primary.jsp"><i class="ft-camera"></i> Color palette system</a>
                        </li>
                        <li><a class="dropdown-item" href="sk-2-columns.jsp"><i class="ft-edit"></i> Page starter kit</a></li>
                        <li><a class="dropdown-item" href="changelog.jsp"><i class="ft-minimize-2"></i> Change log</a></li>
                        <li>
                          <a class="dropdown-item" href="https://pixinvent.ticksy.com/"><i class="la la-life-ring"></i> Customer support center</a>
                        </li>
                      </ul>
                    </li>
                  </ul>
                </li>
                <li class="col-md-3">
                  <h6 class="dropdown-menu-header text-uppercase"><i class="la la-list-ul"></i> Accordion</h6>
                  <div id="accordionWrap" role="tablist" aria-multiselectable="true">
                    <div class="card border-0 box-shadow-0 collapse-icon accordion-icon-rotate">
                      <div class="card-header p-0 pb-2 border-0" id="headingOne" role="tab"><a data-toggle="collapse" data-parent="#accordionWrap" href="#accordionOne"
                        aria-expanded="true" aria-controls="accordionOne">Accordion Item #1</a></div>
                      <div class="card-collapse collapse show" id="accordionOne" role="tabpanel" aria-labelledby="headingOne"
                      aria-expanded="true">
                        <div class="card-content">
                          <p class="accordion-text text-small-3">Caramels dessert chocolate cake pastry jujubes bonbon.
                            Jelly wafer jelly beans. Caramels chocolate cake liquorice
                            cake wafer jelly beans croissant apple pie.</p>
                        </div>
                      </div>
                      <div class="card-header p-0 pb-2 border-0" id="headingTwo" role="tab"><a class="collapsed" data-toggle="collapse" data-parent="#accordionWrap"
                        href="#accordionTwo" aria-expanded="false" aria-controls="accordionTwo">Accordion Item #2</a></div>
                      <div class="card-collapse collapse" id="accordionTwo" role="tabpanel" aria-labelledby="headingTwo"
                      aria-expanded="false">
                        <div class="card-content">
                          <p class="accordion-text">Sugar plum bear claw oat cake chocolate jelly tiramisu
                            dessert pie. Tiramisu macaroon muffin jelly marshmallow
                            cake. Pastry oat cake chupa chups.</p>
                        </div>
                      </div>
                      <div class="card-header p-0 pb-2 border-0" id="headingThree" role="tab"><a class="collapsed" data-toggle="collapse" data-parent="#accordionWrap"
                        href="#accordionThree" aria-expanded="false" aria-controls="accordionThree">Accordion Item #3</a></div>
                      <div class="card-collapse collapse" id="accordionThree" role="tabpanel" aria-labelledby="headingThree"
                      aria-expanded="false">
                        <div class="card-content">
                          <p class="accordion-text">Candy cupcake sugar plum oat cake wafer marzipan jujubes
                            lollipop macaroon. Cake dragée jujubes donut chocolate
                            bar chocolate cake cupcake chocolate topping.</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </li>
                <li class="col-md-4">
                  <h6 class="dropdown-menu-header text-uppercase mb-1"><i class="la la-envelope-o"></i> Contact Us</h6>
                  <form class="form form-horizontal">
                    <div class="form-body">
                      <div class="form-group row">
                        <label class="col-sm-3 form-control-label" for="inputName1">Name</label>
                        <div class="col-sm-9">
                          <div class="position-relative has-icon-left">
                            <input class="form-control" type="text" id="inputName1" placeholder="John Doe">
                            <div class="form-control-position pl-1"><i class="la la-user"></i></div>
                          </div>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label class="col-sm-3 form-control-label" for="inputEmail1">Email</label>
                        <div class="col-sm-9">
                          <div class="position-relative has-icon-left">
                            <input class="form-control" type="email" id="inputEmail1" placeholder="john@example.com">
                            <div class="form-control-position pl-1"><i class="la la-envelope-o"></i></div>
                          </div>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label class="col-sm-3 form-control-label" for="inputMessage1">Message</label>
                        <div class="col-sm-9">
                          <div class="position-relative has-icon-left">
                            <textarea class="form-control" id="inputMessage1" rows="2" placeholder="Simple Textarea"></textarea>
                            <div class="form-control-position pl-1"><i class="la la-commenting-o"></i></div>
                          </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-sm-12 mb-1">
                          <button class="btn btn-info float-right" type="button"><i class="la la-paper-plane-o"></i> Send </button>
                        </div>
                      </div>
                    </div>
                  </form>
                </li>
              </ul>
            </li>-->
          <li class="nav-item nav-search"><a class="nav-link nav-link-search" href="search-page.jsp"><i class="ficon ft-search"></i></a>
            <div class="search-input">
              <input class="input" type="text" placeholder="Explore Modern...">
            </div>
          </li>
        </ul>
        <ul class="nav navbar-nav float-right">
          <li class="dropdown dropdown-user nav-item"> <a class="dropdown-toggle nav-link dropdown-user-link" href="#" data-toggle="dropdown"> <span class="mr-1">您好, <span class="user-name text-bold-700">丁二宝</span> </span> <span class="avatar avatar-online"> <img src="statics/images/portrait/small/me.png" alt="avatar"><i></i></span> </a>
            <div class="dropdown-menu dropdown-menu-right"><a class="dropdown-item" href="#"><i class="ft-user"></i>个人信息</a> <a class="dropdown-item" href="#"><i class="ft-mail"></i> 个人信息</a> <a class="dropdown-item" href="#"><i class="ft-check-square"></i>个人信息</a> <a class="dropdown-item" href="#"><i class="ft-message-square"></i> 个人信息</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#"><i class="ft-power"></i> 退 出</a> </div>
          </li>
          <li class="dropdown dropdown-notification nav-item"> <a class="nav-link nav-link-label" href="#" data-toggle="dropdown"><i class="ficon ft-bell"></i> <span class="badge badge-pill badge-default badge-danger badge-default badge-up badge-glow">5</span> </a>
            <ul class="dropdown-menu dropdown-menu-media dropdown-menu-right">
              <li class="dropdown-menu-header">
                <h6 class="dropdown-header m-0"> <span class="grey darken-2">Notifications</span> </h6>
                <span class="notification-tag badge badge-default badge-danger float-right m-0">5 New</span> </li>
              <li class="scrollable-container media-list w-100"> <a href="javascript:void(0)">
                <div class="media">
                  <div class="media-left align-self-center"><i class="ft-plus-square icon-bg-circle bg-cyan"></i></div>
                  <div class="media-body">
                    <h6 class="media-heading">You have new order!</h6>
                    <p class="notification-text font-small-3 text-muted">Lorem ipsum dolor sit amet, consectetuer elit.</p>
                    <small>
                    <time class="media-meta text-muted" datetime="2015-06-11T18:29:20+08:00">30 minutes ago</time>
                    </small> </div>
                </div>
                </a> <a href="javascript:void(0)">
                <div class="media">
                  <div class="media-left align-self-center"><i class="ft-download-cloud icon-bg-circle bg-red bg-darken-1"></i></div>
                  <div class="media-body">
                    <h6 class="media-heading red darken-1">99% Server load</h6>
                    <p class="notification-text font-small-3 text-muted">Aliquam tincidunt mauris eu risus.</p>
                    <small>
                    <time class="media-meta text-muted" datetime="2015-06-11T18:29:20+08:00">Five hour ago</time>
                    </small> </div>
                </div>
                </a> <a href="javascript:void(0)">
                <div class="media">
                  <div class="media-left align-self-center"><i class="ft-alert-triangle icon-bg-circle bg-yellow bg-darken-3"></i></div>
                  <div class="media-body">
                    <h6 class="media-heading yellow darken-3">Warning notifixation</h6>
                    <p class="notification-text font-small-3 text-muted">Vestibulum auctor dapibus neque.</p>
                    <small>
                    <time class="media-meta text-muted" datetime="2015-06-11T18:29:20+08:00">Today</time>
                    </small> </div>
                </div>
                </a> <a href="javascript:void(0)">
                <div class="media">
                  <div class="media-left align-self-center"><i class="ft-check-circle icon-bg-circle bg-cyan"></i></div>
                  <div class="media-body">
                    <h6 class="media-heading">Complete the task</h6>
                    <small>
                    <time class="media-meta text-muted" datetime="2015-06-11T18:29:20+08:00">Last week</time>
                    </small> </div>
                </div>
                </a> <a href="javascript:void(0)">
                <div class="media">
                  <div class="media-left align-self-center"><i class="ft-file icon-bg-circle bg-teal"></i></div>
                  <div class="media-body">
                    <h6 class="media-heading">Generate monthly report</h6>
                    <small>
                    <time class="media-meta text-muted" datetime="2015-06-11T18:29:20+08:00">Last month</time>
                    </small> </div>
                </div>
                </a> </li>
              <li class="dropdown-menu-footer"><a class="dropdown-item text-muted text-center" href="javascript:void(0)">Read all notifications</a></li>
            </ul>
          </li>
          <li class="dropdown dropdown-notification nav-item"> <a class="nav-link nav-link-label" href="#" data-toggle="dropdown"><i class="ficon ft-mail"> </i></a>
            <ul class="dropdown-menu dropdown-menu-media dropdown-menu-right">
              <li class="dropdown-menu-header">
                <h6 class="dropdown-header m-0"> <span class="grey darken-2">Messages</span> </h6>
                <span class="notification-tag badge badge-default badge-warning float-right m-0">4 New</span> </li>
              <li class="scrollable-container media-list w-100"> <a href="javascript:void(0)">
                <div class="media">
                  <div class="media-left"> <span class="avatar avatar-sm avatar-online rounded-circle"> <img src="statics/images/portrait/small/avatar-s-19.png" alt="avatar"><i></i></span> </div>
                  <div class="media-body">
                    <h6 class="media-heading">Margaret Govan</h6>
                    <p class="notification-text font-small-3 text-muted">I like your portfolio, let's start.</p>
                    <small>
                    <time class="media-meta text-muted" datetime="2015-06-11T18:29:20+08:00">Today</time>
                    </small> </div>
                </div>
                </a> <a href="javascript:void(0)">
                <div class="media">
                  <div class="media-left"> <span class="avatar avatar-sm avatar-busy rounded-circle"> <img src="statics/images/portrait/small/avatar-s-2.png" alt="avatar"><i></i></span> </div>
                  <div class="media-body">
                    <h6 class="media-heading">Bret Lezama</h6>
                    <p class="notification-text font-small-3 text-muted">I have seen your work, there is</p>
                    <small>
                    <time class="media-meta text-muted" datetime="2015-06-11T18:29:20+08:00">Tuesday</time>
                    </small> </div>
                </div>
                </a> <a href="javascript:void(0)">
                <div class="media">
                  <div class="media-left"> <span class="avatar avatar-sm avatar-online rounded-circle"> <img src="statics/images/portrait/small/avatar-s-3.png" alt="avatar"><i></i></span> </div>
                  <div class="media-body">
                    <h6 class="media-heading">Carie Berra</h6>
                    <p class="notification-text font-small-3 text-muted">Can we have call in this week ?</p>
                    <small>
                    <time class="media-meta text-muted" datetime="2015-06-11T18:29:20+08:00">Friday</time>
                    </small> </div>
                </div>
                </a> <a href="javascript:void(0)">
                <div class="media">
                  <div class="media-left"> <span class="avatar avatar-sm avatar-away rounded-circle"> <img src="statics/images/portrait/small/avatar-s-6.png" alt="avatar"><i></i></span> </div>
                  <div class="media-body">
                    <h6 class="media-heading">Eric Alsobrook</h6>
                    <p class="notification-text font-small-3 text-muted">We have project party this saturday.</p>
                    <small>
                    <time class="media-meta text-muted" datetime="2015-06-11T18:29:20+08:00">last month</time>
                    </small> </div>
                </div>
                </a> </li>
              <li class="dropdown-menu-footer"><a class="dropdown-item text-muted text-center" href="javascript:void(0)">Read all messages</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </div>
</nav>
<!-- ////////////////////////////////////////////////////////////////////////////-->
<div class="main-menu menu-fixed menu-dark menu-accordion    menu-shadow " data-scroll-to-active="true">
  <div class="main-menu-content">
<ul class="navigation navigation-main" id="main-menu-navigation" data-menu="menu-navigation" style="font-family:microsoft yahei;">
<li class="nav-item open"><a href="Request_list.jsp"><i class="la la-home"></i><span class="menu-title" data-i18n="nav.dash.main">用户审核


</span></a>
        
      </li>
      <li class=" nav-item"><a href="#"><i class="la la-television"></i><span class="menu-title" data-i18n="nav.templates.main">用户维护</span></a>
         <ul class="menu-content">         
         <li><a class="menu-item" href="revise-password.jsp" data-i18n="">密码修改</a> </li>
         <li><a class="menu-item" href="recover-password.jsp" data-i18n="">忘记密码</a> </li>
        </ul>
      </li>
       <li class=" nav-item"><a href="#"><i class="la la-television"></i><span class="menu-title" data-i18n="nav.templates.main">用户注销</span></a>
         <ul class="menu-content">         
         <li></li>
          
        </ul>
      </li>
   
      
      
      
   
      <li class="nav-item"><a href="#"><i class="la la-columns"></i><span class="menu-title" data-i18n="nav.page_layouts.main">证书下载</span></a>
        <ul class="menu-content">
          <li><a class="menu-item" href="Certificate_download.jsp" data-i18n="">证书下载</a> </li>
          <li><a class="menu-item" href="#" data-i18n="">证书管理</a> </li>
            
         
         
         
        </ul>
      </li>
      <li class=" nav-item"><a href="#"><i class="la la-navicon"></i><span class="menu-title" data-i18n="nav.navbars.main">数据上传
</span></a>
        <ul class="menu-content">
          <li><a class="menu-item" href="#" data-i18n="nav.navbars.nav_light">认证数据上传</a>
          <ul class="menu-content">
              <li><a class="menu-item" href="upload_Certificate_Application.jsp" data-i18n=""> 证书申请资料上传</a> </li>
              <li><a class="menu-item" href="upload_Document_audit_Application.jsp" data-i18n="">文件审核资料上传</a> </li>
              <li><a class="menu-item" href="upload_Site_audit.jsp" data-i18n="">现场审核资料上传</a> </li>
              <li><a class="menu-item" href="upload_Certificate_data.jsp" data-i18n="">证书数据上传</a> </li>
              
            </ul>
           </li>
           
           
         <li><a class="menu-item" href="" data-i18n="">检测检验数据上传</a>
          <ul class="menu-content">
              <li><a class="menu-item" href="upload_Detection.jsp" data-i18n=""> 检测检验上传</a> </li>
              <li><a class="menu-item" href="upload_test_run.jsp" data-i18n="">试运行数据上传</a> </li>
             
              
            </ul>
           </li>  
           
           
           
          
         <li><a class="menu-item" href="" data-i18n="">监管数据上传</a>
          <ul class="menu-content">
              <li> </li>
             
              
            </ul>
           </li>       
           
           
           
           
           
        </ul>
      </li>
      <li class="nav-item"><a href="#"><i class="la la-arrows-v"></i><span class="menu-title" data-i18n="nav.vertical_nav.main">数据校验</span></a>
        <ul class="menu-content">
          <li><a class="menu-item" href="#" data-i18n="">用户权限校验</a>
            
          </li>
          <li class="nav-item"><a class="menu-item" href="" data-i18n="">数据完整性、保密性校验</a> </li>
         
        </ul>
      </li>
      <li class=" nav-item"><a href="search-page.jsp"><i class="la la-arrows-h"></i><span class="menu-title" data-i18n="nav.horz_nav.main">数据查询</span></a> </li>
      <li class="nav-item"><a href="#"><i class="la la-header"></i><span class="menu-title" data-i18n="nav.page_headers.main">平台监控</span></a>
        <ul class="menu-content">
          <li><a class="menu-item" href="" data-i18n="">综合监控</a> </li>
          <li><a class="menu-item" href="" data-i18n="">节点状态监控</a> </li>
          <li><a class="menu-item" href="" data-i18n="">区块信息监控</a> </li>
          <li><a class="menu-item" href="" data-i18n="">交易信息实时监控</a> </li>        
          
          
        
        </ul>
      </li>
    </ul>
  </div>
</div>
<div class="content">
  <div class="content-wrapper">
    <div class="content-header">
      <div class="content-header-left col-md-6 col-12 mb-2">
        <div class="row breadcrumbs-top">
          <div class="breadcrumb-wrapper col-12">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="index.jsp">首页</a> </li>
              <li class="breadcrumb-item"><a href="#">用户审核</a> </li>
              <li class="breadcrumb-item active"><a href="#">用户注册申请列表</a> </li><li class="breadcrumb-item active">查看详情 </li>
            </ol>
          </div>
        </div>
      </div>
    </div>
    <div class="content-body"> 
      
    <div class="app-content content" style="margin-left:0;">
    <div class="content-wrapper">
     
      <div class="content-body">
        <section class="card">
          <div id="invoice-template" class="card-body">
            <!-- Invoice Company Details -->
            <!--<div id="invoice-company-details" class="row">
              <div class="col-md-6 col-sm-12 text-center text-md-left">
                <div class="media">
                  <img src="statics/images/logo/logo-80x80.png" alt="company logo" class=""
                  />
                  <div class="media-body">
                    <ul class="ml-2 px-0 list-unstyled">
                      <li class="text-bold-800">Modern Creative Studio</li>
                      <li>4025 Oak Avenue,</li>
                      <li>Melbourne,</li>
                      <li>Florida 32940,</li>
                      <li>USA</li>
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-sm-12 text-center text-md-right">
                <h2>INVOICE</h2>
                <p class="pb-3"># INV-001001</p>
                <ul class="px-0 list-unstyled">
                  <li>Balance Due</li>
                  <li class="lead text-bold-800">$ 12,000.00</li>
                </ul>
              </div>
            </div>-->
            <!--/ Invoice Company Details -->
            <!-- Invoice Customer Details -->
            <div id="invoice-customer-details" class="row pt-2" style="font-size:15px;margin-bottom:40px;">
              <div class="col-sm-12 text-center text-md-left"> <p class="lead" style="border-bottom:1px solid #e3ebf3;padding-bottom:10px;">详细信息:</p>
               
              </div>
              <div class="col-md-6 col-sm-12 text-center text-md-left">
                <ul class="px-0 list-unstyled">
                <li><b style="margin-right:15px;">机构编号:</b>45898789-7</li>
                  <li><b style="margin-right:15px;">机构类型:</b>2-检测检验机构</li>
                  <li><b style="margin-right:15px;">用户类型:</b>1-业务员</li>
                  <li><b style="margin-right:15px;">身份证号码:</b>371325194568978986</li>
                
                </ul>
              </div>
              <div class="col-md-6 col-sm-12 text-center text-md-left">
                <p>
                  
                  <b style="margin-right:15px;">用户类型:</b>1-业务员
          </p>
                <p><b style="margin-right:15px;">审核员身份证号码:</b>371325194568978986
                  </p>
                <p>
                  <b style="margin-right:15px;">审核员姓名:</b>丁二宝</p>
              </div>
            </div>
            <!--/ Invoice Customer Details -->
            <!-- Invoice Items Details -->  <!-- Invoice Footer -->
            <div id="invoice-footer">
              <!--<div class="row">
                <div class="col-md-7 col-sm-12">
                <button type="button" class="btn btn-info btn-lg my-1"><i class="la la-paper-plane-o"></i>&nbsp;审核通过</button>
                </div>
                <div class="col-md-5 col-sm-12 text-center">
                  <button type="button" class="btn btn-info btn-lg my-1"><i class="la la-paper-plane-o"></i>&nbsp;审核通过</button>
                </div>-->
              </div> <div class="buttons block">
                      <button type="button" class="btn btn-info duallistbox-add">审核通过</button>
                      <button type="button" class="btn btn-info duallistbox-add-clear" style="margin-left:20px;background:#FF4961;border-color:#FF4961!important;">暂不通过</button>
                    </div>
            </div>
            <!--/ Invoice Footer -->
            
          
          </div>
        </section>
      </div>
    </div>
  </div>
    </div>
  </div>
</div>
<!-- ////////////////////////////////////////////////////////////////////////////-->
<footer class="footer footer-static footer-light navbar-border navbar-shadow">
  <p class="clearfix blue-grey lighten-2 text-sm-center mb-0 px-2"> <span class="float-md-left d-block d-md-inline-block">Copyright &copy; 2018 <a class="text-bold-800 grey darken-2" href="index.jsp"
        target="_blank">中国网络安全审查与认证区块链平台 </a>, All rights reserved. </span> </p>
</footer>
<!-- BEGIN VENDOR JS--> 
<script src="statics/vendors/js/vendors.min.js" type="text/javascript"></script> 
<!-- BEGIN VENDOR JS--> 
<!-- BEGIN PAGE VENDOR JS--> 
<script src="statics/vendors/js/tables/jsgrid/jsgrid.min.js" type="text/javascript"></script> 
<script src="statics/vendors/js/tables/jsgrid/griddata.js" type="text/javascript"></script> 
<!-- END PAGE VENDOR JS--> 
<!-- BEGIN MODERN JS--> 
<script src="statics/js/core/app-menu.js" type="text/javascript"></script> 
<script src="statics/js/core/app.js" type="text/javascript"></script> 
<script src="statics/js/scripts/customizer.js" type="text/javascript"></script> 
<!-- END MODERN JS--> 
<!-- BEGIN PAGE LEVEL JS--> 
<script src="statics/js/scripts/tables/jsgrid/jsgrid.js" type="text/javascript"></script> 
<!-- END PAGE LEVEL JS-->
</body>
</html>