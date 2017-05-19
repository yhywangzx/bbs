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
<script type="text/javascript" src="script/newsview.js"></script>
<link type="text/css" rel="stylesheet" href="css/style.css" > 
</head>
<body>
<div id="newmain">
		<div id="newstital"><h1>${ news.title }</h1></div>
		<div id="newstime">
			<div class="newsp">发帖人：${ news.user.name }</div>
			<div class="newst">发帖时间：${ news.publishDate }</div>
			<div class="clear"></div>
		</div>
		<div id="newsbody">
			${ news.content }
		</div>
		<div id="newsline"></div>
		
		<div id="newstk">评论</div>
		<div id="replycontent">
			<c:forEach var="item" items="${ replyList }" varStatus="st">
			
				<div class="newstalk">${ item.user.name }[<fmt:formatDate value="${ item.replyDate }" pattern="yyyy-MM-dd"/>]:${ item.content }
				<a id="item_${ item.id }" style="float: right" class="delete" href="#">刪除</a>
			</div>
			</c:forEach>
		
		</div>

		<c:if test="${ sessionScope.User != null }">
			<div id="newslast">回复:
		
				<input id="newsanswer" type="text"  placeholder="评论内容不能为空"/>
				<input type="hidden" id="newsid" value="${ requestScope.news.id }"> 
				<input type="hidden" id="username" value="${ sessionScope.User.name }"> 
				<input type="button" id="btnReply" value="回复">
			
			</div>
		</c:if>
		<c:if test="${ sessionScope.User == null }">
			<div id="newslast"> 登陆之后才可以评论</div>
		
		</c:if>
	
	</div>

</body>

</html>