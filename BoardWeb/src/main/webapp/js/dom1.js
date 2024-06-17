/**
 * dom1.js
 */

 //id값으로 요소 선택
 document.getElementById('fruit').style.display = 'none';
 
 //추가 버튼 가운데로 설정하기.
 //두 번째 테이블에 5번째 tr에 align="center" 설정하기
 document.querySelector('table.table tr:nth-of-type(5)').setAttribute('align', 'center');
 
 // 페이지 로딩하면서 회원 3명 출력. --data.js
 for(let mem of myMembers){
	document.getElementById('memberList').appendChild(addRow(mem));
 }
 
 //추가 버튼시 두번째 테이블에 사용자의 입력 값을 추가
 //추가 버튼에 클릭 이벤트 등록
 document.getElementById('addBtn').addEventListener('click', addMemberFnc); //펑션을 직접 입력해도 되고 
 document.getElementById('modBtn').addEventListener('click', modMemberFnc);
 document.getElementById('delBtn').addEventListener('click', removeMemberFnc);
 
 document.querySelector('thead input[type="checkbox"]').addEventListener('change', allCheckFnc);
 

 
 //사용자가 클릭하면 addMemberFnc실행 
 function addMemberFnc(){
	//상수(const)
	const id = document.getElementById('mid').value;
	const name = document.getElementById('mname').value;
	const phone = document.getElementById('mphone').value;
	const point = document.getElementById('mpoint').value;
	
	//!id = id가 null이거나 0이면
	if(!id || !name || !phone || !point){
		alert('값을 입력하시오!');
		return;	
	}	
	
	//memberList에 appendChild : 자식 요소 추가 (id, name, phone, point)
	document.getElementById('memberList').appendChild(addRow({id, name, phone, point}));
	
	document.getElementById('mid').value = "";
	document.getElementById('mname').value = "";
	document.getElementById('mphone').value = "";
	document.getElementById('mpoint').value = "";
	
 }
 const id = 'ser0';
 const name = 'hhh';
 const phone = '010-2222';
 const point = 99;
 
 //member = {} : 매개값으로 객체타입
 function addRow(member = {id, name, phone, point}){
	// tr> td * 4 먼저 tr을 만들고 tr 하위에 td 4개를 만든다
	const tr = document.createElement('tr');
	//tr에 대한 이벤트 생성 addEventListener(이벤트기능, 이벤트 핸들러)
	tr.addEventListener('click', showDetailFnc);
	
	//for ~ in : 객체의 갯수만큼 반복 - prop : 속성(id, name, phone, point)
	for(let prop in member){
		const td = document.createElement('td');
		td.innerHTML = member[prop];
		tr.appendChild(td);
	}
	
	//입력된 값 삭제 버튼 생성
	//<td><button>삭제</button></td>	
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.addEventListener('click', removeTrElement);
	btn.innerHTML = '삭제';
	btn.addEventListener('click', () => {btn.parentNode.parentNode.remove()});
	td.appendChild(btn);
	tr.appendChild(td);
	
	//체크박스 생성
	td = document.createElement('td');
	btn = document.createElement('input');
	btn.setAttribute('type', 'checkbox');
	//버튼을 td에 붙이기?
	td.appendChild(btn);
	tr.appendChild(td);
	
	return tr;
 }
 
 //이벤트 핸들러
 function removeTrElement(e){
	console.log('btn 이벤트', e);	
	e.stopPropagation();
	console.log(this.parentElement.parenElement.remove());
 }
 
 function showDetailFnc(e){ //showDetailFnc을 사용하는 대상은 tr이므로 this는 tr을 가리킨다.
	console.log('tr', e);
	//console.dir(this.children[0].innerText); //함수 정의시 this가 가르키는 것이 무엇인지 확인하기.
	//console.dir(this.children[1].innerText); //함수 정의시 this가 가르키는 것이 무엇인지 확인하기.
	document.getElementById('mid').value = this.children[0].innerText; //~.innerText ~의 text값만 가져온다.
	document.getElementById('mname').value = this.children[1].innerText;
	document.getElementById('mphone').value = this.children[2].innerText;
	document.getElementById('mpoint').value = this.children[3].innerText;
 }
 
 
 function modMemberFnc(){
   //tr을 가져오는 방식 document.queryselectAll('')
   let trs = document.querySelectorAll('#memberList tr');
   
   let mid = document.getElementById('mid').value; //사용자가 입력한 값
   let mname = document.getElementById('mname').value;
   let phone = document.getElementById('mphone').value;
   //let point = document.getElementById('mpoint').value; //값을 변수에 거치지 않고 바로 넣기
   // 입력화면의 회원아읻 값을 가져와서 mid 변수에 저장.
	for(let tr of trs){
		if(tr.children[0].innerText == mid){
			console.log(tr.children); //tr.children = td, td, td ~~~~ 데이터 타입이 배열이라서 하나씩 보려면 [인덱스번호]
			tr.children[1].innerText = mname;
			tr.children[2].innerText = phone;
			tr.children[3].innerText = document.getElementById('mpoint').value; //값을 변수에 거치지 않고 바로 넣기		
		}		
	}  	
 } // end of modMemberFnc().
 
 
 //선택삭제
 function removeMemberFnc(){
	let trs = document.querySelectorAll('#memberList tr');
	for(let tr of trs){
		console.log(tr.children[5].children[0].checked);
		//tr.children[5] = td
		if(tr.children[5].children[0].checked){
			tr.remove();
		}
	}	
 }
 
 
 //★this
 //이벤트 핸들러에서 사용시 = 이벤트 대상
 //함수 안에서 사용시 = 윈도우
 //객체안에서 사용시 객체 자신
 const obj = {
	name:'홍',
	age: 10,
	showInfo(){
		return '이름은' + this.name;
	}
 }
 
 
 //체크박스 
 function allCheckFnc(){
	//이벤트 핸들어 안에서 this = 이벤트 받는 대상
	//consol.log(this.checked);
	//밑의 함수를 화살표 함수로 간략화 / 화살표 함수는 객체 자기자신
	document.querySelectorAll('#memberList tr').forEach(item => item.children[5].children[0].checked = this.checked);

	//함수 안에서 this는 윈도우라는 최상위 객체를 가리킨다. 그래서 함수 안에서 사용하려면 미리 밖에서 변수에 담아둔다..
	let checkvalue = this.checked
	document.querySelectorAll('#memberList tr').forEach(function(item){ //NodeList [tr, tr, tr, ....] 배열일 경우 포이치를 사용하여 반복분 사용
		//forEach는 매개값으로 함수를 받음.
		//arrays.forEach(function(a, b, c)) a => arrays[x], b => index번호, c => arrays 
		//함수 안에서 this는 윈도우라는 최상위 객체를 가리킨다.
		console.log(this);
		item.children[5].children[0].checked = checkvalue;
		
	});
 } 
 
 //하나라도 체크하지 않으면 체크 체크박스 체크해제
 
 
 
 function sum(a, b) {
	 return a + b;
 }
 //위 함수를 화살표 함수로 변경 : 매개변수와 리턴값만 필요
 let sum1 = (a, b) => a + b;
 
 let result = sum(10, 30);
	
 