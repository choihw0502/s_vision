<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>

<%
	List<Map<Object, Object>> rlist = (List<Map<Object, Object>>) request.getAttribute("boardList");
	List<Map<Object, Object>> rlist1 = (List<Map<Object, Object>>) request.getAttribute("boardList1");

	Gson gsonObj = new Gson();

	String dataPoints = gsonObj.toJson(rlist);

	String dataPoints2 = gsonObj.toJson(rlist1);
%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset=UTF-8">
<script type="text/javascript">
	window.onload = function() {

		var chart = new CanvasJS.Chart("chartContainer", {
			animationEnabled : true,
			theme : "light",
			title : {
				text : "지출 내역"
			},
			subtitles : [ {
				text : "지출 총액:"
			} ],
			axisX : {
				includeZero : false
			},
			axisY : {
				includeZero : false,
				prefix : ""
			},
			toolTip : {
				shared : true
			},
			legend : {
				cursor : "pointer",
				itemclick : toggleDataSeries
			},
			data : [ {
				type : "stackedArea100",
				name : "평균 지출액",
				color : "#BDBDBD",
				showInLegend : true,
				yValueFormatString : "￦#,##0",
				dataPoints :
<%out.print(dataPoints);%>
	}, {
				type : "stackedArea100",
				name : "이번달 지출액",
				color : "#6799FF",
				showInLegend : true,
				indexLabel : "{y}",
				yValueFormatString : "￦#,##0",
				dataPoints :
<%out.print(dataPoints2);%>
	} ]
		});

		chart.render();

		function toggleDataSeries(e) {
			if (typeof (e.dataSeries.visible) === "undefined"
					|| e.dataSeries.visible) {
				e.dataSeries.visible = false;
			} else {
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