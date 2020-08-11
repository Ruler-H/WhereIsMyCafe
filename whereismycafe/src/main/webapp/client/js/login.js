window.addEventListener("load", function(event){
    //DOM 객체 찾아오기
    var clientEmail = document.getElementById("clientEmail");
    var clientPassword = document.getElementById("clientPassword");
    var loginform = document.getElementById("loginform");
    var loginbtn = document.getElementById("loginbtn");
    var msg = document.getElementById("msg");

    //로그인 버튼을 눌렀을 때 로그인 처리
    loginbtn.addEventListener("click", function(event){
        var flag = false;

        //이메일 유효성 검사
        if(clientEmail.value.trim().length < 1){
            msg.innerHTML = "이메일은 필수 입력입니다!<br/>";
            flag = true;
        }

        //비밀번호 유효성 검사
        if(clientPassword.value.trim().length < 1){
            msg.innerHTML = "비밀번호는 필수 입력입니다!<br/>";
            flag = true;
        }

        //유효성 검사를 통과하지 못한 경우 돌려보내는 작업을 위한 코드
        if(flag == true){
            return;
        }

        //login 요청 준비
        var url = "login";						//요청할 url
		var request = new XMLHttpRequest();		//요청 전송할 객체
		request.open('POST', url, true);		//요청 생성
		var formData = new FormData(loginform);	//요청의 내용인 formData 객체 생성
		request.send(formData);					//요청 전송

		//login 요청 응답이 온 경우 처리
		request.addEventListener("load", function(e){
			var obj = JSON.parse(e.target.responseText);

			if(obj.result == true){
				location.href = "../";
			}else{
				msg = '잘못된 이메일이거나 비밀번호가 틀렸습니다!';
			}
		})
    })

});