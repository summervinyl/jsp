/**
 * js/obj1.js
 */
//object 안에 method 만들기

document.getElementById('dom').remove();

document.getElementById('addBtn2').addEventListener('click', addEmp);

const obj = {
	date: '', //속성
	fields: ['id', 'first_name', 'email', 'salary'], //보여주고 싶은 배열 정의
	showList: function(ary = []){ //메소드
		//배열을 매개값을 기준으로 반복
		ary.forEach((emp, idx) => {
			if(idx < 3){
				document.querySelector('#list').appendChild(this.makeRow(emp)); //목록				
			}
		});
	},
	makeRow(emp = {id, first_name, email, salary}){ //객체티입의 데이터가들어오면 !!!!!! 
		let tr = document.createElement('tr');
		this.fields.forEach(field => {
			let td = document.createElement('td');
			td.innerHTML = emp[field];
			tr.appendChild(td);
		});
		return tr;
	}
}

obj.showList(employees);

//추가에 클릭이벤트 달기
//오브젝트안에 메소드로 만
/*function addEmp(){
	const id = document.getElementById('id').value;
	const first_name = document.getElementById('first_name').value;
	const email = document.getElementById('email').value;
	const salary = document.getElementById('salary').value;
	
	document.getElementById('list').appendChild(obj.makeRow(id,first_name,email,salary));
}*/
	//obj.fields = [id, first_name, email, salary];

function addEmp(){
	const employee = {
		 id : document.getElementById('id').value,
		 first_name : document.getElementById('first_name').value,
		 email : document.getElementById('email').value,
		 salary : document.getElementById('salary').value
	}
	document.getElementById('list').appendChild(obj.makeRow(employee));
}

const today = new Date();
today.getFullYear();
//우리가 직접 만들 수도 있음 fomat에 필요한 메소드를 정의해서 사용 가능
//2024-06-18 이런 형식으로 만들고 싶다면
Date.prototype.format = function(){
	let yy = this.getFullYear(); //현재 년도 풀로 출력
	let mon = '0' + (this.getMonth() + 1);
	let dd = this.getDate(); //현재 일자 출력
	return yy + '-' + mon + '-' + dd;
}
console.log(today.format());


const person = {
	name: "하이",
	age: 20
}
person.height = 166.8;
person.showInfo
let prop = 'age';
console.log(person.prop);
console.log(person[prop]); //가변적인 값을 저장할 수 있다.



let music = new Object;
music.genre = 'rock';
music.singer = 'The 1975';
music.title = 'Allways wanna die';

function showInfo(){
	return `가수 : ${music.singer}\n제목 : ${music.title}\n장르 : ${music.genre}`;
}

console.log(showInfo());