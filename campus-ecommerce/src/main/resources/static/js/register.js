
function display(){document.querySelector('.img__btn').addEventListener('click', function() {
    document.querySelector('.cont').classList.toggle('s--signup');
});}
function checkEmail(sibling,str){
    var reg =/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    if (!reg.test(str)){
        sibling.style.display="inline"; sibling.innerHTML="邮箱格式不正确！";return false;
    }
    else return true;
}
function checkMobile(sibling,str){
    var mobileZhengZe=/^1[3587]\d{9}$/;
    if(!mobileZhengZe.test(str)){sibling.style.display="inline"; sibling.innerHTML="电话号码格式错误！";return false;}
    else return true;
}
function show(sibling,inputNode){
    switch(inputNode.name){
        case "name":sibling.innerHTML="请输入用户名！";break;
        case "studentNumber":sibling.innerHTML="请输入学号！";break;
        case "password":sibling.innerHTML="请设置密码！";break;
        case "repass":sibling.innerHTML="请确认密码！";break;
        case "email":sibling.innerHTML="请输入邮箱地址！";break;
        case "address":sibling.innerHTML="请输入地址！";break;
        case "shopName":sibling.innerHTML="请输入注册的店铺名！";break;
        case "mobile":sibling.innerHTML="请输入电话号码！";
    }
}

function checkBuyerName(){
    var buyer_name=document.getElementById("buyer-register").getElementsByTagName("input")[0];
    buyer_name.onblur=function(){checkBuyer(this,this.nextSibling,buyer_name.value);}
    buyer_name.onfocus=function(){buyer_name.nextSibling.innerHTML="";}}
function checkBuyerStudentNumber(){
    var buyer_student_number=document.getElementById("buyer-register").getElementsByTagName("input")[1];
    buyer_student_number.onblur=function(){checkBuyer(this,this.nextSibling,buyer_student_number.value);}
    buyer_student_number.onfocus=function(){buyer_student_number.nextSibling.innerHTML="";}}
function checkBuyerPassword(){
    var buyer_password=document.getElementById("buyer-register").getElementsByTagName("input")[2];
    buyer_password.onblur=function(){checkBuyer(this,this.nextSibling,buyer_password.value);}
    buyer_password.onfocus=function(){buyer_password.nextSibling.innerHTML="";}}
function checkBuyerRepass(){
    var buyer_repass=document.getElementById("buyer-register").getElementsByTagName("input")[3];
    buyer_repass.onblur=function(){checkBuyer(this,this.nextSibling,buyer_repass.value);}
    buyer_repass.onfocus=function(){buyer_repass.nextSibling.innerHTML="";}}
function checkBuyerEmail(){
    var buyer_email=document.getElementById("buyer-register").getElementsByTagName("input")[4];
    buyer_email.onblur=function(){checkBuyer(this,this.nextSibling,buyer_email.value);}
    buyer_email.onfocus=function (){buyer_email.nextSibling.innerHTML="";}}
function checkBuyerAddress(){
    var buyer_address=document.getElementById("buyer-register").getElementsByTagName("input")[5];
    buyer_address.onblur=function(){checkBuyer(this,this.nextSibling,buyer_address.value);}
    buyer_address.onfocus=function (){buyer_address.nextSibling.innerHTML=""; }}
function checkBuyerMobile(){
    var buyer_mobile=document.getElementById("buyer-register").getElementsByTagName("input")[6];
    buyer_mobile.onblur=function(){checkBuyer(this,this.nextSibling,buyer_mobile.value);}
    buyer_mobile.onfocus=function () {buyer_mobile.nextSibling.innerHTML="";}}
function checkBuyer(inputNode,sibling,str){
    if(str==""){sibling.style.diaplay="inline"; show(sibling,inputNode); return false;}
    else if (inputNode.name=="repass"){var password=document.getElementById("buyer-register").getElementsByTagName("input")[2].value;if(str!=password){sibling.style.display="inline"; sibling.innerHTML="两次密码不一致！";return false;}else {sibling.style.color="green";sibling.style.display="inline"; sibling.innerHTML="验证通过";return true;}}
    else if(inputNode.name=="email"){if(!checkEmail(sibling,str)){return false;}return true;}
    else if(inputNode.name=="mobile"){if(!checkMobile(sibling,str)){return false;}return true;}
    else if (inputNode.name=="student_number"){inputNode.value=str.replace(/[^0-9-]+/,'');return true;}
    else if (inputNode.name=="password"){if(str.length< 6){sibling.innerHTML="密码至少为6位！";return false;}return true;}
    else{
        return true;
    }
}
function checkBuyerAll(){

    var buyer_name=document.getElementById("buyer-register").getElementsByTagName("input")[0];
    var buyer_student_number=document.getElementById("buyer-register").getElementsByTagName("input")[1];
    var buyer_password=document.getElementById("buyer-register").getElementsByTagName("input")[2];
    var buyer_repass=document.getElementById("buyer-register").getElementsByTagName("input")[3];
    var buyer_email=document.getElementById("buyer-register").getElementsByTagName("input")[4];
    var buyer_address=document.getElementById("buyer-register").getElementsByTagName("input")[5];
    var buyer_mobile=document.getElementById("buyer-register").getElementsByTagName("input")[6];
    if(
        !checkBuyer(buyer_name,buyer_name.nextSibling,buyer_name.value) ||
        !checkBuyer(buyer_student_number,buyer_student_number.nextSibling,buyer_student_number.value) ||
        !checkBuyer(buyer_password,buyer_password.nextSibling,buyer_password.value) ||
        !checkBuyer(buyer_repass,buyer_repass.nextSibling,buyer_repass.value) ||
        !checkBuyer(buyer_email,buyer_email.nextSibling,buyer_email.value) ||
        !checkBuyer(buyer_address,buyer_address.nextSibling,buyer_address.value) ||
        !checkBuyer(buyer_mobile,buyer_mobile.nextSibling,buyer_mobile.value)) {return false;}
    else {alert("注册成功！");return true;}

}

function checkSellerName(){
    var seller_name=document.getElementById("seller-register").getElementsByTagName("input")[0];
    seller_name.onblur=function(){checkSeller(this,this.nextSibling,seller_name.value);}
    seller_name.onfocus=function(){seller_name.nextSibling.innerHTML="";}}
function checkSellerStudentNumber(){
    var seller_student_number=document.getElementById("seller-register").getElementsByTagName("input")[1];
    seller_student_number.onblur=function(){checkSeller(this,this.nextSibling,seller_student_number.value);}
    seller_student_number.onfocus=function(){seller_student_number.nextSibling.innerHTML="";}}
function checkSellerPassword(){
    var seller_password=document.getElementById("seller-register").getElementsByTagName("input")[2];
    seller_password.onblur=function(){checkSeller(this,this.nextSibling,seller_password.value);}
    seller_password.onfocus=function(){seller_password.nextSibling.innerHTML="";}}
function checkSellerRepass(){
    var seller_repass=document.getElementById("seller-register").getElementsByTagName("input")[3];
    seller_repass.onblur=function(){checkSeller(this,this.nextSibling,seller_repass.value);}
    seller_repass.onfocus=function(){seller_repass.nextSibling.innerHTML="";}}
function checkSellerShopName(){
    var seller_shop_name=document.getElementById("seller-register").getElementsByTagName("input")[4];
    seller_shop_name.onblur=function(){checkSeller(this,this.nextSibling,seller_shop_name.value);}
    seller_shop_name.onfocus=function (){seller_shop_name.nextSibling.innerHTML="";}}
function checkSellerAddress(){
    var seller_address=document.getElementById("seller-register").getElementsByTagName("input")[5];
    seller_address.onblur=function(){checkSeller(this,this.nextSibling,seller_address.value);}
    seller_address.onfocus=function (){seller_address.nextSibling.innerHTML=""; }}
function checkSellerMobile(){
    var seller_mobile=document.getElementById("seller-register").getElementsByTagName("input")[6];
    seller_mobile.onblur=function(){checkSeller(this,this.nextSibling,seller_mobile.value);}
    seller_mobile.onfocus=function () {seller_mobile.nextSibling.innerHTML="";}}
function checkSeller(inputNode,sibling,str){
    if(str==""){sibling.style.diaplay="inline"; show(sibling,inputNode); return false;}
    else if (inputNode.name=="repass"){var password=document.getElementById("seller-register").getElementsByTagName("input")[2].value;if(str!=password){sibling.style.display="inline"; sibling.innerHTML="两次密码不一致！";return false;}else {sibling.style.color="green";sibling.style.display="inline"; sibling.innerHTML="验证通过";return true;}}
    else if(inputNode.name=="mobile"){if(!checkMobile(sibling,str)){return false;}return true;}
    else if (inputNode.name=="student_number"){inputNode.value=str.replace(/[^0-9-]+/,'');return true;}
    else if (inputNode.name=="password"){if(str.length< 6){sibling.innerHTML="密码至少为6位！";return false;}return true;}
    else{
        return true;
    }
}
function checkSellerAll(){

    var seller_name=document.getElementById("seller-register").getElementsByTagName("input")[0];
    var seller_student_number=document.getElementById("seller-register").getElementsByTagName("input")[1];
    var seller_password=document.getElementById("seller-register").getElementsByTagName("input")[2];
    var seller_repass=document.getElementById("seller-register").getElementsByTagName("input")[3];
    var seller_shop_name=document.getElementById("seller-register").getElementsByTagName("input")[4];
    var seller_address=document.getElementById("seller-register").getElementsByTagName("input")[5];
    var seller_mobile=document.getElementById("seller-register").getElementsByTagName("input")[6];
    if(
        !checkSeller(seller_name,seller_name.nextSibling,seller_name.value) ||
        !checkSeller(seller_student_number,seller_student_number.nextSibling,seller_student_number.value) ||
        !checkSeller(seller_password,seller_password.nextSibling,seller_password.value) ||
        !checkSeller(seller_repass,seller_repass.nextSibling,seller_repass.value) ||
        !checkSeller(seller_shop_name,seller_shop_name.nextSibling,seller_shop_name.value) ||
        !checkSeller(seller_address,seller_address.nextSibling,seller_address.value) ||
        !checkSeller(seller_mobile,seller_mobile.nextSibling,seller_mobile.value)) {return false;}
    else {alert("注册成功！");return true;}

}

window.onload=function(){
        display();
        checkBuyerName();checkBuyerStudentNumber();checkBuyerPassword();checkBuyerRepass();checkBuyerEmail();checkBuyerAddress();checkBuyerMobile();
        checkSellerName();checkSellerStudentNumber();checkSellerPassword();checkSellerRepass();checkSellerShopName();checkSellerAddress();checkSellerMobile();
    }

