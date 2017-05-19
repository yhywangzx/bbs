$(function(){
	$("#save").click(release_click);
});
function release_click(){
	if($("#edittital").val().trim()==""){
		$("#newspan").show();
	}else{
		$("#newspan").hide();
	}
	if($("#editbody").val().trim()==""){
		$("#addspan").show();
	}else{
		$("#addspan").hide();
	}
}