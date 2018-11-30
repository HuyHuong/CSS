<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%><%@page import="dao.UserInformationDao"%>
<%@page import="dao.DataAccess"%>
<%@page import="model.UserInformation"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>Customer Satisfaction Survey - Admin</title>

<meta name="description" content="Static &amp; Dynamic Tables" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

<link rel="stylesheet" href="assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

<script src="assets/js/ace-extra.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
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

						<li><a href="#">Customer</a></li>
						<li class="active">Simple &amp; Dynamic</li>
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
							Customer <small> <i
								class="ace-icon fa fa-angle-double-right"></i> List customer
							</small>
						</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-11">
							<!-- PAGE CONTENT BEGINS -->
							<h3 class="header smaller lighter blue">List customer</h3>

							<div class="clearfix">
								<div class="pull-right tableTools-container"></div>
							</div>
							<div class="row">
								<form action="customerList" method="post">
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
								</form>
							</div>
							<div class="space-4"></div>
							<div class="space-4"></div>
							<%
								int i = 0;
							%>
							<div>
								<div id="dynamic-table_wrapper"
									class="dataTables_wrapper form-inline no-footer">
									<c:out value="${result }"></c:out>
									<table id="myTable"
										class="table table-striped table-bordered table-hover dataTable no-footer display"
										role="grid" aria-describedby="dynamic-table_info"
										align="center">
										<thead>
											<tr role="row">
												<th class="sorting" tabindex="0"
													aria-controls="dynamic-table" rowspan="1" colspan="1"
													aria-label="FirstName: activate to sort column ascending"></th>
												<th class="sorting" tabindex="0"
													aria-controls="dynamic-table" rowspan="1" colspan="1"
													aria-label="FirstName: activate to sort column ascending">First
													Name</th>
												<th class="sorting" tabindex="0"
													aria-controls="dynamic-table" rowspan="1" colspan="1"
													aria-label="LastName: activate to sort column ascending">Last
													Name</th>
												<th class="sorting" tabindex="0"
													aria-controls="dynamic-table" rowspan="1" colspan="1"
													aria-label="Price: activate to sort column ascending">Phone
													Number</th>
												<th class="hidden-480 sorting" tabindex="0"
													aria-controls="dynamic-table" rowspan="1" colspan="1"
													aria-label="Clicks: activate to sort column ascending">Email</th>
												<th class="hidden-480 sorting" tabindex="0"
													aria-controls="dynamic-table" rowspan="1" colspan="1"
													aria-label="Clicks: activate to sort column ascending">Address</th>
												<th class="hidden-480 sorting" tabindex="0"
													aria-controls="dynamic-table" rowspan="1" colspan="1"
													aria-label="Clicks: activate to sort column ascending">Company</th>
												<th class="sorting" tabindex="0"
													aria-controls="dynamic-table" rowspan="1" colspan="1"
													aria-label="Update: activate to sort column ascending">
													<i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
													Update
												</th>
												<th class="sorting_disabled" rowspan="1" colspan="1"
													aria-label=""></th>
											</tr>
										</thead>

										<tbody id="myTable">
											<c:forEach items="${ userInfoList}" var="user">
												<tr role="row" class="odd">
													<td><%=i + 1%></td>
													<td>${user.firstName }</td>
													<td>${user.lastName }</td>
													<td>${user.phoneNumber }</td>
													<td>${user.email }</td>
													<td>${user.address }</td>
													<td>${user.company }</td>
													<td>${user.created }</td>
													<td>
														<div class="hidden-sm hidden-xs action-buttons">
															<form action="editCus" method="post">
																<input name="userInfoId" value="${user.id }"
																	type="hidden" />
																<button class="btn btn-xs btn-info" type="submit"
																	name="edit">
																	<acronym title="Edit Information"> <i
																		class="ace-icon fa fa-pencil bigger-120"></i></acronym>
																</button>
																<button class="btn btn-warning btn-xs" type="submit"
																	name="setPass">
																	<acronym title="Set Password"> <i
																		class="ace-icon fa fa-wrench  bigger-110 icon-only"></i></acronym>
																</button>
																<button class="btn btn-xs btn-danger">
																	<i class="ace-icon fa fa-trash-o bigger-120"></i>
																</button>
															</form>
														</div>
													</td>
												</tr>
												<%
													i = i + 1;
												%>
											</c:forEach>
										</tbody>
									</table>
									<div class="row">
										<div class="col-xs-6">
											<div class="dataTables_info" id="dynamic-table_info"
												role="status" aria-live="polite">Showing 1 to 10 of 23
												entries</div>
										</div>
										<div class="col-xs-6">
											<div class="dataTables_paginate paging_simple_numbers"
												id="dynamic-table_paginate">
												<ul class="pagination">
													<li class="paginate_button previous disabled"
														aria-controls="dynamic-table" tabindex="0"
														id="dynamic-table_previous"><a href="#">Previous</a></li>
													<li class="paginate_button active"
														aria-controls="dynamic-table" tabindex="0"><a
														href="#">1</a></li>
													<li class="paginate_button " aria-controls="dynamic-table"
														tabindex="0"><a href="#">2</a></li>
													<li class="paginate_button " aria-controls="dynamic-table"
														tabindex="0"><a href="#">3</a></li>
													<li class="paginate_button next"
														aria-controls="dynamic-table" tabindex="0"
														id="dynamic-table_next"><a href="#">Next</a></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->

		<jsp:include page="footer.jsp"></jsp:include>
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->

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
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script src="assets/js/bootstrap.min.js"></script>

	<!-- page specific plugin scripts -->
	<script src="assets/js/jquery.dataTables.min.js"></script>
	<script src="assets/js/jquery.dataTables.bootstrap.min.js"></script>
	<script src="assets/js/dataTables.buttons.min.js"></script>
	<script src="assets/js/buttons.flash.min.js"></script>
	<script src="assets/js/buttons.html5.min.js"></script>
	<script src="assets/js/buttons.print.min.js"></script>
	<script src="assets/js/buttons.colVis.min.js"></script>
	<script src="assets/js/dataTables.select.min.js"></script>

	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			//initiate dataTables plugin
			var myTable = $('#dynamic-table')
			//.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
			
			$(document).ready( function () {
			    $('#table_id').DataTable();
			};
			
			
			.DataTable({
				bAutoWidth : false,
				"aoColumns" : [ {
					"bSortable" : false
				}, null, null, null, null, null, {
					"bSortable" : false
				} ],
				"aaSorting" : [],

				//"bProcessing": true,
				//"bServerSide": true,
				//"sAjaxSource": "http://127.0.0.1/table.php"	,

				//,
				//"sScrollY": "200px",
				//"bPaginate": false,

				//"sScrollX": "100%",
				//"sScrollXInner": "120%",
				//"bScrollCollapse": true,
				//Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
				//you may want to wrap the table inside a "div.dataTables_borderWrap" element

				//"iDisplayLength": 50

				select : {
					style : 'multi'
				}
			};

			$.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';

			new $.fn.dataTable.Buttons(
					myTable,
					{
						buttons : [
								{
									"extend" : "colvis",
									"text" : "<i class='fa fa-search bigger-110 blue'></i> <span class='hidden'>Show/hide columns</span>",
									"className" : "btn btn-white btn-primary btn-bold",
									columns : ':not(:first):not(:last)'
								},
								{
									"extend" : "copy",
									"text" : "<i class='fa fa-copy bigger-110 pink'></i> <span class='hidden'>Copy to clipboard</span>",
									"className" : "btn btn-white btn-primary btn-bold"
								},
								{
									"extend" : "csv",
									"text" : "<i class='fa fa-database bigger-110 orange'></i> <span class='hidden'>Export to CSV</span>",
									"className" : "btn btn-white btn-primary btn-bold"
								},
								{
									"extend" : "excel",
									"text" : "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='hidden'>Export to Excel</span>",
									"className" : "btn btn-white btn-primary btn-bold"
								},
								{
									"extend" : "pdf",
									"text" : "<i class='fa fa-file-pdf-o bigger-110 red'></i> <span class='hidden'>Export to PDF</span>",
									"className" : "btn btn-white btn-primary btn-bold"
								},
								{
									"extend" : "print",
									"text" : "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>Print</span>",
									"className" : "btn btn-white btn-primary btn-bold",
									autoPrint : false,
									message : 'This print was produced using the Print button for DataTables'
								} ]
					});
			myTable.buttons().container().appendTo($('.tableTools-container'));

			//style the message box
			var defaultCopyAction = myTable.button(1).action();
			myTable
					.button(1)
					.action(
							function(e, dt, button, config) {
								defaultCopyAction(e, dt, button, config);
								$('.dt-button-info')
										.addClass(
												'gritter-item-wrapper gritter-info gritter-center white');
							});

			var defaultColvisAction = myTable.button(0).action();
			myTable
					.button(0)
					.action(
							function(e, dt, button, config) {

								defaultColvisAction(e, dt, button, config);

								if ($('.dt-button-collection > .dropdown-menu').length == 0) {
									$('.dt-button-collection')
											.wrapInner(
													'<ul class="dropdown-menu dropdown-light dropdown-caret dropdown-caret" />')
											.find('a').attr('href', '#').wrap(
													"<li />")
								}
								$('.dt-button-collection').appendTo(
										'.tableTools-container .dt-buttons')
							});

			////

			setTimeout(function() {
				$($('.tableTools-container')).find('a.dt-button').each(
						function() {
							var div = $(this).find(' > div').first();
							if (div.length == 1)
								div.tooltip({
									container : 'body',
									title : div.parent().text()
								});
							else
								$(this).tooltip({
									container : 'body',
									title : $(this).text()
								});
						});
			}, 500);

			myTable.on('select', function(e, dt, type, index) {
				if (type === 'row') {
					$(myTable.row(index).node()).find('input:checkbox').prop(
							'checked', true);
				}
			});
			myTable.on('deselect', function(e, dt, type, index) {
				if (type === 'row') {
					$(myTable.row(index).node()).find('input:checkbox').prop(
							'checked', false);
				}
			});

			/////////////////////////////////
			//table checkboxes
			$('th input[type=checkbox], td input[type=checkbox]').prop(
					'checked', false);

			//select/deselect all rows according to table header checkbox
			$(
					'#dynamic-table > thead > tr > th input[type=checkbox], #dynamic-table_wrapper input[type=checkbox]')
					.eq(0).on('click', function() {
						var th_checked = this.checked;//checkbox inside "TH" table header

						$('#dynamic-table').find('tbody > tr').each(function() {
							var row = this;
							if (th_checked)
								myTable.row(row).select();
							else
								myTable.row(row).deselect();
						});
					});

			//select/deselect a row when the checkbox is checked/unchecked
			$('#dynamic-table').on('click', 'td input[type=checkbox]',
					function() {
						var row = $(this).closest('tr').get(0);
						if (this.checked)
							myTable.row(row).deselect();
						else
							myTable.row(row).select();
					});

			$(document).on('click', '#dynamic-table .dropdown-toggle',
					function(e) {
						e.stopImmediatePropagation();
						e.stopPropagation();
						e.preventDefault();
					});

			var active_class = 'active';
			$('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on(
					'click',
					function() {
						var th_checked = this.checked;//checkbox inside "TH" table header

						$(this).closest('table').find('tbody > tr').each(
								function() {
									var row = this;
									if (th_checked)
										$(row).addClass(active_class).find(
												'input[type=checkbox]').eq(0)
												.prop('checked', true);
									else
										$(row).removeClass(active_class).find(
												'input[type=checkbox]').eq(0)
												.prop('checked', false);
								});
					});

			//select/deselect a row when the checkbox is checked/unchecked
			$('#simple-table').on('click', 'td input[type=checkbox]',
					function() {
						var $row = $(this).closest('tr');
						if ($row.is('.detail-row '))
							return;
						if (this.checked)
							$row.addClass(active_class);
						else
							$row.removeClass(active_class);
					});

			$('[data-rel="tooltip"]').tooltip({
				placement : tooltip_placement
			});

			//tooltip placement on right or left
			function tooltip_placement(context, source) {
				var $source = $(source);
				var $parent = $source.closest('table')
				var off1 = $parent.offset();
				var w1 = $parent.width();

				var off2 = $source.offset();
				//var w2 = $source.width();

				if (parseInt(off2.left) < parseInt(off1.left)
						+ parseInt(w1 / 2))
					return 'right';
				return 'left';
			}

			$('.show-details-btn').on(
					'click',
					function(e) {
						e.preventDefault();
						$(this).closest('tr').next().toggleClass('open');
						$(this).find(ace.vars['.icon']).toggleClass(
								'fa-angle-double-down').toggleClass(
								'fa-angle-double-up');
					});
		})
	</script>
</body>
</html>
