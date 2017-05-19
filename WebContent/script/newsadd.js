$(function(){
	$("#Release").click(release_click);
});
function release_click(){
	if($("#addti").val().trim()==""){
		$("#newspan").show();
	}else{
		$("#newspan").hide();
	}
	if($("#addbody").val().trim()==""){
		$("#addspan").show();
	}else{
		$("#addspan").hide();
	}
}