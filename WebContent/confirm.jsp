<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="dao.UserAccountDao"%>
<%@page import="dao.DataAccess"%>
<%@page import="dao.QuestionDao"%>
<%@page import="dao.OfferedAnswerDao"%>
<%@page import="dao.AssignSurveyDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Question"%>
<%@page import="model.Reponse"%>
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

<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="index.name" /></title>
<link rel="stylesheet" type="text/css" href="assets/css/confirm.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="login/css/util.css">
<link rel="stylesheet" type="text/css" href="login/css/main.css">
<!--===============================================================================================-->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="container">
				<div class="alert">
					<form action="edit" method="POST">
						<input name="language" value="${language}" type="hidden">
						<input type="hidden" name="assignSurveyId"
							value="${assignSurveyId }" />
						<div class="form">
							<div class="button">
								<input type="submit" class="btn btn-primary" name="edit"
									value="<fmt:message key="confirm.return"/>"> <input
									type="submit" class="btn btn-primary" name="confirm"
									value="<fmt:message key="index.submit"/>">
							</div>
							<div class="form-button">
								<input type="submit" class="btn btn-primary" name="logout"
									value="<fmt:message key="logout"/>" style="margin-right: 1%">
							</div>
						</div>
						<div class="main">
							<aside class="column">
								<img class="img_logo" src="assets/css/images/VTI-image.jpg">
								<br>
								<c:forEach items='${ submissionList}' var="submission">
									<input name="${submission.questionId}"
										value="${submission.answer}" type="hidden">
									<c:if
										test="${submission.questionType == 'open_question' && language == 'en_US' }">
								${submission.questionEN} : ${submission.answer}<br></c:if>
									<c:if
										test="${submission.questionType == 'open_question' && language == 'vi_VN' }">
								${submission.questionVN} : ${submission.answer}<br></c:if>
									<c:if
										test="${submission.questionType == 'open_question' && language == 'ja_JP' }">
								${submission.questionJP} : ${submission.answer}<br></c:if>
								</c:forEach>
							</aside>
							<section class="column">
								<table class="table">
									<c:forEach items='${ submissionList}' var="submission">
										<input name="${submission.questionId}"
											value="${submission.answer}" type="hidden">
										<c:if test="${submission.questionType == 'close_question'}">
										<input name="answer ${submission.questionId}"
											value="${submission.point}" type="hidden">
											<tr>
												<td><c:if test="${language == 'en_US'}">${submission.questionEN}</c:if>
													<c:if test="${language == 'vi_VN'}">${submission.questionVN}</c:if>
													<c:if test="${language == 'ja_JP'}">${submission.questionJP}</c:if></td>
												<td>${submission.answer}</td>
												<td>${submission.point }</td>
											</tr>
										</c:if>
										<c:if test="${submission.questionType == 'opinion'}">
											<tr>
												<td><c:if test="${language == 'en_US'}">${submission.questionEN}</c:if>
													<c:if test="${language == 'vi_VN'}">${submission.questionVN}</c:if>
													<c:if test="${language == 'ja_JP'}">${submission.questionJP}</c:if></td>
												<td>${submission.answer}</td>
											</tr>
										</c:if>
									</c:forEach>
								</table>
							</section>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>