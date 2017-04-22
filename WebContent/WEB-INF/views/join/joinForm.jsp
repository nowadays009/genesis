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
<title>회원 가입</title>
</head>
<body>
<jsp:include page="../nav.jsp" />
<div class="container-fluid text-center">    
  <div class="row content">
    <jsp:include page="../leftSide.jsp" />
    <div class="col-sm-8 text-left"> 
	  <div class="container">
  		<h2>회원 가입</h2>
  		<form:form commandName="member" action="insertMemberProc" method="post">
  			<div class="form-group">
      			<label for="id">Id:</label>&nbsp;<form:errors path="id" cssClass="msg" />
     			<form:input path="id" class="form-control" name ="id" placeholder="Enter id" />
    		</div>
    		<div class="form-group">
      			<label for="pwd">Password:</label>&nbsp;<form:errors path="pw1" cssClass="msg" />
      			<form:input type="password" path="pw1" class="form-control" name="pw1" placeholder="Enter password" />
    		</div>
		    <div class="form-group">
		      	<label for="pwd">Password 확인:</label>&nbsp;<form:errors path="pw2" cssClass="msg" />
		      	<form:input type="password" path="pw2" class="form-control" name="pw2" placeholder="Enter password 확인" />
		    </div>
		    <div class="form-group">
		      	<label for="name">이름:</label>&nbsp;<form:errors path="name" cssClass="msg" />
		      	<form:input path="name" class="form-control" name="name" placeholder="Enter name" />
		    </div>
		    <div class="form-group">
		      	<label for="email">Email:</label>&nbsp;<form:errors path="email" cssClass="msg" />
		      	<form:input path="email" class="form-control" id="email" name="email" placeholder="Enter email" />
		    </div>
		    <div class="form-group">
		      	<label for="address">address:</label>&nbsp;<form:errors path="address" cssClass="msg" />
		      	<form:input path="address" class="form-control" name="address" placeholder="Enter address" />
		    </div>
		    <div class="form-group">
		 	  	<label for="rank">직분:</label>
		  	  	<select class="form-control" name="rank">
			    	<option>성도</option>
			    	<option>집사</option>
			    	<option>권사</option>
			    	<option>목사</option>
		  	  	</select>
			</div>
			<button type="submit" class="btn btn-default">회원가입</button>
			<button type="reset" class="btn btn-default">취소</button>
		 </form:form>
      </div>	      
    </div>
    <jsp:include page="../rightSide.jsp" />
  </div>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>

