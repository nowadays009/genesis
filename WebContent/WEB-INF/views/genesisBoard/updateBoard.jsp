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
<title>자유 게시판</title>
</head>
<body>
<jsp:include page="../nav.jsp" />
<div class="container-fluid text-center">    
  <div class="row content">
    <jsp:include page="../leftSide.jsp" />
    <div class="col-sm-8 text-left"> 
  		<h2>글 수정</h2>
  		<form:form commandName="board" action="updateBoardProc" method="post">
    		<div class="form-group">
		      	<label for="title" >제목:</label>
		      	<form:input path="title" class="form-control" name="title" placeholder="Enter title" value="${board.title }" disabled="true"/>
		    </div>
		    <div class="form-group">
		      	<label for="content">내용:</label>
				<textarea class="form-control" rows="9" name="content" id="content">${board.content}</textarea>
		    </div>
		    <div class="form-group">
      			<label for="writer">작성자:</label>
      			<form:input path="writer" class="form-control" name="writer" placeholder="Enter writer" value="${board.writer }" disabled="true"/>
    		</div>
		    <div class="form-group">
		      	<label for="pwd">비밀번호:</label>
		      	<form:input type="password" path="pwd" class="form-control" name="pwd" placeholder="Enter password" />
		    </div>
		    	<form:input type="hidden" path="b_id" name="b_id" value="${board.b_id }" />
		      	<button type="submit" class="btn btn-default">수정완료</button>
			  	<button type="reset" class="btn btn-default">취소</button>
			  	<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/boardList'">전체글보기</button>
		 </form:form>
    </div>
    <jsp:include page="../rightSide.jsp" />
  </div>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>

