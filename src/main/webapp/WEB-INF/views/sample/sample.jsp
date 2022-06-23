<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link type = "text/css" rel = "stylesheet" href = "resources/css/main.css"></link>
		<script src="https://code.jquery.com/jquery-latest.min.js"></script>
		<script src="resources/js/common.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
	</head>
<body>
	Hello ChartSample!! TEST.. TEST..
	
	<div style="width: 900px; height: 900px;">
	<!--차트가 그려질 부분-->
	<canvas id="canvas"></canvas>
	
</div>
<script type="text/javascript">
	new Chart(document.getElementById("canvas"), {
	    type: 'line',
	    data: {
	        labels: ['1', '2', '3', '4', '5', '6', '7'],
	        datasets: [{
	            label: '작품 히스토리',
	            data: [
	                10,
	                3,
	                30,
	                23,
	                10,
	                5,
	                50
	            ],
	            borderColor: "rgba(255, 201, 14, 1)",
	            backgroundColor: "rgba(255, 201, 14, 0.5)",
	            fill: false,
	            lineTension: 0
	        }]
	    },
	    options: {
	        responsive: true,
	        title: {
	            display: true,
	            text: '딜링아트 응찰 히스토리'
	        },
	        tooltips: {
	            mode: 'index',
	            intersect: false,
	        },
	        hover: {
	            mode: 'nearest',
	            intersect: true
	        },
	        scales: {
	            xAxes: [{
	                display: true,
	                scaleLabel: {
	                    display: true,
	                    labelString: 'x축'
	                }
	            }],
	            yAxes: [{
	                display: true,
	                ticks: {
	                    suggestedMin: 0,
	                },
	                scaleLabel: {
	                    display: true,
	                    labelString: 'y축'
	                }
	            }]
	        }
	    }
	});
</script>
</body>
</html>