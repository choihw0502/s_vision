<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
<meta charset="UTF-8">
<mata name="viewport" content="width=device-width" , inital-scale="1">
<head>
<title>메인(로그아웃) 페이지</title>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/bin.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
.jumbotron {
	background-image: url('/images/vision.gif');
	background-size: cover;
	text-shadow: black 0.2em 0.2em 0.2em;
	color: white;
	width: 100%;
	height: 100%;	
}
</style>
	<!-- 네비게이션 바 시작 -->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			
			<div class="navbar-header"><h4>
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navber-collapse-1" aria-expanded="false">
					<span class="sr-only"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="main.jsp">
					<img src="/images/vision_pay.png" id="imagepreview" style="width: 150px; height: 30px">
				</a></h4>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navber-collapse-1"><h4>
				<ul class="nav navbar-nav">
     				<li class="dropdown">
						<a href="#" class="dropdown-toggle"	data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">VISION PAY 기능
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="cardList.jsp"><img src="/images/card.png" id="imagepreview" style="width: 30px; height: 20px">&nbsp;&nbsp;카드</a></li>
							<li><a href="account.jsp"><img src="/images/account.png" id="imagepreview" style="width: 30px; height: 20px">&nbsp;&nbsp;계좌</a></li>
							<li><a href="membership.jsp"><img src="/images/membership.png" id="imagepreview" style="width: 30px; height: 20px">&nbsp;&nbsp;멤버쉽</a></li>
							<li><a href="planner.jsp"><img src="/images/planner.png" id="imagepreview" style="width: 30px; height: 20px">&nbsp;&nbsp;플레너</a></li>
							<li><a href="cardRecommend.jsp"><img src="/images/cardRecommend.png" id="imagepreview" style="width: 30px; height: 20px">&nbsp;&nbsp;카드 추천</a></li>
							<li><a href="reward.jsp"><img src="/images/reward.png" id="imagepreview" style="width: 30px; height: 20px">&nbsp;&nbsp;리워즈</a></li>
						</ul>
					</li> 
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="background-color: black;">
							<img src="/images/login.png" style="width: 20px; height: 20px"><span class="caret"></span></a>
						<ul class="dropdown-menu">
				    		<li><a href="#">내계정</a></li>
							<li><a href="index">로그아웃</a></li>
						</ul>
					</li>
				</ul>
				<form class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="내용을 입력하세요.">
					</div>
						<label for="#"></label>
					    <button type="submit" class="btn btn-default">검색</button>
				</form></h4>
			</div>
		</div>
	</nav>
	<!-- 네비게이션 바 끝 -->
