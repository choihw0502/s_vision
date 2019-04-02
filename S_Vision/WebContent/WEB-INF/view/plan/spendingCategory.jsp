<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
 
<%

List<Map<Object, Object>> r1 = (List<Map<Object, Object>>)request.getAttribute("r1");
String cen = (String)request.getAttribute("center");

Gson gsonObj = new Gson();

String dataPoints = gsonObj.toJson(r1);
%>
 
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true, 
	theme: "light",
	title: {
		text: "카테고리별 지출"
	},
	legend: {
		verticalAlign: "center",
		horizontalAlign: "left"
	},
	subtitles: [{
		text: "<%=cen%>",
		verticalAlign: "center",
		fontSize: 24,
		dockInsidePlotArea: true
	}],
	
	data: [{
		type: "doughnut",
		showInLegend: true,
		legendText: "{label} : ￦{y}",
		indexLabel: "{label}",
		toolTipContent: "<b>{label}</b>: ￦{y}",
		dataPoints : <%out.print(dataPoints);%>
	}]
	
});
chart.render();
 
}
</script>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
