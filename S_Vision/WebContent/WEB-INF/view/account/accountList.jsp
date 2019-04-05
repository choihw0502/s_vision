<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List" %>    
<!DOCTYPE html>
<%
	List<Map<String,Object>> accountList = (List<Map<String,Object>>)request.getAttribute("accountList");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<style type="text/css">
s1 {
  color: orange;
  font-size: 110%;
} 
s2 {
  color: black;
} 
s3 {
  text-align: right;	
} 
</style>
</head>
<body>
<%
	if(accountList!=null){
		for(int i=0;i<accountList.size();i++){
%>


<div class="media">
<div class="media-left">
<a href="#"> <img class="media-object" src="/images/형원.jpg" style="width: 200px; height: 200px">
</a>
</div>
<div class="media-body">
<h4 class="media-heading"></h4>
	<table style="width:300px">
	<tr>
		<td colspan="2" style="color:orange; font-size:120%; background-color:grey"><%=accountList.get(i).get("ACC_NUM") %></td>
	</tr>
	<tr>
		<td colspan="2">&nbsp;&nbsp;<%=accountList.get(i).get("ACC_BANK") %></td>
	</tr>
	<tr>
		<td colspan="2">&nbsp;&nbsp;<%=accountList.get(i).get("ACC_NAME") %></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;최종거래일</td>
		<td style="text-align:right"><%=accountList.get(i).get("ACC_DATE") %></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;잔액</td>
		<td style="text-align:right; color:blue;"><%=accountList.get(i).get("ACC_BALANCE") %><s2>원</s2></td>
	</tr>
	<tr>
		<td><button id="btn_acc_history" name="btn_acc_history" type="button" class="btn" style="width:150px">거래내역</button></td>
		<td><button id="btn_sendMoney" name="btn_sendMoney" type="button" class="btn" style="width:150px">이체</button></td>
	<tr>	
</table>
</div>
</div>

<%			
		}
	}
%>

<div class="modal fade" id="m_accountAdd" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">계좌 거래내역</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <table>
      	<tr>
      		<td></td>
      		<td></td>
      		<td></td>
      		<td></td>
      	</tr>
      	<tr>
      		<td></td>
      		<td colspan="3"></td>
      	</tr>
      </table>
      </div>
        </form>
    </div>
  </div>
</div>

</body>
</html>