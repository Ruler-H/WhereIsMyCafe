<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="#">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/join.css">
<script src='${pageContext.request.contextPath}/client/js/update.js'></script>
<title>회원정보 수정</title>
</head>
<body>
	<form id="updateform" enctype="multipart/form-data">
		<h2>회원정보 수정</h2>
		<div align="center" id="msg"></div>
		<ul>
			<li>
				<label for="clientEmail">이메일</label> 
				<input type="text" id="clientEmail" name="clientEmail" class="textinput" value="${clientinfo.clientEmail}" readonly="readonly" />
			</li>

			<li>
				<label for="clientPassword">비밀번호</label> 
				<input type="password" id="clientPassword" name="clientPassword" class="textinput" placeholder="비밀번호는 8 - 15자로 만들어야 합니다." />
			</li>
			<div id="clientPasswordmsg"></div>

			<li>
				<label for="clientPassword1">비밀번호 확인</label> 
				<input type="password" id="clientPassword1" class="textinput" placeholder="영문 대소문자와 특수문자와 숫자 1개 이상으로 만들어야 합니다." />
			</li>

			<li>
				<label for="clientNickname">별명</label> 
				<input type="text" id="clientNickname" name="clientNickname" class="textinput" readonly="readonly" value="${clientinfo.clientNickname}" />
			</li>
			
			<li>
				<label for="clientAddress">주소</label> 
				<input type="text" id="clientAddress" name="clientAddress" class="textinput" placeholder="주소를 입력하세요" />
			</li>
			<div id="clientAddressmsg"></div>

			<li>
				<label for="clientAge">나이</label> 
				<input type="number" id="clientAge" name="clientAge" class="textinput" readonly="readonly" value="${clientinfo.clientAge}" />
			</li>

			<li>
				<label for="clientName">이름</label> 
				<input type="text" id="clientName" name="clientName" class="textinput" readonly="readonly" value="${clientinfo.clientName}" />
			</li>

			<li>
				<label for="clientPhoneNum">휴대폰 번호</label> 
				<input type="tel" id="clientPhoneNum" name="clientPhoneNum" class="textinput" placeholder="번호를 입력하세요" />
			</li>
			<div id="clientPhoneNummsg"></div>
			

			<li>
				<label for="clientPreferenceElement">카페 선호 요소</label></br> 
				<input type="checkbox" id="preferConcent" name="preferConcent" class="boxinput" />콘센트 보유 선호&emsp;&emsp; 
				<input type="checkbox" id="preferNoKidsZone" name="preferNoKidsZone" class="boxinput" />노키즈존 보유 선호</br>
				<input type="checkbox" id="preferParking" name="preferParking" class="boxinput" />주차 가능 선호&emsp;&emsp;&nbsp;&nbsp;&nbsp; 
				<input type="checkbox" id="preferPat" name="preferPat" class="boxinput" />애완동물 동반 가능 선호</br> 
				<input type="checkbox" id="preferRefill" name="preferRefill" class="boxinput" />리필 가능 선호&emsp;&emsp;&nbsp;&nbsp;&nbsp; 
				<input type="checkbox" id="preferWifi" name="preferWifi" class="boxinput" />와이파이 보유 선호</br>
			</li>

			<li>
				<label for="clientProfileImage">프로필 이미지</label> 
				<input type="file" id="clientProfileImage" class="fileinput" accept="image/*" name="clientProfileImage" /> 
				<img id="img" src="${pageContext.request.contextPath}/client/profile/${clientinfo.clientProfileImage}" />
				<input type="hidden" name="oldClientProfileImage" value="${clientinfo.clientProfileImage}"/>
			</li>

			<li class="buttons">
				<input type="button" value="정보 수정" id="updatebtn" /> 
				<input type="button" value="메인으로" id="mainbtn" />
				<input type="button" value="로그아웃" id="logoutbtn" />
			</li>
		</ul>
	</form>
</body>
</html>