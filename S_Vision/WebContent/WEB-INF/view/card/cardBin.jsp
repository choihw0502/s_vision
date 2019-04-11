<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List" %>    
<%
	List<Map<String,Object>> cardBin = (List<Map<String,Object>>)request.getAttribute("cardBin");
	int size = cardBin.size();
	out.print(cardBin);
%> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CardBin</title>
</head>
<body>

</body>
</html>