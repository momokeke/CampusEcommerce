// JavaScript Document



/*改变所购商品的数量*/
function changeNum(productId,flag){/*num表示对应商品数量的文本框的值，flag表示是增加还是减少商品数量*/
    var productNum = parseInt($("#product-"+productId).val());//接收商品数量
	if(flag=="minus"){/*减少商品数量*/
		if(productNum<=1){
			alert("宝贝数量必须是大于0");
			return false;
			}
		else{
			cartClient.send(productId,productNum-1,function () {
                productNum=productNum-1;
				$("#product-"+productId).val(productNum);
                productCount();
            });
			}
		}
	else{/*flag为add，增加商品数量*/
        cartClient.send(productId,productNum+1,function () {
            productNum=productNum+1;
            $("#product-"+productId).val(productNum);
            productCount();
        });
		}
	}
	
/*自动计算商品的总金额、总共节省的金额和积分*/
function productCount(){
	var total=0;      //商品金额总计
	var price;     //每一行商品的总价
	var number;    //每一行商品的数量
	var subtotal;  //每一航商品的小计

     /*访问ID为shopping表格中所有的行数*/
	var myTableTr=document.getElementById("shopping").getElementsByTagName("tr"); 
	if(myTableTr.length>0){
	for(var i=1;i<myTableTr.length;i++){/*从1开始，第一行的标题不计算*/
	    if(myTableTr[i].getElementsByTagName("td").length>2){ //最后一行不计算
		price=myTableTr[i].getElementsByTagName("td")[3].innerHTML;
		number=myTableTr[i].getElementsByTagName("td")[4].getElementsByTagName("input")[0].value;
		total+=price*number;
		myTableTr[i].getElementsByTagName("td")[5].innerHTML=price*number;
		}
	}
	document.getElementById("total").innerHTML=total;
	
	}
}
window.onload=productCount;

/*复选框全选或全不选效果*/
// function selectAll(){
// 	var oInput=document.getElementsByName("cartCheckBox");
//  for (var i=0;i<oInput.length;i++){
//  	    oInput[i].checked=document.getElementById("allCheckBox").checked;
// 	}
// }
	
/*根据单个复选框的选择情况确定全选复选框是否被选中*/
// function selectSingle(){
// 	var k=0;
// 	var oInput=document.getElementsByName("cartCheckBox");
// 	 for (var i=0;i<oInput.length;i++){
// 	   if(oInput[i].checked==false){
// 		  k=1;
// 		  break;
// 	    }
// 	}
// 	if(k==0){
// 		document.getElementById("allCheckBox").checked=true;
// 		}
// 	else{
// 		document.getElementById("allCheckBox").checked=false;
// 		}
// }

/*删除单行商品*/
// function deleteRow(rowId){
// 	var Index=document.getElementById(rowId).rowIndex; //获取当前行的索引
// 	document.getElementById("shopping").deleteRow(Index);
// 	//document.getElementById("shopping").deleteRow(Index-1);
// 	productCount();
// 	}

/*删除选中行的商品*/
// function deleteSelectRow(){
// 	var oInput=document.getElementsByName("cartCheckBox");
// 	var Index;
// 	 for (var i=oInput.length-1;i>=0;i--){
// 	   if(oInput[i].checked==true){
// 		 Index=document.getElementById(oInput[i].value).rowIndex; /*获取选中行的索引号*/
// 		 document.getElementById("shopping").deleteRow(Index);
// 	     //document.getElementById("shopping").deleteRow(Index-1);
// 	    }
// 	}
// 	productCount();
// 	}


var cartClient = {
    send : function(id,newNum,callBack){
        $.ajax({
            type: 'GET',
            url: '/buyer/shopping_cart_change/',
            data: {
                'id':id,'newNum':newNum
            },
            async:false,
            success: function(data){
                if(data == "ok") {
                    callBack();
                }
            },
        });
    }
}




// cartClient.send(1,2,function(){
//
// })


