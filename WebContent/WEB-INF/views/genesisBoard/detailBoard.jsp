<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="<c:url value="/css/common.css"/>" type="text/css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>게시판 글 보기</title>
</head>
<body>
<jsp:include page="../nav.jsp" />
<div class="container-fluid text-center">    
  <div class="row content">
    <jsp:include page="../leftSide.jsp" />
    <div class="col-sm-8 col-lg-8 text-left"> 
 		<h2>글보기</h2>
 		<table width="800" border="1">
		<tr height="40">
			<td align="center" width="200"><font size="2">글번호</font></td>
			<td align="center" width="600"><font size="2">${number}</font></td>
		</tr>
		<tr height="40">
			<td align="center" width="200"><font size="2">조회수</font></td>
			<td align="center" width="600"><font size="2">${board.count}</font></td>
		</tr>
		<tr height="40">
			<td align="center" width="200"><font size="2">작성자</font></td>
			<td align="center" width="600"><font size="2">${board.writer}</font></td>
		</tr>
		<tr height="40">
			<td align="center" width="200"><font size="2">작성일</font></td>
			<td align="center" width="600"><font size="2">${board.reg_date}</font></td>
		</tr>
		<tr height="40">
			<td align="center" width="200"><font size="2">제목</font></td>
			<td align="center" width="600"><font size="2">${board.title}</font></td>
		</tr>
		<tr height="40">
			<td align="center" width="200"><font size="2">내용</font>
			<td><textarea rows="10" cols="60" disabled="disabled">${board.content}</textarea></td>
		</tr>
		<tr height="40">
			<td align="center" colspan="2">
				<input type="button" value="답글쓰기" onclick="location.href='${pageContext.request.contextPath}/replyBoard?b_id=${board.b_id }'">
				<input type="button" value="수정하기" onclick="location.href='${pageContext.request.contextPath}/updateBoard?b_id=${board.b_id }'">
				<input type="button" value="삭제하기" onclick="location.href='${pageContext.request.contextPath}/deleteBoard?b_id=${board.b_id }'">
				<input type="button" value="전체글보기" onclick="location.href='${pageContext.request.contextPath}/boardList'">
			</td>
		</tr>
	
	</table>
    </div>
    <jsp:include page="../rightSide.jsp" />
  </div>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
