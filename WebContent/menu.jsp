<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>Customer Satisfaction Survey - Admin</title>

<meta name="description" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

<!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

<link rel="stylesheet" href="assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

<script src="assets/js/ace-extra.min.js"></script>

</head>

<body class="no-skin">

	<div id="sidebar" class="sidebar responsive ace-save-state"
		data-sidebar="true" data-sidebar-scroll="true"
		data-sidebar-hover="true">
		<script type="text/javascript">
			try {
				ace.settings.loadState('sidebar')
			} catch (e) {
			}
		</script>

		<div class="sidebar-shortcuts" id="sidebar-shortcuts">
			<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
				<button class="btn btn-success">
					<i class="ace-icon fa fa-signal"></i>
				</button>

				<button class="btn btn-info">
					<i class="ace-icon fa fa-pencil"></i>
				</button>

				<button class="btn btn-warning">
					<i class="ace-icon fa fa-users"></i>
				</button>

				<button class="btn btn-danger">
					<i class="ace-icon fa fa-cogs"></i>
				</button>
			</div>

			<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
				<span class="btn btn-success"></span> <span class="btn btn-info"></span>

				<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
			</div>
		</div>
		<!-- /.sidebar-shortcuts -->

		<ul class="nav nav-list" style="top: 0px;">
			<li class="active"><a href="home.jsp"> <i
					class="menu-icon fa fa-tachometer"></i> <span class="menu-text">
						ADMIN </span>
			</a> <b class="arrow"></b></li>

			<li class=""><a href="#" class="dropdown-toggle"> <i
					class="menu-icon glyphicon glyphicon-user"></i><span
					class="menu-text"> Customer </span> <b
					class="arrow fa fa-angle-down"></b>
			</a> <b class="arrow"></b>

				<ul class="submenu">
					<li class=""><a
						href="${pageContext.request.contextPath}/create"> <i
							class="menu-icon fa fa-caret-right"></i> Create new customer
					</a> <b class="arrow"></b>
					<li class=""><a
						href="${pageContext.request.contextPath}/customerList"> <i
							class="menu-icon fa fa-caret-right"></i> List Customer<b
							class="arrow fa fa-angle-down"></b>
					</a> <b class="arrow"></b>
						<ul class="submenu">
							<li class=""><a
								href="${pageContext.request.contextPath}/customerList"> <i
									class="menu-icon fa fa-caret-right"></i> Search Customer
							</a> <b class="arrow"></b></li>

							<li class=""><a
								href="${pageContext.request.contextPath}/customerList"> <i
									class="menu-icon fa fa-caret-right"></i> Edit Customer
							</a> <b class="arrow"></b></li>

						</ul></li>

				</ul></li>

			<li class=""><a href="#" class="dropdown-toggle"> <i
					class="menu-icon fa fa-list"></i> <span class="menu-text">
						Survey </span> <b class="arrow fa fa-angle-down"></b>
			</a> <b class="arrow"></b>

				<ul class="submenu">
					<li class=""><a
						href="${pageContext.request.contextPath}/createSurvey"> <i
							class="menu-icon fa fa-caret-right"></i> Create new survey
					</a> <b class="arrow"></b></li>

					<li class=""><a
						href="${pageContext.request.contextPath}/viewSurvey"> <i
							class="menu-icon fa fa-caret-right"></i> View survey
					</a> <b class="arrow"></b></li>
					<li class=""><a
						href="${pageContext.request.contextPath}/surveyList"> <i
							class="menu-icon fa fa-caret-right"></i> List survey
					</a> <b class="arrow"></b></li>
				</ul></li>


		</ul>
		<!-- /.nav-list -->

		<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
			<i id="sidebar-toggle-icon"
				class="ace-icon fa fa-angle-double-left ace-save-state"
				data-icon1="ace-icon fa fa-angle-double-left"
				data-icon2="ace-icon fa fa-angle-double-right"></i>
		</div>
	</div>
</body>
</html>
