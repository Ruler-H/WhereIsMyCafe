window.addEventListener("load", function(event){
    //DOM 객체 찾아오기
    var updateform = document.getElementById("updateform");

    //cafe 테이블 관련 DOM 객체
    var cafeNickname = document.getElementById("cafeNickname");
    var cafePassword = document.getElementById("cafePassword");
    var cafePassword1 = document.getElementById("cafePassword1");
    var cafeName = document.getElementById("cafeName");
    var cafeAddress = document.getElementById("cafeAddress");
    var cafePhoneNum = document.getElementById("cafePhoneNum");
    var cafeTableNum = document.getElementById("cafeTableNum");
    var outdoorTableNum = document.getElementById("outdoorTableNum");
    var cafeHomepage = document.getElementById("cafeHomepage");
    var cafeSNS = document.getElementById("cafeSNS");
    var cafeCommentary = document.getElementById("cafeCommentary");
    var cafeImage = document.getElementById("cafeImage");
    var oldCafeImage = document.getElementById("oldCafeImage");
    var cafeParking = document.getElementById("cafeParking");
    var cafeRefill = document.getElementById("cafeRefill");
    var cafeCoupon = document.getElementById("cafeCoupon");
    var noKidsZone = document.getElementById("noKidsZone");
    var sirenOrder = document.getElementById("sirenOrder");
    var tumblerDiscount = document.getElementById("tumblerDiscount");
    var cafeWifi = document.getElementById("cafeWifi");
    var cafeLogo = document.getElementById("cafeLogo");
    var oldCafeLogo = document.getElementById("oldCafeLogo");
    var img = document.getElementById("img");
    var imgs = document.getElementById("imgs");

    //화면에 출력될 메시지 DOM 객체
    var msg = document.getElementById("msg");
    var cafeAddressmsg = document.getElementById("cafeAddressmsg");
    var cafePasswordmsg = document.getElementById("caefPasswordmsg");
    var cafePhoneNummsg = document.getElementById("caefPhoneNummsg");
    var cafeTableNummsg = document.getElementById("cafeTableNummsg");
    var cafeHomepagemsg = document.getElementById("cafeHomepagemsg");
    var cafeSNSmsg = document.getElementById("cafeSNSmsg");
    var caefCommentarymsg = document.getElementById("cafeCommentarymsg");

    //Button DOM 객체
    var updatebtn = document.getElementById("updatebtn");
    var mainbtn = document.getElementById("mainbtn");
    var logoutbtn = document.getElementById("logoutbtn");

    //메시지가 빨강색으로 출력되도록 설정
    cafeAddressmsg.style.color = "RED";
    cafePasswordmsg.style.color = "RED";
    cafePhoneNummsg.style.color = "RED";
    cafeTableNummsg.style.color = "RED";
    cafeHomepagemsg.style.color = "RED";
    cafeSNSmsg.style.color = "RED";
    caefCommentarymsg.style.color = "RED";

    //메인 버튼을 클릭했을 때 이벤트 처리
    mainbtn.addEventListener("click", function(event){
        location.href = "../";
    })

    //로그아웃 버튼을 클릭했을 때 이벤트 처리
    logoutbtn.addEventListener("click", function(event){
        location.href = "logout";
    })

    //cafeLogo 미리보기 처리
    cafeLogo.addEventListener("change", function(event){
        if(this.file && this.files[0]){                     //선택한 파일이 있는 경우
            var reader = new FileReader();                  //파일 읽기 객체
            reader.readAsDataURL(this.files[0]);            //파일 읽기 요청
            reader.addEventListener("load", function(e){    //자바스크립트에서 파일을 읽는 것은 비동기
                img.src = e.target.result;
            })
        }
    })

    //비밀번호 유효성 검사
    cafePassword.addEventListener("focusout", function(event){
        cafePasswordmsg.innerHTML = '';
        //비밀번호가 입력됐는지 유효성 검사
        if(cafePassword.value.trim().length < 1){
            cafePasswordmsg.innerHTML = '비밀번호는 필수 입력입니다.<br/>';
        //비밀번호 입력 형식을 올바르지 않을 경우의 유효성 검사
        }else{
            var passwordRegExp = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
			if(!passwordRegExp.test(cafePassword.value.trim())){
				cafePasswordmsg.innerHTML = '비밀번호는 숫자와 영문 대소문자, 특수문자가 포함된 8~15자리여야 합니다.<br/>';
			}
        }
    })
    //첫 번째와 두 번째 비밀번호가 같지 않을 경우 유효성 검사
    cafePassword1.addEventListener("focusout", function(event){
        cafePasswordmsg.innerHTML = '';
        if(cafePassword.value.trim() !== cafePassword1.value.trim()){
            cafePasswordmsg.innerHTML = '2개의 비밀번호는 같아야 합니다.<br/>';
        }
    })

    //주소 유효성 검사
    cafeAddress.addEventListener("focusout", function(event){
        cafeAddressmsg.innerHTML = '';
        if(cafeAddress.value.trim().length < 1){
            cafeAddressmsg.innerHTML = '주소는 필수 입력입니다.<br/>';
        }
    })

    //카페 전화번호 유효성 검사
    cafePhoneNum.addEventListener("focusout", function(event){
        cafePhoneNummsg.innerHTML = '';
        if(cafePhoneNum.value.trim().length < 1){
            cafePhoneNummsg.innerHTML = '전화번호는 필수 입력입니다.<br/>';
        }
    })

    //카페 테이블 수 유효성 검사
    cafeTableNum.addEventListener("focusout", function(event){
        cafeTableNummsg.innerHTML = '';
        if(cafeTableNum.value.trim().length < 1){
            cafeTableNummsg.innerHTML = '테이블 수는 필수 입력입니다.<br/>';
        }
    });

    //카페 설명 유효성 검사
    cafeCommentary.addEventListener("focusout", function(event){
        cafeCommentarymsg.innerHTML = '';
        if(cafeCommentary.value.trim().length < 1){
            cafeCommentarymsg.innerHTML = '카페 설명은 필수 입력입니다.<br/>';
        }
    });

    //홈페이지 유효성 검사
    var homepageRefExp = /(http(s)?:\/\/)([a-z0-9\w]+\.*)+[a-z0-9]{2,4}/;
    cafeHomepage.addEventListener("focusout", function(event){
        cafeHomepagemsg.innerHTML = '';
        if(cafeHomepage.value.trim().length < 1){
        }else if(!homepageRefExp.test(cafeHomepage.value.trim())){
            cafeHomepagemsg.innerHTML = '홈페이지의 형식이 잘못되었습니다.<br/>';
        }
    });

    //유효성 검사에 통과하지 못했을 때를 확인하기 위한 변수 생성
    var flag = false;

    //카페 정보 수정 버튼을 눌렀을 때 이벤트 처리
    updatebtn.addEventListener("click", function(event){
        cafeAddressmsg.innerHTML = '<br/>';
        cafePasswordmsg.innserHTML = '<br/>';
        cafePhoneNummsg.innserHTML = '<br/>';
        cafeTableNummsg.innserHTML = '<br/>';
        cafeHomepagemsg.innserHTML = '<br/>';
        cafeSNSmsg.innserHTML = '<br/>';
        cafeCommentarymsg.innserHTML = '<br/>';

        //비밀번호 유효성 검사
        //비밀번호를 입력하지 않았을 경우 유효성 검사
        if(cafePassword.value.trim().length < 1){
            cafePasswordmsg.innerHTML = '비밀번호는 필수 입력입니다.<br/>';
            flag = true;
        }else{
            //정규식에 해당되지 않았을 경우 유효성 검사
            var passwordRegExp = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
            if(!passwordRegExp.test(cafePassword.value.trim())){
                cafePasswordmsg.innerHTML = '비밀번호는 숫자와 영문 대소문자, 특수문자가 포함된 8~15자리여야 합니다.<br/>';
                flag = true;
            //첫 비밀번호와 두 번째 비밀번호가 같은지 유효성 검사
            }else{
                if(cafePassword.value.trim() !== cafePassword1.value.trim()){
                    cafePasswordmsg.innerHTML = '2개의 비밀번호는 같아야 합니다.<br/>';
                    flag = true;
                }
            }

        }

        //주소 유효성 검사
        if(cafeAddress.value.trim().length < 1){
            cafeAddressmsg.innerHTML = '주소는 필수 입력입니다.<br/>';
            flag = true;
        }

        //카페 전화번호 유효성 검사
        cafePhoneNummsg.innerHTML = '';
        if(cafePhoneNum.value.trim().length < 1){
            cafePhoneNummsg.innerHTML = '전화번호는 필수 입력입니다.<br/>';
            flag = true;
        }

        //카페 테이블 수 유효성 검사
        cafeTableNummsg.innerHTML = '';
        if(cafeTableNum.value.trim().length < 1){
            cafeTableNummsg.innerHTML = '테이블 수는 필수 입력입니다.<br/>';
            flag = true;
        }

        //홈페이지 유효성 검사
        cafeHomepagemsg.innerHTML = '';
        if(cafeHomepage.value.trim().length < 1){
        }else if(!homepageRefExp.test(cafeHomepage.value.trim())){
            cafeHomepagemsg.innerHTML = '홈페이지의 형식이 잘못되었습니다.<br/>';
            flag = true;
        }

        //카페 설명 유효성 검사
        cafeCommentarymsg.innerHTML = '';
        if(cafeCommentary.value.trim().length < 1){
            cafeCommentarymsg.innerHTML = '카페 설명은 필수 입력입니다.<br/>';
            flag = true;
        }

        //유효성 검사에 실패한 경우
        if(flag == true){
            return;
        }

        //update요청 준비
        var url = "update";                         //요청할 URL
        var request = new XMLHttpRequest();         //요청 전송할 객체 생성
        request.open('POST', url, true);            //요청 생성
        var formData = new FormData(updateform);    //요청 내용 formData 객체 생성
        request.send(formData);                     //요청 전송

        //update 요청 응답이 온 경우 처리
        request.addEventListener("load", function(e){
            var obj = JSON.parse(e.target.responseText);
            if(obj.result == true){
                location.href = "../cafe/logout";
            }else{
                msg.innerHTML = "회원 정보 수정에 실패하였습니다.";
            }
        })
    })
})


