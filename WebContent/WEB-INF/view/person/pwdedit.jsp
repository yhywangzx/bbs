<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../base.jsp" %>
<link type="text/css" rel="stylesheet" href="css/account.css">
<script type="text/javascript" src="script/jquery-1.11.1.js"></script>
<script type="text/javascript" src="script/pwdedit.js"></script>
</head>
<body>
<div>
<form action="person/pwdedit" method="post">
	<table border="0" cellspacing="10" cellpadding="10">
		<tr>
		<td>账号:</td>
		<td>${ sessionScope.User.name }</td>
		</tr>
		
		<tr>
			<td>旧密码:</td>
			<td><input type="password" id="pwd" name="pwd"></td>
			<td class="pwdp">${ oldmsg }</td>
		</tr>
		
		<tr>
		
			<td>新密码:</td>
			
			<td><input type="password" id="psw" name="psw"></td>
			<td class="pwdp">${ newmsg }</td>
		</tr>
		
		<tr>
		<td>确认密码:</td>
		<td><input type="password" id="password" name="password"></td>
		<td class="pwdp">${ passwordmsg }</td>
		</tr>
		


	</table>



	<div>
		<div class="newsaddinfo"><input type="submit" value="保存"></div>
		<div class="newsaddinfo"><input type="button" value="返回"></div>

	</div>

</form>
</div>

</body>
</html>