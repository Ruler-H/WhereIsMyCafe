window.addEventListener("load", function(event){
	//필요한 DOM 객체 가져오기
	var joinform = document.getElementById("joinform");
	
	//clinet 테이블 관련 DOM 객체
	var clientEmail = document.getElementById("clientEmail");
	var clientAddress = document.getElementById("clientAddress");
	var clientAge = document.getElementById("clientAge");
	var clientName = document.getElementById("clientName");
	var clientNickname = document.getElementById("clientNickname");
	var clientPassword = document.getElementById("clientPassword");
	var clientPassword1 = document.getElementById("clientPassword1");
	var clientPhoneNum = document.getElementById("clientPhoneNum");
	var clientProfileImage = document.getElementById("clientProfileImage");
	var img = document.getElementById("img");
	
	//clientPreferenceElement 테이블 관련 DOM 객체
	var preferConcent = document.getElementById("preferConcent");
	var preferNoKidsZone = document.getElementById("preferNoKidsZone");
	var preferParking = document.getElementById("preferParking");
	var preferPat = document.getElementById("preferPat");
	var preferRefill = document.getElementById("preferRefill");
	var preferWifi = document.getElementById("preferWifi");
	
	//button DOM 객체
	var joinbtn = document.getElementById("joinbtn");
	var mainbtn = document.getElementById("mainbtn");
	var loginbtn = document.getElementById("loginbtn");
	
	//화면에 출력될 메시지 DOM 객체
	var clientEmailmsg = document.getElementById("clientEmailmsg");
	var clientNamemsg = document.getElementById("clientNamemsg");
	var clientNicknamemsg = document.getElementById("clientNicknamemsg");
	var clientPasswordmsg = document.getElementById("clientPasswordmsg");
	var clientAddressmsg = document.getElementById("clientAddressmsg");
	var clientAgemsg = document.getElementById("clientAgemsg");
	var clientPhoneNummsg = document.getElementById("clientPhoneNummsg");

	//mainbtn을 눌렀을 때 페이지 이동 처리
	mainbtn.addEventListener("click", function(event){
		location.href="../";
	});
	
	//loginbtn을 눌렀을 때 페이지 이동 처리
	loginbtn.addEventListener("click", function(event){
		location.href="login";
	});

	//clientProfileImage 미리보기 처리
	clientProfileImage.addEventListener("change", function(event){
		if(this.files && this.files[0]){					//선택한 파일이 있는 경우 처리
			var reader = new FileReader();					//파일 읽기 객체
			reader.readAsDataURL(this.files[0]);			//파일 읽기 요청
			reader.addEventListener("load", function(e){	//자바스크립트에서 파일을 읽는 것은 비동기
				img.src = e.target.result;
			});

		}
	});

	//joinbtn을 눌렀을 때 회원가입 처리
	var flag = false;
	joinbtn.addEventListener("click", function(event){
		clientEmailmsg.innerHTML = '';
		clientNamemsg.innerHTML = '';
		clientNicknamemsg.innerHTML = '';
		clientPasswordmsg.innerHTML = '';
		clientAddressmsg.innerHTML = '';
		clientAgemsg.innerHTML = '';
		clientPhoneNummsg.innerHTML = '';
		//서버로 보내기 전 데이터 유효성 검사
		//이메일 유효성 검사
		if(clientEmail.value.trim().length < 1){
			clientEmailmsg.innerHTML = '이메일은 필수 입력입니다.<br/>';
			flag = true;
		}else{
			var emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			if(!emailRegExp.test(clientEmail.value.trim())){
				clientEmailmsg.innerHTML = '잘못된 이메일 형식입니다.<br/>';
				flag = true;
			}
		}
		

		//비밀번호 유효성 검사
		if(clientPassword.value.trim().length < 1){
			clientPasswordmsg.innerHTML = '비밀번호는 필수 입력입니다.<br/>';
			flag = true;
		}else{
			var passwordRegExp = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
			if(!passwordRegExp.test(clientPassword.value.trim())){
				clientPasswordmsg.innerHTML = '비밀번호는 숫자와 영문 대소문자, 특수문자가 포함된 8~15자리여야 합니다.<br/>';
				flag = true;
			}else{
				if(clientPassword.value.trim() !== clientPassword1.value.trim()){
					clientPasswordmsg.innerHTML = '2개의 비밀번호는 같아야 합니다.<br/>';
					flag = true;
				}
			}
		}
		
		

		//닉네임 유효성 검사
		if(clientNickname.value.trim().length < 1){
			clientNicknamemsg.innerHTML = '닉네임은 필수 입력입니다.<br/>';
			flag = true;
		}else{
			var nicknameRefExp = /^[a-zA-Z가-힣0-9]{2,5}$/;
			if(!nicknameRefExp.test(clientNickname.value.trim())){
				clientNicknamemsg.innerHTML = '닉네임은 영문, 한글, 숫자로 2자 이상 5자 이하이어야 합니다.<br/>';
				flag = true;
			}
		}
		
		

		//주소 유효성 검사
		if(clientAddress.value.trim().length < 1){
			clientAddressmsg.innerHTML = '주소는 필수 입력입니다.<br/>';
			flag = true;
		}
		
		

		//나이 유효성 검사
		if(clientAge.value.trim().length < 1){
			clientAgemsg.innerHTML = '나이는 필수 입력입니다.<br/>';
			flag = true;
		}
		
		

		//이름 유효성 검사
		if(clientName.value.trim().length < 1){
			clientNamemsg.innerHTML = '이름은 필수 입력입니다.<br/>';
			flag = true;
		}
		
		

		//휴대폰 번호 유효성 검사
		if(clientPhoneNum.value.trim().length < 1){
			clientPhoneNummsg.innerHTML = '휴대폰 번호는 필수 입력입니다.<br/>';
			flag = true;
		}
		
		

		//유효성 검사에 실패한 경우 처리
		if(flag == true){
			return;
		}

		//join 요청 준비
		var url = "join";						//요청할 URL
		var request = new XMLHttpRequest();		//요청 전송할 객체
		request.open('POST', url, true);		//요청 생성
		var formData = new FormData(joinform);	//요청의 내용인 formData 객체 생성
		request.send(formData);					//요청 전송

		//join 요청 응답이 온 경우 처리
		request.addEventListener("load", function(e){
			var obj = JSON.parse(e.target.responseText);

			if(obj.result == true){
				location.href = "../";
			}else{
				if(obj.nicknamecheck == false){
					clientNicknamemsg.innerHTML = '이미 사용 중인 닉네임';
				}
			}
		})
	});
});