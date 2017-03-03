/**
 * Created by Administrator on 2017/3/1.
 */
//验证输入的店铺名和所属社团
function checksname()
{
    var oName1 = document.getElementById("inputName3");//获取店铺和社团元素，此时为一个集合
    oName1.value = "";//一旦点击input，文本框中的内容为空
    //失去焦点，点击下一个文本框时，确认上一个文本框输入是否为空
    oName1.onblur = function () {
        check(oName1, oName1.nextElementSibling, "输入不可为空，请重新输入");
    }
}
function checkuname()
{
    var oName2 = document.getElementById("inputClub3");//获取店铺和社团元素，此时为一个集合
    oName2.value = "";//一旦点击input，文本框中的内容为空
    //失去焦点，点击下一个文本框时，确认上一个文本框输入是否为空
    oName2.onblur = function () {
        check(oName2, oName2.nextElementSibling, "输入不可为空，请重新输入");
    }
}
function checkpass()
{
    var oPassword=document.getElementById("inputPassword3");
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
    var rePass=document.getElementById("inputrePassword3");
    var oPassword=document.getElementById("inputPassword3");
    rePass.value="";
    rePass.onblur=function () {
        if(rePass.value!=oPassword.value)
        {
            alert("两次输入密码不同");
        }

        check(rePass,rePass.nextElementSibling,"请再次输入您的密码");

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
            }else{
                alert("手机号码输入错误");
            }
        }
}
function check(node,siblingNode,msg)
{
    if(!node.value||node.value=="您的店铺名"||node.value=="所属社团"||node.value=="设置您的登录密码")
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
    for(var i=0;i<2;i++)
    {
        var str=i==0?"输入不可为空，请重新输入":"请设置您的密码";
        if(check(inputNode[i],inputNode[i].nextSibling,str)&&i==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}