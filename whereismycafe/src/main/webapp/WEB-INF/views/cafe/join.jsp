<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="shortcut icon" href="#">
<meta charset="UTF-8">
<title>회원가입</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-calable=no" />
<script src="${pageContext.request.contextPath}/cafe/js/join.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main_join.css" />
<noscript>
	<link resl="stylesheet" href="${pageContext.request.contextPath}/assets/css/noscript" />
</noscript>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.min.js" ></script>
<script type="text/javascript">
$(function(){
    //여기부터
    $("#cafeImage").change(function(){
    	imageList = $("#cafeImage")[0].files;
    	imageListTag = '';
    	for(i = 0; i < imageList.length; i = i + 1){
    		imageListTag += "<li>" + imageList[i].name + "</li>";
    	}
    	$('#imageList').html(imageListTag);
    });
    //여기까지
});
</script>
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<div class="logo">
				<span class="icon fa-gem"></span>
			</div>
			<div class="content">
				<form method = "post" id="joinform" action="upload-multiple.php" enctype="multipart/form-data"><br/>
					<h1>회원가입</h1>
					<div align="center" id="msg"></div>
						<label for="cafeNickname">카페 닉네임</label> <input type="text"
							id="cafeNickname" name="cafeNickname" class="textinput"
							placeholder="닉네임을 입력하세요" />
						<div id="cafeNicknamemsg"></div><br/>
						<label for="cafePassword">비밀번호</label> <input
							type="password" id="cafePassword" name="cafePassword"
							class="textinput" placeholder="비밀번호는 8-15자로 만들어야 합니다" />
						<div id="cafePasswordmsg"></div><br/>
						<label for="cafePassword1">비밀번호 확인</label> <input
							type="password" id="cafePassword1" class="textinput"
							placeholder="영문 대소문자와 특수문자와 숫자 1개 이상으로 만들어야 합니다" /><br/>
						<label for="cafeAddress">주소</label> <input type="text"
							id="cafeAddress" name="cafeAddress" class="textinput"
							placeholder="주소를 입력하세요" />
						<div id="cafeAddressmsg"></div><br/>
						<label for="cafeName">카페 이름</label> <input type="text"
							id="cafeName" name="cafeName" class="textinput"
							placeholder="카페 이름을 입력하세요" />
						<div id="cafeNamemsg"></div><br/>
						<label for="cafeHomepage">카페 홈페이지</label> <input type="text"
							id="cafeHomepage" name="cafeHomepage" class="textinput"
							placeholder="카페 홈페이지를 입력하세요" />
						<div id="cafeHomepagemsg"></div><br/>
						<label for="cafeSNS">카페 SNS</label> <input type="text"
							id="cafeSNS" name="cafeSNS" class="textinput"
							placeholder="카페 SNS 계정을 입력하세요" />
						<div id="cafeSNSmsg"></div><br/>
						<label for="cafeCommentary">카페 한 줄 설명</label> <input
							type="text" id="cafeCommentary" name="cafeCommentary"
							class="textinput" placeholder="카페 설명을 입력하세요" /><br/>
						<label for="cafePhoneNum">카페 전화번호</label> <input type="tel"
							id="cafePhoneNum" name="cafePhoneNum" class="textinput"
							placeholder="번호를 입력하세요" />
						<div id="cafePhoneNummsg"></div><br/>
						<label for="cafetTableNum">카페 테이블 수</label> <input
							type="number" id="cafeTableNum" name="cafeTableNum"
							class="number" placeholder="테이블 수를 입력하세요" min="0"/>
						<div id="cafeTableNummsg"></div><br/>
						<label for="outdoorTableNum">야외 테이블 수</label> <input
							type="number" id="outdoorTableNum" name="outdoorTableNum"
							class="number" placeholder="야외 테이블 수를 입력하세요" min="0"/><br/>
						<label for="concentTableNum">콘센트 사용 가능 테이블 수</label> <input
							type="number" id="concentTableNum" name="concentTableNum"
							class="number" placeholder="콘센트 사용 가능 테이블 수를 입력하세요" min="0"/>
						<div id="cafeCommentarymsg"></div><br/>
						<label for="cafeLogo">카페 로고</label> <input type="file"
							id="cafeLogo" class="fileinput" accept="image/*" name="cafeLogo" />
							<img id="img" /><br/><br/>
						<label for="cafeImage">카페 이미지</label> 
						<input type="file" id="cafeImage" class="fileinput" accept="image/*" name="cafeImage[]" multiple />
						<ul id="imageList"></ul>
						<img id="imgs"><br/>
						<label for="cafeSurviceElement">카페 서비스 요소</label> 
						<input type="checkbox" id="cafeParking" name="cafeParking" class="boxinput" />주차가능 여부<br/>
						<input type="checkbox" id="cafeRefill" name="cafeRefill" class="boxinput" />리필 가능 여부 <br/>
						<input type="checkbox" id="cafeCoupon" name="cafeCoupon" class="boxinput" />쿠폰 서비스 보유 여부<br/>
						<input type="checkbox" id="noKidsZone" name="noKidsZone" class="boxinput" />노키즈존 보유 선호<br/>
						<input type="checkbox" id="sirenOrder" name="sirenOrder" class="boxinput" />사이렌 오더 가능 여부<br/>
						<input type="checkbox" id="tumblerDiscount" name="tumblerDiscount" class="boxinput" />텀블러 할인 여부<br/>
						<input type="checkbox" id="cafeWifi" name="cafeWifi" class="boxinput" />와이파이 보유 여부<br/><br/>
						<input type="button" value="회원가입" id="joinbtn" /> 
						<input type="button" value="메인으로" id="mainbtn" />
						<input type="button" value="로그인" id="loginbtn" />
				</form>
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