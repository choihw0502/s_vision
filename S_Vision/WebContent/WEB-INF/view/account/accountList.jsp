<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List" %>    
<%
	List<Map<String,Object>> accountList = (List<Map<String,Object>>)request.getAttribute("accountList");
	int size = accountList.size();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script" rel="stylesheet">
<style type="text/css">
.font-size-5{
	font-family:'Nanum Pen Script', cursive;
	font-size: 30pt;
}
</style>
</head>
<body>
<script type="text/javascript">
$(document).ready(function (){

	$("#dg_board").datagrid({
	method:"get",
	//url:"./jsonRestBoardList?cb_search=bm_title&tb_search=테스트"
	url:"./jsonRestBoardList?cb_search="+userInput+"&tb_search="+$("#tb_search").val()
	});
}	
</script>
<table class="dg_accountList" style="width:400px;height:250px"
        data-options="url:'account/accountList?mem_id=elesex',fitColumns:true,singleSelect:true">
    <thead>
        <tr>
            <th data-options="field:'ACC_BANK',width:100">Code</th>
            <th data-options="field:'ACC_NAME',width:100">Name</th>
            <th data-options="field:'ACC_NUM',width:100,align:'right'">Price</th>
        </tr>
    </thead>
</table>

<%

	for(Object c:accountList){
		out.print(c);
	}
%>

</body>
</html>