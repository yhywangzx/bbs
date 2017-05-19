$(function(){
	$("#register").on("click","a",function(){
	


	if($("#email").val().trim()==""){
		$("#tdemail").show();
	}else{
		$("#tdemail").hide();
	}
	if($("#username").val().trim()==""){
		$("#tdun").show();
	}else{
		$("#tdun").hide();
	}
	if($("#psw1").val().trim()==""){
		$("#tdps1").show();
	}else{
		$("#tdps1").hide();
	}
	if($("#psw2").val().trim()==""){
		$("#tdps2").show();
	}else{
		$("#tdps2").hide();
	}

	});
});