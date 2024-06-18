/**
 * 달력 만들기! ㅎㅎ
 */

 //querySelectorAll의 반환 타입은 nodeLsit
 document.querySelectorAll('.container-fluid h3').forEach(item => item.remove());
 
 document.querySelectorAll('.container-fluid table.table').forEach(item => item.remove());
 /*document.getElementById('fruit').remove();*/
 
 
 //change 이벤트 -- 
document.getElementById('selectMonth').addEventListener('change', function(){
	makeCalendar(parseInt(this.value));	
 }); 

 
 
 
/* function selcMonFnc(selecMon){
	if(selecMon.value == 5){
		makeCalendar(month = 5);
	}
 }
 function selcMonFnc(){
	if(selecMon.value == 6){
		makeCalendar(month = 6);
	}
 }
 function selcMonFnc(){
	if(selecMon.value == 7){
		makeCalendar(month = 7);
	}
 }*/
 
 /*let selecMon = document.querySelector('#selectMonth');*/
/* let selecMon = document.getElementById('selectMonth').value;
 selecMon.addEventListener('change', selcMonFnc);
 
 function selcMonFnc(selecMon){
	if(selecMon.value = 5){
		makeCalendar(month = 5);
	}
 }
 function selcMonFnc(){
	if(selecMon.value = 6){
		makeCalendar(month = 6);
	}
 }
 function selcMonFnc(){
	if(selecMon.value = 7){
		makeCalendar(month = 7);
	}
 }*/
 
/*document.getElementById('selectMonth').value;*/
/*document.querySelector('#selectMonth').addEventListener('change', selcMonFnc); 
 function selcMonFnc(){
	if(selectMonth.value = 5){
		makeCalendar(month = 5);
	}
 }
 function selcMonFnc(){
	if(selectMonth.value = 6){
		makeCalendar(month = 6);
	}
 }
 function selcMonFnc(){
	if(selectMonth.value = 7){
		makeCalendar(month = 7);
	}
 }*/
 
 
//달력을 만들 때엔 첫째 날이 무슨 요일인지 마지막 날이 며칠인지 알면 된다.
//첫째 날을 계산하는 함수와, 마지막 날을 계산하는 함수가 필요하다.
//--6월기준 7번째가 1일이라서 7을 리턴
function getFirstDay(month = 6){ //month의 값에 따라 결과가 달라짐. 초기값은 6
	switch(month){
		case 5: return 4;
		case 7: return 2;
	}
	return 7;
}

function getLastDate(month = 6){
	switch(month){
		case 5:
		case 7:
			return 31; //5,7 리턴값이 같으므로 한 번만 리턴
	}
	return 30;
}

function makeCalendar(month = 6){
	let firstDay = getFirstDay(month); //1일의 위치를 지정하기 위해서 공란의 
	let lastDaty = getLastDate(month);
	
	// table 생성. border="2"
	let tbl = document.createElement('table');
	tbl.setAttribute('class', 'table');
	let thd = document.createElement('thead');
	let tbd = document.createElement('tbody');
	
	document.getElementById('show').innerHTML = '';
	
	//thead 하위 요소
	let days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];
	let tr = document.createElement('tr');
	//forEach(ele, idx, ) 즉, day = 요소 ('Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat')
	days.forEach(day => {
		let td = document.createElement('th');
	    td.innerHTML = day;
	    tr.appendChild(td);
	});
	thd.appendChild(tr);
	
	
	//tboay 하위 요소
	tr = document.createElement('tr');
	//날짜칸에 빈공간 만들어주기
	for(let i = 1; i < firstDay; i++){
		let td = document.createElement('td');
		tr.appendChild(td);
	}
	
	//날짜 출력하는 부분
	for(let d = 1; d <= lastDaty; d++){
		let td = document.createElement('td');
		td.innerHTML = d;
	    tr.appendChild(td);	    

		//일요일은 빨간색으로 출력
		if((d + getFirstDay(month) -2) % 7 == 0){
			td.style.color = 'red';
		}
	    
	    if((d + getFirstDay(month) -1) % 7 == 0){   //7일마다 줄바꿈해주는 역학
	   		td.style.color = 'blue';           //토요일에 파란색으로 출력
			tbd.appendChild(tr);
			tr = document.createElement('tr');
		}
	}
	tbd.appendChild(tr);	
	
	//
	tbl.appendChild(thd);
	tbl.appendChild(tbd);

	
	document.getElementById('show').appendChild(tbl);
}
//5월 달력을 보고 싶다면 매개값으로 5, 6은 초기값으로 정해져있으니 아무것도 입력 ㄴ
makeCalendar();