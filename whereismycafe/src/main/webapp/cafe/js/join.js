window.addEventListener("load", function(event){
    //필요한 DOM 객체 가져오기
    var joinform = document.getElementById("joinform");
    
    //cafe 테이블 관련 DOM 객체
    var cafeAddress = document.getElementById("cafeAddress");
    var cafeName = document.getElementById("cafeName");
    var cafeNickname = document.getElementById("cafeNickname");
    var cafePassword = document.getElementById("cafePassword");
    var cafePassword1 = document.getElementById("cafePassword1");
    var cafePhoneNum = document.getElementById("cafePhoneNum");
    var cafeTableNum = document.getElementById("cafeTableNum");
    var outdoorTableNum = document.getElementById("outdoorTableNum");
    var concentTableNum = document.getElementById("concentTableNum");
    var cafeHomepage = document.getElementById("cafeHomepage");
    var cafeSNS = document.getElementById("cafeSNS");
    var cafeCommentary = document.getElementById("cafeCommentary");
    var cafeLogo = document.getElementById("cafeLogo");
    var img = document.getElementById("img");
    var cafeImage = document.getElementById("cafeImage");
    var imgs = document.getElementById("imgs");
    var cafeParking = document.getElementById("cafeParking");
    var cafeRefill = document.getElementById("cafeRefill");
    var cafeCoupon = document.getElementById("cafeCoupon");
    var noKidsZone = document.getElementById("noKidsZone");
    var sirenOrder = document.getElementById("sirenOrder");
    var tumblerDiscount = document.getElementById("tumblerDiscount");
    var cafeWifi = document.getElementById("cafeWifi");
    
    //button DOM 객체
    var joinbtn = document.getElementById("joinbtn");
    var mainbtn = document.getElementById("mainbtn");
    var loginbtn = document.getElementById("loginbtn");
    
    //화면에 출력될 메시지 DOM 객체
    var msg = document.getElementById("msg");
    var cafeAddressmsg = document.getElementById("cafeAddressmsg");
    var cafeNamemsg = document.getElementById("cafeNamemsg");
    var cafeNicknamemsg = document.getElementById("cafeNicknamemsg");
    var cafePasswordmsg = document.getElementById("cafePasswordmsg");
    var cafePhoneNummsg = document.getElementById("cafePhoneNummsg");
    var cafeTableNummsg = document.getElementById("cafeTableNummsg");
    var cafeHomepagemsg = document.getElementById("cafeHomepagemsg");
    var cafeSNSmsg = document.getElementById("caeSNSmsg");
    var cafeCommentarymsg = document.getElementById("cafeCommentarymsg");

    //메시지가 빨강색으로 출력되도록 설정
    cafeAddressmsg.style.color = "RED";
    cafePasswordmsg.style.color = "RED";
    cafeNicknamemsg.style.color = "RED";
    cafeNamemsg.style.color = "RED";
    cafePhoneNummsg.style.color = "RED";
    cafeTableNummsg.style.color = "RED";
    cafeHomepagemsg.style.color = "RED";
    cafeCommentarymsg.style.color = "RED";
    cafeSNSmsg.style.color = "RED";

	//mainbtn을 눌렀을 때 페이지 이동 처리
	mainbtn.addEventListener("click", function(event){
		location.href="../";
    });
    
    //loginbtn을 눌렀을 때 페이지 이동 처리
	loginbtn.addEventListener("click", function(event){
		location.href="login";
    });
    
    //cafeLogo 미리보기 처리
    cafeLogo.addEventListener("change", function(event){
        if(this.files && this.files[0]){					//선택한 파일이 있는 경우 처리
			var reader = new FileReader();					//파일 읽기 객체
			reader.readAsDataURL(this.files[0]);			//파일 읽기 요청
			reader.addEventListener("load", function(e){	//자바스크립트에서 파일을 읽는 것은 비동기
				img.src = e.target.result;
            });
        }
    });

    //비밀번호 유효성 검사
    cafePassword.addEventListener("focusout", function(event){
        cafePasswordmsg.innerHTML = '';
        if(cafePassword.value.trim().length < 1){
			cafePasswordmsg.innerHTML = '비밀번호는 필수 입력입니다.<br/>';
		}else{
			var passwordRegExp = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
			if(!passwordRegExp.test(cafePassword.value.trim())){
				cafePasswordmsg.innerHTML = '비밀번호는 숫자와 영문 대소문자, 특수문자가 포함된 8~15자리여야 합니다.<br/>';
			}
		}
    });
    cafePassword1.addEventListener("focusout", function(event){
        cafePasswordmsg.innerHTML = '';
        if(cafePassword.value.trim() !== cafePassword1.value.trim()){
            cafePasswordmsg.innerHTML = '2개의 비밀번호는 같아야 합니다.<br/>';
        }
    });

    //닉네임 유효성 검사
    cafeNickname.addEventListener("focusout", function(event){
        cafeNicknamemsg.innerHTML = '';
        if(cafeNickname.value.trim().length < 1){
            cafeNicknamemsg.innerHTML = '닉네임은 필수 입력입니다.<br/>';
        }else{
            var nicknameRefExp = /^[a-zA-Z가-힣0-9]{2,10}$/;
            if(!nicknameRefExp.test(cafeNickname.value.trim())){
                cafeNicknamemsg.innerHTML = '닉네임은 영문, 한글, 숫자로 2자 이상 10자 이하이어야 합니다.<br/>';
            }
        }
    });

    //주소 유효성 검사
    cafeAddress.addEventListener("focusout", function(event){
        cafeAddressmsg.innerHTML = '';
        if(cafeAddress.value.trim().length < 1){
            cafeAddressmsg.innerHTML = '주소는 필수 입력입니다.<br/>';
        }
    });

    //카페 이름 유효성 검사
    cafeName.addEventListener("focusout", function(event){
        cafeNamemsg.innerHTML = '';
        if(cafeName.value.trim().length < 1){
            cafeNamemsg.innerHTML = '카페 이름은 필수 입력입니다.<br/>';
        }
    });

    //카페 전화번호 유효성 검사
    cafePhoneNum.addEventListener("focusout", function(event){
        cafePhoneNummsg.innerHTML = '';
        if(cafePhoneNum.value.trim().length < 1){
            cafePhoneNummsg.innerHTML = '전화번호는 필수 입력입니다.<br/>';
        }
    });

    //카페 테이블 수 유효성 검사
    cafeTableNum.addEventListener("focusout", function(event){
        cafeTableNummsg.innerHTML = '';
        if(cafeTableNum.value.trim().length < 1){
            cafeTableNummsg.innerHTML = '테이블 수는 필수 입력입니다.<br/>';
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

    //카페 설명 유효성 검사
    cafeCommentary.addEventListener("focusout", function(event){
        cafeCommentarymsg.innerHTML = '';
        if(cafeCommentary.value.trim().length < 1){
            cafeCommentarymsg.innerHTML = '카페 설명은 필수 입력입니다.<br/>';
        }
    });

    //joinbtn을 눌렀을 때 회원가입 처리
    joinbtn.addEventListener("click", function(event){
        //유효성을 모두 통과했는지 확인할 변수 생성
        var flag = false;

        //비밀번호 유효성 검사
        cafePasswordmsg.innerHTML = '';
        if(cafePassword.value.trim().length < 1){
            cafePasswordmsg.innerHTML = '비밀번호는 필수 입력입니다.<br/>';
            flag = true;
        }else{
            var passwordRegExp = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
            if(!passwordRegExp.test(cafePassword.value.trim())){
                cafePasswordmsg.innerHTML = '비밀번호는 숫자와 영문 대소문자, 특수문자가 포함된 8~15자리여야 합니다.<br/>';
                flag = true;
            }else{
                if(cafePassword.value.trim() !== cafePassword1.value.trim()){
                    cafePasswordmsg.innerHTML = '2개의 비밀번호는 같아야 합니다.<br/>';
                    flag = true;
                }
            }
        }

        //닉네임 유효성 검사
        cafeNicknamemsg.innerHTML = '';
            if(cafeNickname.value.trim().length < 1){
                cafeNicknamemsg.innerHTML = '닉네임은 필수 입력입니다.<br/>';
                flag = true;
            }else{
                var nicknameRefExp = /^[a-zA-Z가-힣0-9]{2,10}$/;
                if(!nicknameRefExp.test(cafeNickname.value.trim())){
                    cafeNicknamemsg.innerHTML = '닉네임은 영문, 한글, 숫자로 2자 이상 10자 이하이어야 합니다.<br/>';
                    flag = true;
                }
            }

        //주소 유효성 검사
        cafeAddressmsg.innerHTML = '';
        if(cafeAddress.value.trim().length < 1){
            cafeAddressmsg.innerHTML = '주소는 필수 입력입니다.<br/>';
            flag = true;
        }

        //카페 이름 유효성 검사
        cafeNamemsg.innerHTML = '';
        if(cafeName.value.trim().length < 1){
            cafeNamemsg.innerHTML = '카페 이름은 필수 입력입니다.<br/>';
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

        //join요청 준비
        var url = "join";						//요청할 URL
		var request = new XMLHttpRequest();		//요청 전송할 객체
		request.open('POST', url, true);		//요청 생성
		var formData = new FormData(joinform);	//요청의 내용인 formData 객체 생성
		request.send(formData);					//요청 전송

		//join 요청 응답이 온 경우 처리
		request.addEventListener("load", function(e){
			var obj = JSON.parse(e.target.responseText);
            cafeNicknamemsg.innerHTML = '';
			if(obj.result == true){
				location.href = "../";
			}else{
				if(obj.cafeNicknamecheck == false){
					cafeNicknamemsg.innerHTML = '이미 사용 중인 닉네임';
				}
			}
		})
    });
    
});