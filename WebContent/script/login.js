$(function(){
	$("#register").click(login);
});
function login(){
	
	var email = $.trim($("#email").val());
	var psw = $.trim($("#psw").val());
	
//	$.post("login",{email:email,password:psw},function(data){
//		if(data=="true"){
//			window.location.href = "index";
//		}else{
//			alert("用户名或密码错误");
//		}
//	});
	$.ajax({
		type:"post",
		url:"login",
		data:{email:email,password:psw},
		success:function(data){
			if(data=="true"){
				window.location.href = "index";
			}else{
				alert("用户名或密码错误");
			}
		}
	});
}

