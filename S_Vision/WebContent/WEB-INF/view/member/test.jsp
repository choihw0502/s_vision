<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String mem_id = (String)session.getAttribute("mem_id");
%>
<!-- 화면상단 시작  -->
<%
	if(mem_id!=null){
%>
<%@include file="main_top_login.jsp" %>
<% 
	}else if(mem_id==null){
%>		
<%@include file="main_top_logout.jsp" %>

<% 
	}
%>		

<!-- 화면상단 끝  -->
<!-- 메인화면 시작  -->
<%@include file="main_mid_logout.jsp" %>
<!-- 화면하단 끝  -->
<%@include file="main_bottom.jsp" %>
<!-- 화면하단 끝  -->

</body>
</html>