window.addEventListener("load", function(event){
    //DOM 객체 찾아오기
    var msg = document.getElementById("msg");
    var loginform = document.getElementById("loginform");
    var cafeNickname = document.getElementById("cafeNickname");
    var cafePassword = document.getElementById("cafePassword");
    var loginbtn = document.getElementById("loginbtn");
    var keepLogin = document.getElementById("keepLogin");
    
    //로그인 버튼을 눌렀을 때 로그인 처리
    loginbtn.addEventListener("click", function(event){
        var flag = false;

        //닉네임 유효성 검사
        if(cafeNickname.value.trim().length < 1){
            msg.innerHTML = "닉네임은 필수 입력입니다!<br/>";
            flag = true;
        }

        //비밀번호 유효성 검사
        if(cafePassword.value.trim().length < 1){
            msg.innerHTML = "비밀번호는 필수 입력입니다!<br/>";
        }

        //유효성 검사를 통과하지 못한 경우 돌려보내는 작업을 위한 코드
       if(flag == true){
           return;
       }

       //login 요청 준비
       var url = "login";                       //요청할 url
       var request = new XMLHttpRequest();      //요청 전송할 객체
       request.open('POST', url, true);         //요청 생성
       var formData = new FormData(loginform);  //요청의 내용인 formData 객체 생성
       request.send(formData);                  //요청 전송

       //login 요청 응답이 온 경우 처리
       request.addEventListener("load", function(event){
           var obj = JSON.parse(e.target.responseText);

           if(obj.result == true){
               location.href = "../";
           }else{
               msg = '잘못된 닉네임이거나 비밀번호가 틀렸습니다!';
           }
       })
    })
})