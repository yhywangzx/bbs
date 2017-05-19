<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="base.jsp" %>
<script type="text/javascript" src="script/jquery-1.11.1.js"></script>
<script type="text/javascript" src="script/index.js"></script>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<form action="index" method="post">
	<div id="main">
	
	<c:if test="${ sessionScope.User ==null }">

		<div id="total">
			<div class="wel">欢迎您</div>
			<div class="zc">
				<a href="register">注册</a> <a href="login">登录</a>
			</div>
			<div class="clear"></div>
		</div>
	</c:if>
	<c:if test="${ sessionScope.User != null }">
		<div id="tital">
			<div class="wel">欢迎您:${ sessionScope.User.name }</div>
			<div class="zc">
				<a href="account">我的账号</a> <a href="cancel">注销</a>
			</div>
			<div class="clear"></div>
		</div>
	</c:if>
		<div id="body">
			<div id="tb">
				<table id="table">
					<tr class="tr1">
						<td><b>序号</b></td>
						<td><b>标题</b></td>
						<td><b>发帖人</b></td>
						<td><b>发帖时间</b></td>
						<td><b>浏览次数</b></td>
					</tr>
					
				<c:forEach var="item" items="${ requestScope.newsList }" varStatus="st">
					<tr class="${ st.index % 2 == 0 ? 'tr2':'tr3' }">
						<td>${ st.index + 1 }</td>
						<td><a href="newsview?id=${ item.id }" target="_blank">${ item.title }</a></td>
						<td>${ item.user.name }</td>
						<td><fmt:formatDate value="${ item.publishDate }" pattern="yyyy-MM-dd"/> </td>
						<td>${ item.browserCount }</td>
					</tr>

					
			</c:forEach>
					

				</table>


			</div>

			<div id="ys">${ requestScope.pageIndex }/${ requestScope.totalPage }</div>
			<div id="tbl">
				<input type="hidden" name="pageIndex" id="pageIndex" value="${ requestScope.pageIndex }">
				<input type="hidden" id="totalPage" value="${ requestScope.totalPage }">
				<table id="tab">
					<tr>
						<td><a href="#" class="flip" id="first">首页</a></td>
						<td><a href="#" class="flip" id="previou">上页</a></td>
						<td><a href="#" class="flip" id="next">下页</a></td>
						<td><a href="#" class="flip" id="last">末页</a></td>
	

					</tr>

				</table>
			</div>


		</div>
		<div id="copyright">合肥迅飞教育</div>


	</div>
</form>
</body>
</html>