(function($) {
    $.fn.jsOrder = function(setting) {
        //初始化配置
        var opts = $.extend( {}, $.fn.jsOrder.defaults, setting);
        //读取cookie信息
        var initData ={};
        if(opts.saveCookie && $.cookie(opts.cookieName)!=null&&$.cookie(opts.cookieName)!=''){
            initData = eval('(' + $.cookie(opts.cookieName) + ')');
        }
        //初始化购物车
        $("body").data(opts.staticName, initData);
        //初始化页面
        var body="";
        var jsOrder = $('<div><div>' + opts.leftDemo + '</div><div><ul><li style="text-align:center">'+ opts.noMessage + '</li></ul><div></div></div></div>').attr('class', opts.jsOrderClass).appendTo($("body"));
        var jsOrderRight = jsOrder.find('div:eq(1)').attr('class', 'right');
        var jsOrderLeft = jsOrder.find('div:eq(0)').attr('class', 'left').click(function() {jsOrderRight.toggle();});
        var slide = {
            //计算金额和数量
            info : function(price, count) {
                return "￥" + price * 10000 * count / 10000 + "(数量:" + count+ ")";
            },
            //增加一个订单项
            addJsOrder : function(e) {
                var dateJsOrder = $("body").data(opts.staticName);
                var id = $(this).attr('id');
                var name = $(this).attr(opts.nameFiled);
                var price = $(this).attr(opts.priceFiled);
                if (dateJsOrder[id] == null || dateJsOrder[id]['count'] == 0) {
                    if (dateJsOrder[id] == null) {
                        dateJsOrder[id] = {};
                    }
                    dateJsOrder[id]['count'] = 1;
                    dateJsOrder[id]['name'] = name;
                    dateJsOrder[id]['price'] = price;
                    $("div." + opts.jsOrderClass + " ul")
                        .append("<li id='"+ opts.jsOrderPre+ id+ "'><span>"+ name+ "<br><b>"+ slide.info(price,dateJsOrder[id]['count'])+ "</b><span  class='del'></span><span  class='sub'></span><span class='add'></span></span></li>");
                    $("#" + opts.jsOrderPre + id + " span.add").click(function() {
                        slide.addJsOrderNum(name, id, price);
                    });
                    $("#" + opts.jsOrderPre + id + " span.sub").click(function() {
                        slide.delJsOrderNum(name, id, price);
                    });
                    $("#" + opts.jsOrderPre + id + " span.del").click(function() {
                        slide.delJsOrder(id);
                    });
                } else {
                    dateJsOrder[id]['count'] += 1;
                    $("#" + opts.jsOrderPre + id + " b").html(
                        slide.info(price, dateJsOrder[id]['count']));
                }
                slide.refresh();
            },
            //增加一个订单项数量
            addJsOrderNum : function(name, id, price) {
                var dateJsOrder = $("body").data(opts.staticName);
                dateJsOrder[id]['count'] += 1;
                $("#" + opts.jsOrderPre + id + " b").html(
                    slide.info(price, dateJsOrder[id]['count']));
                slide.refresh();
            },
            //减少一个订单项数量
            delJsOrderNum : function(name, id, price) {
                var dateJsOrder = $("body").data(opts.staticName);
                dateJsOrder[id]['count'] -= 1;
                if (dateJsOrder[id]['count'] > 0) {
                    $("#" + opts.jsOrderPre + id + " b").html(
                        slide.info(price, dateJsOrder[id]['count']));
                } else {
                    $("#" + opts.jsOrderPre + id).remove();
                }
                slide.refresh();
            },
            //删除一个订单项
            delJsOrder : function(id) {
                var dateJsOrder = $("body").data(opts.staticName);
                dateJsOrder[id]['count'] = 0;
                $("#" + opts.jsOrderPre + id).remove();
                slide.refresh();
            },
            //提交
            submitJs : function() {
                opts.doSubmit($("body").data(opts.staticName));
                $("body").data(opts.staticName,{});
                $("div."+opts.jsOrderClass+" ul li:eq(0)").show();
                $("div."+opts.jsOrderClass+" ul li:gt(0)").remove();
                $('div.'+opts.jsOrderClass+' a.button').remove();
                if(opts.saveCookie){
                    var date = new Date();
                    date.setTime(date.getTime() - (1 * 24 * 60 * 60 ));
                    $.cookie(opts.cookieName, '', { path: '/', expires: date });
                }
            },
            //刷新购物车
            refresh : function() {
                jsOrderRight.show();
                var data = $("body").data(opts.staticName);
                var size = 0;
                for ( var i in data) {
                    if (data[i]['count'] != 0)
                        size++;
                }
                if (size > 0) {
                    $("div."+opts.jsOrderClass+" ul li:eq(0)").hide();
                    if ($('div.' + opts.jsOrderClass + ' a.button').size() == 0)
                        $('<a class="button">' + opts.subButton + '</a>')
                            .appendTo(jsOrderRight).click(slide.submitJs);
                } else {
                    $("div."+opts.jsOrderClass+" ul li:eq(0)").show();
                    $('div.' + opts.jsOrderClass + ' a.button').remove();
                }
                if (opts.saveCookie) {
                    var date = new Date();
                    date.setTime(date.getTime() + (1 * 24 * 60 * 60 * 1000));
                    $.cookie(opts.cookieName, JSON.stringify(data), {
                        path : '/',
                        expires : date
                    });
                }
            }
        };
        //初始化购物车
        var data = $("body").data(opts.staticName);
        for ( var id in data) {
            $("div." + opts.jsOrderClass + " ul")
                .append("<li id='"+ opts.jsOrderPre+ id+ "'><span>"+ data[id]['name']+ "<br><b>"+ slide.info(data[id]['price'],data[id]['count'])+ "</b><span  class='del'></span><span  class='sub'></span><span class='add'></span></span></li>");
            $("#" + opts.jsOrderPre + id + " span.add").click(function() {slide.addJsOrderNum(data[id]['name'], data[id], data[id]['price']);});
            $("#" + opts.jsOrderPre + id + " span.sub").click(function() {slide.delJsOrderNum(data[id]['name'], data[id],data[id]['price']);});
            $("#" + opts.jsOrderPre + id + " span.del").click(function() {slide.delJsOrder(data[id]);});
            slide.refresh();
        }
        $(opts.addButton).click(slide.addJsOrder);
        return jsOrder;
    }
    // 配置
    $.fn.jsOrder.defaults = {
        //全局数据-保存订单信息-通过jQuery绑定在body
        staticName : 'jsOrder',
        //订单class，确保在页面class唯一不重复，否则将导致错误
        jsOrderClass : 'jsOrder',
        //是否保存cookie
        saveCookie : true,
        //cookie的名字
        cookieName : 'jsOrder',
        //ID前缀，暂时无用
        numPre : 'no_',
        //订单项前缀，用来区分不同的订单项，页面内必须不重复
        jsOrderPre : 'jsOrder_',
        //触发订单控件的价格属性
        priceFiled : 'price',
        //触发订单控件的订单名属性
        nameFiled : 'jsOrderName',
        //购物车左侧显示
        leftDemo : '我的购物车',
        //提交按钮文字
        subButton : '',
        //默认加入订单的控件选择
        addButton : 'a.jsOrderAdd',
        //没有订单时显示
        noMessage : '是还空的',
        //提交时触发
        doSubmit : function(data) {
            $("body").append(JSON.stringify(data));
            $("body").data(opts.staticName, {});
        }
    };
})(jQuery);