/**
 * js/ajax3.js
 */
//멤버테이블 목록
 const xthp = new XMLHttpRequest(); 
 xthp.open('get', 'memberAjax.do'); //요청할 페이지 지정
 xthp.send();						//요청 정보 보내기
 xthp.onload = function(){			//실행할 함수
	console.log(xthp);
	let data = JSON.parse(xthp.responseText);
	data.forEach(user => {
		document.getElementById('list').appendChild(makeRow(user));
	});
 }

//json 문자열의 필드 이름을 활용.
const fields = ['userId', 'userName', 'userPw', 'responsibility'];

//json 파일로 페이지 만들기
function makeRow(obj = {}){
	let tr = document.createElement('tr');
	//tr.setAttribute('id', obj.userId); //<tr id='user01'
	tr.addEventListener('dblclick', function(e){
		document.getElementById('myModal').style.display = 'block';
		//선택된 사용자의 이름, 비번을 모달창 input박스에 출력.
		console.log(e, this);
		document.getElementById('modify_name').value = this.children[1].innerHTML;
		document.getElementById('modify_pass').value = this.children[2].innerHTML;
		document.getElementById('modify_id').value = this.children[0].innerHTML;
	})
	//var delBtn = document.createElement('button'); //del
	//delBtn.innerHTML = '삭제';
	fields.forEach(field => { 				//필드의 개수만큼 td 만들기
		let td = document.createElement('td');
		td.innerHTML = obj[field];
		tr.appendChild(td);
		//tr.appendChild(delBtn); //del
	});
	let td = document.createElement('td');
	td.innerHTML = "<button class='btn btn-danger' onclick='delFuc(event)'>삭제</button>"
	tr.appendChild(td);
	
	
	//---
	//let btn = document.createElement('button');
	//btn.setAttribute('date-delId', obj.userId);
	//btn.addEventListener('click', removeFnc);
	//btn.innerHTML = '삭제';
	//td.appendChild(btn);
	//tt.appendChild(td);	
	//--	
	return tr;
}

//--
/*function removeFnc(e){
	//dataset속성 = setA~('date-~')
	let delId = this.dataset.delId;
	let tr = document.getElementById(delId);
	const delAjax = new XMLHttpRequest();
	delAjax.open('get', 'delAjax.do?id=' + delId);
	delAjax.send();
	delAjax.onload = function(){
		let result = JSON.parse(delAjax.responseText);
		if(result.retCode == 'success'){
			alert('삭제 성공');
			tr.remove();
		}else{
			alert('삭제 실패');
		}
	}
	console.log('버튼 누름');
}*/
//--

//수정 이벤트
//더블클릭시 모달창 띄우고 아디와 비번 변경하고 수정버튼 누르고 완료
//display: none인 모달을 더블 클릭시 block으로 변경하면 창이 나타난다.
document.getElementById('modBtn').addEventListener('click', function(){
	
	let id = document.getElementById('modify_id').value;
	let name = document.getElementById('modify_name').value;
	let pw = document.getElementById('modify_pass').value;
	
	// ajax 생성
	//정상적으로 정보가 업뎃이 되면 화면수정
	//수정이 안 됐으면 화면 수정 ㄴㄴ
	let targetTr = document.getElementById(id);
	targetTr.children[1].innerHTML = name;
	targetTr.children[2].innerHTML = pw;
	
	const modAjax = new XMLHttpRequest();
	modAjax.open('get', 'modAjax.do?id=' + id + '&name=' + name + '&pw=' + pw);
	modAjax.send();
	modAjax.onload = function(){
		
	}
	
	
	// 모달창 닫기
	document.getElementById('myModal').style.dispaly = 'none';
})


//등록 버튼을 누르면 이벤트 추가
document.getElementById('addBtn').addEventListener('click', function(){
	let id = document.getElementById('uid').value;
	let pw = document.getElementById('upw').value;
	let nm = document.getElementById('uname').value;
	let auth = document.getElementById('auth').value;
	
	const addAjax = new XMLHttpRequest();
	let url = 'addAjax.do?id=' + id + '&pw=' + pw + '&nm=' + nm + '&auth=' + auth;	
	addAjax.open('get', url);
	addAjax.send();
	addAjax.onload = function(){
		let result = JSON.parse(addAjax.responseText);
		if(result.retCode == 'OK') {
			let newMem = {userId: id, userPw: pw, userName: nm, responsibility: auth};
			document.getElementById('list').appendChild(makeRow(newMem));
			alert(result.retMsg);
		} else {
			alert('실패');
		}
	}
	
/*	id = document.se .value;
	pw = document.getElementById('').value;
	nm = document.getElementById('').value;
	auth = document.getElementById('').value;*/
})

//id값을 넣고 체인지 이벤트가 발생하면 id 체크 기능
document.getElementById('uid').addEventListener('change', function(){
	let checkId = this.value;
	const checkAjax = new XMLHttpRequest();
	checkAjax.open('get', 'checkIdAjax.do?id='+checkId);
	checkAjax.send();
	checkAjax.onload = function(){
		let result = JSON.parse(checkAjax.responseText);
		if(result.retCode == 'Exist'){
			alert('이미 존재하는 아이디입니다.');
			//document.getElementById('addBtn').disabled;
			document.querySelector('#addBtn').disabled = true;//비활성화
		}else{
			alert('등록 가능한 아이디입니다.');
			document.querySelector('#addBtn').disabled = false; //활성화
		}
	}
})


//삭제
/*document.getElementById('delBtn').addEventListener('click', function(){
	let delId = document.getElementById('uid').value;
	
	const delAjax = new XMLHttpRequest();
	delAjax.open('get', 'delAjax.do?id=' + delId);
	delAjax.send();
	delAjax.onload = function(){
		let result = JSON.parse(delAjax.responseText);
		if(result.retCode == 'success'){
			alert('삭제 성공');
			
		}else{
			alert('삭제 실패');
		}
	}
})*/


function delFuc(e) {
	console.log(e);
	console.log(e.target.parentElement.parentElement.children[0].innerText);
	//e는 이벤트가 적용되는 대상, 즉 삭제버튼의 부모요소 = td, td의 부모요소 = tr, tr의 0번째 자식 
	let delId = e.target.parentElement.parentElement.children[0].innerText;
	
	const delAjax = new XMLHttpRequest();
	delAjax.open('get', 'delAjax.do?id=' + delId);
	delAjax.send();
	delAjax.onload = function(){
		let result = JSON.parse(delAjax.responseText);
		if(result.retCode == 'success'){
			alert('삭제 성공');
			e.target.parentElement.parentElement.remove();
		}else{
			alert('삭제 실패');
		}
	}
	console.log('버튼 누름');
}


