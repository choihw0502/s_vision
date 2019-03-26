<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int accountAdd = (Integer)request.getAttribute("accountAdd");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(accountAdd==1){
		out.print("계좌추가 성공");
	}
	else{
		out.print("계좌추가 실패");
		
	}
%>
</body>
</html>