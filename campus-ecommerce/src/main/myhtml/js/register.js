/**
 * Created by Administrator on 2017/3/3.
 */
//验证输入的店铺名和所属社团
function checksname()
{
    var oName1 = document.getElementById("shop_name");//获取店铺和社团元素，此时为一个集合
    oName1.value = "";//一旦点击input，文本框中的内容为空
    //失去焦点，点击下一个文本框时，确认上一个文本框输入是否为空
    oName1.onblur = function () {
        check(oName1, oName1.nextElementSibling, "输入不可为空，请重新输入");
    }
}
function checkbname()
{
    var oName1 = document.getElementById("name");//获取买家姓名元素，此时为一个集合
    oName1.value = "";//一旦点击input，文本框中的内容为空
    //失去焦点，点击下一个文本框时，确认上一个文本框输入是否为空
    oName1.onblur = function () {
        check(oName1, oName1.nextElementSibling, "输入不可为空，请重新输入");
    }
}
function checkuname()
{
    var oName2 = document.getElementById("username");//获取店铺和社团元素，此时为一个集合
    oName2.value = "";//一旦点击input，文本框中的内容为空
    //失去焦点，点击下一个文本框时，确认上一个文本框输入是否为空
    oName2.onblur = function () {
        check(oName2, oName2.nextElementSibling, "输入不可为空，请重新输入");
    }
}
function checkcard()
{
    var oName3= document.getElementById("card");//获取店铺和社团元素，此时为一个集合
    oName3.value = "";//一旦点击input，文本框中的内容为空
    //失去焦点，点击下一个文本框时，确认上一个文本框输入是否为空
    oName3.onblur = function () {
        check(oName3, oName3.nextElementSibling, "输入不可为空，请重新输入");
    }
}
function checkpass()
{
    var oPassword=document.getElementById("password");
    oPassword.value="";
    oPassword.onblur=function()
    {
        check(oPassword,oPassword.nextElementSibling,"请设置您的密码");
        if(oPassword.value.length<=8){
            alert("密码长度不可小于8位");
        }
    }
}
function recheckpass() {
    var rePass=document.getElementById("re_password");
    var oPassword=document.getElementById("password");
    rePass.value="";
    rePass.onblur=function () {
        if(rePass.value!=oPassword.value)
        {
            alert("两次输入密码不同");
        }

        check(rePass,rePass.nextElementSibling,"请再次输入您的密码");

    }
}
function checkemail(){
    var x=document.forms["myForm"]["email"].value;
    var atpos=x.indexOf("@");
    var dotpos=x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length){
        alert("不是一个有效的 e-mail 地址");
        return false;
    }
}
function checkphone() {
    var oPhone=document.getElementById("phone");
    oPhone.value="";
    oPhone.onblur=function()
    {
        var re=/^1[358]\d{9}$/
        if(re.test(oPhone.value)){
            alert("手机号码输入正确");
            return true;
        }else{
            alert("手机号码输入错误");
            return false;
        }
    }
}

function check(node,siblingNode,msg)
{
    if(!node.value)
    {
        node.value="";
        if(siblingNode!=null)
        {
            show(siblingNode,msg);
        }
        return false;
    }return true;
}
function show(node,str)
{
    node.innerHTML=str;
    node.style.color="red";
}
function checkAll()
{
    var inputNode=document.getElementsByTagName("input");
    for(var i=0;i<4;i++)
    {
        var str=i==0||i==1||i==2?"输入不可为空，请重新输入":"请设置您的密码";
        if(check(inputNode[i],inputNode[i].nextSibling,str)&&i==3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}