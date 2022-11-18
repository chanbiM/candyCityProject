var slide = $("#slide>ul>li>a>img");
var sno = 0;
var eno = slide.length - 1;

var timer = setInterval("autoslide()", 3000);

function autoslide() {
    $(slide[sno]).stop().animate({
      left: "100%", opacity: 0 
    }, 1000, function() {
        $(this).css({left: "-100%"});
    });
    sno++;
    if(sno > eno){
        sno = 0;
    }
    $(slide[sno]).stop().animate({
        left: "0", opacity: 1
    }, 1000);
}

$(".slide").hover(
    function() {
        clearInterval(timer)
    },
    function(){
        timer=setInterval("autoslide()", 3000);
    }
);

/*
    탭 구현
*/

$("#post_tab").click(function(){
    $(".tab > div").removeClass("active")
    $("#post_tab").addClass("active")

    $("#event").hide();
    $("#post").show();
})

$("#event_tab").click(function(){
    $(".tab > div").removeClass("active")
    $("#event_tab").addClass("active")

    $("#post").hide();
    $("#event").show();
})

/* 
    메뉴 관련 이벤트 설정
*/



$(".mainmenu > li").mouseover(function (){
     $(this).children(".submenu").stop().slideDown();
 })

$(".mainmenu > li").mouseleave(function (){ // 마우스가 떠나면
    $(".submenu").stop().slideUp(); // slideUp = 올라가는 애니메이션
})


// 비밀번호 변경 팝업
$(".open_popup").click(function(){
    $(".popup_back").show()
})

// 팝업의 '닫기' 버튼 클릭시
$(".popup_close").click(function(){
    $(".popup_back").hide()
})

//탈퇴 팝업
$(".open_popup_del").click(function(){
    $(".popup_back_del").show()
})

// 팝업의 '닫기' 버튼 클릭시
$(".popup_close").click(function(){
    $(".popup_back_del").hide()
})
