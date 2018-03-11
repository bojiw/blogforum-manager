<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BlogForum Admin</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="css/font-awesome.min.css" rel="stylesheet">

<!-- ionicons -->
<link href="css/ionicons.min.css" rel="stylesheet">

<!-- Morris -->

<!-- Datepicker -->

<!-- Animate -->

<!-- Owl Carousel -->

<!-- Simplify -->
<link href="css/simplify.min.css" rel="stylesheet">

<!-- 修改默认字体 -->
<link href="css/typeface.css" rel="stylesheet">



</head>

  	<body class="overflow-hidden">
		<div class="wrapper preload">
			
			<header class="top-nav">
				<div class="top-nav-inner">
					<div class="nav-header">
						<button type="button" class="navbar-toggle pull-left sidebar-toggle" id="sidebarToggleSM">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						
						<a href="index.action" class="brand">
							<span class="brand-name">BlogForum ADMIN</span>
						</a>
					</div>
					<div class="nav-container">
						<button type="button" class="navbar-toggle pull-left sidebar-toggle" id="sidebarToggleLG">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<ul class="nav-notification">	
							<li class="search-list">

							</li>
						</ul>
						<div class="pull-right m-right-sm">
							<div class="user-block hidden-xs">
								<a href="#" id="userToggle" data-toggle="dropdown">
									<img src="images/profile/profile1.jpg" alt="" class="img-circle inline-block user-profile-pic">
									<div class="user-detail inline-block">
										${adminUserName}
										<i class="fa fa-angle-down"></i>
									</div>
								</a>
								<div class="panel border dropdown-menu user-panel">
									<div class="panel-body paddingTB-sm">
										<ul>
											<li>
												<a href="loginout.action">
													<i class="fa fa-power-off fa-lg"></i><span class="m-left-xs">退出</span>
												</a>
											</li>
										</ul>
									</div>
								</div>
							</div>
	
						</div>
					</div>
				</div><!-- ./top-nav-inner -->	
			</header>
			<aside class="sidebar-menu fixed">
				<div class="sidebar-inner scrollable-sidebar">
					<div class="main-menu">
						<ul class="accordion">
							<li class="menu-header">
								Main Menu
							</li>
							<li class="bg-palette1 active">
								<a href="index.action">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-home fa-lg"></i></span>
										<span class="text m-left-sm">主页</span>
									</span>
									<span class="menu-content-hover block">
										Home
									</span>
								</a>
							</li>

							<li class="openable bg-palette3">
								<a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-list fa-lg"></i></span>
										<span class="text m-left-sm">人员管理</span>
										<span class="submenu-icon"></span>
									</span>
									<span class="menu-content-hover block">
										人员管理
									</span>
								</a>
								<ul class="submenu bg-palette4">
									<li><a class="J_menuItem" href="usermanager/adminUserShow.jsp"><span class="submenu-label">管理员用户管理</span></a></li>
									<li><a class="J_menuItem" href="dropzone.html"><span class="submenu-label">用户管理</span></a></li>
								</ul>
							</li>
							<li class="openable bg-palette3">
								<a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-list fa-lg"></i></span>
										<span class="text m-left-sm">权限管理</span>
										<span class="submenu-icon"></span>
									</span>
									<span class="menu-content-hover block">
										权限管理
									</span>
								</a>
								<ul class="submenu bg-palette4">
									<li><a class="J_menuItem" href="role/list.jsp"><span class="submenu-label">角色设置</span></a></li>
									<li><a class="J_menuItem" href="permision/list.jsp"><span class="submenu-label">权限设置</span></a></li>
									<li><a class="J_menuItem" href="rolepermision/list.jsp"><span class="submenu-label">权限关联设置</span></a></li>
								</ul>
							</li>
							<li class="openable bg-palette3">
								<a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-list fa-lg"></i></span>
										<span class="text m-left-sm">系统管理</span>
										<span class="submenu-icon"></span>
									</span>
									<span class="menu-content-hover block">
										系统管理
									</span>
								</a>
								<ul class="submenu bg-palette4">
									<li><a class="J_menu" href="http://www.bojiw.com:9000" target="_blank"><span class="submenu-label">docker管理</span></a></li>
									<li><a class="J_menu" href="http://dubbo.bojiw.com" target="_blank"><span class="submenu-label">dubbo管理</span></a></li>
									<li><a class="J_menu" href="http://rabbit.bojiw.com" target="_blank"><span class="submenu-label">rabbitmq管理</span></a></li>
									<li><a class="J_menu" href="http://solr.bojiw.com/solr" target="_blank"><span class="submenu-label">solr管理</span></a></li>
									<li><a class="J_menu" href="http://nexus.bojiw.com:8081/nexus/" target="_blank"><span class="submenu-label">nexus管理</span></a></li>
									<li><a class="J_menu" href="http://jenkins.bojiw.com:8080/jenkins/" target="_blank"><span class="submenu-label">jenkins管理</span></a></li>
								</ul>
							</li>
						</ul>
					</div>	
					<div class="sidebar-fix-bottom clearfix">
						<div class="user-dropdown dropup pull-left">

						</div>
						<a href="loginout.action" class="pull-right font-18"><i class="ion-log-out"></i></a>
					</div>
				</div><!-- sidebar-inner -->
			</aside>
			
			<div id = "J_iframe" class="main-container">
				<div class="padding-md">
					<div class="row">
						<div class="col-sm-6">
							<div class="page-title">
								仪表板
							</div>
							<div class="page-sub-header">
								欢迎回来,${adminUserName}
							</div>
						</div>

					</div>

					<div class="row m-top-md"><!-- 注册总数 -->
						<div class="col-lg-3 col-sm-6">
							<div class="statistic-box bg-danger m-bottom-md">
								<div id="allUserCountmemo" class="statistic-title">
									
								</div>

								<div id="allUserCount" class="statistic-value">
									
								</div>

								<div class="m-top-md"></div>

								<div class="statistic-icon-background">
									<i class="ion-eye"></i>
								</div>
							</div>
						</div>

						<div class="col-lg-3 col-sm-6">
							<div class="statistic-box bg-info m-bottom-md">
								<div id="activeUserCountmemo" class="statistic-title">
								</div>

								<div id="activeUserCount" class="statistic-value">
								</div>

								<div class="m-top-md"></div>

								<div class="statistic-icon-background">
									<i class="ion-ios7-cart-outline"></i>
								</div>
							</div>
						</div>

						<div class="col-lg-3 col-sm-6">
							<div class="statistic-box bg-purple m-bottom-md">
								<div id="lastMonthUserCountmemo" class="statistic-title">
								</div>

								<div id="lastMonthUserCount" class="statistic-value">
								</div>

								<div class="m-top-md"></div>

								<div class="statistic-icon-background">
									<i class="ion-person-add"></i>
								</div>
							</div>
						</div>

						<div class="col-lg-3 col-sm-6">
							<div class="statistic-box bg-success m-bottom-md">
								<div id="lastSevenUserCountmemo" class="statistic-title">
								</div>

								<div id="lastSevenUserCount" class="statistic-value">
								</div>

								<div class="m-top-md"></div>

								<div class="statistic-icon-background">
									<i class="ion-stats-bars"></i>
								</div>
							</div>
						</div>
					</div><!-- 注册总数 -->

					<div class="row m-top-md"><!-- 笔记总数 -->
						<div class="col-lg-3 col-sm-6">
							<div class="statistic-box bg-danger m-bottom-md">
								<div id="allNoteCountmemo" class="statistic-title">
									
								</div>

								<div id="allNoteCount" class="statistic-value">
									
								</div>

								<div class="m-top-md"></div>

								<div class="statistic-icon-background">
									<i class="ion-eye"></i>
								</div>
							</div>
						</div>

						<div class="col-lg-3 col-sm-6">
							<div class="statistic-box bg-info m-bottom-md">
								<div id="noDelNoteCountmemo" class="statistic-title">
								</div>

								<div id="noDelNoteCount" class="statistic-value">
								</div>

								<div class="m-top-md"></div>

								<div class="statistic-icon-background">
									<i class="ion-ios7-cart-outline"></i>
								</div>
							</div>
						</div>

						<div class="col-lg-3 col-sm-6">
							<div class="statistic-box bg-purple m-bottom-md">
								<div id="lastMonthNoteCountmemo" class="statistic-title">
								</div>

								<div id="lastMonthNoteCount" class="statistic-value">
								</div>

								<div class="m-top-md"></div>

								<div class="statistic-icon-background">
									<i class="ion-person-add"></i>
								</div>
							</div>
						</div>

						<div class="col-lg-3 col-sm-6">
							<div class="statistic-box bg-success m-bottom-md">
								<div id="lastSevenNoteCountmemo" class="statistic-title">
								</div>

								<div id="lastSevenNoteCount" class="statistic-value">
								</div>

								<div class="m-top-md"></div>

								<div class="statistic-icon-background">
									<i class="ion-stats-bars"></i>
								</div>
							</div>
						</div>
					</div><!-- 笔记总数 -->




		
	    <!-- Le javascript
	    ================================================== -->
	    <!-- Placed at the end of the document so the pages load faster -->
		
		<!-- Jquery -->
		<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
		
		<!-- Bootstrap -->
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    	<script src="https://cdn.bootcss.com/bootstrap-3-typeahead/3.1.0/bootstrap3-typeahead.min.js"></script>
	    
	  
		<!-- Flot -->

		<!-- Slimscroll -->
		<script src='js/jquery.slimscroll.min.js'></script>
		
		<script src="http://cdn.staticfile.org/layer/2.3/layer.js"></script>
		
		<!-- Simplify -->
		<script src="js/simplify/simplify.js"></script>
		
		<!-- 页面加载 -->
		<script src="js/index.js"></script>


		<script>
			$(function()	{

			});
			
		</script>
	
  	</body>
</html>
