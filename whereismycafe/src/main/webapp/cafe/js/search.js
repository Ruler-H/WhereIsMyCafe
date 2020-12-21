window.addEventListener("load", function(event){
    //list 요청 준비
    var url = "list";                       //요청할 URL
    var request = new XMLHttpRequest();     //요청 전송할 객체
    request.open('POST', url, true);        //요청 생성
    request.send();                 //요청 전송
})