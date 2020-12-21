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
<script src="${pageContext.request.contextPath}/cafe/js/search.js"></script>
<style>tab1{padding-left: 1.8em}</style>
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<div class="logo">
				<span class="icon fa-gem"></span>
			</div>
			<div class="list">
				<tr>
					<th>카페 이름</th>
					<th><tab1>주소</tab1></th>
					<th><tab1>전화번호</tab1></th><br/>
				</tr>
				<c:choose>
					<c:when test = "${empty cafeinfo}">
						<tr><td>카페 정보가 없습니다.</td></tr><br/>
					</c:when>
					<c:when test = "${!empty cafeinfo}">
						<c:forEach var="list" items="${cafeinfo}">
							<tr>
								<td><c:out value="${cafeinfo.cafeName}"/></td>
								<td><tab1><c:out value="${cafeinfo.cafeAddress}"/></tab1></td>
								<td><tab1><c:out value="${cafeinfo.cafePhoneNum}"/></tab1></td><br/>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</div>
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