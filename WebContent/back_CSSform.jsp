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
<link rel="stylesheet" type="text/css" href="assets/css/CSSInput.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/utils.css" />
<link rel="stylesheet" type="text/css" href="assets/css/CSSInput.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="content">
				<div class="main">
					<img class="img_logo" src="assets/css/images/VTI-image.jpg">
					<h1 class="name">
						<fmt:message key="index.name" />
					</h1>

					<div class="language">
						<a href="?language=en_US"> <img class="img-circle"
							alt="united-states" src="assets/css/images/United_Kingdom.png"
							height="25">
						</a> <a href="?language=ja_JP"> <img class="img-circle"
							alt="japan" src="assets/css/images/japan.png" height="25"
							style="border: 1px solid white">
						</a> <a href="?language=vi_VN"> <img class="img-circle"
							alt="vietnamese" src="assets/css/images/Vietnam.png" height="25">
						</a>
					</div>

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
					<form action="answer" method="post">
						<input name="language" value="${language}" type="hidden">
						<%
							Connection con = DataAccess.getConnection();
							int assignSurveyId = (Integer) request.getAttribute("assignSurveyId");

							List<Question> questionsList = QuestionDao.getSurveyQuestion(con,
									AssignSurveyDao.findAssignSurvey(con, assignSurveyId).getSurveyId());
							int i = 0;
						%>
						<input name="assignSurveyId" value="<%=assignSurveyId%>"
							type="hidden">
						<c:out value="${error}" />
						<c:forEach items="${submissionList }" var="submission">
							<c:if
								test="${submission.questionType == 'open_question' && language == 'en_US' }">
								<p class="font">${submission.questionEN}
									<span style="color: red">*</span><br>
								</p>
								<div class="row">
									<div class="col-xs-5">
										<input type="text" class="form-control"
											name="${ submission.questionId}"
											value="${submission.answer }" required>
									</div>
								</div>
							</c:if>
							<c:if
								test="${submission.questionType == 'open_question' && language == 'vi_VN' }">
								<p class="font">${submission.questionVN}
									<span>*</span><br>
								</p>
								<div class="row">
									<div class="col-xs-5">
										<input type="text" class="form-control"
											name="${ submission.questionId}"
											value="${submission.answer }" required>
									</div>
								</div>
							</c:if>
							<c:if
								test="${submission.questionType == 'open_question' && language == 'ja_JP' }">
								<p class="font">${submission.questionJP}
									<span style="color: red">*</span><br>
								</p>
								<div class="row">
									<div class="col-xs-5">
										<input type="text" class="form-control"
											name="${ submission.questionId}"
											value="${submission.answer }" required>
									</div>
								</div>
							</c:if>
						</c:forEach>
						<%
							for (Question question : questionsList) {
								if (question.getType().equalsIgnoreCase("close_question")) {
									List<OfferedAnswer> answerList = OfferedAnswerDao.getOfferedAnswer(con, question.getId());
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
											<td><input type="radio" name="<%=question.getId() %>"
												<c:forEach  items="${submissionList }" var="submission">
												<c:if test="<%=question.getId()%> == ${submission.questionId }"><c:if test="${answer.point == submission.point }"> check </c:if></c:if>
											</c:forEach>
												value="${answer.id }" required></td>
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
						<c:forEach items="${submissionList }" var="question">
							<c:if
								test="${submission.questionType == 'opinion' && language == 'en_US' }">
								<h1 style="color: #ff7f00;">C. ${submission.questionEN}</h1>
								<textarea name="${ submission.questionId}"
									value="${submission.answer }" rows="5" cols="100"></textarea>
							</c:if>
							<c:if
								test="${submission.questionType == 'opinion' && language == 'vi_VN' }">
								<h1 style="color: #ff7f00;">C. ${submission.questionVN}</h1>
								<textarea name="${ question.id}" rows="5" cols="100"></textarea>
							</c:if>
							<c:if
								test="${submission.questionType == 'opinion' && language == 'ja_JP' }">
								<h1 style="color: #ff7f00;">C. ${submission.questionJP}</h1>
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
				</div>
			</div>
		</div>
	</div>
</body>
</html>