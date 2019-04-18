<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%
	Map<String,Object> cardInfo = (Map<String,Object>)request.getAttribute("cardInfo");
	Cookie cardinfo = new Cookie("card_name",cardInfo.get("CARD_NAME").toString());
	cardinfo.setMaxAge(60*60*365);
	cardinfo.setPath("/");
	response.addCookie(cardinfo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<mata name="viewport" content="width=device-width" , inital-scale="1">
<title>결제 페이지</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.js"></script>
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bin.css">
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	$('#payPwMove').on('click'.function(){
		$.ajax({
			type:'POST',
			url: /pay/paymentPW
			data: {
				"CARD_NUM" : "<%=cardInfo.get("CARD_NUM")%>",
			}
		})
	})
});
</script>
<!-- 네비게이션 바 시작 -->
<nav class="navbar navbar-default">
	<div class="container-fluid">
	<br>
	<h4>
		<div class="navbar-header" style="height: 50px">
			<a style="color: #ffffff; height: 25px" href="main2.jsp"><</a>
			<a href="card.jsp" style="color: white">&nbsp;
				<img src="images/VISION2.png" id="imagepreview" style="width: 80px; height: 20px;">&nbsp;카드 결제
			</a>
			<span style="margin-left: 150px;">
				<a href="memberJoin.jsp" >
					<img src="images/card.png" id="imagepreview" style="width: 40px; height: 20px;">&nbsp;추가
				</a>
			</span>
		</div>
	</h4>
	</div>
</nav>
<!-- 네비게이션 바 끝 -->
<%
	if(cardInfo!=null){
%>
<!-- 결제 화면 시작 -->
<div class="container">
	<div class="row">
		<div class="col-12">
			<div class="col-md-1"></div>
			<div class="col-md-11">
				<h3>
					<p>
						<img src="images/AAP1266.png" style="width: 250px; height: 150px; margin-right: 30px" align="left"> 
						<br><%=cardInfo.get("CARD_NAME") %> 
						<br><p>
				        <a href="/pay/paymentPW">
							<button id="payPwMove" name="payPwMove" type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" style="background-color: white; color: black; border-color: white;">
							비밀번호  
							</button>
						</a>
					</p>
				</h3>
			</div>
		</div>
	</div>
	<hr>
</div>
<!-- 결제 화면 끝 -->
<%
	}
%>
</body>
</html>