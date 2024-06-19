/**
 * js/ajax2.js
 * XMLHttpRequest 객체.
 */
//객체라서 속성, 메소드가 있음
const xhtp = new XMLHttpRequest();
xhtp.open('get', 'data/MOCK_DATA.json'); //open: 페이지지정 = 데이터 요청
xhtp.send(); //요청 결과 받기
xhtp.onload = function(){  //on~ 이벤트와 관련된 기능, 요청된 결과 로드 
	// console.log(xhtp); //콘솔에 결과를 보면 XMLHttpRequest의 속성들을 볼 수 있다.
	// console.log(xhtp.response); //그 중에 response or responseText는 처리 결과를 담고있다.	
	let data = JSON.parse(xhtp.response); //json 문자열 타입을 자바스크립트 객체로 파싱(해석, 변환)해준다. - 배열 형태로 변환
	// console.log(data);
	// DOM 메소드를 이용해서 페이지 그려주기(작성)
	data.forEach(function(emp){
		console.log(emp);
		document.getElementById('list').appendChild(makeRow(emp));		
	});
}

let fields = ['id','first_name','email','salary'];

//json 파일로 페이지 만들기
function makeRow(obj = {}){
	let tr = document.createElement('tr');
	fields.forEach(field => { 				//필드의 개수만큼 td 만들기
		let td = document.createElement('td');
		td.innerHTML = obj[field];
		tr.appendChild(td);
	})
	
	// let th = document.createElement('th');
	
	return tr;
}




const xhtm = new XMLHttpRequest();
xhtm.open('get', 'loginForm.do');
xhtm.send();
xhtm.onload = function(){
	// console.log(xhtm.responseText);
	// document.getElementById('show').innerHTML = xhtm.response;
	}

console.log('end');




//tip. 객체 사용방법 2가지
//1. 객체.속성
//2. 변수를 만들어서 대체하거나 키값을 그대로 적어주기 ex) 객체['key'], 객체[변수명]

//json 파일로 페이지 만들기
//1.데이터 가져오기.
//2.페이지에 나타낼 행 그리기
