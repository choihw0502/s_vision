<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
 
<%
List<Map<Object, Object>> r_ever = (List<Map<Object, Object>>)request.getAttribute("r_cnt");
List<Map<Object, Object>> r1 = (List<Map<Object, Object>>)request.getAttribute("r_sum");

Gson gsonObj = new Gson();

String dataPoints = gsonObj.toJson(r_ever);

 
String dataPoints2 = gsonObj.toJson(r1);

%>
 
<!DOCTYPE HTML>
<html>
<head>
<meta charset=UTF-8">
<script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", { 
	animationEnabled: true, 
	theme: "light",
	title: {
		text: "지출 내역"
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
		type: "column",
		name: "건수",
		color: "#BDBDBD",
		showInLegend: true,
		yValueFormatString: "##0",
		dataPoints: <%out.print(dataPoints);%>
	},
	{
		type: "column",
		name: "요일별 지출액",
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
 
}
</script>

</head>
<body>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>