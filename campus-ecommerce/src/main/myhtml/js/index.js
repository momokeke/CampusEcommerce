/**
 * Created by Administrator on 2017/3/1.
 */
function changeName() {
    var dtNode=document.getElementById("buyername").innerHTML;
    var str=dtNode.substr(1,1);
    var str1=dtNode.replace(str,"*");
    document.getElementById("buyername").innerHTML=str1;
}
window.onload=function(){
    changeName();
}


