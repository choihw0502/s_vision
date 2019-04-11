<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.vo.PlanVO" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<jsp:include page="../WEB-INF/view/common/UI_common.jsp"></jsp:include>
<%
PlanVO planVO = (PlanVO) session.getAttribute("planVO");

	Map<Object, Object> map1 = null;
	Map<Object, Object> map2 = null;
	List<Map<Object, Object>> list1 = new ArrayList<Map<Object, Object>>();
	List<Map<Object, Object>> list2 = new ArrayList<Map<Object, Object>>();
	String month = (String) request.getParameter("month");
	String r_cnts = (String) planVO.getR_week().get(0).get("R_CNT" + month);
	String r_sums = (String) planVO.getR_week().get(0).get("R_SUM" + month);

	if(r_cnts !=null && r_cnts.length()>1){

	String[] r_cnt = r_cnts.split("/");
	String[] r_sum = r_sums.split("/");
	String day = "";
	for (int i = 0; i < r_cnt.length; i++) {

		switch(i) {
			case 0:
				day="일요일";
			break;
			case 1:
				day="월요일";
			break;
			case 2:
				day="화요일";
				break;
			case 3:
				day="수요일";
				break;
			case 4:
				day="목요일";
				break;
			case 5:
				day="금요일";
				break;
			case 6:
				day="토요일";
				break;
		}
		map1 = new HashMap<Object, Object>();
		map2 = new HashMap<Object, Object>();
		map1.put("label", day);
		map2.put("label", day);
		map1.put("y", Integer.parseInt(r_cnt[i]));
		map2.put("y", Integer.parseInt(r_sum[i]));
		list1.add(map1);
		list2.add(map2);
		
	}
	}
	Gson gsonObj = new Gson();

	String dataPoints = gsonObj.toJson(list2);

	String dataPoints2 = gsonObj.toJson(list1);

%>
 
<!DOCTYPE HTML>
<html>
<head>
<meta charset=UTF-8">
<script type="text/javascript">
$(document).ready(function(){
	 
	var chart1 = new CanvasJS.Chart("week_sum", { 
		animationEnabled: true,
		theme: "light3", // "light1", "light2", "dark1", "dark2"
		title:{
			text: "요일기준"
		},
		axisY: {
			title: "금액"
		},
		data: [{        
			type: "column",  
			showInLegend: true, 
			legendMarkerColor: "grey",
			legendText: "금액 기준",
			dataPoints: <%out.print(dataPoints);%>
		}]
	});
	var chart2 = new CanvasJS.Chart("week_cnt", { 
		width:  $( window ).width(),
		animationEnabled: true,
		theme: "light3", // "light1", "light2", "dark1", "dark2"
		title:{
			text: "요일기준"
		},
		axisY: {
			title: "건수"
		},
		data: [{        
			type: "column",  
			showInLegend: true, 
			legendMarkerColor: "grey",
			legendText: "건수 기준",
			dataPoints: <%out.print(dataPoints2);%>
		}]
});
	chart2.render();
	chart1.render();

});
</script>

</head>
<body>
<div id="total_Day" class="span12" style="width: 100%; height:100%;">
	<div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
	    <ul id="myTab" class="nav nav-tabs" role="tablist" >
	      <li role="presentation" class="active" style="width: 50%; text-align: center;"><a href="#week_sum_pane" id="week_sum-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">합계순</a></li>
	      <li role="presentation" style="width: 50%; text-align: center"><a href="#week_cnt_pane" role="tab" id="week_cnt-tab" data-toggle="tab" aria-controls="profile">건수 순</a></li>
	    </ul>
	    <div id="myTabContent" class="tab-content">
		      <div role="tabpanel" class="tab-pane fade in active" id="week_sum_pane" aria-labelledBy="week_sum-tab">
					<div class="container-fluid" >
							<div id="week_sum"></div>
					</div>
				</div>
	      <div role="tabpanel" class="tab-pane fade" id="week_cnt_pane" aria-labelledBy="week_cnt-tab">
		        	<div class="container-fluid" >
					 		<div id="week_cnt"></div>
					</div>
	      </div>
	      
	    </div>
	  </div>
</div>
</body>
</html>