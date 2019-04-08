<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List" %>    
<!DOCTYPE html>
<%
	List<Map<String,Object>> accountList = (List<Map<String,Object>>)request.getAttribute("accountList");
	String mem_id = (String)session.getAttribute("mem_id");
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
	<h3>
						<p>
							<br>계좌리스트
						</p>
					</h3>
<script type="text/javascript">
$("#m_accountAdd").on('shown.bs.modal', function(){
    $(this).find('#acc_name').focus();
});
</script>
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
<form id="accList" name="accList" method="post" action="accHistory?mem_id=<%=mem_id%>&acc_num=<%=accountList.get(i).get("ACC_NUM") %>">
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
		<td><button id="btn_acc_history" name="btn_acc_history" type="submit" class="btn" style="width:150px">거래내역</button></td>
		<td><button id="btn_sendMoney" name="btn_sendMoney" type="button" class="btn" style="width:150px">이체</button></td>
	<tr>	
	</table>
</form>
</div>
</div>

<%			
		}
	}
%>


</body>
</html>