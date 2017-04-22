<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script src="<c:url value="/js/common.js"/>"></script>
<title>제네시스</title>
</head>
<body>
<jsp:include page="nav.jsp" />
<div class="container-fluid text-center">    
  <div class="row content">
    <jsp:include page="leftSide.jsp" />
    <div class="col-sm-8 col-lg-8 text-left"> 
	      <div id="myCarousel" class="carousel slide" data-ride="carousel">
			  <!-- Indicators -->
			  <ol class="carousel-indicators">
			    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			    <li data-target="#myCarousel" data-slide-to="1"></li>
			  </ol>
			
			  <!-- Wrapper for slides -->
			  <div class="carousel-inner" role="listbox">
			    <div class="item active">
			      <img src="<c:url value="/img/mainSlideImg/finance.png"/>" alt="finance">
			      <div class="carousel-caption">
			        <h3>재정 관리</h3>
			        <p>쉬운 UI</p>
			      </div>
			    </div>
			
			    <div class="item">
			      <img src="<c:url value="/img/mainSlideImg/human.png"/>" alt="human">
			      <div class="carousel-caption">
			        <h3>교적 관리</h3>
			        <p>쉬운 UI</p>
			      </div>
			    </div>
			
			  </div>
			
			  <!-- Left and right controls -->
			  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
			    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
			    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
		  </div>
		  <div class="row">
			  <div class="col-sm-4 "><iframe width="100%" height="323" scrolling="no" frameborder="no" src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/312550549&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false&amp;visual=true"></iframe></div>
			  <div class="col-sm-4 "><iframe width="100%" height="323" scrolling="no" frameborder="no" src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/167671065&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false&amp;visual=true"></iframe></div>
			  <div class="col-sm-4 "><iframe width="100%" height="323" src="https://www.youtube.com/embed/tZQ5cqbDQsY" frameborder="0" allowfullscreen></iframe></div>
		  </div>
    </div>
    <jsp:include page="rightSide.jsp" />
  </div>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>
