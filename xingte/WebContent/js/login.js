$(document).ready(function(){

	$("#submit").click(function(){
		login();
	});
	
	$("#cancel").click(function(){
		$("#name").val("");
		$("#password").val("");
	});
});

function login(){
	$.ajax({
         url:'json/ajaxlogon.action', 
         type:'post',
         data:$("#loginform").serializeArray(),
         dataType:'json', 
         success:function(data){ 
	       if(data.result=="0"){
	       	alert("用户名或密码错误，请重新登录！");
	       }else{
	       	   window.location.href = "index.action"; 
	       }
         }
      });
}