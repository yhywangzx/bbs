4$(function(){
	$("#btnReply").click(btnReply);
	
	$("#replycontent").on("mouseover",".newstalk",function(){
		$(this).find("a.delete").show();
	});
	
	$("#replycontent").on("mouseout",".newstalk",function(){
		$(this).find("a.delete").hide();
	});
	
	$("#replycontent").on("click","a.delete",function(){
		
		
		var a = $(this);
		$.ajax({
			type : "get",
			url :"/replydelete",
			data : {
				replyid : a.attr("id")
			},
			success : function(data){
				if(data == true){
					a.parents(".newstalk").remove();
				}
			}
		});
		return false;
	});
});

function btnReply(){
	var content = $("#newsanswer").val();
	var newsid = $.trim($("#newsid").val());
	if (content == "") {
		alert("评论内容不能为空");
		return;
	}
	$("#newsanswer").val("");
	
	
	$.ajax({
		type:"post",
		url:"newsview",
		data:{
			content : content,
			newsid : newsid
		},
		success : function(data){
			if(data =="true"){
				var date = new Date();
				var dateStr = date.getFullYear() + "-"+ (date.getMonth()+1) + "-" +  date.getDate();
				
				var html = '<div class="newstalk">'+ $("#username").val() +'[' + dateStr + ']:'
			     + content
			     +'<a style="float:right";class="delete" id="item_'+data+'">刪除</a></div>';
				
				$("#replycontent").prepend(html);	
				}
		}
		
	});

	
}
