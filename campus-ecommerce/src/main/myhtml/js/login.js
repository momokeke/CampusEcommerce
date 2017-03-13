/**
 * Created by momomo on 2017/3/11.
 */
jQuery(document).ready(function($) {
    $('.theme-logIn').click(function(){
        $('.theme-popover-mask').fadeIn(100);
        $('.theme-popover').slideDown(200);
    })
    $('.theme-popTit .close').click(function(){
        $('.theme-popover-mask').fadeOut(100);
        $('.theme-popover').slideUp(200);
    })

})