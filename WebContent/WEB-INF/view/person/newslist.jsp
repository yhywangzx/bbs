<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../base.jsp" %>
<script type="text/javascript" src="script/jquery-1.11.1.js"></script>
<script type="text/javascript" src="script/newslist.js"></script>
<link type="text/css" rel="stylesheet" href="css/account.css">
</head>
<body>
<form action="person/newslist" method="post">
<div id="newsmain">
	<div id="newstt">标题<input id="newstext" type="text" name="title" value="${ title }">
	<input id="newsbutton" type="submit" value="查询"></div>
	<div style="height: 400px;">
		<div id="newsbody"><a href="person/newsadd">发布信息</a></div>
		
		<table id="table">
					<tr class="tr1">
						<td><input type="checkbox" name="order"></td>
						<td><b>标题</b></td>
						<td><b>内容</b></td>
						<td><b>发帖时间</b></td>
						<td><b>浏览次数</b></td>
						<td><b>操作</b></td>
					</tr>
					
					<c:forEach var="item" items="${ requestScope.newsList}" varStatus="st">
						
					<tr class="${ st.index %2  == 0 ? 'tr2':'tr3' }">
						<td><input type="checkbox" name="order"></td>
						<td>${ item.title }</td>
						<td>${ item.content  }</td>
						<td><fmt:formatDate value="${ item.publishDate }" pattern="yyyy-MM-dd"/> </td>
						<td>${ item.browserCount }</td>	
						<td><a class="delete" href="delete?id=${ item.id }">删除</a>&nbsp;&nbsp;&nbsp;
						<a href="person/newsedit/${ item.id }">修改</a></td>	
						
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
					<td><a href="#" class="page" id="first">首页</a></td>
					<td><a href="#" class="page" id="previou">上页</a></td>
					<td><a href="#" class="page" id="next">下页</a></td>
					<td><a href="#" class="page" id="last">末页</a></td>
				
				
				</tr>
			
			</table>		
		</div>	
		



</div>
</form>

</body>
</html>