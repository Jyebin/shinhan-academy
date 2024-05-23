$(function(){
    // swiper
    var swiper = new Swiper('.swiper-visual',{
        autoplay : {
            delay:3000
        },
        loop : true
    });
    $("#popup").css({
        top:(($(window).height()-$("#popup").outerHeight())/2 + $(window).scrollTop())+'px',
        left:(($(window).width()-$("#popup").outerWidth())/2 + $(window).scrollLeft())+'px',
    });
    $("#popup").draggable();
    $('.board_title').click(function() {
        $('.board_title').removeClass("on");
        $(this).addClass('on');
        if ($(this).text() == '공지사항') {
            $("#board_data").hide();
            $("#board_notice").show();
        } else if ($(this).text() == '자료실') {
            $("#board_data").show();
            $("#board_notice").hide();
        }
    });
});