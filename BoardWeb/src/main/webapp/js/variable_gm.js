/**
 * 
 */

// 변수를 먼저 선언 후 결과를 후에 적어주자
 console.log(greeting);
 const greeting = 'hi'; // error
 
 // const = 상수, 선언과 동시에 초기화, 재할당 불가능, 블록 레벨 스코프
 greeting = 'hello'; // error: Assignment to constant variable.
 
 //속성은 재할당(업데이트) 가능
 const person = {
	name : '김한국',
	age : 20
 }
 
 person = {
	height : '178cm',
	weight : '70kg'
 } // error:  Assignment to constant variable.
 
 //but 속성은 재할당 가능
 person.name = '김민국';
 
 
 //let 중복 선언 불가, 재할당 가능, 블록 레벨 스코프
 
 //var 중복 선언 가능, 재할당 가능, 함수 레벨 스코프