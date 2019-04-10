<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 	response.addCookie(new Cookie("store_name","파리바게트"));
// 	response.addCookie(new Cookie("store_name","2,600"));
//// 	쿠키에 담긴 정보 삭제 후 로그인 화면으로 이동 처리하세요.
// 	insert here - 쿠키 삭제하기
// 	Cookie cooks[] = request.getCookies();
// 	if(cooks!=null&&cooks.length>0){
// 		for(int i=0;cooks.length>i;i++){
// 			Cookie cook = new Cookie("cmem_name","");
// 			cook.setMaxAge(0);
// 			cook.setPath("/");
// 			response.addCookie(cook);
// 		}
// 	}
// // 	insert here - 화면 이동 처리하기
// 	response.sendRedirect("./loginForm.jsp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파리바게트 구매 페이지</title>
</head>
<body>
<div class="content">
	<div class="header" style="text-align: center;">
		<h4 class="modal-title">파리바게트</h4>
	</div>
	<div class="body" style="text-align: center;">
		레드벨벳 치즈케이크<br> <img src="images/케이크.jpg" id="imagepreview"
			style="width: 256px; height: 150px"> <br> ￦2,600
	</div>
	<div class="footer" style="text-align: center;">
	    <a href="payment.jsp">
			<button type="button" class="btn btn-default">
			결제
			</button>
		</a>
		<button type="button" class="btn btn-default" >취소</button>
	</div>
</div>
</body>
</html>