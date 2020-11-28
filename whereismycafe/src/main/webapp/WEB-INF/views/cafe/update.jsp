<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "shortcut icon" href = "#">
<meta charset="UTF-8">
<meta name="viewport" content = "width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<link rel="stylesheet" href = "${pageContext.request.contextPath}/client/css/join.css">
<script src='${pageContext.request.contextPath}/cafe/js/update.js'></script>
<title>카페 정보 수정</title>
</head>
<body>
	<form id="updateform" enctype="multipart/form-data">
		<h2>카페 정보 수정</h2>
		<div align = "center" id = "msg"></div>
		<ul>
			<li>
				<label for = "cafeNickname">카페 닉네임</label>
				<input type = "text" id = "cafeNickname" name = "cafeNickname" class = "textinput" value = "${cafeinfo.cafeNickname}" readonly = "readonly"/>
			</li>
			
			<li>
				<label for = "cafePassword">비밀번호</label>
				<input type = "password" id = "cafePassword" name = "cafePassword" class = "textinput" placeholder = "비밀번호는 8 - 15자로 만들어야 합니다."/>
			</li>
			<div id = "cafePasswordmsg"></div>
			
			<li>
				<label for = "cafePassword1">비밀번호 확인</label>
				<input type = "password" id = "cafePassword1" class = "textinput" placeholder = "영문 대소문자와 특수문자와 숫자 1개 이상으로 만들어야 합니다."/>
			</li>
			
			<li>
				<label for = "cafeName">카페 이름</label>
				<input type = "text" id = "cafeName" name = "cafeName" class = "textinput" readonly = "readonly" value="${cafeinfo.cafeName}"/>
			</li>
			
			<li>
				<label for = "cafeAddress">카페 주소</label>
				<input type = "text" id = "cafeAddress" name = "cafeAddress" class = "textinput" placeholder = "주소를 입력하세요" value="${cafeinfo.cafeAddress}"/>
			</li>
			<div id = "cafeAddressmsg"></div>
			
			<li>
				<label for = "cafePhoneNum">카페 전화번호</label>
				<input type = "tel" id = "cafePhoneNum" name = "cafePhoneNum" class = "textinput" placeholder = "번호를 입력하세요" value = "${cafeinfo.cafePhoneNum}"/>
			</li>
			<div id = "cafePhoneNummsg"></div>
			
			<li>
				<label for="cafeTableNum">카페 테이블 수</label>
				<input type="number" id="cafeTableNum" name="cafeTableNum" class="textinput" placeholder="테이블 수를 입력하세요" value = "${cafeinfo.cafeTableNum}"/>
			</li>
			<div id="cafeTableNummsg"></div>
			
			<li>
				<label for="outdoorTableNum">야외 테이블 수</label>
				<input type="number" id="outdoorTableNum" name="outdoorTableNum" class="textinput" placeholder="야외 테이블 수를 입력하세요" value = "${cafeinfo.outdoorTableNum}"/>
			</li>
			
			<li>
				<label for="concentTableNum">콘센트 사용 가능 테이블 수</label>
				<input type="number" id="concentTableNum" name="concentTableNum" class="textinput" placeholder="콘센트 사용 가능 테이블 수를 입력하세요" value = "${cafeinfo.concentTableNum}"/>
			</li>
			
			<li>
				<label for="cafeHomepage">카페 홈페이지</label>
				<input type="text" id="cafeHomepage" name="cafeHomepage" class="textinput" placeholder="카페 홈페이지를 입력하세요" value = "${cafeinfo.cafeHomepage}"/>
			</li>
			<div id="cafeHomepagemsg"></div>
			
			<li>
				<label for="cafeSNS">카페 SNS</label>
				<input type="text" id="cafeSNS" name="cafeSNS" class="textinput" placeholder="카페 SNS 계정을 입력하세요" value = "${cafeinfo.cafeSNS}"/>
			</li>
			<div id="cafeSNSmsg"></div>
			
			<li>
				<label for="cafeCommentary">카페 한 줄 설명</label>
				<input type="text" id="cafeCommentary" name="cafeCommentary" class="textinput" placeholder="카페 설명을 입력하세요" value = "${cafeinfo.cafeCommentary}"/>
			</li>
			<div id="cafeCommentarymsg"></div>
			
			<li>
				<label for="cafeImage">카페 이미지</label>
				<input type="file" multiple="multiple" id="cafeImage" class="fileinput" accept="image/*" name="cafeImage"/>
				<img id="imgs" src="${pageContext.request.contextPath}/cafe/logo/${cafeinfo.cafeImage}"/>
				<input type = "hidden" name = "oldCafeImage" value="${cafeinfo.cafeImage}"/>
			</li>
			
			<li>
				<label for="cafeSurviceElement">카페 서비스 요소</label></br>
				<input type="checkbox" id="cafeParking" name="cafeParking" class="boxinput" value = "${cafeinfo.cafeParking}"/>주차 가능 여부&emsp;&emsp;
				<input type="checkbox" id="cafeRefill" name="cafeRefill" class="boxinput" value = "${cafeinfo.cafeRefill}"/>리필 가능 여부</br>
				<input type="checkbox" id="cafeCoupon" name="cafeCoupon" class="boxinput" value = "${cafeinfo.cafeCoupon}"/>쿠폰 서비스 보유 여부&emsp;&emsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" id="noKidsZone" name="noKidsZone" class="boxinput" value = "${cafeinfo.noKidsZone}"/>노키즈존 보유 선호</br>
				<input type="checkbox" id="sirenOrder" name="sirenOrder" class="boxinput" value = "${cafeinfo.sirenOrder}"/>사이렌 오더 가능 여부&emsp;&emsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" id="tumblerDiscount" name="tumblerDiscount" class="boxinput" value = "${cafeinfo.tumblerDiscount}"/>텀블러 할인 여부</br>
				<input type="checkbox" id="cafeWifi" name="cafeWifi" class="boxinput" value = "${cafeinfo.cafeWifi}"/>와이파이 보유 여부&emsp;&emsp;&nbsp;&nbsp;&nbsp;
			</li>
			
			<li>
				<label for="cafeLogo">카페 로고</label>
				<input type="file" id="cafeLogo" class="fileinput" accept="image/*" name="cafeLogo"/>
				<img id="img" src="${pageContext.request.contextPath}/cafe/logo/${cafeinfo.cafeLogo}"/>
				<input type = "hidden" name = "oldCafeLogo" value="${cafeinfo.cafeLogo}"/>
			</li>
			
			<li class = "buttons">
				<input type="button" value="정보 수정" id="updatebtn"/>
				<input type="button" value="메인으로" id="mainbtn"/>
				<input type="button" value="로그아웃" id="logoutbtn"/>
			</li>
		</ul>
	</form>
</body>
</html>