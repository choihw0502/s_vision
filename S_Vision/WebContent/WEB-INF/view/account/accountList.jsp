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
.font-size-5{
	font-family:'Nanum Pen Script', cursive;
	font-size: 30pt;
}
</style>
</head>
<body>
<%
	if(accountList!=null){
		for(int i=0;i<accountList.size();i++){
%>
<div class="card border-success mb-3" style="max-width: 20rem;">
  <div class="card-header bg-transparent border-success"><%=accountList.get(i).get("ACC_NAME") %></div>
  <div class="card-body text-success">
    <h4 class="card-title"><%=accountList.get(i).get("ACC_BANK") %></h4>
    <p class="card-text"><%=accountList.get(i).get("ACC_NUM") %></p>
  </div>
  <div class="card-footer bg-transparent border-success"><%=accountList.get(i).get("ACC_BALANCE") %></div>
</div>
<%			
		}
	}
%>
</body>
</html>