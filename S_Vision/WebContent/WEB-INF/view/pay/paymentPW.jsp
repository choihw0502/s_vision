<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,block.*" %>   
<%
	Map<String,Object> list = (Map<String,Object>)request.getAttribute("list");
	 if(Wellet.payList.size()==0){
    	 Wellet.payList.add(list);
    	 out.print("payList에 값이 없어서 add함");
    }else{
    	int i = 0;
    	while(i == Wellet.payList.size()){
	    	if(!Wellet.payList.get(i).equals(list)){
		    	out.print("같은 값이 없어서 add");
				    Wellet.payList.add(list);
		    	out.print(Wellet.payList.size());
		    	out.print(Wellet.payList.get(i).values());
	   		}else{
	   			out.print("중복값 있음");
		    	break;
	   		}
    		i++;
    	}
    }
	 out.print(Wellet.payList.size());
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>
		결제 보안 키보드
	</title>
	<link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/4.1.1/flatly/bootstrap.min.css">
	<style>
	body{
background-color: #e0f2f1;
	}
	.container { margin: 150px auto; 
	 }
	 .cryxpad-container{ background-color: #e0f2f1;
	 }
	 	
	 
</style>
</head>
<body>
<div class="jquery-script-center">

<script type="text/javascript"
src="https://pagead2.googlesyndication.com/pagead/show_ads.js">
</script></div>
<div class="jquery-script-clear"></div>
	<div class="container">
		<div id="cryxpad-clavier" style="position: absolute;left: 50%;">
			<div class="row" style="left: -50%;position: relative; ">
				<div class="col">
					<div class="form-group">
						<h5 class="text-center"><label for="cryxpad-input-field"><a href="main2.jsp"><</a>&nbsp;&nbsp;결제 비밀번호 입력
						</label></h5>
						<small id="cryxpad-input-field-help" class="form-text text-muted">카드 비밀번호를 입력하세요.</small>
						<input type="password" class="form-control" id="cryxpad-input-field" aria-describedby="cryxpad-input-field-help" placeholder="비밀번호" style="width: 99%;">
					</div>
				</div>
			</div>
		<div class="cryxpad-container" ></div>
		<div class="cryxpad-clavier">
			<div class="row" style="left: -50%;position: relative;margin-top: 20px;">
				<div class="col">
					<a href="/block/paris">
					<button id="cryxpad-validate-btn" class="btn btn-primary" type="button" style="width: 100px" >입력</button>
					</a>
					<button id="cryxpad-remove-btn" type="button" class="btn btn-danger" style="width: 100px ">삭제</button>
				</div>
			</div>
				    <a href="naversearchapp://search?qmenu=qrcode&version=3"> 				
				    <button type="button" class="btn btn-info">카메라</button>
</a>
		</div>			
		</div>
	</div>
</body>

<!-- <script  src="jquery.min.js"></script> -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script  src="js/jquery.cryxpad.js"></script>
<script type="text/javascript">
	$(function(){
		//Appel par défaut du plug-in
		$('.cryxpad-container').cryxpad({
			'inputFormId':'cryxpad-input-field',
			'removeButtonId':'cryxpad-remove-btn',
			'validateButtonId':'cryxpad-validate-btn',
			'carreaux':4, // nombre de carreaux sur une ligne du clavier
			'width':50, // longeur d'un bouton
			'height':40, // hauteur d'un bouton
		});
	});

//Effacer saisie....
</script>
	<script type="text/javascript">
		setTimeout(function () {
			location.reload();
		}, 180* 1000);
</script>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);
  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
</script>

</html>
