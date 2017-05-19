$(function() {
	//删除确认操作
	$("a.delete").click(function(){
		var r = confirm("确认删除该记录?");
		return r;
		$("#pageIndex").val(parseInt($("#pageIndex").val()));
	});
	//分页
	$(".page").click(pageClick);
	//查询
	$("#newsbutton").click(function(){
		$("#pageIndex").val(1);
	});
});
function pageClick(){
	var id = $(this).attr("id");
	var pageIndex = parseInt($("#pageIndex").val());
	var totalPage = parseInt($("#totalPage").val());
	
	if(id == "first"){
		$("#pageIndex").val(1);
		$("form").submit();
	}else if (id == "previou"){
		if(pageIndex > 1){
			$("#pageIndex").val(pageIndex-1);
			$("form").submit();
		}
	}else if( id == "next"){
		if(pageIndex < totalPage){
			$("#pageIndex").val(pageIndex+1);
			$("form").submit();
		}
	}else if( id == "last"){
		$("#pageIndex").val(totalPage);
		$("form").submit();
	}
	return false;
}