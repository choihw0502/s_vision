<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List" %>    
<!DOCTYPE html>
<%
	List<Map<String,Object>> cardAllList = (List<Map<String,Object>>)request.getAttribute("cardAllList");
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
	if(cardAllList!=null){
		for(int i=0;i<cardAllList.size();i++){
%>
<table style="width:300px">
	<tr>
		<td rowspan="3"><img src="/images/행복드림카드.PNG">
		<td colspan="2" style="color:orange; font-size:120%; background-color:grey"><%=cardAllList.get(i).get("BIN_NAME") %></td>
	</tr>
	<tr><td></td>
		<td colspan="2">&nbsp;&nbsp;<%=cardAllList.get(i).get("BIN_COMPANY") %></td>
	</tr>
	<tr><td></td>
		<td colspan="2">&nbsp;&nbsp;<%=cardAllList.get(i).get("CARD_NUM") %></td>
	</tr>
	<tr>
		<td>
		</td>
	</tr>
	<!-- <tr>
		<td><button id="btn_accountAdd" name="btn_accountAdd" type="button" class="btn" style="width:150px">거래내역</button></td>
		<td><button id="btn_accountAdd" name="btn_accountAdd" type="button" class="btn" style="width:150px">이체</button></td>
	<tr>	 -->
</table>

<%			
		}
	}
%>
</body>
</html>