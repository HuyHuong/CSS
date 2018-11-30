<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="assets/css/thank.css">
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
			<div class="alert">
				<a href="logout">
					<button type="button" class="btn btn-primary buttons" id="logout">
						Logout</button>
				</a>
				<div class="text-center">
					<img style='height: 100%; width: 100%; object-fit: contain'
						src="assets/css/images/thank-you.jpg" />
					<h3 class="font-weight-bold">
						<fmt:message key="thank" />
					</h3>

				</div>
			</div>
		</div>
	</div>
</body>
</html>