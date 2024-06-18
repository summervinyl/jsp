/**
 * 
 */
//첫 번째 날
 function firstDay(){
	return 2;
 }
 
 //마지막 날
 function lastDate(){
	return 31;
 }
 
 //테이블 안에 데이터 담기
 function calendarJul(){
	let table = document.createElement('table');
	table.setAttribute('border', '1');
	let thead = document.createElement('thead');
	let tbody = document.createElement('tbody');
	
	//thead = 테이블의 머리말같은 느낌? 캘린더 테이블의 thead는 월 화 수 목 금 토 일
	let days = ['일', '월', '화', '수', '목', '금', '토'];
	//tr = 행
	let tr = document.createElement('tr');
	let td = document.createElement('td');
	days.forEach(td)
	
	//tbody
	
	
	//날짜 출력	
	
	table.appendChild('tr');
	
	
	
 }