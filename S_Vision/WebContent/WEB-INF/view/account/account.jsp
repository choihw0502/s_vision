<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Map, java.util.List" %>        
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
<meta charset="UTF-8">
<mata name="viewport" content="width=device-width" , inital-scale="1">
<head>
<title>���� ������</title>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/bin.css">
</head>
<body>
<%
String mem_id = (String)session.getAttribute("mem_id");
%>
<!-- �׺���̼� �� ���� -->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navber-collapse-1" aria-expanded="false">
					<span class="sr-only"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">
					<img src="/images/vision_pay.png" id="imagepreview" style="width: 150px; height: 30px">
				</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navber-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active">
						<a href="index">VISION PAY �Ұ� 
							<span class="sr-only"></span>
						</a>
					</li>
					<li><a href="crew">VISION ���� �Ұ�</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle"	data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">VISION PAY ���
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="card"><img src="/images/card.png" id="imagepreview" style="width: 30px; height: 20px">ī��</a></li>
							<li><a href="account"><img src="/images/account.png" id="imagepreview" style="width: 30px; height: 20px">����</a></li>
							<li><a href="membership"><img src="/images/membership.png" id="imagepreview" style="width: 30px; height: 20px">�����</a></li>
							<li><a href="plan"><img src="/images/planner.png" id="imagepreview" style="width: 30px; height: 20px">�÷���</a></li>
							<li><a href="recommend"><img src="/images/cardRecommend.png" id="imagepreview" style="width: 30px; height: 20px">ī�� ��õ</a></li>
							<li><a href="rewards"><img src="/images/reward.png" id="imagepreview" style="width: 30px; height: 20px">������</a></li>
						</ul>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="background-color: black;">
							<img src="/images/login.png" style="width: 20px; height: 20px"><span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="login">�α���</a></li>
							<li><a href="register">ȸ������</a></li>
						</ul>
					</li>
				</ul>
				<form class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="������ �Է��ϼ���.">
					</div>
					<button type="submit" class="btn btn-default">�˻�</button>
				</form>
			</div>
		</div>
	</nav>
	<!-- �׺���̼� �� �� -->
	<!-- ���� ȭ�� ���� -->
	<div class="container">
		<div class="row">
			<div class="col-12">
				<h2>����</h2>
				<script type="text/javascript">
</script>
<!-- <table class="dg_accountList" style="width:400px;height:250px"
        data-options="url:'account/accountList?mem_id=elesex',fitColumns:true,singleSelect:true">
    <thead>
        <tr>
            <th data-options="field:'ACC_BANK',width:100">Code</th>
            <th data-options="field:'ACC_NAME',width:100">Name</th>
            <th data-options="field:'ACC_NUM',width:100,align:'right'">Price</th>
        </tr>
    </thead>
</table> -->
			</div>
			
		</div>
	</div>
	<iframe src="http://192.168.0.10:9000/account/accountList?mem_id=<%=mem_id%>" weight="500px" height="500px" align="middle"></iframe>
	<!-- ���� ȭ�� �� -->
	<!-- Ǫ�� ���� -->
	<footer style="background-color: #000000;">
		<div class="container">
			<br>
			<div class="row">
				<div class="col-sm-3">
					<h4 style="text-align: left;">����Ʈ��</h4>
					<div class="list-group">
						<a href="index" class="list-group-item">VISION�� ����</a> 
						<a href="crew" class="list-group-item">VISION���� ����</a> 
						<a href="notice.jsp" class="list-group-item">��������</a> 
						<a href="FAQ.jsp" class="list-group-item">FAQ</a>
					</div>
				</div>
				<div class="col-sm-2">
					<h4 style="text-align: left;">�� ����</h4>
					<a href="email.jsp" class="list-group-item">�̸��� ����</a>
				</div>
				<div class="col-sm-4"></div>
				<div class="col-sm-3">
					<h4 style="text-align: left;">sns</h4>
					<div class="list-group">
						<a href="https://www.kakaocorp.com/service/KakaoTalk" class="list-group-item">īī����</a> 
						<a href="https://ko-kr.facebook.com/" class="list-group-item">���̽���</a>
					</div>
					<h5 style="text-align: left;">���� ��ü</h5>
					<div class="list-group">
						<a href="http://www.ikosmo.co.kr/" class="list-group-item" style="width: 190px; background-color: #ffffff;">
							<img src="/images/top_logo.gif"></a> 
						<a href="http://www.moel.go.kr/index.do" class="list-group-item" style="width: 190px; background-color: #ffffff;">
							<img src="/images/logo.png"></a>
					</div>
				</div>
				<div class="col-sm-12" style="height: 30px;">
					<h5 style="text-align: left;">Copyright &copy; 2018-2019
						HEESANG All Rights Reserved.</h5>
				</div>
				
				<div class="col-sm-12"><hr></div>
					<div class="col-sm-3">
						<h1 style="text-align: centar;">
							<img src="/images/VISION4.png" id="imagepreview" style="width: 150px; height: 80px">
						</h1>
					</div>
					<div class="col-sm-9">
						<h4 style="text-align: centar;">
							<br>(��)��������Ʈ����(123-456) ����� ��õ�� ���굿 426-5 ����޸���� 2�� 311ȣ 5���ǽ� <br>
							�����ֽ�ȸ�� ��ǥ�̻� Ȳ��� ����ڵ�Ϲ�ȣ 123-456-78910 ��ǥ��ȣ:010-423-9948
						</h4>
					</div>
					<!--    <div class="col-sm-2"><h4 style="text-align: center;"><span class="glyphicon glyphicon-ok">&nbsp; by ����</span></h4> -->
				</div>
			</div>
	</footer>
	<!-- Ǫ�� �� -->
</body>
</html>