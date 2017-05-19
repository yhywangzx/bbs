<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../base.jsp" %>
<script type="text/javascript" src="script/jquery-1.11.1.js"></script>
<script type="text/javascript" src="script/newsedit.js"></script>
<link type="text/css" rel="stylesheet" href="css/account.css">
</head>
<body>
<form action="person/newsedit" method="post">
	<input type="hidden" name="id" value="${ news.id }"> 

	<div id="newseditmain">
	
	<div id="addedit">标题：<input id="edittital" class="addtital" type="text" name="title" value="${ news.title }"></div>
	
	<div id="newseditbd">内容：<input id="editbody" class="newsaddbody" type="text" name="content" value="${ news.content }"></div>
	
	<div id="newseditbutton">
		<div class="newsaddinfo"><input type="submit" value="保存" /></div>
		<div class="newsaddinfo"><input type="button" value="返回" /></div>
		<div class="clear"></div>
	</div>
</div>



</form>

</body>
</html>