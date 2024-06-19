/**
 * ajax1.js
 * 비동기방식 처리
 */
//setTimeout()은 매개값으로 실행할 함수, 지연 시간를 받는다. 순서 상관없이 제일 빠른 처리 시간부터 출력.
//1000 = 1초
 setTimeout(function(){	console.log("3초 후 시작"); }, 3000);
 
 setTimeout(function(){
	console.log("1초 후 시작");
 }, 1000);
 
 setTimeout(function(){
	console.log("2초 후 시작");
 }, 2000);
 
 console.log("end");