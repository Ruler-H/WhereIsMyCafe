<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="#">
<meta charset="UTF-8">
<title>WhereIsMyCafe</title>
</head>
<body>
	<c:if test = "${clientinfo == null}">
		<a href = "client/join">고객 회원가입</a></br>
		<a href = "client/login">고객 로그인</a></br>
		<a href = "cafe/join">카페 회원가입</a></br>
		<a href = "cafe/login">카페 로그인</a>
	</c:if>
	<c:if test = "${clientinfo != null}">
		<img src = "${pageContext.request.contextPath}/client/profile/
		${clientinfo.clientProfileImage}"/>${clientinfo.clientNickname}님
		<a href = "client/logout" class = "menu">로그아웃</a>
		<a href = "client/update" class = "menu">회원 정보 수정</a>
	</c:if>
	<c:if test = "${cafeinfo != null}">
		<img src = "${pageContext.request.contextPath}/cafe/profile/${cafeinfo.cefeLogo}"/>${cafeinfo.cafeName} 점주님
		<a href = "cafe/logout" class = "menu">로그아웃</a>
		<a href = "cafe/update" class = "menu">카페 정보 수정</a>
	</c:if>
</body>
</html>