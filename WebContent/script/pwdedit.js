$(function(){
	$("#pwd").blur(checkPassword);
	
});
function checkPassword(){
	var pwd = $.trim($("#pwd").val());
	$.post("person/checkpassword",{pwd:pwd},function(data){
		if(data=="true"){
			alert("旧密码正确");
			
		}else{
			alert("旧密码不正确");
			$("#pwd").val("");
		}
	});
	
}