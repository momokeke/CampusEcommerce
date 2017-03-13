/**
 * Created by momomo on 2017/3/12.
 */
$(function() {
    //$(".tc").hide();
    var PId = $("#PId").val(); // 商品的ID
    var PName = $("#PName").text(); // 商品名称
    var PShop = $("#PShop").text(); //商品的店铺
    var PPrice = $("#PPrice").text(); // 商品价格
    var PNum = $("#PNum").val();
    var jsonStr = "[{'PId':'" + PId + "','PName':'" + PName + "','PShop':'" + PShop + "','PPrice':'" + PPrice + "','PNum':'" + PNum + "'}]";
    //将商品放入购物车
    //生成一个cookie
    $("#putCart").click(function () {
        setCookie(PId, jsonStr);
    });
    var setCookie = function (name, value, options) {
        if (typeof value != 'undefined') { //name 和 value 已经存在购物车，设置cookie
            options = options || {};
            if (value === null) {
                value = '';
                options.expires = -1;//???
            }
            var expires = '';
            if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
                var date;
                if (typeof options.expires == 'number') {
                    date = new Date();
                    date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
                } else {
                    date = options.expires;
                }
                expires = '; expires=' + date.toUTCString(); // use expires attribute, max-age is not supported by IE
            }
            var path = options.path ? '; path=' + options.path : '';
            var domain = options.domain ? '; domain=' + options.domain : '';
            var secure = options.secure ? '; secure' : '';
            document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
        } else { // only name given, get cookie
            var cookieValue = null;
            if (document.cookie && document.cookie != '') {
                var cookies = document.cookie.split(';');
                for (var i = 0; i < cookies.length; i++) {
                    var cookie = jQuery.trim(cookies[i]);
                    // Does this cookie string begin with the name we want?
                    if (cookie.substring(0, name.length + 1) == (name + '=')) {
                        cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                        break;
                    }
                }
            }
            return cookieValue;
        }
    }});

