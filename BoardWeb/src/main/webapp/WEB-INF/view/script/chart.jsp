<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	<!-- 개발자 키 없어도 사용 가능 -->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      //google.charts.setOnLoadCallback(drawChart);
		
 	  let centerAry = []; //centerAry 배열의 값을 arrayToDataTable에 넣어주기
      // ajax 호출. url의 값은 centerChart.do / 결과값은 json 문자열
      centerAry.push(['시도명', '센터개수']);
      
      fetch('centerChart.do')
	  	.then(result => result.json())
	  	.then(result => {
	  		console.log(result);
 	  		//for(let prop in result){
	  		//	centerAry.push([prop, result[prop]]); //java script 표현식
	  		//}

	  		result.forEach(center => {
	  			centerAry.push([center.sido, center.count]);
	  		})
  			google.charts.setOnLoadCallback(drawChart); //비동기처리의 순서
      	});
	  
      
      //순서 중요 : centerAry에 데이터가 없으면 차트를 그릴 수 없음
      
      
      
      
      
      
      
      
      
      function drawChart() {
		//[{}, {}, {}] => [[], [], []] : 배열 안에 배열로 출력
		console.log(centerAry.length);
        var data = google.visualization.arrayToDataTable(centerAry);

        var options = {
          title: '시도별 센터 개수'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>