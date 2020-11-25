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
        if(this.file && this.files[0]){
            var filename = this.files[0].name;
            var reader = new FileReader();
            reader.addEventListener("load", function(e){
                img.src = e.target.result;
            })
            reader.readAsDataURL(this.files[0]);
        }
    })
})

