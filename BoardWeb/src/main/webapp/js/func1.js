/**
 * 함수 정의문
 */

 function sum(a, b) {
	return a + b;	
 }
 
 let result1 = sum(10, 20);
 console.log('결과: ', result1);
 
 
 //
 function sum2(c, d) {
	 if(d == undefined){
		return c;		
	 }
	 return c + d;
 }
  
 
 //
 function sum3(e=0, f=0){
	return e+f;
 }
 
 let sum4 = function sum(e=0, f=0){
	return e + f
 }
  console.log('sum: ', sum(1,  5));
  
  
  // 표현하고자하는 변수명이 같으면 줄여서 표현 가능
  let name0 = "홍길동";
  let age0 = 20;  
  const obj1 = {
	name0,
	age0
  }
  
  
  //js 오브젝트 객체
  const obj0 = {
	name: "홍길동",
	age: 20
  }
  
  //obj는 매개변수이기 때문에 위 obj와는 무관
  function showObj(obj = {name: '이성계', age:25}){ 
	return obj.name + ' - ' + obj.age;	
  }
  //매개 값이 없으면 미리 선언해둔 초기값을 전달,
  console.log(showObj());
  console.log(showObj(obj0));
  
  
  //
  function sumAry(ary = []){
	let sum = 0;
	for(let i=0; i<ary.length; i++){
		sum += ary[i];
	}
	return sum;	
  }
  res1 = sumAry([1, 2, 3, 4, 5]);
  console.log('배열의 합 : ' + res1);
  
  
  //전역함수로 정의되면 윈도우에 저장되어 메소드라 불린다.
  function showItem(item){
	let days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];
	//배열의 개수만큼 
	//forEach는 매개값이 함수?
	days.forEach(function(val){
		let span = document.createElement('span');
		span.innerHTML = val + " ";
		item.appendChild(span);
	});
  }
  //자바스크립트언어는 유연해서 돔요소도 매개값으로 받아올 수 있다.
  showItem(document.getElementById('show'));
  
  //전역함수로 정의되면 윈도우에 저장되어 메소드라 불린다.
  //윈도우 객체에 소속되어 있으면 전역함수
  console.log(window);
  //showItem을 확인할 수 있다.
  