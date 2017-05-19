<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../base.jsp" %>
<script type="text/javascript" src="script/jquery-1.11.1.js"></script>
<script type="text/javascript" src="script/newsadd.js"></script>
<link type="text/css" rel="stylesheet" href="css/account.css">
</head>
<body>
<form action="" method="post">	
	<div id="newsaddmain">
	
	<div id="addtt">标题：<input id="addti" class="addtital" type="text" name="title"><span id="newspan" style="font-size: 12px;color: red;display: none">标题不能为空</span></div>
	
	<div id="newsaddbd">内容：<input id="addbody" class="newsaddbody" type="text" name="content" ><span id="addspan" style="font-size: 12px;color: red;display: none">内容不能为空</span></div>
	
	<div id="newsaddbutton">
	<div class="newsaddinfo"><input type="submit" value="发布" /></div>
	<div class="newsaddinfo"><input type="button" value="返回" /></div>
	<div class="clear"></div>
		
	</div>
</div>



</form>

</body>
</html>