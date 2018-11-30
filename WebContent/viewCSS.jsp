<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%><%@page import="dao.UserInformationDao"%>
<%@page import="dao.DataAccess"%>
<%@page import="dao.QuestionDao"%>
<%@page import="dao.OfferedAnswerDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Question"%>
<%@page import="model.OfferedAnswer"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="main.language" scope="session" />

<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>Blank Page - Ace Admin</title>

<meta name="description" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="assets/css/CSSInput.css">
<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

<link rel="stylesheet" href="assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

<script src="assets/js/ace-extra.min.js"></script>

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

						<li><a href="#">Other Pages</a></li>
						<li class="active">Blank Page</li>
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
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="row">
								<form class="form-horizontal" action="viewSurvey" method="post">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1-1"> Survey </label>

										<div class="col-sm-6">
											<select class="chosen-select col-xs-10 col-sm-5"
												id="form-field-select-3"
												data-placeholder="Choose a State..." name="survey"
												onchange="this.form.submit()">
												<option value=""></option>
												<c:forEach items="${surveyList }" var="survey">
													<option value="${survey.id }">${survey.name }</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</form>
							</div>
							<div class="space-4"></div>

							<div class="content">
								<div class="language">
									<a href="?language=en_US"> <img alt="united-states"
										src="assets/css/images/United_Kingdom.png" height="25">
									</a> <a href="?language=ja_JP"> <img alt="japan"
										src="assets/css/images/japan.png" height="25">
									</a> <a href="#"> <img alt="vietnamese"
										src="assets/css/images/Vietnam.png" height="25">
									</a>
								</div>
								<div class="main">
									<img class="img_logo" src="assets/css/images/VTI-image.jpg">
									<h1 class="name">
										<fmt:message key="index.name" />
									</h1>

									<p style="margin-left: 50px">
										<strong>VTI </strong>
										<fmt:message key="index.mess1" />
									</p>
									<p>
										<fmt:message key="index.mess2" />
										<br>
										<fmt:message key="index.mess3" />
									</p>
									<p>
										<fmt:message key="index.mess4" />
									</p>
									<table>
										<tr>
											<td width="25px">5</td>
											<td><fmt:message key="index.5" /></td>
										</tr>
										<tr>
											<td>4</td>
											<td><fmt:message key="index.4" /></td>
										</tr>
										<tr>
											<td>3</td>
											<td><fmt:message key="index.3" /></td>
										</tr>
										<tr>
											<td>2</td>
											<td><fmt:message key="index.2" /></td>
										</tr>
										<tr>
											<td>1</td>
											<td><fmt:message key="index.1" /></td>
										</tr>
									</table>
									<p>
										<span>* <fmt:message key="index.required" /></span>
									</p>
									<form action="" method="post" onsubmit="return validateForm()">
										<input name="language" value="${language}" type="hidden">
										<%
											Connection con = DataAccess.getConnection();
											String username = (String) request.getAttribute("username");
											int surveyId = (Integer) request.getAttribute("surveyId");
											List<Question> questionsList = QuestionDao.getSurveyQuestion(con, surveyId);
											String userId = (String) request.getAttribute("userId");
											int i = 0;
										%>
										<input name="userId" value="${ userId}" type="hidden">
										<c:out value="${error}" />
										<c:forEach items="<%=questionsList%>" var="question">
											<c:if
												test="${question.type == 'open_question' && language == 'en_US' }">
												<p class="font">${question.contentEN}
													<span style="color: red">*</span><br>
												</p>
												<div class="row">
													<div class="col-xs-5">
														<input type="text" class="form-control"
															name="${ question.id}" required>
													</div>
												</div>
											</c:if>
											<c:if
												test="${question.type == 'open_question' && language == 'vi_VN' }">
												<p class="font">${question.contentVN}
													<span>*</span><br>
												</p>
												<div class="row">
													<div class="col-xs-5">
														<input type="text" class="form-control"
															name="${ question.id}" required>
													</div>
												</div>
											</c:if>
										</c:forEach>
										<%
											for (Question question : questionsList) {
												List<OfferedAnswer> answerList = OfferedAnswerDao.getOfferedAnswer(con, question.getId());
												if (question.getType().equalsIgnoreCase("close_question")) {
													if (i == 0) {
										%>
										<h1>
											<fmt:message key="index.overall" />
										</h1>
										<%
											}
													if (i == 1) {
										%>
										<h1>
											A.
											<fmt:message key="index.A" />
										</h1>
										<%
											}
													if (i == 5) {
										%>
										<h1>
											B.
											<fmt:message key="index.B" />
										</h1>
										<%
											}
													i = i + 1;
										%>
										<p class="font"><%=i%>.
											<c:if test="${language == 'en_US'}"><%=question.getContentEN()%></c:if>
											<c:if test="${language == 'vi_VN'}"><%=question.getContentVN()%></c:if>
											<c:if test="${language == 'ja_JP'}"><%=question.getContentJP()%></c:if>
											<span>*</span>
										<div class="form-table">
											<table class="table">
												<thead>
													<tr>
														<td></td>
														<td>1</td>
														<td>2</td>
														<td>3</td>
														<td>4</td>
														<td>5</td>
														<th></th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td><fmt:message key="index.1" /></td>
														<c:forEach items="<%=answerList%>" var="answer">
															<td><input type="radio" name="${ question.id}"
																value="${answer.point }" required></td>
														</c:forEach>
														<td><fmt:message key="index.5" /></td>
													</tr>
												</tbody>
											</table>
										</div>
										<%
											}
											}
										%>
										<c:forEach items="<%=questionsList%>" var="question">
											<c:if
												test="${question.type == 'opinion' && language == 'en_US' }">
												<h1 style="color: #ff7f00;">C. ${ question.contentEN}</h1>
												<textarea name="${ question.id}" rows="5" cols="100"></textarea>
											</c:if>
											<c:if
												test="${question.type == 'opinion' && language == 'vi_VN' }">
												<h1 style="color: #ff7f00;">C. ${ question.contentVN}</h1>
												<textarea name="${ question.id}" rows="5" cols="100"></textarea>
											</c:if>
											<c:if
												test="${question.type == 'opinion' && language == 'ja_JP' }">
												<h1 style="color: #ff7f00;">C. ${ question.contentJP}</h1>
												<textarea name="${ question.id}" rows="5" cols="100"></textarea>
											</c:if>
										</c:forEach>


										<div class="submit">
											<input type="submit" class="btn btn-primary" name="submit"
												value="<fmt:message key="index.submit"/>">
										</div>
									</form>
									<%
										DataAccess.closeQuietly(con);
									%>
									<div></div>
								</div>
							</div>
							<!-- PAGE CONTENT ENDS -->
						</div>

						<!-- /.col -->
					</div>
					<!-- /.row -->
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

	<script src="assets/js/jquery-2.1.4.min.js"></script>

	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script src="assets/js/bootstrap.min.js"></script>

	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>

</body>
</html>
