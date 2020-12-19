<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="shortcut icon" href="#">
<meta charset="UTF-8">
<title>WhereIsMyCafe</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-calable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main_join.css" />
<noscript>
	<link resl="stylesheet" href="assets/css/noscript" />
</noscript>
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<div class="logo">
				<span class="icon fa-gem"></span>
			</div>
			<label for="cafeNickname">카페 닉네임</label>
			<input type="text" id="cafeNickname" name="cafeNickname" class="textinput" placeholder="닉네임을 입력하세요" />
		</header>
		

		<!-- Footer -->
		<footer id="footer">
			<p class="copyright">
				&copy; Untitled. Design: <a href="https://html5up.net">HTML5 UP</a>.
			</p>
		</footer>

	</div>

	<!-- BG -->
	<div id="bg"></div>

	<!-- Scripts -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>



</body>
</html>