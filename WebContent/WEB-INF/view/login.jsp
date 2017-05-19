<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="base.jsp" %>
<link type="text/css" rel="stylesheet" href="css/style.css" > 
<script type="text/javascript" src="script/jquery-1.11.1.js"></script>
<script type="text/javascript" src="script/login.js"></script>
</head>
<body>
<div id="loginmain">
	<form action="login" method="post">
		<table id="logintb" border="0" cellspacing="10" cellpadding="10">
			<tr>
				<td>邮箱:</td>
				<td><input id = "email" type="text" name="email" placeholder="请输入邮箱"/></td>
				<td>${ error }</td>
				</tr>
				<tr>
				<td>密码:</td>
				<td><input type="password" id="psw" name="password" placeholder="请输入密码"/></td>
				<td id="tdpsw" style="font-size: 10pt;color: red"></td>
				</tr>
				</table>
	
		
		
			<div id="loginbt">
				<div class="loginbut"><input type="button" id="register" value="登录" /></div>
				<div class="loginbut"><input type="button" id="back" value="返回" /></div>
				<div class="clear"></div>
			
			</div>
			
			</form>
		
</div>

</body>
</html>