<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List" %>        
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
<meta charset="UTF-8">
<mata name="viewport" content="width=device-width" , inital-scale="1">
<head>
<title>계좌 페이지</title>
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
</script>        
</head>

<body>
<%
String mem_id = (String)session.getAttribute("mem_id");
%>
<script type="text/javascript">
$(document).ready(function(){
    $('#btn_accountAdd').on('click', function(){
        $.ajax({
            type: 'POST',
            url: '../account/accountAdd',
            data: {
                "mem_id" : "<%=mem_id%>",
                "acc_num" : document.getElementById("acc_num").value,
                "acc_bank" : document.getElementById("acc_bank").value,
                "acc_name" : document.getElementById("acc_name").value,
            },
            success: function(data){
                if(data == 0){
                   alert("계좌 추가 실패");
                }
                else{
                   alert("계좌 추가 성공");
                   location.href="account";
                }
            }
        });    //end ajax    
    });    //end on    

    $("#m_accountAdd").on('shown.bs.modal', function(){
        $(this).find('#acc_name').focus();
    });
});
  
</script>
<!-- 네비게이션 바 시작 -->
<%@ include file="account_nav.jsp" %>
<%-- <%
RequestDispatcher dispather2 = request.getRequestDispatcher("/account/nav?nav=account");
dispather2.include(request, response);
%> --%>
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
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="col-md-1"></div>
				<div class="col-md-11">
					<h3>
						<p>
						<br>
						<br>
						<h3>
						<p>
							<br>계좌리스트
						</p>
					</h3>
<iframe id="Contents" src="../account/accountList?mem_id=<%=mem_id %>" scrolling="no" frameborder="0" onload="SetElements()"></iframe>
						</p>
					</h3>
				</div>
			</div>
		</div>
		<hr>
	</div>
<!-- Modal -->
<div class="modal fade" id="m_accountAdd" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">계좌 추가하기</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <div class="group row"><div class="col-md-6 form-group"> <label for="foo">계좌이름</label> <input type="text" class="form-control" id="acc_name" name="acc_name"> </div>
 	  </div><br>
 	   <div class="group row">
 	   <div class="col-md-4">
            <select class="combobox form-control" id="acc_bank" name="acc_bank">
              <option value="은행선택" selected="selected">은행선택</option>
              <option value="농협">농협</option>
              <option value="신한은행">신한은행</option>
              <option value="국민은행">국민은행</option>
              <option value="우리은행">우리은행</option>
              <option value="하나은행">하나은행</option>
              <option value="기업은행">IBK기업은행</option>
              <option value="우체국">우체국</option>
              <option value="새마을금고">새마을금고</option>
              <option value="축협">축협</option>
              <option value="수협">수협</option>
            </select>
          </div>
       </div><br>   
       <div class="group row"><div class="col-md-6 form-group"><label for="foo">계좌번호</label> <input type="text" class="form-control" id="acc_num" name="acc_num"></div>
      </div>
      </div>
      <div class="modal-footer">
        <button id="btn_accountAdd" name="btn_accountAdd" type="button" class="btn btn-primary">추가</button>
        </form>
      </div>
    </div>
  </div>
</div>

			


	<!-- 계좌 화면 끝 -->
	<!-- 푸터 시작 -->
<%@ include file="../include/footer.jsp" %>	
	<!-- 푸터 끝 -->
</body>
</html>