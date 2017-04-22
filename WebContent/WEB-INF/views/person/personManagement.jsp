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
<script src="<c:url value="/js/personManagement.js"/>"></script>
<title>교적 관리</title>
</head>
<body>
<jsp:include page="../nav.jsp" />
<div class="container-fluid text-center">    
  <div class="row content">
    <jsp:include page="../leftSide.jsp" />
    <div class="col-sm-8 text-left"> 
	  <h2>교적 관리</h2>
	  <table class="table table-hover">
	    <thead>
	      <tr>
	        <th>Id</th>
	        <th>이름</th>
	        <th>주소</th>
	        <th>Email</th>
	        <th>직분</th>
	      </tr>
	    </thead>
	    <tbody>
	    <c:forEach var="member" items="${members}">
			<tr>
				<td>${member.id}</td>
				<td>${member.name}</td>
				<td>${member.address}</td>
				<td>${member.email}</td>
				<td>${member.rank}</td>
				<td>
					<input type="button" onclick="location.href='${pageContext.request.contextPath}/updatePerson/${member.id}'" value="회원정보수정" class="btn btn-default" />
					<input type="button" onclick="location.href='${pageContext.request.contextPath}/deletePerson/${member.id}'" value="회원정보삭제" class="btn btn-default" />
				</td>
			</tr>
		</c:forEach>
	    </tbody>
	  </table>
    </div>
    <jsp:include page="../rightSide.jsp" />
  </div>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>