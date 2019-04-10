<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.*" %>
<%@page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<%
	List<Map<String,Object>> cardAllList = (List<Map<String,Object>>)request.getAttribute("cardAllList");
	List<Map<String,Object>> allCard = (List<Map<String,Object>>)request.getAttribute("allCard");

	
%>

<html>
<head>
<meta charset="UTF-8">
<mata name="viewport" content="width=device-width" , inital-scale="1">
<title>카드 페이지</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/bin.css">
<script type="text/javascript">
var card1 = $("#cardnum1").length();
</script>  
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
</script>     
</head>
<body>
<%
	String mem_id = (String)session.getAttribute("mem_id");
%>
<script type="text/javascript">
$(document).ready(function(){
	$(this).find('#acc_name').focus();
    $('#btn_cardAdd').on('click', function(){
        $.ajax({
            type: 'POST',
            url: '../card/cardAdd',
            data: {
            	"mem_id" : "<%=mem_id%>",
                "cardnum" : document.getElementById("cardnum1").value+document.getElementById("cardnum2").value+
                document.getElementById("cardnum3").value+document.getElementById("cardnum4").value
            },
            success: function(data){
                if(data == 0){
                   alert("카드 추가 실패");
                }
                else{
                   alert("카드 추가 성공");
                   location.href="card";
                }
            }
        });      
    });   

    $("#exampleModal").on('shown.bs.modal', function(){
        $(this).find('#cardnum1').focus();
    });
        
});

  
</script>
<script type="text/javascript">
 $(document).ready(function(){
var v_usecard = document.getElementById("use");
var v_allcard = document.getElementById("all");


v_usecard.style.display = 'block';
v_allcard.style.display = 'none';


	$("#btn_useCard").click(function(){
		v_usecard.style.display = 'block';
		v_allcard.style.display = 'none';

	  });
	  $("#btn_allCard").click(function(){
			v_usecard.style.display = 'none';
			v_allcard.style.display = 'block';

	  });
	}); 
</script>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<br>
			<h4>
				<div class="navbar-header">
					<a style="color: #ffffff; height: 25px" href="index"><</a>
					<a href="card" style="color: white">&nbsp;<img src="/images/VISION2.png" id="imagepreview" style="width: 80px; height: 20px;">&nbsp;카드</a>
					<span style="margin-left: 150px;"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" img src="/images/card.png">&nbsp;카드 추가</a></span>
					
				</div>
			</h4>
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
					<button id="btn_useCard" name="btn_useCard" type="button" class="btn" style="width:150px">이번 달 사용카드</button></td>
	             	<button id="btn_allCard" name="btn_allCard" type="button" class="btn" style="width:150px">나의 카드 목록</button></td>
							<br>
							<br>
							<br>
						</p>
					</h3>
<div id="use">
<%


	if(cardAllList!=null){
		for(int i=0;i<cardAllList.size();i++){
%>
<div class="media">
<div class="media-left">
</div>
<div class="media-body">
<h4 class="media-heading"></h4>
<table style="width:300px">
	<tr>
	 <td rowspan="3"><img src="/images/<%=cardAllList.get(i).get("BIN_COMPANY") %>.png">
	 <td colspan="2" style="color:orange; font-size:120%; background-color:grey">
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=cardAllList.get(i).get("BIN_NAME") %></td>
	</tr>
	<tr>
		<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=cardAllList.get(i).get("BIN_COMPANY") %></td>
	</tr>
	<tr>
		<td colspan="2">&nbsp;&nbsp;<%=cardAllList.get(i).get("CARD_NUM") %></td>
 	</tr> 
	<tr>
		<td colspan="2">&nbsp;&nbsp;이번달 사용금액&nbsp;<%=cardAllList.get(i).get("PH_PRICE")%>원</td>
	</tr>
	 <tr>
		
</table>

</div>
</div>

<%			
		}
	}
%>
</div>

<div id="all">
<%

	if(allCard!=null){
		for(int i=0;i<allCard.size();i++){
%>
<div class="media">
<div class="media-left">
</div>
<div class="media-body">
<h4 class="media-heading"></h4>
<table style="width:300px">
	<tr>
	 <td rowspan="3"><img src="/images/<%=allCard.get(i).get("BIN_COMPANY") %>.png">
	 <td colspan="2" style="color:orange; font-size:120%; background-color:grey">
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=allCard.get(i).get("BIN_NAME") %></td>
	</tr>
	<tr>
		<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=allCard.get(i).get("BIN_COMPANY") %></td>
	</tr>
	<tr>
		<td colspan="2">&nbsp;&nbsp;<%=allCard.get(i).get("CARD_NUM") %></td>
 	</tr> 
	<tr>
		
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
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">카드 추가하기</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
	<div class="modal-body">
       <div class="form-group"> <label for="foo">카드번호</label></div>
        <div class="form-group row">
            <div class="col-md-3">
                <input type="text" class="form-control focusedInput" id="cardnum1" placeholder="">
            </div>
                <div class="col-md-3">
                    <input type="text" class="form-control" id="cardnum2" placeholder="">
                </div>
                <div class="col-md-3">
                    <input type="text" class="form-control" id="cardnum3" placeholder="">
                </div>
                <div class="col-md-3">
                    <input type="text" class="form-control" id="cardnum4" placeholder="">
                </div>                                
        </div>
	</div>
      <div class="modal-footer">
         <button id="btn_cardAdd" name="btn_cardAdd" type="button" class="btn btn-primary">추가</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>