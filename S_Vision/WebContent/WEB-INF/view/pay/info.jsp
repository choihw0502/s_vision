<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%
	Map<String,Object> idcard = (Map<String,Object>)request.getAttribute("idcard");
	Cookie[] cookies = request.getCookies();
    StringTokenizer st = null;

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(cookies != null){
    for(int i=0; i < cookies.length; i++){
        Cookie c = cookies[i] ;
        // 저장된 쿠키 이름을 가져온다
        String cName = c.getName();
        out.print("<br>");
        out.print(cName);
        // 쿠키값을 가져온다
        String cValue = c.getValue() ;
        String addValue[] =new String[cookies.length]; 
        addValue[i]=cValue; 
        st = new StringTokenizer(cValue,"!");
        int size = st.countTokens();
        System.out.println(size);
        for(int){
        	
        }
//         st.nextToken();
// 		if(idcard.get("mem_id")==paypws[3]){
// 			if(idcard.get("card_num")==paypws[8]){
%>				
<table>
	<tr>
	<td>
	
	</td>
	</tr>
</table>
<%
				out.print("<br>");
			}
		}
//     }
// }
%>

</body>
</html>