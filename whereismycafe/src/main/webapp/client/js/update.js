window.addEventListener("load", function(event){
    //DOM 객체 찾아오기
    var updateform = document.getElementById("updateform");
    var msg = document.getElementById("msg");
    var clientPassword = document.getElementById("clientPassword");
    var clientPasswordmsg = document.getElementById("clientPasswordmsg");
    var clientPassword1 = document.getElementById("clientPassword1");
    var clientAddress = document.getElementById("clientAddress");
    var clientAddressmsg = document.getElementById("clientAddressmsg");
    var clientPhoneNum = document.getElementById("clientPhoneNum");
    var clientPhoneNummsg = document.getElementById("clientPhoneNummsg");
    var preferConcent = document.getElementById("preferConcent");
    var preferNoKidsZone = document.getElementById("preferNoKidsZone");
    var preferParking = document.getElementById("preferParking");
    var preferPat = document.getElementById("preferPat");
    var preferRefill = document.getElementById("preferRefill");
    var preferWifi = document.getElementById("preferWifi");
    var clientProfileImage = document.getElementById("clientProfileImage");
    var img = document.getElementById("img");
    var updatebtn = document.getElementById("updatebtn");
    var mainbtn = document.getElementById("mainbtn");
    var logoutbtn = document.getElementById("logoutbtn");

    //메인으로 버튼을 클릭했을 때 이벤트 처리
    mainbtn.addEventListener("click", function(event){
        location.href="../";
    });

    //로그아웃 버튼을 클릭했을 때 이벤트 처리
    logoutbtn.addEventListener("click", function(event){
        location.href="logout";
    });

    //clientProfileImage 미리보기 처리
    clientProfileImage.addEventListener("change", function(event){
        if(this.files && this.files[0]){
            var filename = this.files[0].name;
            var reader = new FileReader();
            reader.addEventListener("load", function(e){
                img.src = e.target.result;
            });
            reader.readAsDataURL(this.files[0]);
        }
    });

    //유효성 검사에 통과하지 못했을 때를 확인하기 위한 변수 생성
    var flag = false;
    //회원 정보 수정 버튼을 눌렀을 때 이벤트 처리
    updatebtn.addEventListener("click", function(event){
        clientPasswordmsg.innerHTML = '<br/>';
        clientAddressmsg.innerHTML = '<br/>';
        clientPhoneNummsg.innerHTML = '<br/>';

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
		
        //주소 유효성 검사
		if(clientAddress.value.trim().length < 1){
			clientAddressmsg.innerHTML = '주소는 필수 입력입니다.<br/>';
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
        
        //update 요청 준비
        var url = "update";                         //요청할 URL
        var request = new XMLHttpRequest();         //요청을 전송할 객체 생성
        request.open('POST', url, true);            //요청 생성
        var formData = new FormData(updateform);    //요청 내용 formData 객체 생성
        request.send(formData);                     //요청 전송

        //update 요청 응답이 온 경우 처리
        request.addEventListener("load", function(e){
            var obj = JSON.parse(e.target.responseText);
            if(obj.result == true){
                location.href = "../client/logout";
            }else{
                msg.innerHTML = "회원 정보 수정에 실패하였습니다."
            }
        });
    });
});