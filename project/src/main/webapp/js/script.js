$(function(){
    $('.depth1 > li').on('mouseover',function(){
        $(this).find('.depth2').stop().slideDown();
    }).on('mouseleave',function(){
        $(this).find('.depth2').stop().slideUp();
    });

    

    // section
    // $('.section > img').mouseover(function() {
    //     $(this).css('margin','-3px');
    //     $(this).css('border','3px solid #999');
    // }).mouseout(function() {
    //     $(this).css('margin','0px');
    //     $(this).css('border','none');
    // });
    

    // 퀵메뉴
    var q_left = $(".menu >ul:first-child").position().left + 1200;
    var q_top = $(".menu >ul:first-child").position().top;
    $('#quickMenu').css({
        left : q_left,
        top : q_top
    });

    // 퀵메뉴 따라가게
    $(window).scroll(function(){
        var scrollTop = $(window).scrollTop();
        var q_top_new = scrollTop + q_top;
        // $('#quickMenu').css('top',q_top_new);
        $('#quickMenu').stop().animate({
            top:q_top_new
        }, 500);
    });

    // top으로
    $("#goTop").click(function(){
        $('html').animate({scrollTop:0},300);
    });

    

});