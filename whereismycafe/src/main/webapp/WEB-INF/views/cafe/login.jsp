<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "shortcut icon" href = "#">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/login.css"/>
<script src="${pageContext.request.contextPath}/cafe/js/login.js"></script>
<title>카페 로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<div class = "inner_login">
		<div class = "login_myweb">
			<div id = "msg" class = "msg"></div>
			<form method = "post" id = "loginform">
				<fieldset>
					<legend class = "screen_out">로그인</legend>
					<div class = "box_login">
						<div class = "inp_text">
							<label for = "cafeNickname" class = "screen_out">카페 닉네임</label>
							<input type = "text" id = "cafeNickname" name = "cafeNickname" placeholder = "카페 닉네임을 입력하세요!">
							
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>