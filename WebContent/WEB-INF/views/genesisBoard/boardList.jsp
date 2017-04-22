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
    <div class="col-sm-8 col-lg-8 text-left"> 
 		<h2>자유 게시판</h2>
 		<table class="table table-bordered">
	    <thead>
	      <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>등록일</th>
	        <th>조회수</th>
	      </tr>
	    </thead>
	    <tbody>
	    <c:set  var="number" value="${paging.number}" />
	    <c:if test="${boards !=null }">
	    <c:forEach var="board" items="${boards}">
			<tr>
				<td>${number}</td>
				<td>
					<a href="${pageContext.request.contextPath}/detailBoard?b_id=${board.b_id}&number=${number}">
						<c:if test="${board.re_level>0}" >
							<c:forEach begin="1" end="${board.re_level}">
								&nbsp;&nbsp;&nbsp;
							</c:forEach>
							<img src="<c:url value="/img/genesisBoard/reply_icon.gif"/>" alt="reply_icon">
						</c:if>${board.title}
					</a>
				</td>
				<td>${board.writer}</td>
				<td>${board.reg_date}</td>
				<td>${board.count}</td>
				<c:set  var="number" value="${number-1 }" />
			</tr>
		</c:forEach>
		</c:if>	
	    </tbody>
	  </table>
	  <div align="left" >
		<form action="${pageContext.request.contextPath}/boardList" method="post">	  
		  <select id="searchField" name="searchField" style="height:25px;">
		  	<option value="title">제목</option>
		  	<option value="writer">작성자</option>
		  	<option value="content">내용</option>
		  </select>
		  <input type="text" id="searchValue" name="searchValue" />
		  <input type="submit" value="검색" id="searchButton" name="searchButton" />
		</form> 
	  </div>
	  <div align="right">
	      <input type="button" onclick="location.href='${pageContext.request.contextPath}/insertBoard'" value="글쓰기" class="btn btn-default" />			  
	  </div>
	  <div align="center">
		  <!-- 페이지 타운터링 소스 작성 시작-->
		  <c:if test="${paging.count >0 }" >
		  	<ul class="pagination">
			  <!-- 이전이라는 링크를 걸지 파악  -->
			  <c:if test="${paging.startPage >paging.pageBlock }">
			  		<c:choose>
			  			<c:when test="${searchField eq null||searchValue eq null}">
			  				<li><a href="${pageContext.request.contextPath}/boardList?pageNum=${paging.startPage-paging.pageBlock }">이전</a></li>	
			  			</c:when>
			  			<c:otherwise>
			  				<li><a href="${pageContext.request.contextPath}/boardList?pageNum=${paging.startPage-paging.pageBlock }&searchField=${searchField}&searchValue=${searchValue}">이전</a></li>
			  			</c:otherwise>
			  		</c:choose>
			  </c:if>
			  <!-- 페이징 처리 -->
			  <c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
			  		<c:choose>
			  			<c:when test="${searchField eq null||searchValue eq null}">
			  				<li><a href="${pageContext.request.contextPath}/boardList?pageNum=${i}">${i}</a></li>
			  			</c:when>
			  			<c:otherwise>
			  				<li><a href="${pageContext.request.contextPath}/boardList?pageNum=${i}&searchField=${searchField}&searchValue=${searchValue}">${i}</a></li>
			  			</c:otherwise>
			  		</c:choose>
			  </c:forEach>	
			  <!-- 다음 이라는 링크를 걸지 파악 -->	
			  <c:if test="${paging.endPage < paging.pageCount }">
			  		<c:choose>
			  			<c:when test="${searchField eq null||searchValue eq null}">
			  				<li><a href="${pageContext.request.contextPath}/boardList?pageNum=${paging.startPage+paging.pageBlock }">다음</a></li>	
			  			</c:when>
			  			<c:otherwise>
			  				<li><a href="${pageContext.request.contextPath}/boardList?pageNum=${paging.startPage+paging.pageBlock }&searchField=${searchField}&searchValue=${searchValue}">다음</a></li>
			  			</c:otherwise>
			  		</c:choose>
			  </c:if>
			 </ul>	
		  </c:if>
		  <!-- 페이지 타운터링 소스 작성 끝--> 
	  </div>
    </div>
    <jsp:include page="../rightSide.jsp" />
  </div>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
