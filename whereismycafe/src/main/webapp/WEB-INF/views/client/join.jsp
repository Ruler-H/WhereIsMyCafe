<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="shortcut icon" href="#">
<meta charset="UTF-8">
<title>회원가입</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<script src="${pageContext.request.contextPath}/client/js/join.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main_join.css" />
<noscript>
	<link resl="stylesheet" href="${pageContext.request.contextPath}/assets/css/noscript" />
</noscript>
</head>
<body class="is-preload">
	<div id="wrapper">
		<header id="header">
			<div class="logo">
				<span class="icon fa-gem"></span>
			</div>
			<form id="joinform" enctype="multipart/form-data">
				<h2>회원가입</h2>
				<div align="center" id="msg"></div>
				<label for="clientAddress">주소</label>
				<input type="text" id="clientAddress" name="clientAddress" class="textinput" placeholder="주소를 입력하세요"/>
				<div id="clientAddressmsg"></div><br/>
				
				<label for="clientAge">나이</label>
				<input type="number" id="clientAge" name="clientAge" class="textinput" placeholder="나이를 입력하세요"/>
				<div id="clientAgemsg"></div><br/>
			
				<label for="clientEmail">이메일</label>
				<input type="email" id="clientEmail" name="clientEmail" class="textinput" placeholder="이메일을 입력하세요"/>
				<div id="clientEmailmsg"></div><br/>
			
				<label for="clientName">이름</label>
				<input type="text" id="clientName" name="clientName" class="textinput" placeholder="이름을 입력하세요"/>
				<div id="clientNamemsg"></div><br/>
			
				<label for="clientNickname">별명</label>
				<input type="text" id="clientNickname" name="clientNickname" class="textinput" placeholder="별명을 입력하세요"/>
				<div id="clientNicknamemsg"></div><br/>
			
				<label for="clientPassword">비밀번호</label>
				<input type="password" id="clientPassword" name="clientPassword" class="textinput" placeholder="비밀번호는 8-15자로 만들어야 합니다"/>
				<div id="clientPasswordmsg"></div><br/>
			
				<label for="clientPassword1">비밀번호 확인</label>
				<input type="password" id="clientPassword1" class="textinput" placeholder="영문 대소문자와 특수문자와 숫자 1개 이상으로 만들어야 합니다"/><br/>
			
			
				<label for="clientPhoneNum">휴대폰 번호</label>
				<input type="tel" id="clientPhoneNum" name="clientPhoneNum" class="textinput" placeholder="번호를 입력하세요"/>
				<div id="clientPhoneNummsg"></div><br/>
			
				<label for="clientImage">프로필 사진</label>
				<input type="file" id="clientProfileImage" class="fileinput" accept="image/*" name="clientProfileImage"/>
				<img id="img"/><br/><br/>
			
			
				<label for="clientPreferenceElement">카페 선호 요소</label>
				<input type="checkbox" id="preferConcent" name="preferConcent" class="boxinput"/>콘센트 보유 선호&emsp;&emsp;
				<input type="checkbox" id="preferNoKidsZone" name="preferNoKidsZone" class="boxinput"/>노키즈존 보유 선호</br>
				<input type="checkbox" id="preferParking" name="preferParking" class="boxinput"/>주차 가능 선호&emsp;&emsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" id="preferPat" name="preferPat" class="boxinput"/>애완동물 동반 가능 선호</br>
				<input type="checkbox" id="preferRefill" name="preferRefill" class="boxinput"/>리필 가능 선호&emsp;&emsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" id="preferWifi" name="preferWifi" class="boxinput"/>와이파이 보유 선호<br>
			
				<input type="button" value="회원가입" id="joinbtn"/>
				<input type="button" value="메인으로" id="mainbtn"/>
				<input type="button" value="로그인" id="loginbtn"/>
			</form>
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