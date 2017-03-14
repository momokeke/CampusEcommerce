/**
 * Created by momomo on 2017/3/11.
 */
$(document).ready(function($) {
    $('.theme-logIn').hover(function(){
        $('.theme-popover-mask').fadeIn(100);
        $('.theme-popover').slideDown(200);
    })
    $('.theme-popTit .close').click(function(){
        $('.theme-popover-mask').fadeOut(100);
        $('.theme-popover').slideUp(200);
    })

    $('.theme-selectCampus').hover(function(){
        $('.theme-campus').fadeIn(100);
        $('.theme-campus-mask').slideDown(200);
    })
    $('.theme-campusTit .close').click(function(){
        $('.theme-popover-mask').fadeOut(100);
        $('.theme-popover').slideUp(200);
    })

})