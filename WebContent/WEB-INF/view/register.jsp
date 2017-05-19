<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="base.jsp" %>
<script type="text/javascript" src="script/jquery-1.11.1.js"></script>
<script type="text/javascript" src="script/register.js"></script>
	<link type="text/css" rel="stylesheet" href="css/style.css" > 
</head>
<body>
<div id="regmain">	
	
	<form action="register" method="post">
		<table id="rgtable" border="0" cellspacing="6" cellpadding="6">
			<tr>
				<td></td>
				<td class="rgtr1">信息发布平台</td>
			</tr>
			<tr id="trem">
				<td class="rgtr2">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</td>
				<td><input type="text" id="email" name="email" value="${ email }" placeholder="请输入邮箱"/></td>
				<td id="tdemail" class="rgt">邮箱不能为空</td>
			</tr>
			<tr>
				<td class="rgtr2">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</td>
				<td><input type="text" id="username" name="name" value="${ name }" placeholder="请输入昵称"/></td>
				<td id="tdun" class="rgt">昵称不能为空</td>
			</tr>
			<tr>
				<td class="rgtr2">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
				<td><input type="password" id="psw1" name="password" placeholder="请输入密码"/></td>
				<td id="tdps1" class="rgt">密码不能为空</td>
			</tr>
			
			<tr>
				<td class="rgtr2">确认密码:</td>
				<td><input type="password" id="psw2" name="psw" placeholder="请确认密码"/></td>
				<td style="font-size: 10px;">${ error }</td>
			</tr>
		
		</table>

	
	<div id="resgb">
		<div class="loginbut"><input type="submit"  value="注册" ></div>
		<div class="loginbut"><input type="button"  value="返回" ></div>
		<div class="clear"></div>
	</div>
</form>
	</div>
	
</body>
</html>