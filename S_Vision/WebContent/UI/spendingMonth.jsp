<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.vo.PlanVO" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>

<jsp:include page="../WEB-INF/view/common/UI_common.jsp"></jsp:include>
<%
	PlanVO planVO = (PlanVO)session.getAttribute("planVO");
	Calendar cal = Calendar.getInstance();
	String month = (String)request.getParameter("month");	
	String r_ever = (String)planVO.getR_month().get(0).get("R_EVER");
	String r_month = (String)planVO.getR_month().get(0).get("R_SUM"+month);
	
	Gson gsonObj = new Gson();
	Map<Object,Object> map1 = null;
	Map<Object,Object> map2 = null;
	List<Map<Object,Object>> list1 = new ArrayList<Map<Object,Object>>();
	List<Map<Object,Object>> list2 = new ArrayList<Map<Object,Object>>();
	String dataPoints = "";
	String dataPoints2 = "";	
	
	if(r_ever !=null && r_ever.length()>1){
		
		String [] r_evers = r_ever.split("/");
		String[] r_months = r_month.split("/");
		int y = 1; 
		for(int i=1;i<r_evers.length;i++) {
		
			map1 = new HashMap<Object,Object>();
			map2 = new HashMap<Object, Object>();
				map1.put("x", y);
				map1.put("y", Integer.parseInt(r_evers[i]));
				list1.add(map1);
				map2.put("x", y);
				map2.put("y", Integer.parseInt(r_months[i]));
				list2.add(map2);				
				y = y + 2;
			}
		dataPoints = gsonObj.toJson(list1);
		dataPoints2 = gsonObj.toJson(list2);
	}
%>
 
<!DOCTYPE HTML>
<html>
<head>
<meta charset=UTF-8">
<script type="text/javascript">


$(document).ready(function(){
 
var chart = new CanvasJS.Chart("month_drop", { 
	animationEnabled: true, 
	theme: "light",
	title: {
		text: "월 기준 지출내역"
	},
	subtitles: [{
		text: "지출 총액:"
	}],
	axisX: {
		includeZero: false
	},
	axisY: {
		includeZero: false,
		prefix: ""
	},
	toolTip: {
		shared: true
	},
	legend:{
		cursor: "pointer",
		itemclick: toggleDataSeries
	},
	data: [{
		type: "stepArea",
		name: "평균 지출액",
		color: "#BDBDBD",
		showInLegend: true,
		yValueFormatString: "￦#,##0",
		dataPoints: <%out.print(dataPoints);%>
	},
	{
		type: "stepArea",
		name: "이번달 지출액",
		color: "#6799FF",
		showInLegend: true,
		indexLabel: "{y}",
		yValueFormatString: "￦#,##0",
		dataPoints: <%out.print(dataPoints2);%>
	}]
});
 
chart.render();
 
function toggleDataSeries(e){
	if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
		e.dataSeries.visible = false;
	}
	else{
		e.dataSeries.visible = true;
	}
	chart.render();
}
 
});
</script>
</head>
<body>

<div id="month_drop" style="height: 100%; width: 100%;"></div>
</body>
</html>