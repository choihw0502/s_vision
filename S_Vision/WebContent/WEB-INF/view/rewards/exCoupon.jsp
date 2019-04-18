<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.*" %>
<%@page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<%
	List<Map<String,Object>> couponInven = (List<Map<String,Object>>)request.getAttribute("couponInven");
String mem_id = (String)session.getAttribute("mem_id");
	
%>

<html>

<meta charset="UTF-8">
<mata name="viewport" content="width=device-width" , inital-scale="1">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
<head>
<title>쿠폰함</title>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/bin.css">
<script type="text/javascript">
var frame; //iframe을 담아둘 변수
        function SetElements() {
            frame = document.getElementById("Contents"); //iframe 가져오기
            SetHeight(); //SetHeight 함수 실행
        }

        function SetHeight() {
            var fBody = frame.contentWindow || frame.contentDocument;
            if (fBody.document) fBody = fBody.document.body; //iframe의 body 가져오기
            frame.height = fBody.scrollHeight + (fBody.offsetHeight - fBody.clientHeight); //iframe 높이 크기 조절
            frame.width = fBody.scrollWidth + (fBody.offsetWidth - fBody.clientWidth); //iframe 너비 크기 조절
            scrollTo(0,0); //최상단으로 스크롤 이동

        }
        function keyCheck(objName,objSize,nextObjName){
    		if(objName.value.length==objSize){
	    		nextObjName.focus();
	    		return;
    		}
    	}       
</script>   
<style>
</style>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<br>
			<h5>
				<div class="navbar-header">
					<a style="color: #ffffff; height: 25px" href="../member/index"><</a>
					<a href="../member/index" style="color: white">&nbsp;<img src="/images/VISION2.png" id="imagepreview" style="width: 80px; height: 20px;">&nbsp;카드</a>
					<span style="margin-left: 100px;">
					</span>
				</div>
			</h5>
			<br>
		</div>
	</nav>
<!--카드리스트 시작 ^^!!  -->
		<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="col-md-1"></div>
				<div class="col-md-11">
					<h3>
						<p>
						<h3>
						<p>
							<br>
							<br>
							<br>
						</p>
					</h3>
<div id="use">
<%
	if(couponInven!=null){
		for(int i=0;i<couponInven.size();i++){
%>
<div class="media">
<div class="media-left">
</div>
<div class="media-body">
<h4 class="media-heading"></h4>

<table style="width:200px">
	
	
	
	<tr>
		<td colspan="2">&nbsp;&nbsp;유통기한&nbsp;<%=couponInven.get(i).get("LAST_DATE")%>원</td>
	</tr>
	
	<tr>
		<td colspan="2">&nbsp;&nbsp;쿠폰이름&nbsp;<%=couponInven.get(i).get("COUPON_NAME")%>원</td>
	</tr>
</table>

</div>
</div>
<%			
		}
	}
%>
</div>


						</p>
					</h3>
				</div>
			</div>
		</div>
		<hr>
	</div>
			
<!--카드리스트 끗!!  -->
	<!-- 네비게이션 바 시작 -->
	<!-- 네비게이션 바 끝 -->
	
	<!-- 푸터 시작 -->
	<%@ include file="../include/footer.jsp" %>	
	<!-- 푸터 끝 -->
	<!-- Modal -->

         
	</div>
     
    </div>
  </div>
</div>
</body>
</html>