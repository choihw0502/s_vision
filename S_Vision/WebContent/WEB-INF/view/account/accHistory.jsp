<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List" %>
<%
	Map<String, List<Map<String, Object>>> accHistory = (Map<String, List<Map<String, Object>>>)request.getAttribute("accHistory");
	String choice = "";

%>    
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
<title>계좌 페이지</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/bin.css">
<script type="text/javascript">
	function 1month(){
<%
	choice = "1"; 
%>
		}
	function 3month(){
<%
	choice = "3"; 
%>
		}
	function 6month(){
<%
	choice = "6"; 
%>
		}
	function 12month(){
<%
	choice = "12"; 
%>
		}
	function today(){
<%
	choice = "today"; 
%>
		}
</script>
<button type="button" data-toggle="modal" data-target="#m_accountAdd">거래내역봐볼까</button>

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
      <button class="button button-primary" id="btn_1month" name="btn_1month" onClick="1month()"></button>
      <button class="button button-primary" id="btn_3month" name="btn_3month" onClick="3month()"></button>
      <button class="button button-primary" id="btn_6month" name="btn_6month" onClick="6month()"></button>
      <button class="button button-primary" id="btn_12month" name="btn_12month" onClick="12month()"></button>
      <button class="button button-primary" id="btn_today" name="btn_today" onClick="today()"></button>
      <table>
<%
	for(int i=0;i<accHistory.get(choice).size();i++){
%>      
      	<tr>
      		<td><%=accHistory.get(choice).get(i).get("ACC_DATE") %></td>
      		<td><%=accHistory.get(choice).get(i).get("ACC_PRICE") %></td>
      		<td><%=accHistory.get(choice).get(i).get("ACC_BALANCE") %></td>
      	</tr>
<% 
	}
%>
      </table>
      </div>
        </form>
    </div>
  </div>
</div>
</body>
</html>