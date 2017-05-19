<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="base.jsp" %>
<link type="text/css" rel="stylesheet" href="css/account.css">
</head>
<body>
	<div id="acmain">
		<div id="actotal">
				<div class="acwl">
					<a href="index">首页</a>
					  欢迎你：${ sessionScope.User.name }</div>
				<div class ="aczx">
					<a href="account">我的账号</a>
					<a href="cancel">注销</a>
				</div>
				<div class="clear"></div>
		</div>
		<div id="acbody">
			<div id="acleft">
				<ul>
					<li><a href="person/newslist" target="mainFrame">信息管理</a></li>
					<li><a href="person/pwdedit" target="mainFrame">密码修改</a></li>
					<li><a href="http://www.sina.com.cn/" target="mainFrame">新浪</a></li>
					<li><a href="http://www.163.com/" target="mainFrame">网易</a></li>
					<li><a href="http://www.baidu.com/" target="mainFrame">百度</a></li>
					
				</ul>
	
			</div>
			<div id="acright">
				<iframe name="mainFrame" frameborder="0" width="100%" height="600px"></iframe>
			</div>
		
		
		</div>
		<div id="acclast">合肥讯飞教育</div>
	
	
	
	
	
	</div>
	

</body>
</html>