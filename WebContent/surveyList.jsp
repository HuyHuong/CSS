<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%><%@taglib uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>Customer Satisfaction Survey - Admin</title>

<meta name="description"
	content="Dynamic tables and grids using jqGrid plugin" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

<!-- page specific plugin styles -->
<link rel="stylesheet" href="assets/css/jquery-ui.min.css" />
<link rel="stylesheet" href="assets/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet" href="assets/css/ui.jqgrid.min.css" />

<!-- text fonts -->
<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet" href="assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

<script src="assets/js/ace-extra.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(
			function() {
				$("#myInput").on(
						"keyup",
						function() {
							var value = $(this).val().toLowerCase();
							$("#myTable tr").filter(
									function() {
										$(this).toggle(
												$(this).text().toLowerCase()
														.indexOf(value) > -1)
									});
						});
			});
</script>
</head>

<body class="no-skin">
	<jsp:include page="header.jsp"></jsp:include>

	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.loadState('main-container')
			} catch (e) {
			}
		</script>

		<jsp:include page="menu.jsp"></jsp:include>

		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
						</li>

						<li><a href="#">Tables</a></li>
						<li class="active">jqGrid plugin</li>
					</ul>
					<!-- /.breadcrumb -->

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon"> <input type="text"
								placeholder="Search ..." class="nav-search-input"
								id="nav-search-input" autocomplete="off" /> <i
								class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- /.nav-search -->
				</div>

				<div class="page-content">
					<jsp:include page="setting.jsp"></jsp:include>
					<div class="page-header">
						<h1>
							Survey <small> <i
								class="ace-icon fa fa-angle-double-right"></i> Survey List
							</small>
						</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<div class="row">
								<form class="form-horizontal" action="surveyList" method="post">
									<div class="col-xs-5">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1-1"> Choose </label>

										<div class="col-sm-6">
											<select class="chosen-select col-xs-10 col-sm-5"
												id="form-field-select-3" onchange="this.form.submit()"
												data-placeholder="Choose a State..." name="fitler">
												<option value=""></option>

												<optgroup label="Status">
													<option value="completed">Completed</option>
													<option value="uncompleted">Uncompleted</option>
												</optgroup>
											</select>
										</div>
									</div>


								</form>
								<div class="col-xs-5">
									<div id="dynamic-table_filter" class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1-1">Search:</label>
										<div class="col-sm-6">
											<input type="text" class="input-sm" placeholder="Search"
												aria-controls="dynamic-table" name="name" id="myInput">
										</div>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-11" id="surveyInformation">
									<c:if test="${survey != null }">
										<table>
											<tr>
												<td>Survey Name :</td>
												<td>${survey.name }</td>
											</tr>
											<tr>
												<td>Number of question :</td>
												<td>${survey.numberOfQuestion }</td>
											</tr>
											<tr>
												<td>Description :</td>
												<td>${survey.description }</td>
											</tr>
										</table>
									</c:if>
									<c:if test="${project != null }">
										<table>
											<tr>
												<td>Project Name :</td>
												<td>${project.name }</td>
											</tr>
											<tr>
												<td>Description :</td>
												<td>${project.description }</td>
											</tr>
											<tr>
												<td>Status :</td>
												<td>${project.status }</td>
											</tr>
										</table>
									</c:if>
									<c:if test="${userInfo != null }">
										<table>
											<tr>
												<td>First name:</td>
												<td>${userInfo.firstName }</td>
											</tr>
											<tr>
												<td>Last name:</td>
												<td>${userInfo.lastName }</td>
											</tr>
											<tr>
												<td>Phone number:</td>
												<td>${userInfo.phoneNumber }</td>
											</tr>
											<tr>
												<td>Email:</td>
												<td>${userInfo.email }</td>
											</tr>
											<tr>
												<td>Address:</td>
												<td>${userInfo.address }</td>
											</tr>
											<tr>
												<td>Company:</td>
												<td>${userInfo.company }</td>
											</tr>
										</table>
									</c:if>
								</div>
							</div>
							<div class="space-4"></div>
							<%
								int i = 0;
							%>
							<div class="row">
								<div class="col-xs-11">
									<table id="dataTable" class="table table-bordered table-hover">
										<thead>
											<tr>
												<th></th>
												<th>Survey Name</th>
												<th>Project Name</th>
												<th>Customer Name</th>
												<th>Time</th>
												<th>Status</th>
												<th></th>
											</tr>
										</thead>

										<tbody id="myTable">
											<c:forEach items="${surveyInfoList }" var="surveyInfo">
												<td><%=i + 1%></td>
												<td>${surveyInfo.surveyName }</td>
												<td>${surveyInfo.projectName }</td>
												<td>${surveyInfo.customerName }</td>
												<td>${surveyInfo.time }</td>
												<td><c:if test="${surveyInfo.status==0 }">
														<i class="green ace-icon glyphicon glyphicon-ok"></i>
													</c:if> <c:if test="${surveyInfo.status==1 }">
														<i class="red ace-icon glyphicon glyphicon-remove"></i>
													</c:if></td>
												<td><div class="hidden-sm hidden-xs action-buttons">
														<form action="viewInfo" method="post">
															<input name="assignSurveyId" value="${surveyInfo.id }"
																type="hidden" />
															<button class="btn btn-xs btn-info" type="submit"
																name="survey">
																<acronym title="Survey Information"> <i
																	class="ace-icon fa fa-pencil bigger-120"></i></acronym>
															</button>
															<button class="btn btn-yellow btn-xs" type="submit"
																name="project">
																<acronym title="Project Information"> <i
																	class="ace-icon fa fa-laptop bigger-120"></i></acronym>
															</button>
															<button class="btn btn-xs btn-purple" type="submit"
																name="customer">
																<acronym title="Customer Information"> <i
																	class="ace-icon glyphicon glyphicon-user bigger-120"></i></acronym>
															</button>
														</form>
													</div></td>
												<%
													i = i + 1;
												%>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<!-- /.span -->
							</div>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
			<!-- /.main-content -->

			<jsp:include page="footer.jsp"></jsp:include>

			<a href="#" id="btn-scroll-up"
				class="btn-scroll-up btn btn-sm btn-inverse"> <i
				class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div>
		<!-- /.main-container -->
	</div>
	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script src="assets/js/jquery-2.1.4.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("_$tag_______________________________________________"
							+ "_$tag_______");

		/* function findRows(table, column, searchText) {
			var rows = table.rows, r = 0, found = false, anyFound = false;

			for (; r < rows.length; r += 1) {
				row = rows.item(r);
				found = (row.cells.item(column).textContent.indexOf(searchText) !== -1);
				anyFound = anyFound || found;

				row.style.display = found ? "table-row" : "none";
			}

			document.getElementById('noresults').style.display = anyFound ? "none"
					: "block";
		}

		function performSearch() {
			var searchText = document.getElementById('searchTerm').value, targetTable = document
					.getElementById('dataTable');

			findRows(targetTable, 1, searchText);
			findRows(targetTable, 2, searchText);
			findRows(targetTable, 3, searchText);
			findRows(targetTable, 4, searchText);
		}

		document.getElementById("search").onclick = performSearch;
		document.getElementById("searchTerm").onkeyup = performSearch; */
	</script>
	<script src="assets/js/bootstrap.min.js"></script>

	<!-- page specific plugin scripts -->
	<script src="assets/js/bootstrap-datepicker.min.js"></script>
	<script src="assets/js/jquery.jqGrid.min.js"></script>
	<script src="assets/js/grid.locale-en.js"></script>

	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
</body>
</html>
