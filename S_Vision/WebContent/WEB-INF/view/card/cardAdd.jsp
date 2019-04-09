<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int cardAdd = (Integer)request.getAttribute("cardAdd");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카드추가</title>
</head>
<body>
<%
	if(cardAdd==1){
		out.print("카드추가 성공");
	}
	else{
		out.print("카드추가 실패");
		
	}
%>
</body>
</html>