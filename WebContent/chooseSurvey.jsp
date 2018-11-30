<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.DataAccess"%>
<%@page import="dao.SurveyDao"%>
<%@page import="dao.AssignSurveyDao"%>
<%@page import="model.AssignSurvey"%>
<%@page import="model.Survey"%>
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
<title><fmt:message key="index.name" /></title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="login/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="login/vendor/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css"
	href="login/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="login/vendor/select2/select2.min.css">

<link rel="stylesheet" href="assets/css/bootstrap.min.css" />

<link rel="stylesheet" href="assets/css/utils.css" />

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
<body>
	<div class="container-login100">
		<div class="alert">
			<h3 class="text-center font-weight-bold">
				<fmt:message key="chooseSurvey" />
			</h3>

			<table class="table table-hover text-centered">
				<tr>
					<td align="center"><div class="language">
							<a href="?language=en_US"> <img alt="united-states"
								src="assets/css/images/United_Kingdom.png" height="25">
							</a> <a href="?language=ja_JP"> <img alt="japan"
								src="assets/css/images/japan.png" height="25">
							</a> <a href="#"> <img alt="vietnamese"
								src="assets/css/images/Vietnam.png" height="25">
							</a>
						</div></td>
				</tr>
			</table>
			<div class="container" style="padding-left: 250px">
				<form class="form-horizontal" action="chooseSurvey" method="post">
					<input name="language" value="${language}" type="hidden"> <select
						class="chosen-select col-xs-10 col-sm-5" id="form-field-select-3"
						data-placeholder="Choose a State..." name="assignSurveyId"
						onchange="this.form.submit()">
						<option>Choose Survey</option>
						<%
							Connection con = DataAccess.getConnection();
							int userInfoId = (Integer) request.getAttribute("userInfoId");
							List<AssignSurvey> assignSurveyList = AssignSurveyDao.findSurveyListByUserInfoId(con, userInfoId);
							Survey survey = null;
							for (AssignSurvey assignSurvey : assignSurveyList) {
								survey = SurveyDao.findSurveyById(con, assignSurvey.getSurveyId());
						%>
						<option value="<%=assignSurvey.getId()%>"><%=survey.getName()%></option>
						<%
							}
							DataAccess.closeQuietly(con);
						%>
					</select>
				</form>
			</div>
		</div>
	</div>
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/tilt/tilt.jquery.min.js"></script>
	<script>
		$('.js-tilt').tilt({
			scale : 1.1
		})
	</script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>